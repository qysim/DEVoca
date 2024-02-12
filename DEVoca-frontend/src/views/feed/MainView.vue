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

</script>