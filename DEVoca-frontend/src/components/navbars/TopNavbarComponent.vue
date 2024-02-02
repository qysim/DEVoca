<template>
  <div class="navbar bg-base-100 fixed top-0 z-10">
    <div class="navbar-start ml-2">
      <a>
        <img src="@/assets/images/DEVoca_logo_en_only.png" class="size-1/2" alt="devoca_logo">
      </a>
    </div>

    <!-- 알림페이지 연결 후 swap 기능 구현 예정 -->
    <div class="navbar-end">
      <button class="btn btn-ghost btn-circle">
        <div class="indicator text-neutral-900">
          <svg xmlns="http://www.w3.org/2000/svg" class="h-8 w-8" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 17h5l-1.405-1.405A2.032 2.032 0 0118 14.158V11a6.002 6.002 0 00-4-5.659V5a2 2 0 10-4 0v.341C7.67 6.165 6 8.388 6 11v3.159c0 .538-.214 1.055-.595 1.436L4 17h5m6 0v1a3 3 0 11-6 0v-1m6 0H9" /></svg>
          <span class="badge badge-xs badge-error indicator-item"></span>
        </div>
      </button>
    </div>
  </div>
</template>

<script setup>

</script>

<style scoped>

</style>