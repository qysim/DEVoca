<template>
  <div class="card card-side bg-base-100 items-center py-2 px-4">
    <div class="avatar basis-1/6">
      <div class="rounded-full">
        <img :src="userInfo.userImg" />
      </div>
    </div>
    <div class="card-body grow p-2">
      <div class="flex flex-col">
        <h2 class="card-title text-lg font-jalnan">{{ userInfo.userNickname }}</h2>
        <span class="text-sm">{{ userInfo.userIntro }}</span>
      </div>
    </div>
    <div class="flex flex-col basis-1/4 text-right">
      <button v-if="userInfo.followingYn === 'Y'" class="btn bg-devoca text-white">팔로우</button>
      <button v-else class="btn bg-devoca text-white">팔로잉</button>
    </div>
  </div>
</template>

<script setup>
defineProps({
  userInfo: Object
})
</script>
