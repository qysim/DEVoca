<template>
  <div class="m-2 h-full flex flex-col">
    <SearchBarComponent />

    <div role="tablist" class="tabs tabs-bordered tabs-lg">
      <input type="radio" name="my_tabs_1" role="tab" class="tab" aria-label="자유" />
      <input type="radio" name="my_tabs_1" role="tab" class="tab" aria-label="Q&A" />
    </div>


    <ArticleComponent />
    <ArticleComponent />
    <ArticleComponent />
    <ArticleComponent />
    <ArticleComponent />
  </div>
</template>

<script setup>
import SearchBarComponent from '@/components/common/SearchBarComponent.vue';
import ArticleComponent from '@/components/article/ArticleComponent.vue';

</script>

<style scoped></style>