<template>
  <div class="flex justify-between p-2">
    <div class="flex gap-2">
      <!-- 링크 공유 -->
      <ShareIcon @click="doShare(card.cardId)"/>
      <!-- 단어장 저장하기 -->
      <BookmarkIcon @click="selectModal"/>
      <VocalistSelectModal :class="{'modal-open' : isShowModal}" @close-modal="isShowModal = false" 
        :vocalistInfo="vocalistInfo" @load-vocalist="loadVocalist" v-if="vocalistInfo"/>
    </div>
    <div class="flex gap-4">
      <div class="flex gap-2">
        <!-- 좋아요 -->
        <label class="swap swap-flip">
          <input type="checkbox" @click="likeCards()" v-model="card.cardLikeYN"/>
          <div class="swap-on"><LikeIcon class="stroke-devoca" /></div>
          <div class="swap-off"><LikeIcon /></div>
        </label>
        <p class="mt-1">{{ card.cardLikeCnt }}</p>
      </div>
      <!-- 리포스트 -->
      <div class="flex gap-2">
        <RepostIcon @click="goRepost(card)"/>
        <p class="mt-1">{{ card.cardRepostCnt }}</p>
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
import { likeCard } from '@/api/card'
import { checkVocaList } from '@/api/vocalist'
import VocalistSelectModal from '@/components/vocalist/VocalistSelectModal.vue'

const userStore = useUserStore()
const router = useRouter()
const props = defineProps({
  card: Object
})
const vocalistInfo = ref(null)

const doShare = async function (id) {
  const link = `https://i10d112.p.ssafy.io/card/detail/${id}`
  await navigator.clipboard.writeText(link)
  window.alert('클립보드에 링크가 복사되었습니다.')
}

const isShowModal = ref(false) // 모달 표시 플래그
const selectModal = () => {
  isShowModal.value = true
}

const loadVocalist = () => {
  checkVocaList(props.card.cardId, (res) => {
    vocalistInfo.value = res.data
    vocalistInfo.value.forEach((obj) => {obj.cardId = props.card.cardId})
  }, (err) => {
    console.log(err)
  })
}

const likeCards = () => {
  likeCard(props.card.cardId, {cardLikeYN : props.card.cardLikeYN}, (res) => {
    props.card.cardLikeCnt += props.card.cardLikeYN ? 1 : -1
  }, (err) => {
    console.log(err)
  })
}

// TODO : 전달할 데이터 정의하기
const goRepost = () => {
  // const cardInfo = {
  //   userId: card.userId, // 리포스트하는 유저아이디
  //   cardId: null,
  //   cardContent: card.cardContent, //새로 추가하는 내용
  //   cardLink: card.cardLink, // 새로 작성하는 참고링크
  //   cardRelatedKeywordList: card.cardRelatedKeywordList, // 새로 작성하는 연관개념
  //   originCardId: card.cardId, // 리포스트 대상이 되는 카드 id
  //   wordId: card.wordId // 조상 단어 id
  // }
  // repostCard(cardInfo, (res) => {
  //   console.log(res)
  // }, (err) => {
  //   console.log(err)
  // })
  // router.push({name: 'CardRepostView', state: {
  //   repostInfo : {
  //       userId: userStore.kakaoUserInfo['id'], // 리포스트하는 유저아이디
  //       cardId: props.card.cardId,
  //       cardContent: props.card.cardContent, //새로 추가하는 내용
  //       cardLink: props.card.cardLink, // 새로 작성하는 참고링크
  //       cardRelatedKeywordList: props.card.cardRelatedKeywordList, // 새로 작성하는 연관개념
  //       originCardId: props.card.cardId, // 리포스트 대상이 되는 카드 id
  //       wordId: props.card.wordId // 조상 단어 id
  //   }}})
}

onMounted(() => {
  loadVocalist()
})
</script>
