FROM node:16.18.1 AS builder
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

FROM nginx:alpine AS deploy
COPY --from=builder /app/dist/wow-ui-pwa /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]