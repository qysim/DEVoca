import { localAxios } from '@/util/http-commons'

const local = localAxios()
const localUserInfo = JSON.parse(localStorage.getItem('user'))
const accessToken = localUserInfo.kakaoUserInfo.token
local.defaults.headers['token'] = accessToken

export function getWordList(param, success, fail) {
  local.get(`/dictionary/${param}`).then(success).catch(fail)
}

export async function getWordDetail(param, success, fail) {
  await local.get(`/dictionary/detail/${param}`).then(success).catch(fail)
}

export function getCardListByWord(param, success, fail) {
  local.get(`/dictionary/detail/${param}`).then(success).catch(fail)
}

// author: cheesecat47 <cheesecat47@gmail.com>
export function getSearchResultWords(param, success, fail) {
  local.get(`/search/word/${param}/0`).then(success).catch(fail)
}

// author: cheesecat47 <cheesecat47@gmail.com>
export function getSearchResultCards(param, success, fail) {
  local.get(`/search/card/${param}/0`).then(success).catch(fail)
}
