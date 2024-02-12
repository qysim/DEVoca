<template>
  <div class="flex justify-center m-2">
    <div class="card h-fit bg-base-100 shadow-xl">
      <!-- 유저 -->
      <AvartarComponent :userInfo="userInfo" @click="goProfile(userInfo.userId)"/>
      <!-- 본문 -->
      <div class="card-body p-4">
        <div @click="goCardDetail(card.cardId)">
          <WordComponent :word="word" v-if="card.originCardId === 0" />
          <OriginCardComponent :card="card" v-else />

          <div class="m-2">{{ card.cardContent }}</div>
        </div>

        <div class="flex justify-between p-2">
          <div class="flex gap-2">
            <ShareIcon @click="goShare(card.cardId)"/>
            <BookmarkIcon />
          </div>
          <div class="flex gap-4">
            <div class="flex gap-2">
              <LikeIcon />
              <p>{{ card.cardLikeCnt }}</p>
            </div>
            <div class="flex gap-2">
              <RepostIcon @click="goRepost(card)"/>
              <p>{{ card.cardRepostCnt }}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import AvartarComponent from '@/components/common/AvatarComponent.vue'
import WordComponent from "@/components/word/WordComponent.vue"
import ShareIcon from "@/components/icon/ShareIcon.vue"
import BookmarkIcon from "@/components/icon/BookmarkIcon.vue"
import LikeIcon from "@/components/icon/LikeIcon.vue"
import RepostIcon from "@/components/icon/RepostIcon.vue"
import { useUserStore } from '@/stores/user'
import { useRouter } from 'vue-router'
import { repostCard } from '@/api/card'
import OriginCardComponent from '@/components/feed/OriginCardComponent.vue'

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
  if (userId === userStore.kakaoUserInfo['id']) {
    router.push({name: 'MypageView'})
  } else {
    router.push({name: 'OtherUserProfileView', params: {id: userId}})
  }
}

const goCardDetail = function (cardId) {
  router.push({name: 'CardDetailView', params: {id: cardId}})
}

const goShare = async function (id) {
  const link = `https://i10d112.p.ssafy.io/card/detail/${id}`
  await navigator.clipboard.writeText(link)
  window.alert('클립보드에 링크가 복사되었습니다.')
}

const goRepost = (card) => {
  const cardInfo = {
    userId: card.userId, // 리포스트하는 유저아이디
    cardId: null,
    cardContent: card.cardContent, //새로 추가하는 내용
    cardLink: card.cardLink, // 새로 작성하는 참고링크
    cardRelatedKeywordList: card.cardRelatedKeywordList, // 새로 작성하는 연관개념
    originCardId: card.cardId, // 리포스트 대상이 되는 카드 id
    wordId: card.wordId // 조상 단어 id
  }
  repostCard(cardInfo, (res) => {
    console.log(res)
  }, (err) => {
    console.log(err)
  })
}
</script>
