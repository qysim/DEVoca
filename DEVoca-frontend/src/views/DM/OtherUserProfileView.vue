<template>
  <ProfIleCardComponents :otherUserId="userId" />
  <div class="flex justify-between mt-3">
    <div>
      <button type="submit" class="btn btn-sm w-24 ml-5 bg-devoca text-white">팔로우</button>
    </div>
    <div>
      <button type="submit" class="btn btn-sm w-24 bg-devoca text-white">DM</button>
    </div>
    <div>
      <button type="submit" class="btn btn-sm w-24 mr-5 bg-devoca text-white">VS</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import ProfIleCardComponents from '@/components/mypage/ProfIleCardComponents.vue'
import { useRoute } from "vue-router";

const route = useRoute()
const userId = ref(route.params.id)
</script>