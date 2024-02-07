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
import { localAxios } from '@/util/http-commons';
import axios from 'axios'

const router = useRouter()

const tokenInfo = ref(null)

onMounted (() => {
  const queryString = window.location.search
  const urlParams = new URLSearchParams(queryString)
  const codeParam = urlParams.get('code')
  console.log('Code parameter:', codeParam)

  axios({
    method: 'get',
    url: `https://i10d112.p.ssafy.io/devoca/kakao/callback?code=${codeParam}`,
  })
  .then ((res) => {
    console.log(res.data)
    console.log(res.data.userYn)
    tokenInfo.value = res.data
    console.log(tokenInfo.value)
    
    if (res.data.userYn == true) {
      router.push({name : 'MainView'})
    } else if (res.data.userYn == false) {
      router.push({name : 'SignupView'})
    }
  })
  .catch((err) => {
    console.log(err)
  })
  // getKaKaoToken(codeParam, (res) => {
  //   tokenInfo = res.data
  //   console.log(tokenInfo)
  //   console.log(tokenInfo.value)

  //   if (res.data.userYn === true) {
  //     router.push({name : 'MainView'})
  //   } else if (res.data.userYn === false) {
  //     router.push({name : 'SignupView'})
  //   }
  // }, (err) => {
  //   console.log(err)
  })

</script>

<style scoped>

</style>