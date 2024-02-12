<template>
  <div class="card bg-base-100 shadow-xl m-2 w-96 h-96 text-center">
    <div class="card-body p-8 w-80 flex flex-col items-center self-center">
      <div class="w-full mt-1 flex">
        <p class="m-3 self-center">도전할 단어장을 선택하세요.</p>
      </div>
      <select class="border-devoca select select-bordered w-full max-w-xs">
        <option disabled selected>도전자의 단어장</option>
        <option>Han Solo</option>
      </select>
      <select class="border-devoca select select-bordered w-full max-w-xs">
        <option disabled selected>응전자의 단어장</option>
        <option>Han Solo</option>
      </select>
      <div class="w-60 mt-5 flex flex-row justify-evenly">
        <button class="btn bg-devoca text-white w-40">도전하기</button>
      </div>
    </div>

  </div>
</template>

<script setup>

</script>

<style scoped></style>