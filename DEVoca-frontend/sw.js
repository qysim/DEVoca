self.addEventListener('fetch', function (e) {
  // 여기에 코드를 넣지 않아도 설치는 가능하다.
})

import { ref } from "vue";
import { EventSourcePolyfill } from 'event-source-polyfill';

const lastEventId = ref(null);
const token = JSON.parse(localStorage.getItem('user')).kakaoUserInfo.token;

const SSEsw = new EventSourcePolyfill(
  'https://i10d112.p.ssafy.io/devoca/notify/connect?Last-Event-ID='+lastEventId.value,
  {
    headers: { token: token },
    withCredentials: true,
    heartbeatTimeout: 300000000,
  }
);

SSEsw.addEventListener('sse', (event) => {
  console.log("SSEsw 연결 완료!!");
  console.log(event.data);
  console.log(JSON.parse(event.data));
})

SSEsw.onerror = (err) => { 
  console.log(err);
  SSEsw.close();
  console.log("SSEsw 종료!");
}