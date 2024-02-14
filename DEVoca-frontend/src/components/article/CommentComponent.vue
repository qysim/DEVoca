<template>
  <div class="flex justify-center m-2">
    <div class="card h-fit w-full bg-base-100 shadow-xl">
      <div class="card-body p-6">
        <div class="flex items-center gap-2">
          <div class="avatar basis-8">
            <img :src="comment.userImg" class="rounded-full" />
          </div>
          <h2 class="grow text-sm font-jalnan">{{ comment.userNickName }}</h2>
          <div class="flex flex-col basis-1/3 text-xs text-right">
            <span :key="dateString">{{ dateString }}</span>
            <span :key="timeString">{{ timeString }}</span>
          </div>
        </div>
        <hr class="mt-1 mb-2">
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

const props = defineProps({
  comment: Array
})

const datetime = new Date(props.comment.commentRegistDate)
const locale = 'ko-KR'
const options = { timeZone: 'Asia/Seoul' }
const dateString = ref(datetime.toLocaleDateString(locale, options))
const timeString = ref(datetime.toLocaleTimeString(locale, options))
</script>
