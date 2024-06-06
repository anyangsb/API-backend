package com.gl.glapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.gl.glapiclientsdk.model.Number;
import com.gl.glapiclientsdk.model.User;


import java.util.HashMap;
import java.util.Map;

import static com.gl.glapiclientsdk.utils.SignUtils.genSign;


public class GlApiClient {

    private String accessKey;

    private String secretKey;

    private static final String GATEWAY_HOST = "http://localhost:8090";

    private static final String ONLINE_GATEWAY_HOST = "http://111.229.101.185:8090";

    public GlApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    private Map<String,String> getHeaderMap(String body){
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("accessKey",accessKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body",body);
        hashMap.put("timestamp",String.valueOf(System.currentTimeMillis()/1000));
        hashMap.put("sign",genSign(body,secretKey));
//        hashMap.put("secretKey",secretKey);
        return hashMap;
    }

    public String getNameByGet(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name",name);
        String result = HttpUtil.get(GATEWAY_HOST +"/api/name/get/", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name",name);
        String result = HttpUtil.post(GATEWAY_HOST +"/api/name/post/", paramMap);
        System.out.println(result);
        return result;
    }

    public String getUserNameByPost(User user){
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST +"/api/name/user/")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    public String add(Number number){
        String json = JSONUtil.toJsonStr(number);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST +"/api/number/add/")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    public String sub(Number number){
        String json = JSONUtil.toJsonStr(number);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST +"/api/number/sub/")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    public String multiply(Number number){
        String json = JSONUtil.toJsonStr(number);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST +"/api/number/multiply/")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    public String division(Number number){
        String json = JSONUtil.toJsonStr(number);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST +"/api/number/division/")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    public String getLoveByGet(){
        String json = "";
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST +"/api/love/get/")
                .addHeaders(getHeaderMap(json))
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }
}
