<template>
  <div class="m-2">
    <SearchBarComponent />

    <div role="tablist" class="tabs tabs-bordered tabs-lg">
      <input type="radio" name="my_tabs_1" role="tab" class="tab" aria-label="글" />
      <div role="tabpanel" class="tab-content p-10">내용</div>
      
      <input type="radio" name="my_tabs_1" role="tab" class="tab" aria-label="단어" />
      <div role="tabpanel" class="tab-content p-10">내용</div>
    </div>
  </div>
</template>

<script setup>
import SearchBarComponent from '@/components/common/SearchBarComponent.vue'

</script>

<style scoped>

</style>