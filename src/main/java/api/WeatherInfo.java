package api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 気象情報リスト
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class WeatherInfo {

    private final String Type;
    private final String Date;
    private final double Rainfall;
}
