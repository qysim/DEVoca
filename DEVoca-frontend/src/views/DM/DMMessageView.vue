<template>
  <div class="flex flex-col justify-between h-full">
    <div>
      <div class="card card-side bg-devoca_skyblue">
        <div class="flex justify-between">
          <div>
            <svg @click="exitChat" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-8 h-8 mt-14 ml-5"><path fill-rule="evenodd" d="M7.28 7.72a.75.75 0 0 1 0 1.06l-2.47 2.47H21a.75.75 0 0 1 0 1.5H4.81l2.47 2.47a.75.75 0 1 1-1.06 1.06l-3.75-3.75a.75.75 0 0 1 0-1.06l3.75-3.75a.75.75 0 0 1 1.06 0Z" clip-rule="evenodd" /></svg>
          </div>
          <div class="avatar">
            <div class="w-14 h-14 rounded-full my-10 ml-5">
              <img :src="dmUser.userImg" />
            </div>
          </div>
          <div class="card-body pl-2">
            <div class="flex flex-row justify-between">
              <h2 class="card-title text-lg mt-3">{{ dmUser.userNickName }}</h2>
            </div>
            <p class="text-sm">{{dmUser.userIntro}}</p>
          </div>
        </div>
      </div>
      <div v-for="(chat, index) in messageList " :key="index">
        <div v-if="chat.sendUserId == dmUser.userId" class="chat chat-start mt-3 ml-5">
          <div class="chat-bubble break-words">
            {{chat.dmContent}}
          </div>
          <div class="chat-footer">
            <time class="text-xs opacity-50">{{formatDateTime(chat.dmSendDate)}}</time>
          </div>
        </div>
        <div v-if="chat.sendUserId !== dmUser.userId" class="chat chat-end mt-3 mr-5">
          <div class="chat-bubble break-words">{{chat.dmContent}}</div>
          <div class="chat-footer">
            <time class="text-xs opacity-50">{{formatDateTime(chat.dmSendDate)}}</time>
          </div>
        </div>
      </div>
    </div>
    <div class="input-container flex ml-2">
      <input type="text" placeholder="메시지 입력" class="input input-bordered w-full" v-model="message" @keyup.enter="sendMessage"/>
      <button @click="sendMessage" class="btn bg-devoca text-white mr-2">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6"><path d="M3.478 2.404a.75.75 0 0 0-.926.941l2.432 7.905H13.5a.75.75 0 0 1 0 1.5H4.984l-2.432 7.905a.75.75 0 0 0 .926.94 60.519 60.519 0 0 0 18.445-8.986.75.75 0 0 0 0-1.218A60.517 60.517 0 0 0 3.478 2.404Z" /></svg>
      </button>
    </div>
  </div>
</template>


<script setup>
import { ref, onMounted, onUnmounted } from 'vue';
import { getDmList, getDmUser } from '@/api/dm'
import { useUserStore } from '@/stores/user';
import Stomp from 'stompjs';

const props = defineProps({
  roomUuid: String
})

const userStore = useUserStore();

const dmUser = ref({});
const messageList = ref([]);

onMounted(()=> {
  getDmUser(
    props.roomUuid,
    ({ data }) => {
      dmUser.value = data;
    },
    (error) => {
      console.log(error);
    });
  getDmList(
  props.roomUuid, 0,
  ({data}) => {
    data.forEach(element => {
      messageList.value.push(element)
    });
  },
  (error) => {
    console.log(error);
  });
  connect(props.roomUuid);
})

// websocket
const socket = ref(null);
const stompClient = ref(null);

const message = ref('');

const dm = ref({
  sendUserId: "",
  dmContent: "",
  dmSendDate: "",
  dmBattleQuizId: 0,
})

// websocket 연결
const connect = (uuid) => {
  if(stompClient.value && stompClient.value.connected) {
    if(socket.value.connected) stompClient.value.disconnect();
  }

  socket.value = new WebSocket('wss://i10d112.p.ssafy.io/devoca/chat');
  // socket.value = new WebSocket('ws://localhost/devoca/chat');
  stompClient.value = Stomp.over(socket.value);

  stompClient.value.connect({}, () => {
    console.log('Connected to WebSocket' + uuid);
    dm.value.sendUserId = userStore.kakaoUserInfo['id'];  

    stompClient.value.send('/pub/chat/' + uuid + '/enter', {}, dm.value.sendUserId); // 유저 입장
    console.log("유저 입장 : " + uuid + " " + dm.value.sendUserId);

    //메시지 수신
    stompClient.value.subscribe('/sub/chat/' + uuid, (message) => {
      displayMessage(JSON.parse(message.body));
    });
  });

  // websocket 재연결
  socket.value.onclose = function() {
    console.log("WebSocket 연결 해제. 재연결 시도 중..");
    setTimeout(connect(uuid), 1000);
  }
};

// 화면에 메시지 표시
const displayMessage = (message) => {
  messageList.value.push(message);
};

// 메시지 전송
const sendMessage = () => {
  dm.value.sendUserId = userStore.kakaoUserInfo['id']; 
  dm.value.dmContent = message.value;
  dm.value.dmSendDate = new Date();

  console.log("메시지 보내기" + dm.value);
  if(dm.value.dmContent.trim() !== '') {
    stompClient.value.send('/pub/chat/' + props.roomUuid, {}, JSON.stringify(dm.value));
    message.value = '';
  }
}

// 유저 퇴장
const exitChat = () => {
  stompClient.value.send('/pub/chat/' + props.roomUuid + '/exit', {}, JSON.stringify({ userId: dm.value.sendUserId, lastDate: new Date()})); // 유저 퇴장
  console.log("유저 퇴장 : " + props.roomUuid + " " + dm.value.sendUserId);

  stompClient.value.disconnect();
  console.log("웹소켓 연결 해제");
}

onUnmounted(() => {
  exitChat();
})

// 메시지 시간 설정
const locale = 'ko-KR';
const options = {
  timeZone: 'Asia/Seoul',
  hour: "2-digit",
  minute: "2-digit"
};

const formatDateTime = (date) => {
  const dateTime = new Date(date);
  return `${dateTime.toLocaleDateString(locale, options)}`;
}

</script>

<style scoped></style>