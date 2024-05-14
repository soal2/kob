//存储所有和pk相关的全局变量


export default {
    state: {
        status : "matching",  //matching表示正在匹配，playing表示对战页面
        socket : null,
        opponent_username : "",  //对手的名字
        opponent_photo: "",
        gamemap : null,
    },
    getters: {

    },
    mutations: {
        updateSocket(state, socket){
            state.socket = socket;
        },
        updateOpponent(state, opponent){
            state.opponent_username = opponent.username;
            state.opponent_photo = opponent.photo;
        },
        updateStatus(state, status){
            state.status = status;
        },
        updateGamemap(state, gamemap){
            state.gamemap = gamemap;
        }
    },
    actions: {
        
    },
    modules: {
    }
}