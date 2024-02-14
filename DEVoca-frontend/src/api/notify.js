import { localAxios } from '@/util/http-commons'

const local = localAxios()

export function connectSSE(LastEventId, success, fail) {
    local.get(`/notify/connect?Last-Event-ID=${LastEventId}`, {
        headers: {
            token: JSON.parse(localStorage.getItem('user')).kakaoUserInfo.token
        }
    }).then(response => {
        console.log("connectSSE 실행 완료")
        const eventSource = new EventSource(response.data, { withCredentials: true });

        eventSource.onmessage = (event) => {
            const eventData = JSON.parse(event.data);
            success(eventData);
        }
        eventSource.onerror = (error) => {
            fail(error);
        }

    }).catch(error => {
        fail(error);
    });
    
}