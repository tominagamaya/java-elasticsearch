package kibana;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import java.io.IOException;
import java.util.Collections;

public class ElasticSearchPutRestClient {

    public static void main(String[] args) {
        //登録するデータを生成
        Gson gson = new Gson();
        Book book = new Book("Pakaan", new Name("Taro", "Momo"));

        RestClient client = RestClient.builder(new HttpHost("localhost", 9200)).build();

        HttpEntity entity = new NStringEntity(
                gson.toJson(book), ContentType.APPLICATION_JSON);

        try {
            Response indexResponse = null;
            indexResponse = client.performRequest(
                    "PUT",
                    "/library/books/2",
                    Collections.<String, String>emptyMap(),
                    entity);

            System.out.println(EntityUtils.toString(indexResponse.getEntity()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
