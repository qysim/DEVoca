<template>
<div class="ml-5 mt-5">
  <hr/>
  <p @click="goRoute()">● {{ notificationString[type] }}</p>
</div>
</template>

<script setup>
import { useRouter } from 'vue-router';
import { ref } from 'vue';
const router = useRouter();
const props = defineProps({
  notify: {
    type: Object,
    required: true
  },
});
const type = props.notify.notificationType;

const notificationString = ["내 게시글에 댓글이 달렸어요.", "내 댓글이 채택되었어요.",
  "내 카드가 좋아요를 받았어요.", "내 카드가 재게시되었어요.",
  "새로운 DM이 도착했어요.", "좋은 아침입니다! 오늘의 퀴즈가 도착했어요.",
  "내 카드에 댓글이 달렸어요."];

const notificationLink = ['/article/detail/', '/article/detail/', '/card/detail/',
  '/card/detail/', '/dmmessage/', '/quizpopup', '/card/detail/']

const goRoute = () => {
  let url = notificationLink[type] + ""
  if (type != 5) {
    url = url + props.notify.notificationLinkId + "";
  }
  router.push(url);
}
</script>