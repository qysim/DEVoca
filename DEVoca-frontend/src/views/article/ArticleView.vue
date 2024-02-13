<template>
  <div class="m-2 h-full flex flex-col">
    <div role="tablist" class="tabs tabs-bordered tabs-lg">
      <input :class="{ 'active': boardType === 0 }" @click="changeBoardType(0)" type="radio" name="my_tabs_1" role="tab" class="tab" aria-label="자유" />
      <input :class="{ 'active': boardType === 1 }" @click="changeBoardType(1)" type="radio" name="my_tabs_1" role="tab" class="tab" aria-label="Q&A" />
    </div>

    <ArticleComponent v-for="board in boards" :board="board" :key="board.id" />
  </div>
</template>

<script setup>
import SearchBarComponent from '@/components/common/SearchBarComponent.vue';
import ArticleComponent from '@/components/article/ArticleComponent.vue';
import { ref, onMounted } from 'vue';
import { getBoardList } from '@/api/board';

const boards = ref([]);
const boardType = ref(0);

const changeBoardType = (type) => {
  boardType.value = type;
  fetchBoardData();
};

const fetchBoardData = () => {
  getBoardList(boardType.value, 
    (response) => {
      boards.value = response.data;
      // console.log('게시판 데이터:', response.data);
    },
    (error) => {
      console.error(error);
    }
  );
};

  onMounted(() => {
    // 컴포넌트가 마운트될 때 데이터를 가져옵니다.
    getBoardList(boardType.value, 
      (response) => {
        boards.value = response.data;
      },
      (error) => {
        console.error(error);
      }
    );
  });
  </script>

  <style scoped></style>
