<template>
  <div>
    <!-- 상단바에서 터치로 좌우로 움직이도록 -->
    <div class="join join-vertical shadow-xl mb-16">
      <button class="btn join-item bg-base-100 px-2 py-6 " v-for="alphabet in alphabets">{{ alphabet }}</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import LoginViewVue from '../MembershipManagement/LoginView.vue';

const alphabets = ref('ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split(''))

</script>

<style scoped>

</style>