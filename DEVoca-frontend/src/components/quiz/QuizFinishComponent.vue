<template>
  <div class="card bg-white shadow-xl m-2 w-96 h-auto">
    <div class="card-body p-8 w-80 flex flex-col items-center self-center">
      <img src="@/assets/images/quiz/quiz_logo.png" viewBox="0 0 24 24" class="stroke-info shrink-0 w-56 h-20"
        alt="devoca_logo">
      <div class="relative">
        <p class="text-3xl font-jalnan mt-5">퀴즈 종료!</p>
      </div>
      <div>
        <p class="mt-5 text-sm">{{ Qnum }} 문제 중 {{ Anum }}개 정답으로..</p>
        <div class="w-80 mb-5 p-5 rounded-lg bg-slate-200 text-amber-500 flex justfy-center text-center">
          <p class="text-xl text-amber-500">{{ score*10 }}점</p>
        </div>
        <div class="flex justify-evenly">
          <button class="mt-2 flex-shrink-0 bg-devoca_sky hover:bg-devoca_skyblue text-sm text-devoca py-1 px-4 rounded-3xl"
            type="button" @click="goQuizList">
            등수 확인하러 가기
          </button>
          <button class="mt-2 flex-shrink-0 bg-devoca_sky hover:bg-devoca_skyblue text-sm text-devoca py-1 px-4 rounded-3xl"
          type="button" @click="goMain">
            메인으로
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
const router = useRouter();

const props = defineProps({
  Qnum: {
    type: Number,
    required: true
  },
  Anum: {
    type: Number,
    required: true
  },
  score: {
    type: Number,
    required: true
  }
});

const goQuizList = function () {
  router.push({ name: 'QuizListView' });
}
const goMain = function () {
  router.push({ name: 'FeedListView' });
}

</script>

<style scoped></style>