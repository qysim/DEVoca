<template>
  <div class="navbar">
    <div class="navbar-start ml-2">
      <a>
        <!-- <img src="@/assets/images/logo.png" width="150" alt="logo"> -->
        <img src="@/assets/images/DEVoca_logo_initial.png" width="50" height="50" alt="logo">
      </a>
    </div>
    
    <div class="navbar-center bg-neutral-50 mt-1 ml-2 rounded-lg">
      <div class="relative flex items-center w-full h-10 rounded-lg overflow-hidden">
        <div class="grid place-items-center h-full w-12 text-gray-300">
          <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
          </svg>
        </div>
        <input class="peer h-full w-full outline-none text-sm text-gray-700 pr-10 bg-neutral-50"
          type="text" id="search" placeholder="단어 검색" /> 
      </div>
    </div>

    <div class="navbar-end m-2">
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