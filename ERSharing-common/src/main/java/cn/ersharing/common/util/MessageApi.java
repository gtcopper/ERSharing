package cn.ersharing.common.util;

import okhttp3.*;

import java.io.IOException;

public class MessageApi {
    public static String setRequestSmsCode(String phone) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create
                (mediaType, "{\n\t\"mobilePhoneNumber\":\""+phone+"\",\n    \"template\":\"makerlab\"\n}");
        Request request = new Request.Builder()
                .url("https://api2.bmob.cn/1/requestSmsCode")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("X-Bmob-Application-Id", "769728bd8077c18bc642e40c31d70f92")
                .addHeader("X-Bmob-REST-API-Key", "3663c9c338bf2f317ebb70408091c18b")
                .addHeader("Cache-Control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("服务器端错误: " + response);
        }
        return response.message();
    }

    public static int setVerifySmsCode(String phone,String code) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"mobilePhoneNumber\":\""+phone+"\"\n}");
        Request request = new Request.Builder()
                .url("https://api2.bmob.cn/1/verifySmsCode/"+code)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("X-Bmob-Application-Id", "769728bd8077c18bc642e40c31d70f92")
                .addHeader("X-Bmob-REST-API-Key", "3663c9c338bf2f317ebb70408091c18b")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "8cf596ea-d26a-4626-8f30-47dbaeebb3dd")
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("服务器端错误: " + response);
        }
        return response.code();
    }

    public static void main(String[] args) throws Exception{
        //setRequestSmsCode("15014345412");
        System.out.println(setVerifySmsCode("15014345412","107224"));
    }
}
