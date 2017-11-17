package com.openapi.httptransform.utils;

import java.util.ArrayList;
import java.util.List;

public class Constents {
    public final static String REP_TYPE_EQUIPMENT = "equipment";        //equipment
    public final static String BASE_BI_URL = "http://compbi.gz.1251415748.clb.myqcloud.com/tracking/";            //base url
    public static List<String> channels = new ArrayList<>();

    static {
        channels.add("baidu");
        channels.add("yyb");
        channels.add("tv");
        channels.add("vivo_offline");
        channels.add("amigo");
        channels.add("lenovo");
        channels.add("meizu");
    }

}
