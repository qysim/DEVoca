<template>
  <form class="card-body">
    <div class="flex flex-col items-center">
      <div class="flex flex-grow justify-center mt-5">
        <img src="@/assets/images/badge.png" alt="" class="w-8 h-8">
        <p class="text-3xl">배지 획득 현황</p>
      </div>
      <div class="flex justify-center mt-3">
        배지 00개 중 0개 보유
      </div>

      <!-- 체크박스 그룹 1 -->
      <div class="flex justify-center mt-8">
        <div class="checkbox-container mr-4">
          <label class="swap swap-flip text-3xl">
            <input type="checkbox" class="" />
            <div class="swap-on"><img src="@/assets/images/badge/calendar_0.png" alt="" class="badge-img"></div>
            <div class="swap-off"><img src="@/assets/images/badge/calendar_1.png" alt="" class="badge-img"></div>
          </label>
        </div>

        <div class="checkbox-container mr-4">
          <label class="swap swap-flip text-3xl">
            <input type="checkbox" class="" />
            <div class="swap-on"><img src="@/assets/images/badge/first_0.png" alt="" class="badge-img"></div>
            <div class="swap-off"><img src="@/assets/images/badge/first_1.png" alt="" class="badge-img"></div>
          </label>
        </div>

        <div class="checkbox-container">
          <label class="swap swap-flip text-3xl">
            <input type="checkbox" class="" />
            <div class="swap-on"><img src="@/assets/images/badge/good_0.png" alt="" class="badge-img"></div>
            <div class="swap-off"><img src="@/assets/images/badge/good_1.png" alt="" class="badge-img"></div>
          </label>
        </div>
      </div>
    </div>

  </form>
</template>

<script setup>

</script>

<style scoped></style>