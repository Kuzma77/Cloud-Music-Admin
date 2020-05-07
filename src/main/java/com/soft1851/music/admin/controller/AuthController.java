package com.soft1851.music.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.soft1851.music.admin.annotation.ControllerWebLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/oauth2/code/github")
@Slf4j
public class AuthController {

    @GetMapping()
    @ControllerWebLog
    public void getUser(@RequestParam("code") String code) {
        String token = "";
        String user = "";
        try {
            //创建一个HttpClient对象
            HttpClient client = HttpClients.createDefault();
            //创建一个Post对象
            HttpPost post = new HttpPost("https://github.com/login/oauth/access_token");
            //创建一个entity模拟一个表单
            List<NameValuePair> list = new ArrayList<>();
            list.add(new BasicNameValuePair("client_id", "029605ac4b8d64a69874"));
            list.add(new BasicNameValuePair("client_secret", "7744fb940c8f98d9e1d5abba390d17f247d5b0a4"));
            list.add(new BasicNameValuePair("code", code));
            //包装成一个entity对象
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");
            //设置请求内容
            post.setEntity(urlEncodedFormEntity);
            post.addHeader("accept", "application/json");
            post.addHeader("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.129 Mobile Safari/537.36");
            //执行请求内容
            HttpResponse httpResponse = client.execute(post);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            log.info(String.valueOf(statusCode));
            HttpEntity contentEntity = httpResponse.getEntity();
            String content = EntityUtils.toString(contentEntity);
            log.info(content);
            token = JSONObject.parseObject(content).getString("access_token");
            log.info("token>>>>>>>>>>>>>>>>" + token);

            //取user
            RequestConfig requestConfig = RequestConfig.custom()
                    .setExpectContinueEnabled(true)
                    .setSocketTimeout(10000)
                    .setConnectTimeout(10000)
                    .setConnectionRequestTimeout(10000)
                    .build();
            HttpGet get = new HttpGet("https://api.github.com/user?access_token=" + token);
            get.setConfig(requestConfig);
            get.setHeader("Authorization", "token " + token);
            get.setHeader("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.129 Mobile Safari/537.36");

            httpResponse = client.execute(get);
            contentEntity = httpResponse.getEntity();
            user = EntityUtils.toString(contentEntity);
            log.info("user>>>>>>>>>>>>" + user);
            EntityUtils.consume(contentEntity);
            //重定向跳回客户端
            ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert sra != null;
            HttpServletResponse response = sra.getResponse();
            response.sendRedirect("http://localhost:8081/#/auth?uId=" + JSONObject.parseObject(user).getString("id"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
