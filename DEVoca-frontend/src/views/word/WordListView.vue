<template>
  <div class="flex flex-col justify-start">
    <div class="join join-vertical overflow-y-scroll overscroll-contain fixed z-10 h-[85lvh]">
      <button class="btn join-item bg-base-100" v-for="alphabet in alphabets" @click="getAlphabetWord(alphabet)">{{ alphabet }}</button>
    </div>
    <div class="pl-12">
      <SearchBarComponent/>
      <div v-for="word in wordStore.wordList[selectedAlphabet]" :key="word.wordId">
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
const selectedAlphabet = ref('A')

onMounted(() => {
  if (!('A' in wordStore.wordList)) {
    getWordList('A', 
    (res) => {
      wordStore.wordList['A'] = res.data
    }, (err) => {
      console.log(err)
    })
  }
})

const getAlphabetWord = function (alphabet) {
  if (!(alphabet in wordStore.wordList)) {
    getWordList(alphabet, 
    (res) => {
      // console.log(res.data)
      wordStore.wordList[alphabet] = res.data
      // console.log(wordStore.wordList[alphabet])
    }, (err) => {
      console.log(err)
    })
  }
  selectedAlphabet.value = alphabet
}

const goWordDetail = function (wordId) {
  router.push({name: 'WordDetailView', params: {id: wordId}})
}

</script>