<template>
  <div>
    <div v-for="card in cardList">
      <CardComponent :card="card" />
    </div>
    <WriteButtonComponent @click="bottom_modal.showModal()"/>
    <BottomModalComponent />
  </div>
</template>

<script setup>
import CardComponent from '@/components/feed/CardComponent.vue'
import WriteButtonComponent from '@/components/feed/WriteButtonComponent.vue'
import BottomModalComponent from '@/components/common/BottomModalComponent.vue'
import { getCardList } from '@/api/card'
import { ref, onMounted } from 'vue'

const cardList = ref(null)
const scrollNum = ref(0)

onMounted(() => {
  getCardList(scrollNum.value, (res) => {
    cardList.value = res.data
    console.log(res)
  }, (err) => {
    console.log(err)
  })
})

</script>

<style scoped>

</style>