<template>
  <div>
    <TopNavBarComponent />
    <!-- 테스트용 추후 v-for로 구현 예정 -->
    <div class="my-16">
      <CardComponent />
      <CardComponent />
      <CardComponent />
      <CardComponent />
      <CardComponent />
      <CardComponent />
      <CardComponent />
      <CardComponent />
      <CardComponent />
      <CardComponent />
      <WriteButtonComponent/>
    </div>
    <BottomNavbarComponent />
  </div>
</template>

<script setup>
import TopNavBarComponent from '@/components/navbars/TopNavbarComponent.vue'
import BottomNavbarComponent from '@/components/navbars/BottomNavbarComponent.vue'
import CardComponent from '@/components/feeds/CardComponent.vue'
import WriteButtonComponent from '@/components/feeds/WriteButtonComponent.vue'

</script>

<style scoped>

</style>