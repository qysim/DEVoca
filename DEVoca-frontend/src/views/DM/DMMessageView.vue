<template>
  <div class="flex flex-col justify-between h-full">
    <div>
      <div class="card card-side bg-devoca_skyblue">
        <div class="flex justify-between">
          <div>
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-8 h-8 mt-14 ml-5"><path fill-rule="evenodd" d="M7.28 7.72a.75.75 0 0 1 0 1.06l-2.47 2.47H21a.75.75 0 0 1 0 1.5H4.81l2.47 2.47a.75.75 0 1 1-1.06 1.06l-3.75-3.75a.75.75 0 0 1 0-1.06l3.75-3.75a.75.75 0 0 1 1.06 0Z" clip-rule="evenodd" /></svg>
          </div>
          <p>{{ $route.params.userNickName }}</p>

          <div class="avatar">
            <div class="w-14 h-14 rounded-full my-10 ml-5">
              <img src="https://daisyui.com/images/stock/photo-1635805737707-575885ab0820.jpg" />
            </div>
          </div>
          <div class="card-body pl-2">
            <div class="flex flex-row justify-between">
              <h2 class="card-title text-lg mt-3">닉네임</h2>
            </div>
          </div>
        </div>
        </div>
      <div class="chat chat-start mt-5 ml-5">
        <div class="chat-image avatar">
          <div class="w-10 rounded-full">
            <img alt="Tailwind CSS chat bubble component"
              src="https://daisyui.com/images/stock/photo-1635805737707-575885ab0820.jpg" />
          </div>
        </div>
        <div class="chat-header">
          Obi-Wan Kenobi
          <time class="text-xs opacity-50">12:45</time>
        </div>
        <div class="chat-bubble">You were the Chosen One!</div>
        <div class="chat-footer opacity-50">
          Delivered
        </div>
      </div>
      <div class="chat chat-end mr-5">
        <div class="chat-image avatar">
          <div class="w-10 rounded-full">
            <img alt="Tailwind CSS chat bubble component"
              src="https://daisyui.com/images/stock/photo-1534528741775-53994a69daeb.jpg" />
          </div>
        </div>
        <div class="chat-header">
          Anakin
          <time class="text-xs opacity-50">12:46</time>
        </div>
        <div class="chat-bubble">I hate you!</div>
        <div class="chat-footer opacity-50">
          Seen at 12:46
        </div>
      </div>
    </div>
    <div class="input-container flex ml-2">
      <input type="text" placeholder="Type here" class="input input-bordered w-full"/>
      <button type="submit" class="btn bg-devoca text-white mr-2">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6"><path d="M3.478 2.404a.75.75 0 0 0-.926.941l2.432 7.905H13.5a.75.75 0 0 1 0 1.5H4.984l-2.432 7.905a.75.75 0 0 0 .926.94 60.519 60.519 0 0 0 18.445-8.986.75.75 0 0 0 0-1.218A60.517 60.517 0 0 0 3.478 2.404Z" /></svg>
      </button>
    </div>
  </div>
</template>


<script setup>
import { ref, onMounted } from 'vue';
import { getDmList, getDmUser } from '@/api/dm'

const props = defineProps({
  roomUuid: String
})

const dmUser = ref({});
const messageList = ref([]);

onMounted(()=> {
  getDmUser(
    props.roomUuid,
    ({ data }) => {
      dmUser.value = data;
      console.log("상대 유저 정보 : ", dmUser);
    },
    (error) => {
      console.log(error);
    });
  getDmList(
  props.roomUuid, 0,
  ({data}) => {
    console.log(data);
    data.forEach(element => {
      messageList.value.push(element)
    });
  },
  (error) => {
    console.log(error);
  });
})

</script>

<style scoped></style>