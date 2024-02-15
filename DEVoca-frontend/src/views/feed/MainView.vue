<template>
  <div class="py-16">
    <TopNavbarComponent/>
    <div v-if="false" @click="isPopupClicked">
      <NotificationComponent />
    </div>
    <div class="flex justify-center" v-if="popup" @click="isPopupClicked">
      <QuizPopupComponent/>
    </div>

    <RouterView/>
    <BottomNavbarComponent />
  </div>
</template>

<script setup>
import TopNavbarComponent from '@/components/navbar/TopNavbarComponent.vue'
import BottomNavbarComponent from '@/components/navbar/BottomNavbarComponent.vue'
import NotificationComponent from "@/components/common/NotificationComponent.vue";
import QuizPopupComponent from "@/components/quiz/QuizPopupComponent.vue";
import { ref, onMounted } from "vue";
import { EventSourcePolyfill } from 'event-source-polyfill';
const popup = ref(false);
const isPopupClicked = function () {
  popup.value = !popup.value;
}

const pushedData = ref({});
const notificationLink = ["/board/", "/board/", "/card/", "/card/", "/dm/", "/quiz/"]
const routeto = ref({});
const lastEventId = ref(null);
const SSE = ref(null);

onMounted(() => {
  initSSE();
})

const initSSE = () => { 
  if (!SSE.value) {
    const token = JSON.parse(localStorage.getItem('user')).kakaoUserInfo.token;

    SSE.value = new EventSourcePolyfill(
      'https://i10d112.p.ssafy.io/devoca/notify/connect?Last-Event-ID=' + lastEventId.value,
      {
        headers: { token: token },
        withCredentials: true,
        heartbeatTimeout: 300000000,
      }
    );

    SSE.value.addEventListener('sse', (event) => {
      console.log("SSE 수신!");
      console.log(event.data);
    })

    SSE.value.onerror = (err) => {
      console.log(err);
      SSE.value.close();
      console.log("SSE 종료!");
      SSE.value = null;
    }
  } else {
    console.log("기존 SSE 연결 이용");
  }
}





</script>