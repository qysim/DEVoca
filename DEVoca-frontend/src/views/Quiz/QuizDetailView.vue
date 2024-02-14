<template>
  <div class="m-12 p-12 bg-white flex flex-col card shadow-3">
    <div class="w-full h-20 rounded-lg">
      <p class="text-3xl text-center font-jalnan">게릴라 퀴즈</p>
      <p class="text-sm text-center">{{ formatDateTime(quizInfo.participateDate) }}</p>
      <div class="mt-1 flex justify-evenly">
        <img src='@/assets/images/quiz/list_1.png' class='w-12 h-12' v-if="imgRank[0]"/>
        <img src='@/assets/images/quiz/list_2.png' class='w-12 h-12' v-if="imgRank[1]"/>
        <img src='@/assets/images/quiz/list_3.png' class='w-12 h-12' v-if="imgRank[2]"/>
        <img src='@/assets/images/quiz/list_4.png' class='w-12 h-12' v-if="imgRank[3]"/>
        <img src='@/assets/images/quiz/list_win.png' class='w-12 h-12' v-if="imgRank[4]"/>
        <img src='@/assets/images/quiz/list_lose.png' class='w-12 h-12' v-if="imgRank[5]"/>
        <img src='@/assets/images/quiz/list_draw.png' class='w-12 h-12' v-if="imgRank[6]"/>
        <p class="self-center text-3xl">{{ txtRank[quizInfo.type] }}</p>
      </div>
      <p class="text-xl text-center"> {{ correctCnt }} / {{ quizCnt }} </p>
      <hr class="bg-black">
    </div>
    <div class="mt-16">
      <QuizDetailComponent class="mt-1" v-for="(quiz, index) in quizResultList"
      :key="index" :quiz="quiz" :index="index" v-if="quizResultList.length"/>
    </div>
  </div>
  
  
</template>

<script setup>
import QuizDetailComponent from "@/components/quiz/QuizDetailComponent.vue";
import { getQuizResultDetail, getQuiz } from '@/api/quiz'
import { useRoute } from "vue-router";
import { ref, onMounted } from "vue";

const imgRank = ref([false, false, false, false, false, false, false]);
const txtRank = ref(["1등", "2등", "3등", "순위권 밖", "승리", "패배", "무승부"]);
const route = useRoute();
const { quizId } = route.params;
const quizInfo = history.state.quizInfo;
const score = ref(null);
const quizAnswerDTOList = ref([]);
const quizList = ref([]);
const quizResultList = ref([]);
const quizCnt = ref(null);
const correctCnt = ref(null);

onMounted(() => {
  imgRank.value[quizInfo.type] = true;
  getQuizResultDetail(quizId, (data) => {
    quizAnswerDTOList.value = data.data[0].quizAnswerDTOList;
    score.value = data.data[0].score;
    quizCnt.value = quizAnswerDTOList.value.length;
    correctCnt.value = score.value * 10 / quizCnt.value;
    getQuiz(quizId, (data) => {
      quizList.value = data.data;

      quizResultList.value = quizAnswerDTOList.value.map((item, index) => { 
        return { ...item, ...quizList.value[index] };
      })

    }, (err) => {
      console.log(err)
    })
  }, (err) => {
    console.log(err)
  });

})

// 일시 설정
const locale = 'ko-KR';
const options = {
  timeZone: 'Asia/Seoul',
  hour: "2-digit",
  minute: "2-digit"
};

const formatDateTime = (date) => {
  const dateTime = new Date(date);
  return `${dateTime.toLocaleDateString(locale, options)}`;
}
</script>

<style scoped></style>