import { localAxios } from '@/util/http-commons'

const local = localAxios()

// export function registCard(data, success, fail) {
//   local.post(`/card`, data).then(success).catch(fail)
// }

export function getCardList(param, success, fail) {
  // local.defaults.headers["Authorization"] = sessionStorage.getItem("accessToken")
  local.get(`/card/list/${param}`).then(success).catch(fail)
}
