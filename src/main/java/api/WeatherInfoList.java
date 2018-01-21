package api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 気象情報リスト
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class WeatherInfoList {

    private final List<WeatherInfo> Weather;
}
