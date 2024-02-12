import { localAxios } from '@/util/http-commons'

const local = localAxios()

export function getMyBoard(success, fail) {
  local.get(`/mypage/myboard`, {
    headers: {
      token: JSON.parse(localStorage.getItem('user')).kakaoUserInfo.token
    }
  }).then(success).catch(fail)
}
