<template>
  <div class="flex flex-col">
    <CardComponent v-for="(card, index) in cardList" :key="index" :card="card" />
  </div>
</template>

<script setup>
import { getVocaListDetail } from '@/api/vocalist'
import { ref, onMounted } from 'vue'
import CardComponent from "@/components/feed/CardComponent.vue"

const cardList = ref([])

onMounted(() => {
  // TODO: 무한 스크롤 적용 필요
  getVocaListDetail(9, (res) => {
    cardList.value = res.data
    console.log(res.data)
  }, (err) => {
    console.log(err)
  })
})
</script>