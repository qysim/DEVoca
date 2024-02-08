import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useWordStore = defineStore('word', () => {
  const wordList = ref({})

  return { wordList }
},{persist:true})
