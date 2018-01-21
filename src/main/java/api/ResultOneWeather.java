package api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 天気情報のレスポンス結果1件
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class ResultOneWeather {

    private final String Id;
    private final String Name;
    private final GeometryInfo Geometry;
    private final PropertyInfo Property;
}
