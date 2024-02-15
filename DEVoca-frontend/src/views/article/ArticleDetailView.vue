<template>
  <div class="flex my-2 ml-5">
    <p class="text-2xl">Q<span class="text-devoca">&</span>A</p>
  </div>
  <ArticleDetailComponent :key="boardInfo" :board="boardInfo" />
  <p class="ml-5 mt-5">댓글 {{ comments.length }}개</p>
  <div v-for="comment in comments" :key="comment.commentId">
    <CommentComponent :comment="comment" />
  </div>
</template>

<script setup>
import { ref, onBeforeMount } from 'vue';
import { getBoardDetail, getCommentList } from '@/api/board.js'
import ArticleDetailComponent from "@/components/article/ArticleDetailComponent.vue";
import CommentComponent from "@/components/article/CommentComponent.vue";

const props = defineProps({
  boardId: String
})

const userInfo = ref({})
const boardInfo = ref({})
const comments = ref([])

const dateString = ref('')
const timeString = ref('')

onBeforeMount(() => {
  getBoardDetail(props.boardId, (res) => {
    boardInfo.value = res.data
    userInfo.value = {
      userIdx: res.data.userIdx,
      userId: res.data.userId,
      userNickName: res.data.userNickName,
      userImg: res.data.userImg,
      cardRegistDate: res.data.boardRegistDate
    }

    const datetime = new Date(boardInfo.value.boardRegistDate)
    const locale = 'ko-KR'
    const options = { timeZone: 'Asia/Seoul' }
    dateString.value = datetime.toLocaleDateString(locale, options)
    timeString.value = datetime.toLocaleTimeString(locale, options)
  }, (err) => {
    console.log(err);
    router.push({ name: 'MainView' });
    alert("존재하지 않는 게시글입니다.");
  })

  getCommentList("board", props.boardId, (res) => {
    comments.value = res.data
  }, null)
})
</script>
