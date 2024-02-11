<template>
  <div class="card card-compact bg-base-100 dark:bg-base-100 shadow-xl mb-4 p-2">
    <div class="card-body">
      <h2 class="card-title text-base">{{ word.wordNameEn }}</h2>
      <span class="text-gray-400 text-xs">{{ word.wordNameKr }}</span>
      <hr>
      <p class="text-sm leading-relaxed">{{ word.wordDef }}</p>
      <div v-if="word.wordCategory !== undefined" class="flex justify-start gap-1 mt-2 text-xs">
        <span v-for="category in word.wordCategory" :key="category.id">#{{ category }}</span>
      </div>
      <div class="text-wrap mt-2">
        <ul class="text-sm list-inside list-disc">참고 링크
          <li>
            <a :href="word.wordLink" class="text-xs text-blue-600">{{ word.wordLink }}</a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script setup>
defineProps({
  word: Object
})
</script>
