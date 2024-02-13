<template>
  <div class="m-2">
    <SearchBarComponent />

    <h3 class="font-jalnan text-xl ml-2">최근 검색어</h3>
    <div class="mb-4">
      <p v-if="recentKeywordList.length === 0" class="text-center m-8">최근 검색어가 없습니다.</p>
      <RouterLink v-else :to="{ name: 'SearchResultView', query: { q: item } }" v-for="(item, index) in recentKeywordList"
        :key="index" role="button" class="btn m-2 px-6 bg-devoca bg-opacity-50">{{ item }}</RouterLink>
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
import { ref, onMounted } from 'vue'
import SearchBarComponent from '@/components/common/SearchBarComponent.vue'
import { getRecentKeyword } from "@/api/search";

const recentKeywordList = ref([])

onMounted(async () => {
  await getRecentKeyword((res) => {
    if (res.data.length > 0) {
      recentKeywordList.value = res.data
    }
  }, null)
})

</script>
