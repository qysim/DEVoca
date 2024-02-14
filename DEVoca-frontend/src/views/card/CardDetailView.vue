<template>
  <div>
    <div class="bg-neutral-100 py-1">
      <CardDetailComponent :card="card" v-if="card"/>
    </div>

    <div class="input-container flex mx-2 mt-4">
      <input type="text" placeholder="댓글을 남겨보세요" class="input input-bordered w-full" v-model="inputComment" @keyup.enter="submitComment"/>
      <button @click="submitComment" class="btn bg-devoca text-white text-lg">등록</button>
    </div>

    <div class="collapse collapse-arrow bg-base-100 shadow-xl m-2 w-auto">
      <input type="checkbox" /> 
      <div class="collapse-title text-xl font-jalnan">
        댓글
      </div>
      <div class="collapse-content"> 
        <div v-show="hasCommentResults" class="flex flex-col">
          <CardCommentComponent v-for="(comment, index) in commentList" :key="index" :comment="comment" 
            @update-comments="updateComments"/>
        </div>
      </div>
    </div>
  </div>  
</template>

<script setup>
import { ref, onMounted } from 'vue'
import CardDetailComponent from '@/components/feed/CardDetailComponent.vue'
import CardCommentComponent from "@/components/feed/CardCommentComponent.vue"
import { getCardDetail, getCommentList, registComment } from '@/api/card'

const props = defineProps({
  id: String
})

const card = ref(null)
const inputComment = ref(null)
const hasCommentResults = ref(false)
const commentList = ref([])

const submitComment = () => {
  const commentInfo = {
    cardBoardId: props.id,
    flag: 'card',
    commentContent: inputComment.value
  }
  // console.log(commentInfo)
  registComment(commentInfo, (res) => {
    inputComment.value = ''
    updateComments()
  }, (err) => {
    console.log(err)
  })
}

const updateComments = () => {
  getCommentList(props.id, (res) => {
    hasCommentResults.value = res.data.length > 0
    if (!hasCommentResults.value) return
    commentList.value = res.data
    console.log(res.data)
  }, (err) => {
    console.log(err)
  })
}

onMounted(() => {
  getCardDetail(props.id, (res) => {
    card.value = res.data
  }, (err) => {
    console.log(err)
  })

  updateComments()
})
</script>

<style scoped>

</style>