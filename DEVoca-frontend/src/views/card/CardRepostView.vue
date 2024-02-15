<template>
  <div class="p-3">
    <OriginCardComponent :card="card" />

    <form @submit.prevent="submitCard">
      <textarea class="textarea textarea-bordered w-full h-[30vh] resize-none mb-2" placeholder="나누고 싶은 글을 적어주세요"
      v-model="inputData.cardContent"></textarea>
      
      <label class="form-control w-full mb-4">
        <div class="label">
          <span class="label-text font-jalnan text-lg px-2">참고 링크</span>
        </div>
        <input type="text" placeholder="www.example.com" class="input input-bordered w-full" 
        v-model="inputData.cardLink"/>
      </label>

      <label class="form-control w-full mb-4">
        <div class="label">
          <span class="label-text font-jalnan text-lg px-2">연관 개념</span>
        </div>
        <input type="text" placeholder="연관 개념을 , (쉼표) 로 구분해 입력해주세요" class="input input-bordered w-full" 
        v-model="inputData.cardRelatedKeywordList"/>
      </label>
      
      <div class="flex justify-end">
        <button class="btn btn-md bg-devoca text-white text-lg">게시</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { repostCard } from '@/api/card'
import OriginCardComponent from '@/components/feed/OriginCardComponent.vue'

const router = useRouter()
const repostInfo = history.state.repostInfo
console.log(repostInfo)

const inputData = ref({
  // userId: userStore.kakaoUserInfo['id'],
  wordId: null,
  cardContent: null,
  cardLink: null,
  cardRelatedKeywordList: null
})

const submitCard = function () {
  // if (inputData.value.cardRelatedKeywordList) {
  //   inputData.value.cardRelatedKeywordList = inputData.value.cardRelatedKeywordList.
  //     split(',').map(item => item.trim()).filter(item => item !== '')
  // }
  // registCard(inputData.value, (res) => {
  //   router.push({name: 'MainView'})
  // }, (err) => {
  //   console.log(`err : ${err}`)
  // })
}

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

</script>