import { localAxios } from '@/util/http-commons'

const local = localAxios()

// author: cheesecat47 <cheesecat47@gmail.com>
export function getSearchResults(param, success, fail) {
  local.get(`/search/word/${param}/0`).then(success).catch(fail)
}
