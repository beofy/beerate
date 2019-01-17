package cn.beerate.controller;

import cn.beerate.common.Message;
import cn.beerate.model.entity.stock.t_company_big_news;
import cn.beerate.service.CompanyBigNewsService;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CompanyBigNewsController {

    @Autowired
    private CompanyBigNewsService bigNewsService;

    @RequestMapping(value = "/companybignews")
    @ResponseBody
    public Object CompanyBigNews(@Param(value = "code") String code){
        if(StringUtil.isBlank(code)){
            Message.error("股票代码错误");
        }

        Message<t_company_big_news> message = bigNewsService.findByCode(code);
        //如果数据库中未保存
        if(message.getCode()==Message.Code.ERROR){
            Message<String> message1 = bigNewsService.companyBigNews(code);
            //未抓取到
            if(message1.getCode()==Message.Code.ERROR){
               return message;
            }

            return Message.success(JSONObject.parseObject(message1.getData()));
        }

        return message;
    }
}
