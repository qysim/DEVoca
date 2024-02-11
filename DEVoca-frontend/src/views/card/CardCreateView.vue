<template>
  <div class="container p-3">
    <form @submit.prevent="submitCard">
      <h2 class="font-jalnan text-lg px-2">단어 선택</h2>
      <SearchBarComponent />
      
      <textarea class="textarea textarea-bordered w-full h-[30vh] resize-none mb-2" placeholder="나누고 싶은 글을 적어주세요"
      ></textarea>
      
      <label class="form-control w-full mb-4">
        <div class="label">
          <span class="label-text font-jalnan text-lg px-2">참 고</span>
        </div>
        <input type="text" placeholder="참고 링크를 추가할 수 있어요" class="input input-bordered w-full" 
        />
      </label>

      <label class="form-control w-full mb-4">
        <div class="label">
          <span class="label-text font-jalnan text-lg px-2">연관 개념</span>
        </div>
        <input type="text" placeholder="연관 개념을 추가할 수 있어요" class="input input-bordered w-full" 
        />
      </label>
      
      <div class="flex justify-end">
        <button class="btn btn-md bg-devoca text-white text-lg">게시</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import SearchBarComponent from '@/components/common/SearchBarComponent.vue'
import { registCard } from '@/api/card'

const inputData = ref({
  userId: '3332004001',
  wordId: 1,
  cardContent: 'test1',
  cardLink: 'test2',
  cardRelationWords: ['test3', 'test4', 'test5']
})

const submitCard = function () {
  registCard(inputData.value, (res) => {
    console.log(`res : ${res}`)
  }, (err) => {
    console.log(`err : ${err}`)
  })
}

// autocomplete https://tw-elements.com/docs/standard/forms/autocomplete/
// const data = ['One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight'];

// const dataFilter = (value) => {
//   return data.filter((item) => {
//     return item.toLowerCase().startsWith(value.toLowerCase());
//   });
// };

// const basicAutocomplete = document.querySelector('#basic');

// new Autocomplete(basicAutocomplete, {
//   filter: dataFilter,
// });

</script>