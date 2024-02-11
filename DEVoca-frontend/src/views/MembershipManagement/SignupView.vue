<template>
  <div class="container h-screen flex items-center">
    <div class="card shrink-0 w-full max-w-sm bg-base-100 mx-auto">
      <div class="flex justify-center">
        <img src="@/assets/images/DEVoca_logo_en_only.png" class="w-3/4">
      </div>
      <form class="card-body" @submit.prevent="submitUserInfo">
        <div class="form-control">
          <label class="label">
            <span class="label-text">이메일</span>
          </label>
          <input type="email" placeholder="example@naver.com" class="input input-bordered" required v-model.trm="memberStore.userInfo.userEmail" />
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-text">이름</span>
          </label>
          <input type="text" placeholder="이름" class="input input-bordered" required v-model.trm="memberStore.userInfo.userName" />
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-text">닉네임</span>
          </label>
          <input type="text" placeholder="닉네임" class="input input-bordered" required v-model.trm="memberStore.userInfo.userNickname" />
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-tex">생년월일</span>
          </label>
          <input ref="datepicker" class="input input-bordered w-full" type="text" placeholder="날짜를 선택해 주세요" v-model.trm="memberStore.userInfo.userBirth" >
        </div>

        <div class="form-control mt-6">
          <button class="btn bg-devoca text-white text-xl align-bottom">회원가입</button>
        </div>
      </form>
    </div>
  </div>
</template>
  
<script setup>
import { ref, onMounted } from 'vue'
import flatpickr from 'flatpickr'
import 'flatpickr/dist/flatpickr.min.css'
import { useRouter } from 'vue-router'
import { joinUser } from '@/api/user'
import { useMemberStore } from '@/stores/member'

const router = useRouter()
const memberStore = useMemberStore()
const datepicker = ref(null)

const submitUserInfo = function () {
  // console.log(memberStore.userInfo)
  joinUser(memberStore.userInfo, (res) => {
    // console.log(res)
    router.push({name: 'SelectInterestsView'})
  }, (err) => {
    console.log(err)
  })
}

onMounted(() => {
  flatpickr(datepicker.value, {
    appendTo: document.body,
    static: true,
  })
})
</script>
  
<style scoped>

</style>
  