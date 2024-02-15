<template>
<p class="ml-5 mt-5">
  <a @click="goRoute()">● {{ notificationString[props.pushedData.notificationType] }}</a>
</p> 

</template>

<script setup>
import { useRouter } from 'vue-router'
const router = useRouter();
const props = defineProps({
  pushedData: {
    type: Object,
    required: true
  },
});

const notificationString = ["내 게시글에 댓글이 달렸어요.", "내 댓글이 채택되었어요.",
  "내 카드가 좋아요를 받았어요.", "내 카드가 재게시되었어요.",
  "새로운 DM이 도착했어요.", "좋은 아침입니다! 오늘의 퀴즈가 도착했어요.",
  "내 카드에 댓글이 달렸어요."];

const goRoute = () => {

}
</script>