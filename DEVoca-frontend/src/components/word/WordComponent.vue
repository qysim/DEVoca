<template>
  <div class="card bg-base-100 shadow-xl m-2">
    <div class="card-body">
      <div class="flex justify-between pb-2">
        <h2 class="card-title">{{ word.wordNameEn }}</h2>
        <h2 class="card-title">{{ word.wordNameKr }}</h2>
      </div>
      <p>{{ word.wordSumm }}</p>
      <p>{{ word.wordDef }}</p>
      <p>{{ word.wordLink }}</p>
      <div>
        <p v-for="category in word.wordCategory" class="inline-block mr-4"># {{ category }}</p>
      </div>
    </div>
  </div>
</template>

<script setup>

const props = defineProps({
  word: Object
})

</script>

<style scoped>

</style>