import $ from 'jquery'

export default {
    state: {
        id : "",
        username: "",
        photo: "",
        token: "",
        is_login: false,
        pulling_info: true,  //是否正在拉取信息
    },
    getters: {
    },
    mutations: {
        updateUser(state, user){
            state.id = user.id;
            state.username = user.username;
            state.photo = user.photo;
            state.is_login = user.is_login;
        },

        updateToken(state, token){
            state.token = token;
        },

        logout(state){
            state.id = "";
            state.username = "";
            state.photo = "";
            state.token = "";
            state.is_login = false;
        },
        updatePullingInfo(state, pulling_info){
            state.pulling_info = pulling_info;
        }
    },
    actions: {
        login(context, data){
            $.ajax({
                url:"http://127.0.0.1:3000/user/account/token/",
                type: "post",
                data: {
                  username : data.username,
                  password : data.password,
                },
                success(resp){
                    if(resp.error_message === "success")
                    {
                        localStorage.setItem("jwt_token", resp.token);  //将用户的token放到浏览器的硬盘中
                        context.commit("updateToken", resp.token);  //调用mutations的函数
                        data.success(resp);
                    } else {
                        data.error(resp);
                    }
                },
                error(resp){
                    data.error(resp); 
                }
              });
        },

        getinfo(context, data){
            $.ajax({
                url:"http://127.0.0.1:3000/user/account/info/",
                type : "get",
                headers : {
                    Authorization: "Bearer " + context.state.token,
                },
                success(resp){
                    if(resp.error_message === "success")
                    {
                        context.commit("updateUser", {
                            ...resp,  //把resp中的信息放到当前对象里
                            is_login : true,
                        });
                        data.success(resp);
                    } else {
                        data.error(resp);
                    }
                },
                error(resp){
                    data.error(resp);
                }
            })
        },
        logout(context){
            localStorage.removeItem("jwt_token"); //退出时删除token 
            context.commit("logout");
        }
    },
    modules: {
    }
}