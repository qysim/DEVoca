import { localAxios } from "@/util/http-commons"

const local = localAxios()   //axios instance 호출

function getWordList(param, success, fail) {
  local.get(`/dictionary/${param}`).then(success).catch(fail)
}

async function getWordDetail(param, success, fail) {
  await local.get(`/dictionary/detail/${param}`).then(success).catch(fail)
}

function getCardListByWord(param, success, fail) {
  // param = {wordId}/{scroll}
  local.get(`/dictionary/detail/${param}`).then(success).catch(fail)
}

export {
  getWordList,
  getWordDetail,
  getCardListByWord
}
