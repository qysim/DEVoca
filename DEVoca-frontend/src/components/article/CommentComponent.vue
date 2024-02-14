<template>
  <div class="flex justify-center m-2">
    <!-- TODO: 클릭 시 해당 글로 이동 -->
    <div class="card h-fit w-full bg-base-100 shadow-xl">
      <AvartarComponent :userInfo="userInfo" />

      <div class="card-body p-6">
        <div class="flex justify-between">
          <p class="ml-3">{{ comment.commentContent }}</p>
          <div class="flex justify-end">
            <button class="btn btn-sm text-white text-lg" :class="{ 'bg-devoca': comment.commentPicked }">채택</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue"
import AvartarComponent from '@/components/common/AvatarComponent.vue'

const props = defineProps({
  comment: Object
})
console.log(props.comment)

const userInfo = ref({
  userId: props.comment.userId,
  userImg: props.comment.userImg,
  userIntro: props.comment.userIntro,
  userNickName: props.comment.userNickName,
  cardRegistDate: props.comment.commentRegistDate
})

const comment = ref({
  boardId: null,
  cardId: null,
  commentContent: null,
  commentId: null,
  commentPicked: null,
  commentRegistDate: null
})
</script>
