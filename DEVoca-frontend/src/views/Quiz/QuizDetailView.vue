<template>
  <div>
    <FightPopupComponent/>
  </div>
  <div>
    <FightChallengeComponent/>
  </div>
  <div>
    <QuizFinishComponent/>
  </div>
  <div class="m-12 flex flex-col">
    <div class="w-full h-20 rounded-lg">
      <p class="text-xl text-center">날짜</p>
      <p class="text-xl text-center">게릴라 퀴즈</p>
      <p class="text-sm text-center"> 8 / 10 </p>
      <hr class="bg-black">
    </div>
  </div>
  <div class="flex flex-col relative">
    <img src="@/assets/images/quiz/correct.png" class="w-12 h-12 absolute top-0 left-10 transform -translate-x-1/2">
    <p class="text-center text-lg mt-3">1. 가상 머신을 실행하기 위한 프로그램은?</p>
    <p class="text-[red] underline text-lg flex justify-end mr-5">오답일때</p>
    <div class="flex justify-end">
      <p class="text-sm bg-devoca_skyblue rounded-lg w-10 h-6 mr-5 mt-1 text-center">정답</p>
      <p class="text-lg flex justify-end mr-5">정답일때</p>
    </div>
  </div>
  <div class="flex flex-col relative">
    <img src="@/assets/images/quiz/incorrect.png" class="w-10 h-10 absolute top-0 left-10 transform -translate-x-1/2">
    <p class="text-center text-lg mt-1">1. 가상 머신을 실행하기 위한 프로그램은?</p>
    <p class="text-[red] underline text-lg flex justify-end mr-5">오답일때</p>
    <div class="flex justify-end">
      <p class="text-sm bg-devoca_skyblue rounded-lg w-10 h-6 mr-5 mt-1 text-center">정답</p>
      <p class="text-lg flex justify-end mr-5">정답일때</p>
    </div>
  </div>
</template>

<script setup>
import FightPopupComponent from '@/components/quiz/FightPopupComponent.vue';
import FightChallengeComponent from '@/components/quiz/FightChallengeComponent.vue';
import QuizFinishComponent from '@/components/quiz/QuizFinishComponent.vue';
</script>

<style scoped></style>