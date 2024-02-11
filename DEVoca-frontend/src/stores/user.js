import { ref } from "vue"
import { defineStore } from "pinia"

export const useUserStore = defineStore("user", () => {
  const isLogin = ref(false)
  const kakaoUserInfo = ref(null)
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
