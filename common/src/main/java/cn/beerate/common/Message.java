package cn.beerate.common;

public class Message<T> {

    private int code;

    private String msg;

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

    public class Code{

        public final static int SUCCESS = 200;

        public final static int ERROR = -1;

    }
}
