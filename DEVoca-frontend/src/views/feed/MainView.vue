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
import { connectSSE } from '@/api/notify'
import { ref, onMounted } from "vue";
const popup = ref(false);
const isPopupClicked = function () {
  popup.value = !popup.value;
}

const pushedData = ref({});
const notificationLink = ["/board/", "/board/", "/card/", "/card/", "/dm/", "/quiz/"]
const routeto = ref({});
const lastEventId = ref(null);

// onMounted(() => {

//   handleSSE();
  

// })

const handleSSE = () => {

  connectSSE(lastEventId.value, (eventData) => {
    console.log("SSE event received:", eventData);

  }, (err) => {
    console.log(err);
  });


}

</script>