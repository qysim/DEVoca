# DEVoca Deploy Guides

## 환경 변수 설정

```bash
cp .env.template .env

vi .env
# 환경 변수 값 수정
# MYSQL_EXTERNAL_PORT=3306
# MYSQL_PORT=3306
# MYSQL_ROOT_PASSWORD=your_root_password
# ...
```

## MySQL DB

- Version: 8.0.35
- Docker container

### Run

```bash
docker compose -f docker-compose.mysql.yml up -d mysql
```
