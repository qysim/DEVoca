<template>
  <div class="card card-side bg-base-100 items-center py-2 px-4">
    <div class="avatar basis-1/6">
      <div class="rounded-full">
        <img :src="userInfo.userImg" />
      </div>
    </div>
    <div class="card-body grow p-2">
      <div class="flex flex-col">
        <h2 class="card-title text-lg font-jalnan">{{ userInfo.userNickName }}</h2>
        <span class="text-sm">{{ userInfo.userIntro }}</span>
      </div>
    </div>
    <div class="flex flex-col basis-1/3 text-xs text-right">
      <span class="">{{ dateString }}</span>
      <span class="">{{ timeString }}</span>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const props = defineProps({
  userInfo: Object
})

const datetime = new Date(props.userInfo.cardRegistDate)
const locale = 'ko-KR'
const options = { timeZone: 'Asia/Seoul' }
const dateString = ref(datetime.toLocaleDateString(locale, options))
const timeString = ref(datetime.toLocaleTimeString(locale, options))
</script>
