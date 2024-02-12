<template>
  <div class="card card-side bg-devoca_skyblue">
    <div class="avatar">
      <div class="w-24 h-24 rounded-full my-10 ml-5">
        <img :src="userInfo.userImg" />
      </div>
    </div>
    <div class="card-body">
      <div class="flex flex-row justify-between">
        <h2 class="card-title mt-6">{{ userInfo.userNickname }}</h2>
        <div class="flex justify-start gap-2">
          <router-link :to="{ name: 'ProfileChangeView', params: { id: userId } }">
            <PenIcon />
          </router-link>
          <router-link :to="{ name: 'MypageSettingView', params: { id: userId } }">
            <ConfigIcon />
          </router-link>
        </div>
      </div>
      <p class="text-sm">{{ userInfo.userIntro }}
      <div class="flex-row">
        <router-link :to="{ name: 'FollowView' }" class="mr-5 text-sm">팔로우 {{ userInfo.userFollowingCnt }}</router-link>
        <router-link :to="{ name: 'FollowerView' }" class="text-sm">팔로워 {{ userInfo.userFollowerCnt }}</router-link>
      </div>
      </p>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { getUserInfo } from '@/api/user.js'
import { useUserStore } from '@/stores/user'
import PenIcon from '@/components/icon/PenIcon.vue'
import ConfigIcon from '@/components/icon/ConfigIcon.vue'

const userStore = useUserStore()
const userInfo = ref({})
const userId = ref(null)

// TODO: 로그인 시 이 로직이 포함되어야 함. 로그인 완료되면 이렇게 직접 호출하는게 아니라 userStore에서 가져다 사용.
onMounted(() => {
  getUserInfo((res) => {
    userInfo.value = res.data
    userId.value = userStore.kakaoUserInfo['id']
  }, (err) => {
    console.err(err)
  })
})

</script>
