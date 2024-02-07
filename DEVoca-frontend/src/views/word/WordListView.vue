<template>
  <div class="flex flex-col justify-start">
    <div class="join join-vertical overflow-y-scroll overscroll-contain fixed z-10 h-[85lvh]">
      <button class="btn join-item bg-base-100" v-for="alphabet in alphabets">{{ alphabet }}</button>
    </div>
    <div class="pl-12">
      <div v-for="word in wordList">
        <WordComponent :word="word"/>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import WordComponent from '@/components/word/WordComponent.vue'
import { getWordList } from '@/api/word.js'

const alphabets = ref('ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split(''))
const wordList = ref(null)

onMounted(() => {
  getWordList('A', (res) => {
    // console.log(res)
    wordList.value = res.data.slice(0, 10)
    // console.log(wordList.value)
  }, (err) => {
    console.log(err)
  })
})

</script>

<style scoped>

</style>