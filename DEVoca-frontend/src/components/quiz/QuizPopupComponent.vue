<template>
  <div>
     <div class="card bg-base-100 shadow-xl m-2 w-96 h-96">
      <div class="card-body p-8 w-80 flex flex-col items-center self-center">
        <img src="@/assets/images/quiz/quiz_logo.png" viewBox="0 0 24 24" class="stroke-info shrink-0 w-56 h-20" alt="devoca_logo">
        <div class="w-72 mt-5 flex flex-row justify-evenly">
            <img src="@/assets/images/quiz/quiz_speaker.png" viewBox="0 0 24 24" class="stroke-info shrink-0 w-11 h-11" alt="devoca_logo">
            <h1 class="m-3 mb-auto">{{ quiz_type[battleYn] }} 퀴즈</h1>
        </div>
        <div class="w-72 mt-1 flex flex-row justify-between">
            <img src="@/assets/images/quiz/quiz_timer.png" viewBox="0 0 24 24" class="stroke-info shrink-0 w-11 h-11" alt="devoca_logo">
            <h1 class="m-3 self-center">제한시간이 없는 퀴즈입니다.</h1>
        </div>
        <div class="w-60 mt-5 flex flex-row justify-evenly">
            <button class="btn bg-black text-white w-20" @click="goQuizPage">참여</button>
            <button class="btn bg-black text-white w-20">닫기</button>
        </div>

      </div>
    </div>
  </div>
</template>

  <script setup>
  import { useRouter } from 'vue-router'
  import { ref } from "vue";
  const router = useRouter()
  const quizId = 19;
  const battleYn = ref(0);

  const quiz_type = ["게릴라", "대결"];
  const goQuizPage = function () {
    router.push({ name: 'QuizPageView', query: { quizId: quizId, battleYn: battleYn.value } });
  }
  </script>
  
<style scoped></style>