# DEVoca-api

REST API server for DEVoca

## 실행 방법

### 실행 전 필요한 사항

- 환경 변수 확인
  - [deploy/README.md](../deploy/README.md) 참고하여 `.env` 파일 생성.
  - IDE, 실행환경 별 환경변수에 추가.

### 빌드, 실행

```bash
$ ./gradlew bootJar
$ ./gradlew bootRun
```

- Go to <http://localhost/swagger-ui.html>

## 디렉토리 구조

```bash
DEVoca-api
├─resources
│  └─sql        # DB 초기화, 샘플 데이터 생성 등에 사용되는 SQL 파일
└─src
    ├─main
    │  ├─generated
    │  ├─java
    │  │  └─com
    │  │      └─ssafy
    │  │          └─devoca
    │  │              ├─board
    │  │              │  ├─controller
    │  │              │  ├─model
    │  │              │  │  └─mapper
    │  │              │  └─service
    │  │              ├─card
    │  │              │  ├─controller
    │  │              │  ├─model
    │  │              │  │  └─mapper
    │  │              │  └─service
    │  │              ├─config
    │  │              └─word
    │  │                  ├─controller
    │  │                  ├─model
    │  │                  │  └─mapper
    │  │                  └─service
    │  └─resources
    │      ├─mapper
    │      │  ├─board
    │      │  └─card
    │      └─mapper.word
    └─test
        └─java
            └─com
                └─ssafy
                    └─devoca
```

## Contributors

- [배성연](https://github.com/bae2019)
- [류지윤](https://github.com/Ryujy)
- [김주이](https://github.com/jjuyii49)
