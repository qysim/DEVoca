<template>
  <form class="card-body">
    <img id="image" src="@/assets/images/profile.png" alt="" class="mt-5 m-auto">
    <div class="upload" @click="triggerFileUpload">프로필 사진 선택하기
    <input type="file" ref="profileUpload" @change="handleFileUpload">
  </div>
    <div class="form-control">
      <label class="label">
        <span class="label-text">닉네임</span>
      </label>
      <input type="text" placeholder="닉네임자리" class="input input-bordered" required />
    </div>
    <div class="form-control">
      <label class="label">
        <span class="label-text">한 줄 소개</span>
      </label>
      <input type="text" placeholder="한줄소개" class="input input-bordered" required />
    </div>
    <div class="flex justify-end">
      <button type="button" onclick="location.href='/mypage'" class="btn btn-sm w-24 bg-devoca text-white ">변경하기</button>
    </div>
  </form>
</template>

<script setup>
import axios from 'axios';
import { onMounted } from 'vue';
import { uploadImage } from '@/api/mypage'
import { getUserInfo } from '@/api/user';

const token = JSON.parse(localStorage.getItem('user')).kakaoUserInfo.token

onMounted(() => {
  getUserInfo((res) => {
    const imageUrl = res.data.userImg;
    document.getElementById('image').src = imageUrl;
  })
})

const handleFileUpload = function(e) {
  const imgname = e.target.files[0]
  console.log(e.target.files[0])

  const formData = new FormData();
  formData.append('image', imgname);

  uploadImage(formData, (res) => {
    const imageUrl = res.data;
    document.getElementById('image').src = imageUrl;
  }, null)

  // axios.post(`https://i10d112.p.ssafy.io/devoca/mypage/profile`, formData, {
  //   headers: {
  //     token: JSON.parse(localStorage.getItem('user')).kakaoUserInfo.token
  //   }
  // })
  // .then((response) => {
  //   const imageUrl = response.data;
  //   console.log(imageUrl)
  //   document.getElementById('image').src = imageUrl;
  // })
  // .catch((error) => {
  //   console.log(error)
  // })
}
</script>

<style scoped></style>