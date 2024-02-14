<template>
  <div class="flex justify-between p-2">
    <div class="flex gap-2">
      <!-- 링크 공유 -->
      <ShareIcon @click="goShare(card.cardId)"/>
      <!-- 단어장 저장하기 -->
      <BookmarkIcon @click="selectModal"/>
      <VocalistSelectModal :class="{'modal-open' : isShowModal}" @close-modal="isShowModal = false" 
        :vocalistInfo="vocalistInfo" @load-vocalist="loadVocalist"/>
    </div>
    <div class="flex gap-4">
      <div class="flex gap-2">
        <!-- 좋아요 -->
        <label class="swap swap-flip">
          <input type="checkbox" />
          <div class="swap-on"><LikeIcon :class="{'stroke-devoca' : card.likeYn}" @click="likeCards()"/></div>
          <div class="swap-off"><LikeIcon @click="likeCards()"/></div>
        </label>
        <p>{{ card.cardLikeCnt }}</p>
      </div>
      <!-- 리포스트 -->
      <div class="flex gap-2">
        <RepostIcon @click="goRepost(card)"/>
        <p>{{ card.cardRepostCnt }}</p>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import ShareIcon from "@/components/icon/ShareIcon.vue"
import BookmarkIcon from "@/components/icon/BookmarkIcon.vue"
import LikeIcon from "@/components/icon/LikeIcon.vue"
import RepostIcon from "@/components/icon/RepostIcon.vue"
import { useUserStore } from '@/stores/user'
import { useRouter } from 'vue-router'
import { likeCard, repostCard } from '@/api/card'
import { checkVocaList } from '@/api/vocalist'
import VocalistSelectModal from '@/components/vocalist/VocalistSelectModal.vue'

const userStore = useUserStore()
const router = useRouter()
const props = defineProps({
  card: Object
})
const emit = defineEmits(['loadCard'])
const vocalistInfo = ref(null)
// console.log(props.card)

const goShare = async function (id) {
  const link = `https://i10d112.p.ssafy.io/card/detail/${id}`
  await navigator.clipboard.writeText(link)
  window.alert('클립보드에 링크가 복사되었습니다.')
}

const isShowModal = ref(false) // 모달 표시 플래그
const selectModal = () => {
  isShowModal.value = true
}

const likeCards = (likeYn) => {
  console.log(props.card.cardLikeYN)

  likeCard(props.card.cardId, {cardLikeYN : props.card.cardLikeYN}, (res) => {
    console.log(res)
    emit('loadCard') // TODO : 상위컴포넌트마다 emit 설정
  }, (err) => {
    console.log(err)
  })
}

// TODO : 전달할 데이터 정의하기
const goRepost = () => {
  router.push({name: 'CardRepostView', state: {
    repostInfo : {
        userId: userStore.kakaoUserInfo['id'], // 리포스트하는 유저아이디
        cardId: props.card.cardId,
        cardContent: props.card.cardContent, //새로 추가하는 내용
        cardLink: props.card.cardLink, // 새로 작성하는 참고링크
        cardRelatedKeywordList: props.card.cardRelatedKeywordList, // 새로 작성하는 연관개념
        originCardId: props.card.cardId, // 리포스트 대상이 되는 카드 id
        wordId: props.card.wordId // 조상 단어 id
    }}})
}

const loadVocalist = () => {
  checkVocaList(props.card.cardId, (res) => {
    vocalistInfo.value = res.data
    vocalistInfo.value.forEach((obj) => {obj.cardId = props.card.cardId})
    // console.log(vocalistInfo.value)
  }, (err) => {
    console.log(err)
  })
}

onMounted(() => {
  loadVocalist()
})
</script>
