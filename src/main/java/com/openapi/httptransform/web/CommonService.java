package com.openapi.httptransform.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.openapi.httptransform.utils.Constents;
import com.openapi.httptransform.utils.HttpUtils;
import com.openapi.httptransform.utils.IPAddressUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class CommonService {

    private static final Logger logger = LoggerFactory.getLogger(CommonService.class);

    /**
     * 公司bi启动报送
     *
     * @param snid
     * @param gameid
     * @param ip
     * @param ds
     * @param jsonString
     * @param httpServletRequest
     * @return
     */
    public int equipment(String snid,
                         String gameid,
                         String ip,
                         String ds,
                         String jsonString,
                         String metric,
                         HttpServletRequest httpServletRequest) {
        logger.info(Constents.REP_TYPE_EQUIPMENT + " : " + snid + " : " + gameid + " : " + ip + " : " + ds + " : " + jsonString);

        try {
            JSONObject data = JSON.parseObject(jsonString);
            String channelid = data.getString("creative");

            if (Constents.channels.contains(channelid)) {
                ip = IPAddressUtil.getClientIpAddress(httpServletRequest);
                // 时间
                LocalDateTime date = LocalDateTime.now();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                Map<String, String> params = new HashMap<>();
                params.put("snid", snid);
                params.put("gameid", gameid);
                params.put("ip", ip);
                params.put("ds", dateFormatter.format(date));
                params.put("jsonString", jsonString);
                params.put("metric", metric);

                logger.info("#######   " + JSON.toJSONString(params));

                HttpUtils.Get(Constents.BASE_BI_URL, params);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return -1;
        }

        return 1;
    }


}
