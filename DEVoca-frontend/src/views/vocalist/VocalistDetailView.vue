<template>
  <div class="flex flex-col items-center">
    <CardComponent v-for="(card, index) in cardList" :key="index" :card="card" />
    <p v-if="!cardList.length" class="text-xl m-12">저장한 단어가 없습니다</p>
  </div>
</template>

<script setup>
import { getVocaListDetail } from '@/api/vocalist'
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import CardComponent from "@/components/feed/CardComponent.vue"

const route = useRoute()
const cardList = ref([])

onMounted(() => {
  getVocaListDetail(route.params.id, (res) => {
    cardList.value = res.data
    console.log(res.data)
  }, (err) => {
    console.log(err)
  })
})
</script>