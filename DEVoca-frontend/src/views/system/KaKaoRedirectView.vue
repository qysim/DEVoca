<template>
  <div class="flex flex-col justify-center items-center h-dvh">
    <h1 class="font-jalnan text-3xl inline-block">로그인 중입니다</h1>
    <h1 class="font-jalnan text-3xl inline-block">잠시만 기다려주세요</h1>
    <span class="loading loading-dots loading-lg"></span>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import { getKaKaoToken } from '@/api/user.js'
import { useMemberStore } from '@/stores/member'

const router = useRouter()
const memberStore = useMemberStore()

onMounted (() => {
  const queryString = window.location.search
  const urlParams = new URLSearchParams(queryString)
  const codeParam = urlParams.get('code')
  // console.log('Code parameter:', codeParam)

  getKaKaoToken(codeParam, (res) => {
    memberStore.userInfo = { ...memberStore.userInfo.value, ...response.data }
    console.log(memberStore.userInfo)

    if (res.data.userYn === true) {
      router.push({name : 'MainView'})
    } else if (res.data.userYn === false) {
      router.push({name : 'SignupView'})
    }
  }, (err) => {
    console.log(err)
  })
})

</script>

<style scoped>

</style>