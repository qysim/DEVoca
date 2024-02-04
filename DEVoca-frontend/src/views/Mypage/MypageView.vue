<template>
    <div class="text-xl">
        <div>
            <ProfIleCardComponents />
        </div>
        <div class="flex flex-row mt-3 ">
            <img src="@/assets/images/badge.png" alt="" class="ml-4">
            <a href="" class="ml-1">획득한 배지 00개></a>
        </div>
        <div class="mt-2 flex justify-end mr-14">
            <p>등급</p>
        </div>
        <div class="flex justify-center mt-5">
            <progress class="progress progress-info w-80" value="42" max="100"></progress>
        </div>
        <div>
            <div class="ml-10 mt-8">
                <div class="flex justify-between">
                    <a href="">나의 피드</a>
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-8 h-8 ml-20 mr-10"><path stroke-linecap="round" stroke-linejoin="round" d="m8.25 4.5 7.5 7.5-7.5 7.5" /></svg>
                </div>
            </div>
            <div class="ml-10 mt-8">
                <div class="flex justify-between">
                    <a href="">참여한 퀴즈</a>
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-8 h-8 ml-20 mr-10"><path stroke-linecap="round" stroke-linejoin="round" d="m8.25 4.5 7.5 7.5-7.5 7.5" /></svg>
                </div>
            </div>
            <div class="ml-10 mt-8">
                <div class="flex justify-between">
                    <a href="">단어장</a>
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-8 h-8 ml-20 mr-10"><path stroke-linecap="round" stroke-linejoin="round" d="m8.25 4.5 7.5 7.5-7.5 7.5" /></svg>
                </div>
            </div>
            <div class="ml-10 mt-8">
                <div class="flex justify-between">
                    <a href="">나의 글</a>
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-8 h-8 ml-20 mr-10"><path stroke-linecap="round" stroke-linejoin="round" d="m8.25 4.5 7.5 7.5-7.5 7.5" /></svg>
                </div>
            </div>
            <div class="ml-10 mt-8">
                <div class="flex justify-between selection">
                    <a href="">나의 댓글</a>
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-8 h-8 ml-20 mr-10"><path stroke-linecap="round" stroke-linejoin="round" d="m8.25 4.5 7.5 7.5-7.5 7.5" /></svg>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import ProfIleCardComponents from '@/components/mypage/ProfIleCardComponents.vue';


</script>

<style scoped></style>