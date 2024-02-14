import { ref } from "vue"
import { defineStore } from "pinia"

export const useUserStore = defineStore("user", () => {
  const kakaoUserInfo = ref({
    id: null,
    token: null,
    userYn: false
  })

  return {
    kakaoUserInfo
  }
},{persist:true})
