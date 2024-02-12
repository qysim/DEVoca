<template>
  <div class="flex justify-center m-2">
    <div class="card h-fit bg-base-100 shadow-xl">
      <!-- 유저 -->
      <AvartarComponent :userInfo="userInfo" @click="goProfile(userInfo.userId)"/>
      <!-- 본문 -->
      <div class="card-body p-4">
        <!-- originCard용 컴포넌트 만들기 -->
        <!-- <CardComponent :card="originCard" v-if="props.card.originCardId" /> -->

        <WordComponent :word="word" @click="goWordDetail(word.wordId)"/>

          
        <div class="m-2">{{ card.cardContent }}</div>
        
        <div v-if="card.cardRelatedKeywordList" class="flex justify-start gap-1 mt-2 text-xs">
          <span v-for="keyword in card.cardRelatedKeywordList" :key="keyword.id">#{{ keyword }}</span>
        </div>
        <hr>
        <div class="mt-2">
          <p>참고 링크</p>
          <a :href="card.cardLink" class="text-xs text-wrap break-words text-blue-600">{{ card.cardLink }} <LinkIcon class="inline"/></a>
        </div>

        <div class="flex justify-between p-2">
          <div class="flex gap-2">
            <button @click="bottom_modal.showModal">
              <ShareIcon />
            </button>
            <button>
              <BookmarkIcon />
            </button>
          </div>
          <div class="flex gap-4">
            <div class="flex gap-2">
              <LikeIcon />
              <p>{{ card.cardLikeCnt }}</p>
            </div>
            <div class="flex gap-2">
              <RepostIcon />
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
import CardComponent from '@/components/feed/CardComponent.vue'
import ShareIcon from "@/components/icon/ShareIcon.vue"
import BookmarkIcon from "@/components/icon/BookmarkIcon.vue"
import LikeIcon from "@/components/icon/LikeIcon.vue"
import RepostIcon from "@/components/icon/RepostIcon.vue"
import { useUserStore } from '@/stores/user'
import { useRouter } from 'vue-router'
import LinkIcon from "@/components/icon/LinkIcon.vue"

const userStore = useUserStore()
const router = useRouter()
const props = defineProps({
  card: Object
})
console.log(props.card)

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

const goWordDetail = function (wordId) {
  router.push({name: 'WordDetailView', params: {id: wordId}})
}

</script>