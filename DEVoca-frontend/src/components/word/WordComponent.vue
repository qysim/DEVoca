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
      <p>{{ word.wordCategory }}</p>
    </div>
  </div>
</template>

<script setup>

const props = defineProps({
  word: Object
})

console.log(props.word)

</script>

<style scoped>

</style>