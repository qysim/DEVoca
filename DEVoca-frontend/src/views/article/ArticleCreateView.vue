<template>
  <div class="m-2">
    <form>
      <select class="select select-bordered max-w-xs">
        <option disabled selected>카테고리</option>
        <option>자유 게시판</option>
        <option>Q&A 게시판</option>
      </select>
      
      <h2 class="font-jalnan text-xl pt-4 m-2">제목</h2>
      <input type="text" placeholder="제목을 입력하세요" class="input input-bordered w-full" />

      <div>
        <h2 class="font-jalnan text-xl pt-4 m-2">내용</h2>
        <textarea class="textarea textarea-bordered w-full h-[30vh] resize-none my-2" placeholder="나누고 싶은 글을 적어주세요"></textarea>
      </div>
      
      <div class="flex justify-end">
        <button type="button" onclick="location.href='/main'" class="btn btn-md bg-devoca text-white text-lg">등록</button>
      </div>
    </form>
  </div>
</template>

<script setup>

</script>

<style scoped>

</style>