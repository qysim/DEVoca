<template>
  <div class="flex justify-center m-2">
    <div class="card h-fit w-full bg-base-100 shadow-xl">
      <AvartarComponent :userInfo="userInfo" />

      <div class="card-body p-6">
        <div class="flex justify-between">
          <p class="ml-3">{{ comment.commentContent }}</p>
          <div class="flex justify-end" v-if="comment.userId == userStore.kakaoUserInfo['id']">
            <button class="btn btn-sm text-white text-lg bg-devoca" @click="deleteComments(comment.commentId)">삭제</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import AvartarComponent from '@/components/common/AvatarComponent.vue'
import { useUserStore } from '@/stores/user'
import { deleteComment } from '@/api/card'

const props = defineProps({
  comment: Object
})
const emit = defineEmits(['updateComments'])
const userStore = useUserStore()

// console.log(props.comment)
const userInfo = ref({
  userId: props.comment.userId,
  userImg: props.comment.userImg,
  userIntro: props.comment.userIntro,
  userNickName: props.comment.userNickName,
  cardRegistDate: props.comment.commentRegistDate
})

const deleteComments = (commentId) => {
  deleteComment(commentId, (res) => {
    console.log(res)
    emit('updateComments')
  }, (err) => {
    console.log(err)
  })
}
</script>
