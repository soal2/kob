<template>
  <NavBar />
  <router-view/>
</template>

<script>
//导入组件
import NavBar from './components/NavBar.vue'
//导入bootstrap
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"
export default{
  components :{
    NavBar
  }
}
</script>


<style>
body {
  background-image: url("@/assets/images/background.png");
  background-size: cover;
}

</style>
