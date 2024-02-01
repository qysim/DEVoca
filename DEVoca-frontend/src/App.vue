<template>
  <div class="h-screen">
    <!-- TopNav와 BottomNav는 Login 했을 때만 보이기 -->
    <TopNavBarComponent v-if="isLogin"/>
    <div :class="{'container mx-auto':true, 'my-16':isLogin}">
      <RouterView />
    </div>
    <BottomNavbarComponent v-if="isLogin"/>
  </div>
</template>

<script setup>
import TopNavBarComponent from '@/components/navbars/TopNavbarComponent.vue'
import BottomNavbarComponent from '@/components/navbars/BottomNavbarComponent.vue'
import { ref } from 'vue'

// Login 여부 테스트용 변수
const isLogin = ref(true)

</script>

<style scoped>

</style>
