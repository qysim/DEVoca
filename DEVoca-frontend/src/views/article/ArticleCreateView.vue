<template>
  <div class="m-2">
    <form @submit.prevent="submitBoard">
      <select v-model="inputData.boardType" class="select select-bordered max-w-xs">
        <option disabled selected>카테고리</option>
        <option value="0">자유 게시판</option>
        <option value="1">Q&A 게시판</option>
      </select>
      
      <h2 class="font-jalnan text-xl pt-4 m-2">제목</h2>
      <input v-model="inputData.boardTitle" type="text" placeholder="제목을 입력하세요" class="input input-bordered w-full" />

      <div>
        <h2 class="font-jalnan text-xl pt-4 m-2">내용</h2>
        <textarea v-model="inputData.boardContent" class="textarea textarea-bordered w-full h-[30vh] resize-none my-2" placeholder="나누고 싶은 글을 적어주세요"></textarea>
      </div>
      
      <div class="flex justify-end">
        <button type="submit" class="btn btn-md bg-devoca text-white text-lg">등록</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { createBoard } from '@/api/board';
import { useUserStore } from '@/stores/user';
import { useRouter } from 'vue-router';

const router = useRouter();
const userStore = useUserStore();

const responseData = ref(null);

const inputData = ref({
  boardType: '카테고리',
  boardTitle: null,
  boardContent: null,
});

const submitBoard = function() {
  if (inputData.value.boardTitle && inputData.value.boardContent) {
    inputData.value.boardTitle = inputData.value.boardTitle.trim();
    inputData.value.boardContent = inputData.value.boardContent.trim();
  } else {
    console.error('boardTitle 또는 boardContent가 존재하지 않습니다.');
    return;
  }

  //  console.log('전송할 데이터:', inputData.value);

  createBoard(inputData.value, 
    (res) => {
      responseData.value = res.data;
      router.push({ name: 'ArticleView' });
    }, 
    (err) => {
      console.log(`err : ${err}`);
    }
  );
}
</script>


<style scoped>

</style>