import { ref } from "vue"
import { defineStore } from "pinia"

export const useUserStore = defineStore("user", () => {
  const isLogin = ref(false)
  const userInfo = ref({
    id: null,
    token: null,
    userYn: null,
    userId: null,
    userName: null,
    userEmail: null,
    userBirth: null,
    userNickname: null
  })

  return {
    isLogin,
    userInfo,
  }
},{persist:true})
