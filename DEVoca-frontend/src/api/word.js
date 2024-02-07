import { localAxios } from "@/util/http-commons"

const local = localAxios()   //axios instance 호출

function getWordList(param, success, fail) {
  local.get(`/dictionary/${param}`).then(success).catch(fail)
}

function getWordDetail(param, success, fail) {
  local.get(`/dictionary/detail/${param}`).then(success).catch(fail)
}

function getCardListByWord(param, success, fail) {
  // param = {wordId}/{scroll}
  local.get(`/dictionary/detail/${param}`).then(success).catch(fail)
}

// local.defaults.headers["Authorization"] = sessionStorage.getItem("accessToken")
// local.defaults.headers["refreshToken"] = sessionStorage.getItem("refreshToken") //axios header에 refresh-token 셋팅

export {
  getWordList,
  getWordDetail,
  getCardListByWord
}
