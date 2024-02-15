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
// import { connectSSE } from '@/api/notify'
// import urlApi from '@/util/http-commons.js'
import { ref } from "vue";
import { NativeEventSource, EventSourcePolyfill } from 'event-source-polyfill';
const popup = ref(false);
const isPopupClicked = function () {
  popup.value = !popup.value;
}

const pushedData = ref({});
const notificationLink = ["/board/", "/board/", "/card/", "/card/", "/dm/", "/quiz/"]
const routeto = ref({});
const lastEventId = ref(null);
const token = JSON.parse(localStorage.getItem('user')).kakaoUserInfo.token;

const SSE = new EventSourcePolyfill(
  'https://i10d112.p.ssafy.io/devoca/notify/connect?Last-Event-ID='+lastEventId.value,
  {
    headers: { token: token },
    withCredentials: true,
    heartbeatTimeout: 300000000,
  }
);

// SSE.onmessage = (event) => { 
//   console.log("push notify!");
//   console.log(event.data);
//   console.log(JSON.parse(event.data));
//   pushedData.value = JSON.parse(event.data);
//   lastEventId = event.lastEventId;
// }

SSE.addEventListener('connect', (event) => {
  console.log("SSE 연결 완료!!");
  console.log(event.data);
  console.log(JSON.parse(event.data));
})

SSE.onerror = (err) => { 
  console.log(err);
  SSE.close();
  console.log("SSE 종료!");
}




</script>