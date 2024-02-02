<template>
  <div class="container h-screen flex items-center">
    <div class="card shrink-0 w-full max-w-sm bg-base-100 mx-auto">
      <div class="flex justify-center">
        <img src="@/assets/images/DEVoca_logo_en_only.png" class="w-3/4">
      </div>
      <form class="card-body">
        <div class="form-control">
          <label class="label">
            <span class="label-text">이메일</span>
          </label>
          <input type="email" placeholder="example@naver.com" class="input input-bordered" required />
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-text">이름</span>
          </label>
          <input type="text" placeholder="이름" class="input input-bordered" required />
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-text">닉네임</span>
          </label>
          <input type="text" placeholder="닉네임" class="input input-bordered" required />
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-tex">생년월일</span>
          </label>
          <input ref="datepicker" class="input input-bordered w-full" type="text" placeholder="날짜를 선택해 주세요">
        </div>

        <div class="form-control mt-6">
          <button class="btn bg-[#00B4D8]">회원가입</button>
        </div>
      </form>
    </div>
  </div>
</template>
  
<script setup>
import { onMounted, ref } from 'vue';
import flatpickr from 'flatpickr';
import 'flatpickr/dist/flatpickr.min.css';

const datepicker = ref(null);

onMounted(() => {
  flatpickr(datepicker.value, {
    appendTo: document.body,
    static: true,
    // Configuration options for Flatpickr
    // You can customize the appearance and behavior here
    // todo -> 라이브러리 설정으로 디자인 수정이 필요해서 우선순위가 아니라 나중에 다시 보겠습니다.
  });
});
</script>
  
<style scoped>
/* Your component-specific styles go here */
</style>
  