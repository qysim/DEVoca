<template>
    <div class="flex flex-col relative">
        <img v-if="!isCorrect" src="@/assets/images/quiz/incorrect.png"
        class="w-10 h-10 absolute top-0 left-3 transform -translate-x-1/2">
        <img v-if="isCorrect" src="@/assets/images/quiz/correct.png"
        class="w-12 h-12 absolute top-0 left-3 transform -translate-x-1/2">
        <p class="text-center text-lg mt-3">{{ props.index + 1 }}. {{ props.quiz.wordSumm }}</p>
        <p class="text-[red] underline text-lg flex justify-end mr-5" v-if="!isCorrect">{{ props.quiz.quizAnswer }}</p>
        <div class="flex justify-end">
            <p class="text-sm bg-devoca_skyblue rounded-lg w-10 h-6 mr-5 mt-1 text-center">정답</p>
            <p class="text-lg flex justify-end mr-5" v-if="isCorrect">정답일때</p>
        </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
const props = defineProps({
    quiz: Object,
    index: Number
})
const isCorrect = ref(null);

onMounted(() => {
    isCorrect.value = props.quiz.quizYn;

})




</script>

<style>
</style>