FROM node:20-alpine

ENV WATCHPACK_POLLING=true
ENV NODE_ENV=$NODE_ENV

COPY . ./srv
WORKDIR /srv


RUN npm install
CMD npm run dev

EXPOSE 4200