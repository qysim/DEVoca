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
import { login } from '@/api/user.js'

const router = useRouter()

const loginInfo = ref({
  id: "",
  token: "",
  userYn: ""
})

const loginWithKaKao = () => {
    login(), (res) => {
    console.log(res)
  }, (err) => {
    console.log(err)
  }

  
  // loginInfo(obj, () => {
  //   if (userYn.value === true) {
  //     router.push({ name: "MainView" });
  //   } else if (userYn.value === flase) {
  //     router.push({ naeme: "SignupView" })
  //   }
  // },
  //   (error) => {
  //     console.log(error)
  //     router.push({ name: "LoginView" })
  //   }
  // );
}

</script>

<style scoped>
.logo {
  width: 300px;
  height: 50px;
}
</style>
  
