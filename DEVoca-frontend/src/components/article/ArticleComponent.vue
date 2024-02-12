<template>
  <div class="card bg-base-100 shadow-xl m-2">
    <div class="card-body">
      <div class="flex pb-2">
        <p class="text-xl">글 제목</p>
      </div>
      <div class="flex justify-between">
        <div>
          <p>유저 이름</p>
        </div>
        <div class="flex flex-row ml-3">
          <div class="flex">
            <LikeIcon />
            <p class="mt-1 ml-1">5</p>
          </div>
          <div class="flex">
            <ChatBubbleIcon />
            <p class="mt-1">5</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import LikeIcon from "@/components/icon/LikeIcon.vue";
import ChatBubbleIcon from "@/components/icon/ChatBubbleIcon.vue";
</script>
