<template>
  <div class="m-12 flex flex-col">
    <RouterLink :to="{name: 'VocalistDetailView', params: {id: 9}}" class="btn btn-lg w-full bg-base-100 shadow-xl flex justify-between my-2">
      <p>북마크</p>
      <RightArrowIcon />
    </RouterLink>
  </div>
</template>

<script setup>
import RightArrowIcon from '@/components/icon/RightArrowIcon.vue'

</script>

<style scoped>

</style>