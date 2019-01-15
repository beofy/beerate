requirejs.config({
    //By default load any module IDs from js/lib
    //baseUrl: '',
    paths: {
        "jquery":'lib/jquery',
        "layui":"layui/layui",
        "encrypt":"encrypt/encrypt",//rsa工具
        "3DES":"encrypt/3DES"
    },
    shim:{

    }
});

define(["jquery","layui"],function ($) {
    //拦截处理器
    window.interceptor=function(result){
        if(result=="undefined"||result==null||result.length==0){//无数据
            window.location.reload();
            return false;
        }

        if(result.code == -100){//没有登录
            location.href="/pages/login.html";
            return false;
        }

        return true;
    }

})

