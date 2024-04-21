import { createRouter, createWebHistory } from 'vue-router'

import PkIndexView from '../views/pk/PkIndexView'
import RecordIndexView from '../views/record/RecordIndexView'
import RankListIndexView from '../views/ranklist/RankListIndexView'
import UserBotIndexView from '../views/user/bot/UserBotIndexView'
import NotFound from '../views/error/NotFound'

//定义路径映射
const routes = [
  //输入根路径，重定向到pk页面
  {
    path : "/",
    name : "home",
    redirect : "/pk/"
  },
  {
    path : "/pk/",
    name : "pk_index",
    component: PkIndexView,
  },

  {
    path : "/record/",
    name : "record_index",
    component: RecordIndexView,
  },

  {
    path : "/ranklist/",
    name : "ranklist_index",
    component: RankListIndexView,
  },

  {
    path : "/user/bot",
    name : "user_bot_index",
    component: UserBotIndexView,
  },

  {
    path : "/error/",
    name : "404",
    component: NotFound,
  },
  //非法输入跳到404
  {
    path: "/:catchAll(.*)",
    redirect : "/error/"
  }

]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
