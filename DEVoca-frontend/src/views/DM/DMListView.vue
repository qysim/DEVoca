<template>
  <div class="flex">
    <div>
      <p class="text-xl ml-5 mr-3 mt-5">DM</p>
    </div>
  </div>
  <div v-for="room in roomList" :key="room">
    <div class="card card-side bg-base-100 items-center">
      <div class="avatar basis-1/4">
        <div class="rounded-full m-3">
          <img :src="room.userImg" />
        </div>
      </div>
      <div class="card-body flex-row p-3">
        <div>
          <h2 class="card-title font-jalnan">{{room.userNickName}}</h2>
          <p>{{room.lastMessage}}</p>
        </div>
      </div>
      <div class="flex justify-end flex-col mr-5">
        <p class="text-right">{{formatDate(room.lastSendDate)}}</p>
        <p class="text-right">{{formatTime(room.lastSendDate)}}</p>
        <button>
          <div class="badge bg-devoca_skyblue">{{room.unReadCnt}}</div>
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { getDmRoomList } from '@/api/dm';

const roomList = ref([]);

onMounted(() => {
  getDmRoomList(
    ({ data }) => {
      roomList.value = data
      console.log(roomList.value)
    },
    (error) => {
      console.log(error);
    }
  )
});

const locale = 'ko-KR';
const options = {
  timeZone: 'Asia/Seoul',
  hour: "2-digit",
  minute: "2-digit"
};

const formatDate = (date) => {
  const dateTime = new Date(date);
  return `${dateTime.toLocaleDateString(locale)}`;
}

const formatTime = (date) => {
  const dateTime = new Date(date);
  return `${dateTime.toLocaleTimeString(locale, options)}`;
}
</script>

<style scoped></style>