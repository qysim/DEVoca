<template>
  <div class="card card-side bg-devoca_skyblue">
    <div class="avatar">
      <div class="w-24 h-24 rounded-full my-10 ml-5">
        <img src="https://daisyui.com/images/stock/photo-1635805737707-575885ab0820.jpg" />
      </div>
    </div>
    <div class="card-body">
      <div class="flex flex-row justify-between">
        <h2 class="card-title mt-6">닉네임 위치</h2>
        <div class="flex justify-start">
          <router-link :to="{ name: 'ProfileChangeView', params: { id: userId } }">
            <PenIcon />
          </router-link>
          <router-link :to="{ name: 'MypageSettingView', params: { id: userId } }">
            <ConfigIcon />
          </router-link>
        </div>
      </div>
      <p class="text-sm">한 줄 소개자리
      <div class="flex-row">
        <a href="" class="mr-5 text-sm">팔로우11</a>
        <a href="" class="text-sm">팔로워11</a>
      </div>
      </p>
    </div>
  </div>
</template>

<script setup>
import PenIcon from '@/components/icon/PenIcon.vue'
import ConfigIcon from '@/components/icon/ConfigIcon.vue'

// 예시로 userId를 설정하는 함수
const setUserId = (newUserId) => {
  userId.value = newUserId;
};

const router = useRouter();
</script>


<style scoped></style>