<template>
  <div class="flex justify-center m-2">
    <div class="card h-fit w-full bg-base-100 shadow-xl">
      <div class="card-body p-6">
        <AvatarComponent :userInfo="userInfo" />
        <p class="text-xl">{{ board.boardTitle }}</p>
        <p>{{ board.boardContent }}</p>
      </div>
    </div>
  </div>
</template>

<script setup>
import {ref, onMounted } from 'vue';
import LikeIcon from "@/components/icon/LikeIcon.vue";
import ChatBubbleIcon from "@/components/icon/ChatBubbleIcon.vue";
import AvatarComponent from '@/components/common/AvatarComponent.vue';

const props = defineProps({
  board: Object
});

const userInfo = ref({
  userImg: props.board.userImg,
  userNickName: props.board.userNickName,
  cardRegistDate: props.board.boardRegistDate
});


</script>

