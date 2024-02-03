<template>
  <div>
    <!-- 테스트용 코드 추후 변경 예정 -->
    <CardComponent />
    <CardComponent />
    <CardComponent />
    <CardComponent />
    <CardComponent />
    <CardComponent />
    <CardComponent />
    <CardComponent />
    <CardComponent />
    <CardComponent />
    <WriteButtonComponent onclick="bottom_modal.showModal()"/>
    <BottomModalComponent />
  </div>
</template>

<script setup>
import CardComponent from '@/components/feed/CardComponent.vue'
import WriteButtonComponent from '@/components/feed/WriteButtonComponent.vue'
import BottomModalComponent from '@/components/common/BottomModalComponent.vue'

</script>

<style scoped>

</style>