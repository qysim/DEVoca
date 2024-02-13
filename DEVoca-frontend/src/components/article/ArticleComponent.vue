<template>
  <div class="flex justify-center m-2">
    <div class="card h-fit w-full bg-base-100 shadow-xl">
      <div class="card-body p-6">
        <p class="text-xl">{{ board.boardTitle }}</p>
        <div>{{ board.boardContent }}</div>

        <div class="flex justify-end ml-3">
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
import { defineProps } from 'vue';
import LikeIcon from "@/components/icon/LikeIcon.vue";
import ChatBubbleIcon from "@/components/icon/ChatBubbleIcon.vue";

const props = defineProps(['board']);
</script>
