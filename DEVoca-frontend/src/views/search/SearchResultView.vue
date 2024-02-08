<template>
  <div class="m-2 h-full flex flex-col">
    <SearchBarComponent :param="param" />

    <div role="tablist" class="tabs tabs-bordered tabs-lg">
      <input type="radio" name="my_tabs_1" role="tab" class="tab" aria-label="단어" />
      <input type="radio" name="my_tabs_1" role="tab" class="tab" aria-label="글" />
    </div>

    <div v-show="isResult" class="flex flex-col items-center justify-center flex-grow">
      <p>아직 등록되지 않은 단어입니다.</p>
      <button class="btn bg-devoca text-white text-lg m-2">단어 등록 요청하러 가기</button>
    </div>
    <div v-show="!isResult" class="flex flex-col justify-center p-2 pb-16">
      <WordComponent v-for="word of searchResults" :key="word.id" :word="word" />
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRoute } from 'vue-router'
import { getSearchResults } from '@/api/word'

import SearchBarComponent from '@/components/common/SearchBarComponent.vue'
import WordComponent from "@/components/word/WordComponent.vue";

const isResult = ref(true)
const searchResults = ref([])

const route = useRoute()
const param = ref(route.query.q)

if (param.value !== undefined) {
  getSearchResults(param.value,
    (data) => {
      // 검색 결과 없는 경우 early exit
      if (data.data.length === 0) return

      isResult.value = false
      searchResults.value = data.data
    }, (error) => {
      console.log(error)
    }
  )
}

</script>
