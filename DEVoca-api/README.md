# DEVOCA - backend part

backend server for DEVOCA

## 실행 방법

### 실행 전 필요한 사항

- `.env` 파일의 생성 : [deploy/README.md](../deploy/README.md) 참고하여 .env 파일 생성
- 환경 변수 세팅 : 위에서 생성한 .env파일을 IDE, 실행환경 별 환경변수에 추가

```bash
$ ./gradlew bootJar
$ ./gradlew bootRun
```

- Go to <http://localhost/swagger-ui.html>

## 디렉토리 구조

```bash
DEVoca-api
├─.gradle
│  ├─8.5
│  │  ├─checksums
│  │  ├─dependencies-accessors
│  │  ├─executionHistory
│  │  ├─fileChanges
│  │  ├─fileHashes
│  │  └─vcsMetadata
│  ├─buildOutputCleanup
│  └─vcs-1
├─.idea
├─gradle
│  └─wrapper
├─out
│  └─production
│      ├─classes
│      │  └─com
│      │      └─ssafy
│      │          └─devoca
│      │              ├─board
│      │              │  ├─controller
│      │              │  ├─model
│      │              │  │  └─mapper
│      │              │  └─service
│      │              ├─card
│      │              │  ├─controller
│      │              │  ├─model
│      │              │  │  └─mapper
│      │              │  └─service
│      │              ├─config
│      │              └─word
│      │                  ├─controller
│      │                  ├─model
│      │                  │  └─mapper
│      │                  └─service
│      └─resources
│          ├─mapper
│          │  ├─board
│          │  └─card
│          └─mapper.word
├─resources
│  └─sql
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


($tree 명령어 사용, 구조 다시 업데이트)
```

## Contributors

- [배성연](https://github.com/bae2019)
- [류지윤](https://github.com/Ryujy)
- [김주이](https://github.com/jjuyii49)
