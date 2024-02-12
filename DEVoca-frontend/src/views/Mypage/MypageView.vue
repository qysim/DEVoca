<template>
  <div class="text-xl">
    <div>
      <ProfIleCardComponents />
    </div>
    <div class="flex flex-row mx-4 mt-4 mb-8">
      <img src="@/assets/images/badge.png" alt="" class="ml-4">
      <RouterLink :to="{ name: 'MyBadgeView' }" class="ml-1">획득한 배지 {{ userBadge.filter(b => b.badgeHaveYn === '1').length }}개></RouterLink>
    </div>
    <div>
      <div class="ml-10 mt-8">
        <RouterLink :to="{ name: 'MyCardView' }">
          <div class="flex justify-between">
            <div>
              <p>나의 피드</p>
            </div>
            <RightArrowIcon />
          </div>
        </RouterLink>
      </div>
      <div class="ml-10 mt-8">
        <RouterLink to="/vocalist">
          <div class="flex justify-between">
            <div>
              <p>참여한 퀴즈</p>
            </div>
            <RightArrowIcon />
          </div>
        </RouterLink>
      </div>
      <div class="ml-10 mt-8">
        <RouterLink :to="{ name: 'VocalistListView' }">
          <div class="flex justify-between">
            <div>
              <p>단어장</p>
            </div>
            <RightArrowIcon />
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
import RightArrowIcon from '@/components/icon/RightArrowIcon.vue'

const userBadge = ref([]);

onMounted(() => {
  getUserBadge((res) => {
    userBadge.value = res.data
  }, (err) => {
    console.err(err)
  })
})
</script>
