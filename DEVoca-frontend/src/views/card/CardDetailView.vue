<template>
  <div>
    <div class="bg-neutral-100 py-1">
      <CardDetailComponent :card="card" v-if="card"/>
    </div>

    <div class="collapse collapse-arrow bg-base-100 shadow-xl m-2 w-auto">
      <input type="checkbox" /> 
      <div class="collapse-title text-xl font-jalnan">
        댓글
      </div>
      <div class="collapse-content"> 
        <div>
          <div class="card card-side bg-base-100 items-center">
            <div class="avatar">
              <div class="rounded-full size-10">
                <img src="https://daisyui.com/images/stock/photo-1534528741775-53994a69daeb.jpg" />
              </div>
            </div>
            <div class="card-body flex-row p-2">
              <p class="card-title font-jalnan">닉네임</p>
              <p class="text-right">시간</p>
            </div>
          </div>
          <p class="p-2">댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글</p>
        </div>
      </div>
    </div>

    <!-- <div class="collapse collapse-arrow bg-base-100 shadow-xl w-full">
      <input type="checkbox" />
      <div class="collapse-title text-xl font-medium font-jalnan">관련 카드</div>
      <div v-if="cardList && cardList.length === 0" class="collapse-content p-0">
        <div class="card card-compact bg-base-100 dark:bg-base-100 shadow-xl mb-4 p-2">
          <div class="card-body">관련 카드가 없습니다!</div>
        </div>
      </div>
      <div v-if="cardList && cardList.length > 0" class="collapse-content p-0">
        <CardComponent v-for="card in cardList" :key="card.id" :card="card" />
      </div>
    </div> -->
  </div>  
</template>

<script setup>
import { ref, onMounted } from 'vue'
import CardDetailComponent from '@/components/feed/CardDetailComponent.vue'
import { getCardDetail } from '@/api/card'

const props = defineProps({
  id: String
})

const card = ref(null)

onMounted(() => {
  getCardDetail(props.id, (res) => {
    card.value = res.data
  }, (err) => {
    console.log(err)
  })
})
</script>

<style scoped>

</style>