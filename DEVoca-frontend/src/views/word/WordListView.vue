<template>
  <div class="flex flex-col justify-start">
    <div class="join join-vertical overflow-y-scroll overscroll-contain fixed z-10 h-[85svh]">
      <button class="btn join-item bg-base-100" v-for="alphabet in alphabets">{{ alphabet }}</button>
    </div>
    <div class="pl-12">
      <WordComponent />
      <WordComponent />
      <WordComponent />
      <WordComponent />
      <WordComponent />
      <WordComponent />
      <WordComponent />
      <WordComponent />
      <WordComponent />
      <WordComponent />
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import WordComponent from '@/components/word/WordComponent.vue'

const alphabets = ref('ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split(''))

</script>

<style scoped>

</style>