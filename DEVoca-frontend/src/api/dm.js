import { localAxios } from "@/util/http-commons";

const local = localAxios();

async function getDmRoomList(success, fail) {
    const localUserInfo = JSON.parse(localStorage.getItem('user'))
    const accessToken = localUserInfo.kakaoUserInfo.token
    local.defaults.headers['token'] = accessToken
    await local.get('/dm').then(success).catch(fail);
}

async function getDmList(roomUuid, scroll, success, fail) {
    await local.get(`/dm/` + `${roomUuid}` + `/` + `${scroll}`).then(success).catch(fail);
}

export {
    getDmRoomList,
    getDmList,
};