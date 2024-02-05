<template>
  <div class="py-16">
    <TopNavbarComponent/>
    <div>
      <RouterView/>
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