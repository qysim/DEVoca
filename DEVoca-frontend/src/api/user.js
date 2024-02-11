import { localAxios } from '@/util/http-commons'

const local = localAxios()

export function joinUser(data, success, fail) {
  local.post('/user', data).then(success).catch(fail)
}

export function getKaKaoToken(param, success, fail) {
  local.get(`/kakao/callback?code=${param}`).then(success).catch(fail)
}