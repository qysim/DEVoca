FROM node:20-slim as builder
LABEL authors="cheesecat47"

WORKDIR /app

COPY package*.json .

RUN npm install

COPY . .

RUN npm run build

FROM nginx:1.25

COPY --from=builder /app/dist /usr/share/nginx/html
COPY ../deploy/nginx/nginx.conf /etc/nginx/nginx.conf

EXPOSE 443

CMD ["nginx", "-g", "daemon off;"]
