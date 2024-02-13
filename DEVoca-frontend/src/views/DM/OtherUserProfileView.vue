<template>
  <ProfIleCardComponents :otherUserId="userId" />
  <div class="flex justify-between mt-3">
    <div>
      <button :key="userInfo.followingYn" v-if="userInfo.followingYn === 'N'"
        class="btn btn-sm w-24 ml-5 bg-devoca text-white"
        @click="followHandler(userInfo.followingYn, userInfo.userId)">팔로우</button>
      <button v-else class="btn btn-sm w-24 ml-5 border-devoca text-devoca"
        @click="followHandler(userInfo.followingYn, userInfo.userId)">팔로우</button>
    </div>
    <div>
      <button class="btn btn-sm w-24 bg-devoca text-white" @click="dmHandler(userInfo.userId)">DM</button>
    </div>
    <div>
      <button class="btn btn-sm w-24 mr-5 bg-devoca text-white">VS</button>
    </div>
  </div>
</template>

<script setup>
import { ref, onBeforeMount } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { getOtherUserInfo } from '@/api/user.js'
import { getRoomUuid } from '@/api/dm'
import { followUser, unfollowUser } from "@/api/mypage"
import ProfIleCardComponents from '@/components/mypage/ProfIleCardComponents.vue'

const route = useRoute()
const router = useRouter()

const userId = ref(route.params.id)
const userInfo = ref({})

onBeforeMount(() => {
  getOtherUserInfo(userId.value, (res) => {
    userInfo.value = res.data
  }, null)
})

const followHandler = (option, id) => {
  if (option === 'N') {
    followUser(id)
    userInfo.value.followingYn = 'Y'
  } else {
    unfollowUser(id)
    userInfo.value.followingYn = 'N'
  }
}

const dmHandler = (id) => {
  getRoomUuid(id, (res) => {
    router.push({
      name: 'DMMessageView',
      params: { roomUuid: res.data }
    })
  }, null)
}
</script>