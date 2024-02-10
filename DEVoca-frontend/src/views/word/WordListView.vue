<template>
  <div class="flex flex-col justify-start">
    <div class="join join-vertical overflow-y-scroll overscroll-contain fixed z-10 h-[85lvh]">
      <button class="btn join-item bg-base-100" v-for="alphabet in alphabets" @click="getAlphabetWord(alphabet)">{{ alphabet }}</button>
    </div>
    <div class="pl-12">
      <SearchBarComponent/>
      <div v-for="word in wordList" :key="word.wordId">
        <WordComponent :word="word" @click="goWordDetail(word.wordId)"/>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import WordComponent from '@/components/word/WordComponent.vue'
import SearchBarComponent from '@/components/common/SearchBarComponent.vue'
import { getWordList } from '@/api/word'
import { useWordStore } from '@/stores/word'

const router = useRouter()
const wordStore = useWordStore()
const alphabets = ref('ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split(''))
const wordList = ref(null)

onMounted(() => {
  if ('A' in wordStore.wordList) {
    wordList.value = wordStore.wordList['A']
  } else {
    getWordList('A', (res) => {
      wordList.value = res.data
      wordStore.wordList['A'] = res.data
      console.log(wordStore.wordList)
    }, (err) => {
      console.log(err)
    })
  }
})

const getAlphabetWord = function (alphabet) {
  if (alphabet in wordStore.wordList) {
    wordList.value = wordStore.wordList[alphabet]
  } else {
    getWordList(alphabet, (res) => {
      wordList.value = res.data
      wordStore.wordList[alphabet] = res.data
      console.log(wordStore.wordList)
    }, (err) => {
      console.log(err)
    })
  }
}

const goWordDetail = function (wordId) {
  router.push({name: 'WordDetailView', params: {id: wordId}})
}

</script>