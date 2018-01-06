package gson;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Weather {

    private Long id;
    private String area;
    private String datelabel;
    private String telop;
    private Integer min_temperature;
    private Float min_fahrenheit;
    private Integer max_temperature;
    private Float max_fahrenheit;
    private String comment;
    private LocalDateTime yyyymmdd;
}
