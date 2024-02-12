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

      <div class="flex justify-center mt-8">
        <template v-for="(badge, index) in userBadge" :key="index">
          <div class="checkbox-container mr-4">
            <label class="swap swap-flip text-3xl">
              <input type="checkbox" />
              <div class="swap-on" @click="selectBadgeHandler(index, false)">
                <img :src="getImgUrl(badge.badgeImgName, badge.badgeHaveYn)">
              </div>
              <div class="swap-off" @click="selectBadgeHandler(index, true)">
                <img :src="getImgUrl(badge.badgeImgName, badge.badgeHaveYn)">
              </div>
            </label>
          </div>
        </template>
      </div>
    </div>
  </form>

  <div v-show="toggleBadgeDescription" class="card w-96 bg-base-100 shadow-xl mx-auto">
    <div class="card-body">
      <h2 class="card-title">{{ selectedBadge.badgeName }}</h2>
      <p>{{ selectedBadge.badgeInfo }}</p>
      <div class="card-actions justify-end">
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { getUserBadge } from '@/api/user.js'

const userBadge = ref([])
const selectedBadge = ref({})
const toggleBadgeDescription = ref(false)

onMounted(() => {
  getUserBadge((res) => {
    userBadge.value = res.data
  }, (err) => {
    console.err(err)
  })
})

const getImgUrl = (badgeImgName, badgeHaveYn) => {
  return new URL(`/src/assets/images/badge/${badgeImgName}_${badgeHaveYn}.png`, import.meta.url).href
}

const selectBadgeHandler = (idx, toggle) => {
  toggleBadgeDescription.value = toggle
  selectedBadge.value = userBadge.value[idx]
}
</script>
