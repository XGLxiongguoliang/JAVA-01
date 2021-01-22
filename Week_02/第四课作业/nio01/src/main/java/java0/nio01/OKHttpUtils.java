package java0.nio01;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program java0.nio01
 * @description okhttp
 * @auther Mr.Xiong
 * @create 2021-01-22 08:56
 */
public class OKHttpUtils {
    public static  final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10000, TimeUnit.MINUTES)
            .readTimeout(10000, TimeUnit.MINUTES)
            .build();

    public static String doPost(String url, Map<String, String> bodyParams) throws IOException {
        FormBody.Builder formBuilder = new FormBody.Builder();

        if (null != bodyParams && !bodyParams.isEmpty()) {
            for (Map.Entry<String, String> entry : bodyParams.entrySet()) {
                formBuilder.add(entry.getKey(), entry.getValue());
            }
        }

        RequestBody body = formBuilder.build();
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    public static String doGet(String url, Map<String, String> bodyParams) throws IOException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();

        if (null != bodyParams && !bodyParams.isEmpty()) {
            for (Map.Entry<String, String> entry : bodyParams.entrySet()) {
                urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
            }
        }

        Request request = new Request.Builder().url(urlBuilder.build()).get().build();
        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    public static void main(String[] args) throws IOException {
        //String url = "http://localhost:8088/api/hello";
        String url = "http://localhost:8801";
        String resjult = OKHttpUtils.doGet(url, null);
        System.out.println(resjult);
    }
}
