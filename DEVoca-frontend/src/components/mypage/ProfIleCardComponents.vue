<template>
  <div class="card card-side bg-devoca_skyblue">
    <div class="avatar">
      <div class="w-24 h-24 rounded-full my-10 ml-5">
        <img :src="userInfo.userImg" />
      </div>
    </div>
    <div class="card-body">
      <div class="flex flex-row justify-between">
        <h2 class="card-title mt-6">{{ userInfo.userNickName }}</h2>
        <template v-if="props.otherUserId === undefined && userInfo.userId">
          <div class="flex justify-start gap-2">
            <router-link :to="{ name: 'ProfileChangeView', params: { id: userInfo.userId } }">
              <PenIcon />
            </router-link>
            <router-link :to="{ name: 'MypageSettingView', params: { id: userInfo.userId } }">
              <ConfigIcon />
            </router-link>
          </div>
        </template>
      </div>
      <p class="text-sm">{{ userInfo.userIntro }}</p>
      <div class="flex-row">
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
import { ref, onBeforeMount } from 'vue';
import { getUserInfo, getOtherUserInfo } from '@/api/user.js'
import PenIcon from '@/components/icon/PenIcon.vue'
import ConfigIcon from '@/components/icon/ConfigIcon.vue'

const userInfo = ref({})

const props = defineProps({
  otherUserId: String
})

onBeforeMount(() => {
  if (props.otherUserId === undefined) {
    // 내 프로필 조회인 경우
    getUserInfo((res) => {
      userInfo.value = res.data
    }, null)
  } else {
    // 다른 사람 프로필 조회인 경우
    getOtherUserInfo(props.otherUserId, (res) => {
      userInfo.value = res.data
    }, null)
  }
})
</script>
