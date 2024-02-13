import { localAxios } from '@/util/http-commons'

const local = localAxios()


// author: cheesecat47 <cheesecat47@gmail.com>
export function getSearchResultWords(param, success, fail) {
  local.get(`/search/word/${param}/0`).then(success).catch(fail)
}

// author: cheesecat47 <cheesecat47@gmail.com>
export function getSearchResultCards(param, success, fail) {
  local.get(`/search/card/${param}/0`).then(success).catch(fail)
}

export async function getAutoCompList(success, fail) {
  await local.get('/search/autocomplete').then(success).catch(fail)
}

export async function getRecentKeyword(success, fail) {
  await local.get('/search/reco/keyword', {
    headers: {
      token: JSON.parse(localStorage.getItem('user')).kakaoUserInfo.token
    }
  }).then(success).catch(fail)
}