<template>
  <div class="py-16">
    <TopNavbarComponent/>
    <RouterView/>
    <BottomNavbarComponent />
  </div>
</template>

<script setup>
import TopNavbarComponent from '@/components/navbar/TopNavbarComponent.vue'
import BottomNavbarComponent from '@/components/navbar/BottomNavbarComponent.vue'
import NotificationComponent from "@/components/common/NotificationComponent.vue";
import QuizPopupComponent from "@/components/quiz/QuizPopupComponent.vue";
</script>