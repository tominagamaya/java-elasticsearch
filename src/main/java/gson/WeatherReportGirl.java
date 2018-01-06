package gson;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalTime;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class WeatherReportGirl {
    @SerializedName("lastName")
    private String lastName;
    private String firstName;
    private int age;
    private LocalTime startingTime;
}
