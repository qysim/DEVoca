<template>
  <div class="m-2">
    <SearchBarComponent />

    <h3 class="font-jalnan text-xl ml-2">최근 검색어</h3>
    <div class="mb-4">
      <a role="button" class="btn m-2 bg-devoca bg-opacity-50">pythorch</a>
      <a role="button" class="btn m-2 bg-devoca bg-opacity-50">python</a>
      <a role="button" class="btn m-2 bg-devoca bg-opacity-50">pypy</a>
      <a role="button" class="btn m-2 bg-devoca bg-opacity-50">코랩</a>
    </div>

    <h3 class="font-jalnan text-xl ml-2">인기 검색어</h3>
    <div class="flex justify-between">
      <div class="flex flex-col basis-1/2">
        <a role="button" class="btn btn-ghost m-2 justify-start rounded-none border-b-neutral-400">pythorch</a>
        <a role="button" class="btn btn-ghost m-2 justify-start rounded-none border-b-neutral-400">python</a>
        <a role="button" class="btn btn-ghost m-2 justify-start rounded-none border-b-neutral-400">pypy</a>
        <a role="button" class="btn btn-ghost m-2 justify-start rounded-none border-b-neutral-400">코랩</a>
        <a role="button" class="btn btn-ghost m-2 justify-start rounded-none border-b-neutral-400">데보카</a>
      </div>
      <div class="flex flex-col basis-1/2">
        <a role="button" class="btn btn-ghost m-2 justify-start rounded-none border-b-neutral-400">pythorch</a>
        <a role="button" class="btn btn-ghost m-2 justify-start rounded-none border-b-neutral-400">python</a>
        <a role="button" class="btn btn-ghost m-2 justify-start rounded-none border-b-neutral-400">pypy</a>
        <a role="button" class="btn btn-ghost m-2 justify-start rounded-none border-b-neutral-400">코랩</a>
        <a role="button" class="btn btn-ghost m-2 justify-start rounded-none border-b-neutral-400">데보카</a>
      </div>
    </div>

  </div>
</template>

<script setup>
import SearchBarComponent from '@/components/common/SearchBarComponent.vue'

</script>

<style scoped>

</style>