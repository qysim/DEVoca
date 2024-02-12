<template>
  <div class="flex justify-center m-2">
    <div class="card h-fit bg-base-100 shadow-xl">
      <!-- 유저 -->
      <AvartarComponent :userInfo="userInfo" />
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
import WordComponent from "@/components/word/WordComponent.vue"
import CardComponent from '@/components/feed/CardComponent.vue'
import { useUserStore } from '@/stores/user'
import { useRouter } from 'vue-router'

const userStore = useUserStore()
const router = useRouter()
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

const word = ref({
  wordId: props.card.wordId,
  wordNameEn: props.card.wordNameEn,
  wordNameKr: props.card.wordNameKr,
  wordSumm: props.card.wordSumm,
})

const originCard = ref({
  originCardId: props.card.originCardId,
  originUserNickName: props.card.originUserNickName,
  originUserImg: props.card.originUserImg,
  originCardContent : props.card.originCardContent
})

const goProfile = function (userId) {
  if (userId === userStore.kakaoUserInfo['id'].toString()) {
    router.push({name: 'MypageView'})
  } else {
    router.push({name: 'OtherUserProfileView', params: {id: userId}})
  }
}

const goCardDetail = function (cardId) {
  router.push({name: 'CardDetailView', params: {id: cardId}})
}
</script>
