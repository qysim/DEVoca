<template>
  <form class="card-body">
    <img src="@/assets/images/profile.png" alt="" class="mt-5 m-auto">
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

const handleFileUpload = function(e) {
  const imgname = e.target.files[0]
  console.log(e.target.files[0])

  const formData = new FormData();
  formData.append('image', imgname);

  axios.post(`http://localhost/devoca/mypage/profile`, formData, {
    headers: {
      // 'Content-Type' : 'multipart/form-data',
      token: JSON.parse(localStorage.getItem('user')).kakaoUserInfo.token
    }
  })
  .then((response) => {
    console.log(response)
  })
  .catch((error) => {
    console.log(error)
  })
}
</script>

<style scoped></style>