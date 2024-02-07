// 백그라운드에서 브라우저 이벤트를 모니터링.
// 서비스 워커는 이벤트를 처리하고 필요하지 않을 때 종료되는 특수 JS 환경.

// // 상태 배지 추가
// chrome.runtime.onInstalled.addListener(() => {
//     chrome.action.setBadgeText({
//         text: "OFF",
//     })
// })

// const extensions = 'https://developer.chrome.com/docs/extensions'
// const webstore = 'https://developer.chrome.com/docs/webstore'

// chrome.action.onClicked.addListener(async (tab) => {
//     if (tab.url.startsWith(extensions) || tablurl.startsWith(webstore)) {
//         // 확장 프로그램이 'ON', 'OFF' 상태인지 가져옴
//         const prevState = await chrome.action.getBadgeText({ tabId: tab.id })
//         // 다음 상태는 반대
//         const nextState = prevState === 'ON' ? 'OFF' : 'ON'

//         // 배지 상태 변경
//         await chrome.action.setBadgeText({
//             tabId: tab.id,
//             text: nextState
//         })
//     }
// })