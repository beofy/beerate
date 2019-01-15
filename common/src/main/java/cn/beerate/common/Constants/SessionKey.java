package cn.beerate.common.Constants;

public class SessionKey {
    private SessionKey() {
    }

    /** 当前登录用户凭证缓存key前缀（key = front_ + sessionID） */
    public static final String FRONT_ = "front_";

    /** 当前后台用户凭证缓存key前缀（key = back_ + sessionID） */
    public static final String BACK_ = "back_";
}
