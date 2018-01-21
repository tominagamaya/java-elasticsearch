package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

/**
 * Yahoo情報を取得する
 */
public class YdnConnector {

    /**
     * Yahoo天気情報を取得する
     *
     * @return Yahoo天気情報
     */
    public YahooWeather getWeather() {

        try {
            URL url = new URL("https://map.yahooapis.jp/weather/V1/place?coordinates=139.767052,35.681167&output=json&appid=XXXXXXXXXXXXXXXX");

            try {
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                // リダイレクトを自動で許可しない設定
                con.setInstanceFollowRedirects(false);

                con.connect();
                InputStream inputStream = con.getInputStream();

                StringBuilder src = new StringBuilder();

                while (true) {
                    byte[] line = new byte[1024];
                    int size = inputStream.read(line);
                    if (size <= 0) {
                        break;
                    }
                    src.append(new String(line, "utf-8"));
                }
                JsonParser parser = new JsonParser();
                JsonObject json = parser.parse(src.toString().trim()).getAsJsonObject();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                return gson.fromJson(gson.toJson(json), YahooWeather.class);

            } catch (IOException e) {
                throw new RuntimeException("情報の取得に失敗しました");
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException("不正なURLです");
        }
    }

    /**
     * Elasticsearchへリクエストを送信する
     */
    public void putElasticsearch(YahooWeather yahooWeather) {
        Gson gson = new Gson();
        RestClient client = RestClient.builder(new HttpHost("localhost", 9200)).build();

        HttpEntity entity = new NStringEntity(
                gson.toJson(yahooWeather), ContentType.APPLICATION_JSON);

        try {
            Response indexResponse = null;
            indexResponse = client.performRequest(
                    "POST",
                    "/yahoo/weather/",
                    Collections.<String, String>emptyMap(),
                    entity);

            System.out.println(EntityUtils.toString(indexResponse.getEntity()));

        } catch (IOException e) {
            throw new RuntimeException("リクエストの送信に失敗しました");
        }
    }
}
