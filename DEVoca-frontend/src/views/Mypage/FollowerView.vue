<template>
    <div class="flex flex-row">
      <a href="">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="w-6 h-6 mt-5 ml-5"><path fill-rule="evenodd" d="M7.72 12.53a.75.75 0 0 1 0-1.06l7.5-7.5a.75.75 0 1 1 1.06 1.06L9.31 12l6.97 6.97a.75.75 0 1 1-1.06 1.06l-7.5-7.5Z" clip-rule="evenodd" /></svg>
      </a>
        <p class="mt-6 ml-5 font-[GmarketSansMedium] text-xl">여기는 팔로잉</p>
    </div>
    <div>
        <FollowerComponents/>
    </div>

</template>


<script setup>
import FollowerComponents from '@/components/mypage/FollowerComponents.vue';


</script>

<style scoped>

</style>