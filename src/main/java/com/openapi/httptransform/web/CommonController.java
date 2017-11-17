package com.openapi.httptransform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mustangkong on 2017/3/11.
 */
@RestController
@RequestMapping("/track/")
public class CommonController {

    @Autowired
    public CommonService commonService;

    /**
     * equipment
     * @return
     */
    @RequestMapping(value = "equipment", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public int equipment(@RequestParam(value="snid") String snid,
                         @RequestParam(value="gameid") String gameid,
                         @RequestParam(value="ip") String ip,
                         @RequestParam(value="ds") String ds,
                         @RequestParam(value="jsonString") String jsonString,
                         @RequestParam(value="metric") String metric,
                         HttpServletRequest httpServletRequest){
        return commonService.equipment(snid, gameid, ip, ds, jsonString, metric, httpServletRequest);
    }


}
