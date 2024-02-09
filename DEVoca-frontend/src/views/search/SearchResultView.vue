<template>
  <div class="m-2 h-full flex flex-col">
    <SearchBarComponent />

    <div role="tablist" class="tabs tabs-bordered tabs-lg">
      <input type="radio" name="my_tabs_1" role="tab" class="tab" aria-label="단어" />
      <input type="radio" name="my_tabs_1" role="tab" class="tab" aria-label="글" />
    </div>

    <div v-show="isResult" class="flex flex-col items-center justify-center flex-grow">
      <p>아직 등록되지 않은 단어입니다.</p>
      <button class="btn bg-devoca text-white text-lg m-2">단어 등록 요청하러 가기</button>
    </div>
    <div v-show="!isResult" class="flex flex-col justify-center p-2 pb-16">
      <WordComponent v-for="word of searchResultWords" :key="word.id" :word="word" />
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { onBeforeRouteUpdate, useRoute } from 'vue-router'
import { getSearchResultWords, getSearchResultCards } from '@/api/word'

import SearchBarComponent from '@/components/common/SearchBarComponent.vue'
import WordComponent from "@/components/word/WordComponent.vue";

const isResult = ref(true)
const searchResultWords = ref([])
const searchResultCards = ref([])

const route = useRoute()
const param = ref(route.query.q)

const getSearchResults = () => {
  if (param.value !== undefined) {
    getSearchResultWords(param.value,
      (data) => {
        console.log(data.data.length)
        // 검색 결과 없는 경우
        if (data.data.length === 0) {
          isResult.value = true
          return
        }

        isResult.value = false
        searchResultWords.value = data.data
      }, (error) => {
        console.log(error)
      }
    )

    getSearchResultCards(param.value,
      (data) => {
        console.log(data.data.length)
        // 검색 결과 없는 경우
        if (data.data.length === 0) {
          isResult.value = true
          return
        }

        isResult.value = false
        searchResultCards.value = data.data
      }, (error) => {
        console.log(error)
      }
    )
  }
}

onBeforeRouteUpdate((to,) => {
  param.value = to.query.q
  getSearchResults()
})

</script>
