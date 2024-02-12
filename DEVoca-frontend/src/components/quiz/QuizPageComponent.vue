<template>
    <div class="card bg-white shadow-xl m-2 w-96 h-fit flex flex-col items-center p-12">
      <img src="@/assets/images/quiz/quiz_page_logo.png" viewBox="0 0 24 24" class="stroke-info shrink-0 w-60 h-32" alt="devoca_logo">
      <div>
        <div class="text-slate-400 flex justify-end">{{ pageIndex }} / {{ quizList.length }}</div>
        <div class="w-80 p-5 rounded-lg bg-slate-100">Q. {{ Question }}</div>
        <div class="mt-5 flex items-center border-b border-devoca py-2">
          <input class="appearance-none bg-transparent border-none w-full text-gray-700 mr-3 py-1 px-2 leading-tight focus:outline-none"
          type="text" placeholder="답을 입력하세요" aria-label="Answer" v-model="answer"/>
        </div>
        <div class="flex justify-end">
          <button class="mt-2 flex-shrink-0 bg-devoca hover:bg-devoca_sky text-sm text-white py-1 px-4 rounded-3xl"
          type="button" @click="goNext">
            제 출
          </button>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref } from "vue";
  import { useRoute, useRouter } from "vue-router";

  const props = defineProps({
    quizList: {
      type: Array,
      required: true
    },
    quizId: {
      type: Number,
      required: true
    },
    userId: {
      type: String,
      required: true
    },
    answerList: {
      type: Array,
      required: true
    },
  });
  const emit = defineEmits(['add-answer']);

  const route = useRoute();
  const router = useRouter();
  const { index } = route.params;
  const pageIndex = Number(index) + 1;
  let Question = props.quizList[index].wordSumm;
  Question = Question.replaceAll(props.quizList[index].wordNameKr, " [ ? ] ");

  const answer = ref(null);
  const quizYn = ref(0);
  const score = ref(0);
  
  const grading = function () {
    if (answer.value == props.quizList[index].wordNameKr
      || answer.value == props.quizList[index].wordNameEn) {
        quizYn.value = 1;
    }
    const quizAnswer = {
      "quizWordId": props.quizList[index].wordId,
      "quizAnswer": answer.value,
      "quizYn": quizYn.value
    };
    emit('add-answer', quizAnswer);
  }

  const goNext = function () {
    grading();
    if (pageIndex != props.quizList.length) {
      router.push({ name: "QuizPageComponent", params: { index: pageIndex } });
    } else {
      score.value = props.answerList.reduce((total, item) => {
        return total + item.quizYn;
      }, 0);
      score.value = score.value / props.quizList.length * 10;
      // saveQuizResult api에 전부 담아서 보내기
      // 결과 모달 띄우기
    }
  }
  </script>
  
  <style scoped></style>