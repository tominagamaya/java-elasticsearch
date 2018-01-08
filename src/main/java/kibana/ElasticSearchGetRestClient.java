package kibana;

import org.apache.http.HttpHost;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ElasticSearchGetRestClient {

    public static void main(String[] args) {
        RestClient client = RestClient.builder(new HttpHost("localhost", 9200)).build();

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("q", "title:Pakaan");  //検索クエリ
        paramMap.put("pretty", "true");     //整形される

        try {
            Response response = client.performRequest("GET", "/library/_search", paramMap);

            System.out.println(EntityUtils.toString(response.getEntity()));
            System.out.println("Host - " + response.getHost());
            System.out.println("RequestLine - " + response.getRequestLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
