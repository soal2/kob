<!--写html-->
<template>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container">
    <!--避免了界面切换时的刷新-->
    <router-link class="navbar-brand" :to="{name:'home'}">King Of Bots</router-link>
    <!-- <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button> -->
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <router-link class = "nav-link" aria-current="page" :to="{name:'pk_index'}">对战</router-link>
        </li>
        <li class="nav-item">
            <router-link class = "nav-link" :to="{name:'record_index'}">对局列表</router-link>
        </li>
        <li class="nav-item">
            <router-link class = "nav-link" :to="{name:'ranklist_index'}">排行榜</router-link>
        </li>
      </ul>
      <ul class="navbar-nav">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Formatting
          </a>
          <ul class="dropdown-menu">
            <li><router-link class="dropdown-item" :to="{name:'user_bot_index'}">My Bots</router-link></li>
            <!-- <li><a class="dropdown-item" href="#">Another action</a></li> -->
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">退出</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
</template>

<!--js-->
<script>


</script>

<!--css-->
<style>

</style>