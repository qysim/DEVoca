<template>
  <div>
    <TopNavbarComponent />
    <div class="my-16">
      <RouterView />
    </div>
    <BottomNavbarComponent />
  </div>
</template>

<script setup>
import TopNavbarComponent from '@/components/navbar/TopNavbarComponent.vue'
import BottomNavbarComponent from '@/components/navbar/BottomNavbarComponent.vue'

</script>

<style scoped>

</style>