// 콘텐츠 스크립트
// - 웹페이지 컨텍스트에서 JS 실행
// - 표준 DOM을 사용해 방문한 웹페이지 세부 정보를 읽고, 변경하고, 정보를 상위 확장 프로그램에 전달.

document.querySelector('#searchBtn').addEventListener('click', () => {
    console.log('handler1')
    document.querySelector('#searchInput').value = 'hi'
});
