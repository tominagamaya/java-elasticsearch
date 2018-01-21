package api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 地点の詳細情報
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class PropertyInfo {

    private final int WeatherAreaCode;
    private final WeatherInfoList WeatherList;
}
