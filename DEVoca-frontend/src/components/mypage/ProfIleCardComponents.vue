<template>
  <div class="card card-side bg-devoca_skyblue bg-opacity-60">
    <div class="avatar">
      <div class="w-24 h-24 rounded-full my-auto ml-5">
        <img :src="userInfo.userImg" />
      </div>
    </div>
    <div class="card-body">
      <div class="flex flex-row justify-between">
        <h2 class="card-title mt-6 font-jalnan">{{ userInfo.userNickName }}</h2>
        <div class="flex justify-start gap-3">
          <router-link :to="{ name: 'ProfileChangeView', params: { id: userId } }">
            <PenIcon />
          </router-link>
          <router-link :to="{ name: 'MypageSettingView', params: { id: userId } }">
            <ConfigIcon />
          </router-link>
        </div>
      </div>
      <p class="text-sm">{{ userInfo.userIntro }}</p>
      <div class="flex-row mt-2">
        <router-link :to="{ name: 'FollowView', params: { option: 'following' } }" class="mr-5 text-sm">
          팔로우 {{ userInfo.userFollowingCnt }}
        </router-link>
        <router-link :to="{ name: 'FollowView', params: { option: 'follower' } }" class="text-sm">
          팔로워 {{ userInfo.userFollowerCnt }}
        </router-link>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { getUserInfo } from '@/api/user.js'
import PenIcon from '@/components/icon/PenIcon.vue'
import ConfigIcon from '@/components/icon/ConfigIcon.vue'

const userInfo = ref({})
const userId = ref(0)

// TODO: 로그인 시 이 로직이 포함되어야 함. 로그인 완료되면 이렇게 직접 호출하는게 아니라 userStore에서 가져다 사용.
onMounted(() => {
  getUserInfo((res) => {
    userInfo.value = res.data
    userId.value = Number(userInfo.value.userId)
    // userId.value = userStore.kakaoUserInfo['id']
    console.log(res.data)
  }, (err) => {
    console.err(err)
  })
})
</script>
