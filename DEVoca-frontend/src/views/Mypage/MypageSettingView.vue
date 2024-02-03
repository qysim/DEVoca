<template>
  <div class="flex flex-col justify-between h-full">
    <div class="h-full">
      <p class="font-['GmarketSansMedium'] text-2xl text-center mt-5">설정</p>
      <form class="card-body">
        <div class="form-control">
          <button class="btn bg-netural-200 w-auto h-16" onclick="location.href=''">
            <div class="flex">
              <div>
                <img src="@/assets/images/key.png" alt="" class="">
              </div>
              <div>
                <p class="font-['GmarketSansMedium'] text-2xl ml-5">비밀번호 변경</p>
              </div>
              <div>
                <img src="@/assets/images/Right.png" alt="" class="ml-20 mt-2">
              </div>
            </div>
          </button>
          <button class="btn bg-netural-200 w-auto h-16 mt-10" onclick="location.href=''">
            <div class="flex">
              <div>
                <img src="@/assets/images/heart.png" alt="" class="">
              </div>
              <div>
                <p class="font-['GmarketSansMedium'] text-2xl ml-5">관심분야 변경</p>
              </div>
              <div>
                <img src="@/assets/images/Right.png" alt="" class="ml-20 mt-2">
              </div>
            </div>
          </button>
        </div>
      </form>
    </div>
    <div>
      <div class="flex flex-row justify-center">
        <p>버전1.1</p>
        <a href="">/로그아웃</a>
      </div>
      <div class="flex flex-row justify-center">
        <p>이용약관 / 개인정보 처리방침</p>
      </div>
    </div>
  </div>
</template>
<script setup>

</script>

<style scoped></style>