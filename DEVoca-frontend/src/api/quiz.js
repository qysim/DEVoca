import { localAxios } from '@/util/http-commons'

const local = localAxios()

export function getQuiz(quizId, success, fail) {
  console.log("보내는 값 : " + quizId);
  local.get(`/quiz/${quizId}`).then(success).catch(fail)
}

// export function getCardListByUserId(userid, scroll, success, fail) {
//   local.get(`/card/list/${userid}/${scroll}`).then(success).catch(fail)
// }

// export function getCardDetail(cardId, success, fail) {
//   local.get(`/card/${cardId}`, {
//     headers: {
//       token: JSON.parse(localStorage.getItem('user')).kakaoUserInfo.token
//     }
//   }).then(success).catch(fail)
// }

// export function updateCard(cardId, data, success, fail) {
//   local.patch(`/card/${cardId}`, data).then(success).catch(fail)
// }

// export function deleteCard(cardId, success, fail) {
//   local.delete(`/card/${cardId}`).then(success).catch(fail)
// }

// export function repostCard(data, success, fail) {
//   local.post('/card/repost', data).then(success).catch(fail)
// }