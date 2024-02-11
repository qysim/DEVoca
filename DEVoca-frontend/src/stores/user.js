import { ref } from "vue"
import { defineStore } from "pinia"

export const useUserStore = defineStore("user", () => {
  const isLogin = ref(false)
  const kakaoUserInfo = ref({
    id: 3332004001,
    token: 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhY2Nlc3MtdG9rZW4iLCJpYXQiOjE3MDc2NDE0NzQsInVzZXJJZCI6IjMzMzIwMDQwMDEifQ.FsJA1AHoAQ6tDzCjV8Sps5aPYn2H3FGzQ21_Qau7-lI',
    userYn: true
  })
  const userInfo = ref({
    userId: null,
    userName: null,
    userEmail: null,
    userBirth: null,
    userNickname: null
  })

  return {
    isLogin,
    kakaoUserInfo,
    userInfo
  }
},{persist:true})
