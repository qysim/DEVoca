import { localAxios } from '@/util/http-commons'

const local = localAxios()

export function getQuiz(quizId, success, fail) {
  local.get(`/quiz/${quizId}`).then(success).catch(fail)
}

export function saveQuizResult(data, success, fail) {
  console.log(data);
  local.post(`/quiz/save`, data).then(success).catch(fail)
}

export function saveBattleResult(data, success, fail) {
  console.log(data);
  local.post(`/quiz/battle/save`, data).then(success).catch(fail)
}

// export function updateCard(cardId, data, success, fail) {
//   local.patch(`/card/${cardId}`, data).then(success).catch(fail)
// }

// export function deleteCard(cardId, success, fail) {
//   local.delete(`/card/${cardId}`).then(success).catch(fail)
// }

// export function repostCard(data, success, fail) {
//   local.post('/card/repost', data).then(success).catch(fail)
// }