import { localAxios } from '@/util/http-commons'

const local = localAxios()

export function getMyCard(param, success, fail) {
    local.get(`/mypage/mycard/${param}`, {
        headers: {
            token: JSON.parse(localStorage.getItem('user')).kakaoUserInfo.token
        }
    }).then(success).catch(fail)
}

export function getMyBoard(success, fail) {
    local.get(`/mypage/myboard`, {
        headers: {
            token: JSON.parse(localStorage.getItem('user')).kakaoUserInfo.token
        }
    }).then(success).catch(fail)
}

export function getMyComment(success, fail) {
    local.get(`/mypage/mycomment`, {
        headers: {
            token: JSON.parse(localStorage.getItem('user')).kakaoUserInfo.token
        }
    }).then(success).catch(fail)
}
