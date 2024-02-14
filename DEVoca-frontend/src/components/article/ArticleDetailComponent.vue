<template>
  <div class="card bg-base-100 shadow-xl m-2">
    <div class="card-body">
      <div class="flex pb-2">
        <p class="text-xl">{{ props.boardInfo.boardTitle }}</p>
      </div>
      <div class="flex justify-between"> 
        <div>
          <p>{{ props.boardInfo.boardContent }}</p>
        </div>
        <div class="flex flex-row ml-3">
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
const props = defineProps({
  boardInfo: Object
})
</script>

<style scoped>

</style>