<template>
  <form class="card-body">
    <div class="flex flex-col items-center">
      <div class="flex flex-grow justify-center mt-5">
        <img src="@/assets/images/badge.png" alt="" class="w-8 h-8">
        <p class="text-3xl">배지 획득 현황</p>
      </div>
      <div class="flex justify-center mt-3">
        배지 {{ userBadge.length }}개 중 {{ userBadge.filter(b => b.badgeHaveYn === '1').length }}개 보유
      </div>
      <div class="relative mt-8">
        <div class="flex justify-center mt-8 grid grid-cols-3 gap-4">
          <template v-for="(badge, index) in userBadge" :key="index">
            <div class="checkbox-container mr-4">
              <label class="swap swap-flip text-3xl">
                <input type="checkbox" />
                <div class="swap-on" @click="selectBadgeHandler(index, false)">
                  <img :src="getImgUrl(badge.badgeImgName, 1)">
                </div>
                <div class="swap-off" @click="selectBadgeHandler(index, true)">
                  <img :src="getImgUrl(badge.badgeImgName, badge.badgeHaveYn)">
                </div>
              </label>
            </div>
          </template>
        </div>

        <div v-show="toggleBadgeDescription" class="absolute z-10 top-[6rem] left-1/2 transform -translate-x-1/2 
        card w-[20rem] bg-base-100 opacity-95 shadow-xl mx-auto">
          <div class="card-body">
            <h2 class="card-title">{{ selectedBadge.badgeName }}</h2>
            <p>{{ selectedBadge.badgeInfo }}</p>
            <div class="card-actions justify-end">
            </div>
          </div>
        </div>
      </div>
    </div>
  </form>

</template>

<script setup>
import { ref, onMounted, onUnmounted } from 'vue'
import { getUserBadge } from '@/api/user.js'

const userBadge = ref([])
const selectedBadge = ref({})
const toggleBadgeDescription = ref(false)

onMounted(() => {
  // window.addEventListener('click', onOutsideClick)

  getUserBadge((res) => {
    userBadge.value = res.data
  }, (err) => {
    console.err(err)
  })
})

onUnmounted(() => {
  window.removeEventListener('click', onOutsideClick);
});

const getImgUrl = (badgeImgName, badgeHaveYn) => {
  return new URL(`/src/assets/images/badge/${badgeImgName}_${badgeHaveYn}.png`, import.meta.url).href
}

const selectBadgeHandler = (idx, toggle) => {
  toggleBadgeDescription.value = toggle
  selectedBadge.value = userBadge.value[idx]
}

const onOutsideClick = (event) => {
  const cardElement = document.querySelector('.card'); // 카드 요소 선택
  if (cardElement && !cardElement.contains(event.target)) {
    toggleBadgeDescription.value = false;
  }
};
</script>
