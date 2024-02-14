<template>
  <div class="flex justify-center">
    <div class="card h-fit bg-base-100 shadow-xl w-full">
      <!-- 유저 -->
      <AvartarComponent :userInfo="userInfo" :isOrigin="true"/>
      <!-- 본문 -->
      <div class="card-body p-4">
        <div class="m-2">{{ card.cardContent }}</div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import AvartarComponent from '@/components/common/AvatarComponent.vue'

const props = defineProps({
  card: Object
})

const userInfo = ref({
  userNickName: props.card.originUserNickName,
  userImg: props.card.originUserImg,
  cardRegistDate: ''
})

const originCard = ref({
  originUserImg: props.card.originUserImg,
  originUserNickName: props.card.originUserNickName,
  originCardId: props.card.originCardId,
  originCardContent: props.card.originCardContent
})
</script>
