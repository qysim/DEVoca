<template>
  <div>
    <div class="bg-neutral-100 py-1">
      <CardComponent />
      <div class="card bg-base-100 shadow-xl m-2">
        <div class="card-body p-4">
          <h2 class="text-lg font-jalnan">참 고</h2>
          <p class="break-all">https://tailwindcss.com/docs/customizing-colors</p>
        </div>
      </div>
      <div class="card bg-base-100 shadow-xl m-2">
        <div class="card-body p-4">
          <h2 class="text-lg font-jalnan">연관 개념</h2>
          <p class="break-all">tailwind css, daisyUI</p>
        </div>
      </div>
    </div>

    <div class="collapse collapse-arrow bg-base-100 shadow-xl m-2 w-auto">
      <input type="checkbox" /> 
      <div class="collapse-title text-xl font-jalnan">
        댓글
      </div>
      <div class="collapse-content"> 
        <div>
          <div class="card card-side bg-base-100 items-center">
            <div class="avatar">
              <div class="rounded-full size-10">
                <img src="https://daisyui.com/images/stock/photo-1534528741775-53994a69daeb.jpg" />
              </div>
            </div>
            <div class="card-body flex-row p-2">
              <p class="card-title font-jalnan">닉네임</p>
              <p class="text-right">시간</p>
            </div>
          </div>
          <p class="p-2">댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글</p>
        </div>
      </div>
    </div>
  </div>  
</template>

<script setup>
import CardComponent from '@/components/feed/CardComponent.vue'
</script>

<style scoped>

</style>