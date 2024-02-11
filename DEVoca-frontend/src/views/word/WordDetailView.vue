<template>
  <div>
    <div class="bg-neutral-100 pt-2">
      <WordComponent v-if="word" :word="word"/>
      <div v-else class="flex justify-center">
        <span class="loading loading-dots loading-lg"></span>
      </div>
    </div>

    <!-- 기사 -->
    <p class="font-jalnan text-lg ml-4 mt-4">관련 최신 기사</p>
    <div v-for="news in newsList">
      <div class="card bg-base-100 shadow-xl m-2 text-xs" @click="goNews(news.link)">
        <div class="card-body p-4">
          <h2 class="card-title text-sm">{{ news.title }}</h2>
          <p v-html="news.description" class="truncate"></p>
          <p>{{ changeDateFormat(news.pubDate) }}</p>
        </div>
      </div>
    </div>

    <div class="collapse collapse-arrow bg-base-100 shadow-xl w-auto">
      <input type="checkbox" /> 
      <div class="collapse-title text-xl font-medium font-jalnan">관련 카드</div>
      <div v-for="card in cardList" class="collapse-content p-0"> 
        <CardComponent :card="card"/>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onBeforeMount } from 'vue'
import WordComponent from '@/components/word/WordComponent.vue'
import CardComponent from '@/components/feed/CardComponent.vue'
import { getWordDetail, getCardListByWord } from '@/api/word.js'

const props = defineProps({
  id: String
})

const word = ref(null)
const newsList = ref(null)
const cardList = ref(null)
const scrollNo = ref(0)

onBeforeMount(async() => {
  try {
    await 
    getWordDetail(props.id, (res) => {
    word.value = res.data.wordDTO
    newsList.value = res.data.newsList
  }, (err) => {
    console.log(err)
  })

  getCardListByWord(`${word.value.wordId}/${scrollNo.value}`, (res) => {
    cardList.value = res.data
    scrollNo.value++
  }, (err) => {
    console.log(err)
  })
  } catch (err) {
    console.log(err)
  }
})

const goNews = function (link) {
  location.href=link
}

const changeDateFormat = function (string) {
  const date = new Date(string)
  const newDate = date.toLocaleDateString('ko-KR')
  return newDate
}

</script>