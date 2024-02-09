<template>
  <div>
  <div class="flex mt-5 ml-5">
    <p class="text-2xl">Q</p>
    <p class="text-2xl text-devoca">&</p>
    <p class="text-2xl">A</p>
  </div>
  </div>
  <div>
    <AvatarComponent />
    <ArticleDetailComponent />
  </div>
  <CommentComponent />
</template>

<script setup>
import AvatarComponent from '@/components/common/AvatarComponent.vue';
import ArticleDetailComponent from '@/components/article/ArticleDetailComponent.vue';
import CommentComponent from '@/components/article/CommentComponent.vue';
</script>

<style scoped>

</style>