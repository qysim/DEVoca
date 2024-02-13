<template>
    <button class="btn btn-lg w-full rounded-lg bg-base-100 shadow-xl my-2 mt-5 flex flex-col">
        <div class="flex justify-between items-center space-x-12">
          <div v-html="typeHtml[type]"></div>
          <div class="flex flex-col items-center">
            <p class="text-center text-xl">1등</p>
            <p class="text-center text-sm">{{ props.quiz.participateDate }}</p>
          </div>
          <div>
            <list_1 v-if="imgRank[0]"/>
            <list_2 v-if="imgRank[1]"/>
            <list_3 v-if="imgRank[2]"/>
            <list_4 v-if="imgRank[3]"/>
            <list_win v-if="imgRank[4]"/>
            <list_lose v-if="imgRank[5]"/>
            <list_draw v-if="imgRank[6]"/>
          </div>
        </div>
    </button>
</template>
  
<script setup>
import list_1 from '@/components/quiz/quizImg/list_1.vue';
import list_2 from '@/components/quiz/quizImg/list_2.vue';
import list_3 from '@/components/quiz/quizImg/list_3.vue';
import list_4 from '@/components/quiz/quizImg/list_4.vue';
import list_win from '@/components/quiz/quizImg/list_win.vue';
import list_lose from '@/components/quiz/quizImg/list_lose.vue';
import list_draw from '@/components/quiz/quizImg/list_draw.vue';
import { ref, onMounted } from "vue";
const type = ref(0);
const imgRank = ref([false, false, false, false, false, false, false]);
const typeHtml = [
    "<div class='w-16 h-10 mt-5'><p class='text-sm bg-orange-200 rounded-lg'>게릴라</p></div>",
    "<div class='w-10 h-10 mt-5'><p class='text-sm bg-devoca_skyblue rounded-lg'>대결</p></div>"
]
const props = defineProps({
    quiz: Object
})

onMounted(() => {
    if (props.quiz.battleId != null) {
        // 대결이라면
        type.value = 1;
        // 이미지 계산
        imgRank.value[4] = true;
    } else {
        // 이미지 계산
        imgRank.value[0] = true;
    }
})

</script>
  
<style scoped>
</style>