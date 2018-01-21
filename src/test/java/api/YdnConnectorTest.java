package api;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Yahoo情報を取得する
 */
public class YdnConnectorTest {
    @Test
    public void getWeather() throws Exception {

        YdnConnector ydn = new YdnConnector();
        YahooWeather yahooWeather = ydn.getWeather();
        ydn.putElasticsearch(yahooWeather);
    }
}