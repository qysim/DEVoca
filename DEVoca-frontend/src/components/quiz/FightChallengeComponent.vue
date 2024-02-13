<template>
  <div class="card bg-base-100 shadow-xl m-2 w-96 h-auto text-center">
    <div class="card-body p-8 w-80 flex flex-col items-center self-center">
      <div class="w-full mt-1 flex">
        <p class="m-3 self-center font-jalnan text-3xl text-devoca">DEVOCA</p>
        <img src="@/assets/images/quiz/fight.png">
      </div>
      <img src="@/assets/images/quiz/challenge.png">
      <p>상대유저닉네임 님이</p>
      <p>도전장을 보내셨습니다!</p>
      <p>수락하시겠습니까??</p>
      <div class="w-60 mt-5 flex flex-row justify-evenly">
        <button class="btn bg-devoca text-white w-20">수락</button>
        <button class="btn bg-devoca text-white w-20">거절</button>
      </div>
    </div>
  </div>
</template>

<script setup>

</script>

<style scoped></style>