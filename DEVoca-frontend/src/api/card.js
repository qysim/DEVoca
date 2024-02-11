import { localAxios } from '@/util/http-commons'

const local = localAxios()

export function registCard(data, success, fail) {
  local.post('/card', data).then(success).catch(fail)
  // local.post('/card', JSON.stringify(data)).then(success).catch(fail)
}

export function getCardList(param, success, fail) {
  const localUserInfo = JSON.parse(localStorage.getItem('user'))
  const accessToken = localUserInfo.kakaoUserInfo.token
  local.defaults.headers['token'] = accessToken
  local.get(`/card/list/${param}`).then(success).catch(fail)
}
