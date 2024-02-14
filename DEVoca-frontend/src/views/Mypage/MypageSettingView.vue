<template>
  <div class="flex flex-col justify-between h-full">
    <div class="h-full">
      <p class="text-2xl text-center mt-5">설정</p>
      <form class="card-body">
        <div class="form-control">
          <button button type="button" onclick="location.href='/passwordchange'" class="btn bg-netural-200 w-auto h-16">
            <div class="flex">
              <div>
                <svg xmlns="http://www.w3.org/2000/svg" class="w-8 h-8" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" d="M15.75 5.25a3 3 0 0 1 3 3m3 0a6 6 0 0 1-7.029 5.912c-.563-.097-1.159.026-1.563.43L10.5 17.25H8.25v2.25H6v2.25H2.25v-2.818c0-.597.237-1.17.659-1.591l6.499-6.499c.404-.404.527-1 .43-1.563A6 6 0 1 1 21.75 8.25Z" /></svg>
              </div>
              <div>
                <p class="text-2xl ml-5">비밀번호 변경</p>
              </div>
              <div>
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-8 h-8 ml-20"><path stroke-linecap="round" stroke-linejoin="round" d="m8.25 4.5 7.5 7.5-7.5 7.5" /></svg>
              </div>
            </div>
          </button>
          <button button type="button" onclick="location.href='/selecinterestschange'" class="btn bg-netural-200 w-auto h-16 mt-10">
            <div class="flex">
              <div>
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-8 h-8"><path stroke-linecap="round" stroke-linejoin="round" d="M21 8.25c0-2.485-2.099-4.5-4.688-4.5-1.935 0-3.597 1.126-4.312 2.733-.715-1.607-2.377-2.733-4.313-2.733C5.1 3.75 3 5.765 3 8.25c0 7.22 9 12 9 12s9-4.78 9-12Z" /></svg>
              </div>
              <div>
                <p class="text-2xl ml-5">관심분야 변경</p>
              </div>
              <div>
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-8 h-8 ml-20"><path stroke-linecap="round" stroke-linejoin="round" d="m8.25 4.5 7.5 7.5-7.5 7.5" /></svg>
              </div>
            </div>
          </button>
        </div>
      </form>
    </div>
    <div>
      <div class="flex flex-row justify-center">
        <p>버전1.1</p>
        <a @click="logOut">/로그아웃</a>
      </div>
      <div class="flex flex-row justify-center">
        <p>이용약관 / 개인정보 처리방침</p>
      </div>
    </div>
  </div>
</template>
<script setup>
import { useUserStore } from '@/stores/user'

const userStore = useUserStore()

const logOut = () => {
  // userStore.kakaoUserInfo = {
  //   id: null,
  //   token: null,
  //   userYn: false
  // }
  localStorage.clear()
  console.log(userStore.kakaoUserInfo)
  location.href="https://i10d112.p.ssafy.io/devoca/kakao/logout"
}

</script>