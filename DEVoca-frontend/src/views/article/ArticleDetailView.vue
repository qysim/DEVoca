<template>
  <div>
  <div class="flex mt-5 ml-5">
    <p class="text-2xl">Q</p>
    <p class="text-2xl text-devoca">&</p>
    <p class="text-2xl">A</p>
  </div>
  </div>
  <div>
    <AvatarComponent :userInfo="userInfo"/>
    <ArticleDetailComponent :boardInfo="boardInfo"/>
  </div>
  <div v-for="board in boards" :key="board.boardId">
      <!-- <ArticleComponent :board="board" @click="goArticleDetail(board.boardId)"/> -->
      <CommentComponent :comment="commentInfo"/>
  </div>
</template>

<script setup>
import {ref, onBeforeMount, onMounted } from 'vue';
import { getBoardDetail, getCommentList } from '@/api/board.js'
import { getUserInfo } from '@/api/user.js'
import AvatarComponent from '@/components/common/AvatarComponent.vue';
import ArticleDetailComponent from '@/components/article/ArticleDetailComponent.vue';
import CommentComponent from '@/components/article/CommentComponent.vue';

const props = defineProps({
  boardId: String
})

const userInfo = ref({
  userId: null,
  userImg: null,
  userIntro: null,
  userName: null,
  userNickName: null,
  cardRegistDate: null
})

const boardInfo = ref({
  boardId: null,
  boardContent: null,
  boardRegistDate: null,
  boardUpdateDate: null,
  boardTitle: null,
  boardType: 0
})

const comments = ref([])
const commentInfo = ref({
  boardId: null,
  cardId: null,
  commentContent: null,
  commentId: null,
  commentPicked: null,
  commentRegistDate: null,
  userId: null,
  userImg: null,
  userNickName: null
})

onMounted(async () => {
  boardInfo.value.boardId = props.boardId
  getBoardDetail(boardInfo.value.boardId, (res) => {
    boardInfo.value = res.data
    userInfo.value = res.data
    userInfo.value.cardRegistDate = res.data.boardRegistDate
    console.log(userInfo.value.cardRegistDate)
  }, (err) => {
    console.log(err)
  })
  getCommentList("board", props.boardId, (res) => {
    comments.value = res.data
    console.log(comments.value)
  }, (err) => {
    console.log(err)
  })
})
</script>

<style scoped>

</style>