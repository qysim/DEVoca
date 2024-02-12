<template>
    <div class="bg-devoca_skyblue w-full h-fit pt-6 pb-6 flex justify-center items-center">
        <router-view :quizList="quizList"></router-view>
    </div>
  </template>
  
  <script setup>

    const quizList = [
        {"wordId": 714, "wordNameKr": "상태", "wordNameEn": "state",
          "wordSumm": "정보 기술 및 컴퓨터 과학에서는 시스템이 이전 이벤트 또는 사용자 상호 작용을 기억하도록 설계된 경우 시스템을 상태 저장소라고 하며, 기억된 정보를 시스템 상태라고 합니다."},
        { "wordId": 687, "wordNameKr": "런타임 오류", "wordNameEn": "run time error", "wordSumm": "" },
        { "wordId": 651, "wordNameKr": "노드", "wordNameEn": "node", "wordSumm": "" },
        { "wordId": 11, "wordNameKr": "에이6", "wordNameEn": "A6", "wordSumm": "요약1" },
        { "wordId": 724, "wordNameKr": "시스템 콘솔", "wordNameEn": "system console", "wordSumm": "" },
        { "wordId": 624, "wordNameKr": "정보 공간 분석", "wordNameEn": "information space analysis", "wordSumm": "" },
        { "wordId": 677, "wordNameKr": "참조", "wordNameEn": "reference", "wordSumm": "" },
        {"wordId": 611, "wordNameKr": "전역 변수", "wordNameEn": "global variable",
          "wordSumm": "전역 변수는 프로그램 내 어디서나 접근 가능한 변수입니다. 컴파일 언어에선 정적 변수로, 인터프리트 언어에선 동적 변수로 처리됩니다. 전역 변수의 과도한 사용은 모듈성 저하 및 오류 위험 증가시키므로 주의가 필요합니다."},
        { "wordId": 595, "wordNameKr": "실행", "wordNameEn": "execution", "wordSumm": "" },
        { "wordId": 8, "wordNameKr": "에이3", "wordNameEn": "a3", "wordSumm": "요약1" }];
  </script>
  
  <style scoped>
  
  </style>