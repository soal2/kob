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
  },
  setup(){

    

    // $.ajax({
    //   url:"http://127.0.0.1:3000/user/account/register/",
    //   type : "post",
    //   data :{
    //     username : "yxc",
    //     password : "1234",
    //     confirmedPassword : "1234"
    //   },
    //   success(resp){
    //     console.log(resp);
    //   },
    //   error(resp){
    //     console.log(resp);
    //   }
    // })
  }
}
</script>


<style>
body {
  background-image: url("@/assets/images/background.png");
  background-size: cover;
}

</style>
