<template>
  <div class="container h-screen flex items-center">
    <div class="card shrink-0 w-full max-w-sm bg-base-100 mx-auto">
      <div class="flex justify-center">
        <img src="@/assets/images/DEVoca_logo_en_only.png" class="w-3/4">
      </div>
      <p class="text-center mt-6">관심 분야를 변경합니다.</p>
      <p class="text-center mt-1 mb-5">최대 3개 선택 가능</p>
      <div>
        <div v-for="(buttonGroup, groupIndex) in buttonGroups" :key="groupIndex" class="flex">
          <button v-for="(button, index) in buttonGroup" :key="index" type="submit" class="btn flex-grow m-2"
            :class="{ 'bg-white': !button.clicked, 'bg-devoca': button.clicked }"
            @click="handleClick(groupIndex, index)">
            Button {{ groupIndex * 2 + index + 1 }}
          </button>
        </div>
      </div>
      <div class="form-control mt-6">
        <button class="btn bg-devocao">확인</button>
      </div>
    </div>
  </div>
</template>
  
<script setup>
import { ref } from 'vue';

const buttons = ref(Array.from({ length: 10 }, () => ({ clicked: false })));

const buttonGroups = ref([]);

// Split buttons into groups of 2
for (let i = 0; i < buttons.value.length; i += 2) {
  buttonGroups.value.push(buttons.value.slice(i, i + 2));
}

const handleClick = (groupIndex, buttonIndex) => {
  const button = buttonGroups.value[groupIndex][buttonIndex];
  button.clicked = !button.clicked;
};
</script>
  
<style scoped></style>