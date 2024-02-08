<template>
  <div class="card card-compact bg-base-100 dark:bg-base-100 shadow-xl mb-4 p-2">
    <div class="card-body">
      <h2 class="card-title text-base">Hypervisor</h2>
      <span class="text-gray-400 text-xs">하이퍼바이저</span>
      <hr>
      <p class="text-sm">가상머신을 실행하기 위한 프로그램</p>
      <div class="flex justify-start gap-1 mt-2 text-xs">
        <span v-for="category in categories" :key="category.id">#{{ category }}</span>
      </div>
    </div>
  </div>
</template>

<script setup>

</script>
