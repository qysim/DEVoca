<template>
  <div class="flex justify-center">
    <div class="card h-fit bg-base-100 shadow-xl">
      <!-- 유저 -->
      <AvartarComponent :userInfo="userInfo" />
      <!-- 본문 -->
      <div class="card-body p-4">
        <div class="m-2">{{ card.originCardContent }}</div>
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
  userId: props.card.userId,
  userImg: props.card.userImg,
  userIntro: props.card.userIntro,
  userNickName: props.card.userNickName,
  cardRegistDate: props.card.cardRegistDate
})
</script>
