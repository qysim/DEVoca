<template>
  <div class="container mx-auto">
    <TopNavBarComponent />
    <RouterView />
    <BottomNavbarComponent />
  </div>
</template>

<script setup>
import TopNavBarComponent from '@/components/TopNavbarComponent.vue'
import BottomNavbarComponent from './components/BottomNavbarComponent.vue'

</script>

<style scoped>

</style>
