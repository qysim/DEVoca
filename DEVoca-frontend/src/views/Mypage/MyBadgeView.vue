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
        <template v-for="badge in userBadge" :key="badge.id">
          <div class="checkbox-container mr-4">
            <label class="swap swap-flip text-3xl">
              <input type="checkbox" />
              <div class="swap-on">
                <img :src="getImgUrl(badge.badgeImgName, badge.badgeHaveYn == '0' ? 1 : 0)">
              </div>
              <div class="swap-off">
                <img :src="getImgUrl(badge.badgeImgName, badge.badgeHaveYn == '1' ? 1 : 0)">
              </div>
            </label>
          </div>
        </template>
      </div>
    </div>
  </form>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { getUserBadge } from '@/api/user.js'

const userBadge = ref([]);

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
</script>
