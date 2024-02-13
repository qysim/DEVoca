<template>
  <div class="text-xl">
    <div>
      <ProfIleCardComponents />
    </div>
    <div class="flex flex-col m-10">
      <RouterLink :to="{ name: 'MyBadgeView' }">
        <div class="flex justify-between py-4">
          <div>
            <p>나의 배지</p>
          </div>
          <RightArrowIcon />
        </div>
      </RouterLink>
      <RouterLink :to="{ name: 'MyCardView' }">
        <div class="flex justify-between py-4">
          <div>
            <p>나의 피드</p>
          </div>
          <RightArrowIcon />
        </div>
      </RouterLink>
      <RouterLink :to="{ name: 'MyBoardView' }">
        <div class="flex justify-between py-4">
          <div>
            <p>나의 글</p>
          </div>
          <RightArrowIcon />
        </div>
      </RouterLink>
      <RouterLink :to="{ name: 'MyCommentView' }">
        <div class="flex justify-between py-4">
          <div>
            <p>나의 댓글</p>
          </div>
          <RightArrowIcon />
        </div>
      </RouterLink>
      <RouterLink to="/vocalist">
        <div class="flex justify-between py-4">
          <div>
            <p>참여한 퀴즈</p>
          </div>
          <RightArrowIcon />
        </div>
      </RouterLink>
      <RouterLink :to="{ name: 'VocalistListView' }">
        <div class="flex justify-between py-4">
          <div>
            <p>단어장</p>
          </div>
          <RightArrowIcon />
        </div>
      </RouterLink>
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
