package cn.beerate.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "响应数据")
public class Message<T> {

    @ApiModelProperty(value = "状态码(200：成功,-1：失败)")
    private int code;

    @ApiModelProperty(value = "响应信息")
    private String msg;

    @ApiModelProperty(value = "响应数据")
    private T data;

    public Message(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Message(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Message<T>  ok(){
        return new Message<T>(Message.Code.SUCCESS,"success");
    }
    public static <T> Message<T>  ok(String msg){
        return new Message<T>(Message.Code.SUCCESS,msg);
    }
    public static <T> Message<T> success(T data){
        return new Message<T>(Message.Code.SUCCESS,"success",data);
    }

    public static <T> Message<T> error(){
        return new Message<T>(Message.Code.ERROR,"error");
    }

    public static <T> Message<T> error(String msg){
        return new Message<T>(Message.Code.ERROR,msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public class Code{

        /** 公共成功码200:处理成功 */
        public static final int SUCCESS = 200;

        /** 公共错误码 -1:处理失败 */
        public static final int ERROR = -1;

        /** 公共错误码-404:未找到资源() */
        public static final int ERROR_404 = -404;

        /** 公共错误码-500:程序错误 */
        public static final int ERROR_500 = -500;

        /** 拦截标识-100:登录拦截 */
        public static final int NOT_LOGIN = -100;

        /** 登录超时*/
        public static final int  LOGIN_TIME_OUT = -102;
    }
}
