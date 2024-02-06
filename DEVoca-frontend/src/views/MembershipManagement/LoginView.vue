<template>
  <div class="container h-screen flex items-center">
    <div class="card shrink-0 w-full max-w-sm bg-base-100 mx-auto">
      <div class="flex justify-center">
        <img src="@/assets/images/DEVoca_logo_en_only.png" class="w-3/4">
      </div>
      <form class="card-body">
        <div class="mt-3 flex flex-col items-center">
          <div class="mb-5">
            <a @click="loginWithKaKao" class="button" title="kakao login">
              <img alt="kakao logo" src="@/assets/images/kakao_login.png" class="logo" />
            </a>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>
  
<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { login, listArticle } from '@/api/user.js'

const router = useRouter()

const loginInfo = ref({
  id: "",
  token: "",
  userYn: ""
})

const kakao_url = "https://accounts.kakao.com/login/?continue=https%3A%2F%2Fkauth.kakao.com%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26redirect_uri%3Dhttps%253A%252F%252Fi10d112.p.ssafy.io%252Fdevoca%252Fkakao%252Fcallback%26through_account%3Dtrue%26client_id%3Df9cb962075484b28551d411e7d63c0eb"

const loginWithKaKao = function () {
  // 카카오 url로 연결하면 로그인 페이지로 넘어가고 정보가 화면에 출력됨
  // axios 요청이 아니라 링크연결을 해야 할 것 같음
  location.href = kakao_url

  // axios 요청 보내면 cors 에러
  login(), (res) => {
    console.log('OK')
    console.log(res)
  }, (err) => {
    console.log(err)
  }
}

</script>

<style scoped>
.logo {
  width: 300px;
  height: 50px;
}
</style>