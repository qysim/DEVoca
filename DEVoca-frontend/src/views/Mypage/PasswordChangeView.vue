<template>
  <div class="container h-screen">
    <div class="card shrink-0 w-full max-w-sm bg-base-100 mx-auto">
      <div class="h-full">
        <p class="font-['GmarketSansMedium'] text-2xl text-center mt-5">비밀번호 변경</p>
        <form class="card-body">
          <div class="form-control">
            <label class="label">
              <span class="label-text">새 비밀번호</span>
            </label>
            <input type="password" placeholder="비밀번호를 입력해주세요." class="input input-bordered" required />
          </div>
          <div class="form-control">
            <label class="label">
              <span class="label-text">비밀번호 확인</span>
            </label>
            <input type="password" placeholder="비밀번호를 입력해주세요." class="input input-bordered" required />
          </div>
          <div class="form-control mt-6">
            <button class="btn bg-[#00B4D8]">변경하기</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script setup>

</script>

<style scoped></style>