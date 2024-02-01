<template>
  <div class="flex justify-center">
    <div class="card w-screen h-fit bg-base-100 shadow-xl m-2">
      <!-- 유저 -->
      <div class="card card-side bg-base-100 items-center">
        <div class="avatar">
          <div class="w-16 rounded-full m-3">
            <img src="https://daisyui.com/images/stock/photo-1534528741775-53994a69daeb.jpg" />
          </div>
        </div>
        <div class="card-body flex-row p-3">
          <div>
            <h2 class="card-title font-jalnan">닉네임</h2>
            <p>한줄소개</p>
          </div>
          <p class="text-right">시간</p>
        </div>
      </div>
      <!-- 본문 -->
      <div class="card-body">
        <div class="border-neutral-100">단어인용</div>
        <p>유저 의견 내용</p>
      </div>
    </div>
  </div>
</template>

<script setup>

</script>

<style scoped>

</style>