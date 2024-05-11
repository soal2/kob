<!--写html-->
<template>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >  <!--设置外观样式-->
  <div class="container">
    <!--避免了界面切换时的刷新-->
    <router-link class="navbar-brand" :to="{name:'home'}">King Of Bots</router-link>
    <!-- <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button> -->
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <!--高亮选中标签-->
          <router-link :class = "route_name == 'pk_index' ? 'nav-link active' : 'nav-link'" aria-current="page" :to="{name:'pk_index'}">对战</router-link>
        </li>
        <li class="nav-item">
            <router-link :class = "route_name == 'record_index' ? 'nav-link active' : 'nav-link'" :to="{name:'record_index'}">对局列表</router-link>
        </li>
        <li class="nav-item">
            <router-link :class = "route_name == 'ranklist_index' ? 'nav-link active' : 'nav-link'" :to="{name:'ranklist_index'}">排行榜</router-link>
        </li>
      </ul>
      <ul class="navbar-nav" v-if="$store.state.user.is_login">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            {{ $store.state.user.username }}
          </a>
          <ul class="dropdown-menu">
            <li><router-link class="dropdown-item" :to="{name:'user_bot_index'}">My Bots</router-link></li>
            <!-- <li><a class="dropdown-item" href="#">Another action</a></li> -->
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#" @click="logout">退出</a></li>
          </ul>
        </li>
      </ul>
      <ul class="navbar-nav" v-else-if="!$store.state.user.pulling_info">
        <li class="nav-item">
          <router-link class="nav-link" :to="{name : 'user_account_login' }" role="button" >
            登录
          </router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" :to="{name : 'user_account_register' }" role="button" >
            注册
          </router-link>
        </li>
      </ul>
    </div>
  </div>
</nav>
</template>

<!--js-->
<script>
/*获取当前所在页面 */
import { useRoute } from 'vue-router'
import { computed } from 'vue'
import { useStore } from 'vuex'


export default {
  setup(){
    const store = useStore();
    const route = useRoute();
    let route_name = computed(() => route.name)
    //let show_bar = ref(false);

    const logout = () => {
      store.dispatch("logout");
    }

    //取出localStorage的token判断是否合法，是则直接进入首页
    // const jwt_token = localStorage.getItem("jwt_token");
    // if(jwt_token){
    //     store.commit("updateToken", jwt_token);
    //     store.dispatch("getinfo",{   //条用的方法，参数 
    //         success(){
    //             router.push({ name : "home" });
    //         },
    //         error(){
    //             show_bar.value = true;
    //         }
    //     })
    // } else {
    //     show_bar.value = true;
    // }

    return {
      route_name,
      logout
    } 
  }
}
</script>

<!--css-->
<style>

</style>