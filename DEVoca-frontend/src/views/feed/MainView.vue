<template>
  <div class="py-16">
    <TopNavbarComponent/>
    <NotificationComponent v-show="false"/>
    <RouterView/>
    <BottomNavbarComponent />
  </div>
</template>

<script setup>
import TopNavbarComponent from '@/components/navbar/TopNavbarComponent.vue'
import BottomNavbarComponent from '@/components/navbar/BottomNavbarComponent.vue'
import NotificationComponent from "@/components/common/NotificationComponent.vue";

</script>

<style scoped>

</style>