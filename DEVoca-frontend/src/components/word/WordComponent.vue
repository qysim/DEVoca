<template>
  <div class="card card-compact bg-base-100 dark:bg-base-100 shadow-xl mb-4 p-2">
    <div class="card-body">
      <h2 class="card-title text-base">{{ word.wordNameEn }}</h2>
      <span class="text-gray-400 text-xs">{{ word.wordNameKr }}</span>
      <hr>
      <p class="text-sm">{{ word.wordSumm }}</p>
      <div v-if="word.wordCategory !== undefined" class="flex justify-start gap-1 mt-2 text-xs">
        <span v-for="category in word.wordCategory" :key="category.id">#{{ category }}</span>
      </div>
    </div>
  </div>
</template>

<script setup>
defineProps({
  word: Object
})
</script>
