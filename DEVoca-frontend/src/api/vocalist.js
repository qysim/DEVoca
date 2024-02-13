import { localAxios } from '@/util/http-commons'

const local = localAxios()

export function getVocaListDetail(vocaListId, success, fail) {
  local.get(`/vocalist/detail/${vocaListId}`, {
    headers: {
      token: JSON.parse(localStorage.getItem('user')).kakaoUserInfo.token
    }
  }).then(success).catch(fail)
}
