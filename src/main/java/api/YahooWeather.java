package api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * Yahoo天気情報
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class YahooWeather {

    private final ResultAllWeather ResultInfo;
    private final List<ResultOneWeather> Feature;
}
