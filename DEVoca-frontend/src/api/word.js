import { localAxios } from '@/util/http-commons'

const local = localAxios()

export function getWordList(param, success, fail) {
  local.get(`/dictionary/${param}`).then(success).catch(fail)
}

export async function getWordDetail(param, success, fail) {
  await local.get(`/dictionary/detail/${param}`).then(success).catch(fail)
}

export function getCardListByWord(param, success, fail) {
  // param = {wordId}/{scroll}
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
