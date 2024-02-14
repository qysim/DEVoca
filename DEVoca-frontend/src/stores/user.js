import { ref } from "vue"
import { defineStore } from "pinia"

export const useUserStore = defineStore("user", () => {
  // TODO : 하드 코딩 삭제 후 null로 정의
  const kakaoUserInfo = ref(null)

  return {
    kakaoUserInfo
  }
},{persist:true})
