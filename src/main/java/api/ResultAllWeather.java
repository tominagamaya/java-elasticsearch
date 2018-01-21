package api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 天気情報のレスポンス結果まとめ
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class ResultAllWeather {

    private final int Count;
    private final int Total;
    private final int Start;
    private final int Status;
    private final double Latency;
    private final String Description;
    private final String Copyright;
}
