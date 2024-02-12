<template>
  <div role="tablist" class="tabs tabs-bordered mx-4">
    <a role="tab" class="tab tab-active">팔로워 12명</a>
    <a role="tab" class="tab">팔로잉 12명</a>
  </div>
  <div class="mx-4">
    <div class="flex items-center py-4 relative">
      <input
        class="text-sm leading-none text-left text-gray-600 px-2 py-3 w-full border rounded border-gray-300 outline-none"
        type="text" placeholder="검색" />
      <svg class="absolute right-3 z-10 cursor-pointer" width="24" height="24" viewBox="0 0 24 24" fill="none"
        xmlns="http://www.w3.org/2000/svg">
        <path
          d="M10 17C13.866 17 17 13.866 17 10C17 6.13401 13.866 3 10 3C6.13401 3 3 6.13401 3 10C3 13.866 6.13401 17 10 17Z"
          stroke="#4B5563" stroke-width="1.66667" stroke-linecap="round" stroke-linejoin="round" />
        <path d="M21 21L15 15" stroke="#4B5563" stroke-width="1.66667" stroke-linecap="round" stroke-linejoin="round" />
      </svg>
    </div>
  </div>
  <div class="card card-side">
    <div class="avatar">
      <div class="w-20 h-20 rounded-full my-10 ml-5">
        <img src="https://daisyui.com/images/stock/photo-1635805737707-575885ab0820.jpg" />
      </div>
    </div>
    <div class="card-body">
      <div class="flex flex-row justify-between">
        <h2 class="card-title">닉네임 위치</h2>
        <button type="submit" class="btn mt-2">팔로잉</button>
      </div>
      <div class="">
        <p class="font-['GmarketSansMedium'] text-sm">한 줄 소개자리</p>
      </div>
    </div>
  </div>
</template>


<script setup>

</script>
