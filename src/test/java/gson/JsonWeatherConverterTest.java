package gson;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Jsonを変換するテスト
 */
public class JsonWeatherConverterTest {
    @Test
    public void run() throws Exception {

        JsonWeatherConverter con = new JsonWeatherConverter();
        con.run();
    }
}