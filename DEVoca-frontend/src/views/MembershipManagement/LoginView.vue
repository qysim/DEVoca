<template>
  <div class="container h-screen flex items-center">
    <div class="card shrink-0 w-full max-w-sm bg-base-100 mx-auto">
      <div class="flex justify-center">
        <img src="@/assets/images/DEVoca_logo_en_only.png" class="w-3/4">
      </div>
      <form class="card-body">
        <div class="mt-3 flex flex-col items-center">
          <div class="mb-5">
            <a :href=kakaoURI>
              <img alt="kakao logo" src="@/assets/images/kakao_login.png" class="logo" />
            </a>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>
  
<script setup>

const clientId = import.meta.env.VITE_CLIENT_ID
const redirectURI = "https://i10d112.p.ssafy.io/kakao/callback"
const kakaoURI = `https://kauth.kakao.com/oauth/authorize?client_id=${clientId}&redirect_uri=${redirectURI}&response_type=code`

</script>

<style scoped>
.logo {
  width: 300px;
  height: 50px;
}
</style>