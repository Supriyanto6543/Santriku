package supriyanto.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by SUPRIYANTO on 20/04/2019.
 */

public class UtilsJson {

    public static String okHttpGet(String url){
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(7000, TimeUnit.MILLISECONDS)
                .writeTimeout(7000, TimeUnit.MILLISECONDS)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();

            return response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
