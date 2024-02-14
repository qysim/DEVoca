import { ref } from "vue"
import { defineStore } from "pinia"

export const useUserStore = defineStore("user", () => {
  const kakaoUserInfo = ref(null)

  return {
    kakaoUserInfo
  }
},{persist:true})
