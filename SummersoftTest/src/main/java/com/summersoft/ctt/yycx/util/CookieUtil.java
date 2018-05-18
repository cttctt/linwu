package com.summersoft.ctt.yycx.util;
import org.openqa.selenium.Cookie;

public class CookieUtil {

    private static Cookie ck = null;

    public static Cookie getCk() {
        return ck;
    }

    public static void setCk(Cookie ck) {
        CookieUtil.ck=ck;
    }

}
