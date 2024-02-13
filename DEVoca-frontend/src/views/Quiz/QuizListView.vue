<template>
  <div class="flex text-center">
    <div>
      <p class="mt-5 mr-3 ml-5 text-xl font-jalnan">참여한</p>
    </div>
    <div>
      <p class="mt-5 mr-3 text-xl font-jalnan text-devoca">퀴즈</p>
    </div>
    <div>
      <p class="mt-5 text-xl font-jalnan">목록</p>
    </div>
  </div>
  <div class="m-12 flex flex-col">
    <div class="w-full h-20 rounded-lg p-4 bg-[#e5e5e5]">
      <p class="text-base text-center">누적 퀴즈 참여</p>
      <p class="text-xl text-center">0개</p>

    </div>
    <div>
      <button class="btn btn-lg w-full rounded-lg bg-base-100 shadow-xl my-2 mt-5 flex flex-col">
        <div class="flex justify-between items-center space-x-12">
          <div class="w-10 h-10 mt-5">
            <p class="text-sm bg-devoca_skyblue rounded-lg">대결</p>
          </div>
          <div class="flex flex-col items-center">
            <p class="text-center text-xl">공동 1등</p>
            <p class="text-center text-sm">날짜</p>
          </div>
          <div>
            <img src="@/assets/images/quiz/1st.png" class="w-12 h-12">
          </div>
        </div>
      </button>
      <button class="btn btn-lg w-full rounded-lg bg-base-100 shadow-xl my-2 mt-5 flex flex-col">
        <div class="flex justify-between items-center space-x-12">
          <div class="w-10 h-10 mt-5">
            <p class="text-sm bg-devoca_skyblue rounded-lg">대결</p>
          </div>
          <div class="flex flex-col items-center">
            <p class="text-center text-xl">공동 1등</p>
            <p class="text-center text-sm">날짜</p>
          </div>
          <div>
            <img src="@/assets/images/quiz/lose.png" class="w-12 h-12">
          </div>
        </div>
      </button>
      <button class="btn btn-lg w-full rounded-lg bg-base-100 shadow-xl my-2 mt-5 flex flex-col">
        <div class="flex justify-between items-center space-x-12">
          <div class="w-10 h-10 mt-5">
            <p class="text-sm bg-devoca_skyblue rounded-lg">대결</p>
          </div>
          <div class="flex flex-col items-center">
            <p class="text-center text-xl">공동 1등</p>
            <p class="text-center text-sm">날짜</p>
          </div>
          <div>
            <img src="@/assets/images/quiz/win.png" class="w-12 h-12">
          </div>
        </div>
      </button>
      <button class="btn btn-lg w-full rounded-lg bg-base-100 shadow-xl my-2 mt-5 flex flex-col">
        <div class="flex justify-between items-center space-x-12">
          <div class="w-10 h-10 mt-5">
            <p class="text-sm bg-devoca_skyblue rounded-lg">대결</p>
          </div>
          <div class="flex flex-col items-center">
            <p class="text-center text-xl">공동 1등</p>
            <p class="text-center text-sm">날짜</p>
          </div>
          <div>
            <img src="@/assets/images/quiz/draw.png" class="w-12 h-12">
          </div>
        </div>
      </button>
    </div>
  </div>
</template>



<script setup>

</script>

<style scoped></style>