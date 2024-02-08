<template>
  <div>
    <div class="flex justify-start items-center p-2 relative " id="searchbar">
      <input
        class="input input-bordered w-full px-6"
        type="text"
        placeholder="검색어를 입력하세요"
        v-model="searchInput"
      />
      <svg
        class="absolute right-6 z-10 cursor-pointer"
        width="24"
        height="24"
        viewBox="0 0 24 24"
        fill="none"
        xmlns="http://www.w3.org/2000/svg" @click="searchBtnHandler"
      >
        <path
          d="M10 17C13.866 17 17 13.866 17 10C17 6.13401 13.866 3 10 3C6.13401 3 3 6.13401 3 10C3 13.866 6.13401 17 10 17Z"
          stroke="#4B5563"
          stroke-width="1.66667"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
        <path
          d="M21 21L15 15"
          stroke="#4B5563"
          stroke-width="1.66667"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
      </svg>
    </div>
  </div>
  <hr class="my-4">
</template>

<script setup>
import { ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'

const route = useRoute()
const router = useRouter()

// url에 있는 쿼리 스트링을 입력 박스에 기본값으로 채워넣기
const searchInput = ref(route.query.q)

// 검색 버튼 클릭 핸들러
const searchBtnHandler = () => {
  // 입력이 없는 경우
  if (searchInput.value === "" || searchInput.value === undefined) return

  // 화면 전환
  router.push({
    name: 'SearchResultView',
    query: {
      q: searchInput.value
    }
  })
}
</script>
