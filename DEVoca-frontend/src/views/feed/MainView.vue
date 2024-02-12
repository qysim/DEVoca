<template>
  <div class="py-16">
    <TopNavbarComponent/>
    <div v-if="false" @click="isPopupClicked">
      <NotificationComponent />
    </div>
    <div class="flex justify-center" v-if="popup">
      <QuizPopupComponent/>
    </div>
    <RouterView/>
    <BottomNavbarComponent />
  </div>
</template>

<script setup>
import TopNavbarComponent from '@/components/navbar/TopNavbarComponent.vue'
import BottomNavbarComponent from '@/components/navbar/BottomNavbarComponent.vue'
import NotificationComponent from "@/components/common/NotificationComponent.vue"
import QuizPopupComponent from '@/components/quiz/QuizPopupComponent.vue'

import { ref } from "vue"
const popup = ref(false);
const isPopupClicked = (event) => {
  popup.value = !popup.value;
  console.log(popup.value);
}

</script>