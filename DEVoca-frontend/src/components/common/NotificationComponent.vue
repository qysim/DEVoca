<template>
<div onclick="">
    <div role="alert" class="alert" style="display: flex; flex-direction: row;">
        <img src="@/assets/images/DEVoca_logo_initial.png" viewBox="0 0 24 24" class="stroke-info shrink-0 w-12 h-11" alt="devoca_logo">
        <div style="display: flex; flex-direction: column; align-items: start;">
            <h1 style="font-weight:bolder; font-size: larger;">DEVoca</h1>
            <h3>{{ notification }}</h3>
        </div>
    </div>
</div>
</template>

<script setup>
import { ref, onMounted, computed } from "vue";

const pushedData = ref({});
const notificationLink = ["/board/", "/board/", "/card/", "/card/", "/dm/", "/quiz/"];
const routeto = ref({});
let lastEventId = null;
const notificationString = ["내 게시글에 댓글이 달렸어요.", "내 댓글이 채택되었어요.",
    "내 카드가 좋아요를 받았어요.", "내 카드가 재게시되었어요.",
    "새로운 DM이 도착했어요.", "좋은아침입니다! 오늘의 퀴즈가 도착했어요."];

const notificationType = ref(0);
const notification = computed(() => notificationString[notificationType.value]);

onMounted(() => {
    notificationType.value = 5;
//   const eventSource = new EventSource("http://localhost/devoca/notify/connect?Last-Event-ID=" + lastEventId);
//   eventSource.addEventListener('push', (event) => {
//     console.log("push notify!");
//     pushedData.value = JSON.parse(event.data);

//     // 예상 data : notificationId, userIdx, notificationType, notificationLinkId, notificationDate, isRead
//     // notificationType
//     // -> 타입 0:글 댓글, 1: 댓글 채택, 2: 카드 좋아요, 3: 카드 재게시, 4: DM, 5: 퀴즈
//     // notificationLinkId
//     // -> 타입 0,1: 원본 게시글 Id, 2: 해당 카드 Id, 3: 재게시로 생성된 카드 Id, 4: 해당 roomIdx, 5: 해당 퀴즈 Id
//     if(notificationType == 4){    // DM의 경우 idx
//       // notificationLinkId를 DM room id(String)으로 반환하는 api 쓰기
//       const temp = //api 반환값(String DM room id)
//       routeto.value = notificationLink[notificationType] + temp + "/0";
//     }else{
//       routeto.value = notificationLink[notificationType] + pushedData.notificationLinkId;
//     }

//     lastEventId = event.lastEventId;  // 마지막 이벤트 아이디 업데이트
//     // 하단 플로팅메뉴처럼 상단 플로팅으로 푸시알림 컴포넌트 생성
//     // 푸시알림 컴포넌트에 routeto 보내서 푸시알림 클릭 시 거기로 보내기
//   })
})
</script>