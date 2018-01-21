package api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 拠点の場所（世界測地系）
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class GeometryInfo {

    private final String Type;
    private final String Coordinates;
}
