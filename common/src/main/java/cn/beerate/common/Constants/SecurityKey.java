package cn.beerate.common.Constants;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class SecurityKey {
    public static String privateKey;

    public static String publicKey;

    public static String md5Key;

    public void setPrivateKey(String privateKey) {
        SecurityKey.privateKey = privateKey;
    }

    public void setPublicKey(String publicKey) {
        SecurityKey.publicKey = publicKey;
    }

    public void setMd5Key(String md5Key) {
        SecurityKey.md5Key = md5Key;
    }

    public void init(){
        Log log= LogFactory.getLog(SecurityKey.class);
        log.info("加载系统安全配置文件...");
    }
}
