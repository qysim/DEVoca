<template>
  <form class="card-body">
    <img src="@/assets/images/profile.png" alt="" class="mt-5 m-auto">
    <div class="form-control">
      <label class="label">
        <span class="label-text">닉네임</span>
      </label>
      <input type="text" placeholder="닉네임자리" class="input input-bordered" required />
    </div>
    <div class="form-control">
      <label class="label">
        <span class="label-text">한 줄 소개</span>
      </label>
      <input type="text" placeholder="한줄소개" class="input input-bordered" required />
    </div>
    <div class="flex justify-end">
      <button type="button" onclick="location.href='/mypage'" class="btn btn-sm w-24 bg-devoca text-white ">변경하기</button>
    </div>
  </form>
</template>

<script setup>

</script>

<style scoped></style>