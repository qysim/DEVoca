<template>
  <div>
    <div class="bg-neutral-100 py-1">
      <WordComponent :word="word"/>
    </div>

    <!-- 기사 -->
    <div>
      <p class="font-jalnan text-xl ml-4 mt-4">관련 최신 기사</p>
      <div class="card bg-base-100 shadow-xl m-2">
        <div class="card-body">
          <h2 class="card-title">기사 제목</h2>
          <p>기사내용</p>
        </div>
      </div>
      <div class="card bg-base-100 shadow-xl m-2">
        <div class="card-body">
          <h2 class="card-title">기사 제목</h2>
          <p>기사내용</p>
        </div>
      </div>
      <div class="card bg-base-100 shadow-xl m-2">
        <div class="card-body">
          <h2 class="card-title">기사 제목</h2>
          <p>기사내용</p>
        </div>
      </div>
    </div>

    <div class="collapse collapse-arrow bg-base-100 shadow-xl m-2 w-auto">
      <input type="checkbox" /> 
      <div class="collapse-title text-xl font-medium font-jalnan">
        카드 3
      </div>
      <div class="collapse-content p-0"> 
        <CardComponent />
        <CardComponent />
        <CardComponent />
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, onBeforeMount } from 'vue'
import WordComponent from '@/components/word/WordComponent.vue'
import CardComponent from '@/components/feed/CardComponent.vue'
import { getWordDetail } from '@/api/word.js'
import { defineAsyncComponent } from 'vue'

const props = defineProps({
  id: String
})

const wordId = Number(props.id)
const word = ref(null)
const news = ref(null)

onBeforeMount(async() => {
  try {
    await getWordDetail(wordId, (res) => {
      // console.log(res.data)
      word.value = res.data.wordDTO
      news.value = res.data.newsList
      console.log(word.value)
      console.log(news.value)
  })
  } catch (err) {
    console.log(err)
  }
})

// onMounted( async () => {
  
// })
</script>

<style scoped>

</style>