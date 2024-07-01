import { createRouter, createWebHistory } from 'vue-router'

import PkIndexView from '../views/pk/PkIndexView'
import RecordIndexView from '../views/record/RecordIndexView'
import RecordContentView from '../views/record/RecordContentView'
import RankListIndexView from '../views/ranklist/RankListIndexView'
import UserBotIndexView from '../views/user/bot/UserBotIndexView'
import NotFound from '../views/error/NotFound'
import UserAccountLoginView from '../views/user/account/UserAccountLoginView'
import UserAccountRegisterView from '../views/user/account/UserAccountRegisterView'
import store from '@/store/index'

//定义路径映射
const routes = [
  //输入根路径，重定向到pk页面
  {
    path : "/",
    name : "home",
    redirect : "/pk/",
    meta :{  //存放额外信息
      flag: true,   //表示需要授权
    }
  },
  {
    path : "/pk/",
    name : "pk_index",
    component: PkIndexView,
    meta :{  //存放额外信息
      flag: true,   //表示需要授权
    }
  },

  {
    path : "/record/",
    name : "record_index",
    component: RecordIndexView,
    meta :{  //存放额外信息
      flag: true,   //表示需要授权
    }
  },

  {
    path : "/record/:recordId/",
    name : "record_content",
    component: RecordContentView,
    meta :{  //存放额外信息
      flag: true,   //表示需要授权
    }
  },

  {
    path : "/ranklist/",
    name : "ranklist_index",
    component: RankListIndexView,
    meta :{  //存放额外信息
      flag: true,   //表示需要授权
    }
  },

  {
    path : "/user/bot",
    name : "user_bot_index",
    component: UserBotIndexView,
    meta :{  //存放额外信息
      flag: true,   //表示需要授权
    }
  },

  {
    path : "/user/account/login",
    name : "user_account_login",
    component: UserAccountLoginView,
    meta :{  //存放额外信息
      flag: false,   
    }
  },

  {
    path : "/user/account/register",
    name : "user_account_register",
    component: UserAccountRegisterView,
    meta :{  //存放额外信息
      flag: false,   
    }
  },

  {
    path : "/error/",
    name : "404",
    component: NotFound,
    meta :{  //存放额外信息
      flag: false,   
    }
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

//通过router进入某个页面前调用
router.beforeEach((to, from, next) => {
  if(to.meta.flag && !store.state.user.is_login){
    next({name : 'user_account_login'});  //需要授权则跳转到登录页面
  } 
  else{
    next();  //否则跳转到默认页面
  }
})

export default router
