<template>
  <div class="text-xl">
    <div>
      <ProfIleCardComponents />
    </div>
    <div class="flex flex-row mx-4 mt-4 mb-8">
      <img src="@/assets/images/badge.png" alt="" class="ml-4">
      <RouterLink to="/mybadge" class="ml-1">획득한 배지 {{ userBadge.length }}개></RouterLink>
    </div>
    <div>
      <div class="ml-10 mt-8">
        <RouterLink to="/vocalist">
          <div class="flex justify-between">
            <div>
              <p>나의 피드</p>
            </div>
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
              stroke="currentColor" class="w-8 h-8 ml-20 mr-10">
              <path stroke-linecap="round" stroke-linejoin="round" d="m8.25 4.5 7.5 7.5-7.5 7.5" />
            </svg>
          </div>
        </RouterLink>
      </div>
      <div class="ml-10 mt-8">
        <RouterLink to="/vocalist">
          <div class="flex justify-between">
            <div>
              <p>참여한 퀴즈</p>
            </div>
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
              stroke="currentColor" class="w-8 h-8 ml-20 mr-10">
              <path stroke-linecap="round" stroke-linejoin="round" d="m8.25 4.5 7.5 7.5-7.5 7.5" />
            </svg>
          </div>
        </RouterLink>
      </div>
      <div class="ml-10 mt-8">
        <RouterLink to="/vocalist">
          <div class="flex justify-between">
            <div>
              <p>단어장</p>
            </div>
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
              stroke="currentColor" class="w-8 h-8 ml-20 mr-10">
              <path stroke-linecap="round" stroke-linejoin="round" d="m8.25 4.5 7.5 7.5-7.5 7.5" />
            </svg>
          </div>
        </RouterLink>
      </div>
      <div class="ml-10 mt-8">
        <RouterLink to="/vocalist">
          <div class="flex justify-between">
            <div>
              <p>나의 글</p>
            </div>
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
              stroke="currentColor" class="w-8 h-8 ml-20 mr-10">
              <path stroke-linecap="round" stroke-linejoin="round" d="m8.25 4.5 7.5 7.5-7.5 7.5" />
            </svg>
          </div>
        </RouterLink>
      </div>
      <div class="ml-10 mt-8">
        <RouterLink to="/vocalist">
          <div class="flex justify-between">
            <div>
              <p>나의 댓글</p>
            </div>
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
              stroke="currentColor" class="w-8 h-8 ml-20 mr-10">
              <path stroke-linecap="round" stroke-linejoin="round" d="m8.25 4.5 7.5 7.5-7.5 7.5" />
            </svg>
          </div>
        </RouterLink>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { getUserBadge } from '@/api/user.js'
import ProfIleCardComponents from '@/components/mypage/ProfIleCardComponents.vue';

const userBadge = ref([]);

onMounted(() => {
  getUserBadge((res) => {
    userBadge.value = res.data
  }, (err) => {
    console.err(err)
  })
})
</script>
