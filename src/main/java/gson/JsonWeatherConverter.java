package gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class JsonWeatherConverter {
    public static void main(String[] args) {
        Weather weather1 = new Weather(1L, null, "今日", "晴れ", 2, 35.6f, 11, 51.8f, "北風が強いので洗濯物に注意するべし", LocalDateTime.of(2018, 1, 6, 5, 0, 0));
        Weather weather2 = new Weather(1L, "東京", "明日", "曇り", 1, 33.8f, 5, 41f, "夕方雨が降るかもしれないので折畳み傘を持つべし", LocalDateTime.of(2018, 1, 7, 5, 0, 0));
        Weather weather3 = new Weather(1L, "東京", "明後日", "雨", 3, 37.4f, 6, 42.8f, "夜になると雨が強くなるので早く帰るべし", LocalDateTime.of(2018, 1, 8, 5, 0, 0));

        List<Weather> weatherList = new ArrayList<>();
        weatherList.add(weather1);
        weatherList.add(weather2);
        weatherList.add(weather3);

        /**
         * JavaからJsonへ変換
         */

        // Nullの項目は無視される
        Gson gson = new Gson();
        System.out.println("JsonからJavaへ変換(Null無視): " + gson.toJson(weatherList));
        //[{"id":1,"datelabel":"今日","telop":"晴れ","min_temperature":2,"min_fahrenheit":35.6,"max_temperature":11,"max_fahrenheit":51.8,"comment":"北風が強いので洗濯物に注意するべし","yyyymmdd":{"date":{"year":2018,"month":1,"day":6},"time":{"hour":5,"minute":0,"second":0,"nano":0}}},{"id":1,"area":"東京","datelabel":"明日","telop":"曇り","min_temperature":1,"min_fahrenheit":33.8,"max_temperature":5,"max_fahrenheit":41.0,"comment":"夕方雨が降るかもしれないので折畳み傘を持つべし","yyyymmdd":{"date":{"year":2018,"month":1,"day":7},"time":{"hour":5,"minute":0,"second":0,"nano":0}}},{"id":1,"area":"東京","datelabel":"明後日","telop":"雨","min_temperature":3,"min_fahrenheit":37.4,"max_temperature":6,"max_fahrenheit":42.8,"comment":"夜になると雨が強くなるので早く帰るべし","yyyymmdd":{"date":{"year":2018,"month":1,"day":8},"time":{"hour":5,"minute":0,"second":0,"nano":0}}}]

        // Nullの項目も出力する
        Gson gson2 = new GsonBuilder().serializeNulls().create();
        System.out.println("JsonからJavaへ変換(Nullあり): " + gson2.toJson(weatherList));
        //[{"id":1,"area":null,"datelabel":"今日","telop":"晴れ","min_temperature":2,"min_fahrenheit":35.6,"max_temperature":11,"max_fahrenheit":51.8,"comment":"北風が強いので洗濯物に注意するべし","yyyymmdd":{"date":{"year":2018,"month":1,"day":6},"time":{"hour":5,"minute":0,"second":0,"nano":0}}},{"id":1,"area":"東京","datelabel":"明日","telop":"曇り","min_temperature":1,"min_fahrenheit":33.8,"max_temperature":5,"max_fahrenheit":41.0,"comment":"夕方雨が降るかもしれないので折畳み傘を持つべし","yyyymmdd":{"date":{"year":2018,"month":1,"day":7},"time":{"hour":5,"minute":0,"second":0,"nano":0}}},{"id":1,"area":"東京","datelabel":"明後日","telop":"雨","min_temperature":3,"min_fahrenheit":37.4,"max_temperature":6,"max_fahrenheit":42.8,"comment":"夜になると雨が強くなるので早く帰るべし","yyyymmdd":{"date":{"year":2018,"month":1,"day":8},"time":{"hour":5,"minute":0,"second":0,"nano":0}}}]

        /**
         * JsonからJavaへ変換
         */
        Weather weather4 = gson.fromJson(gson.toJson(weatherList.get(0)), Weather.class);
        System.out.println("JsonからJavaへ変換: " + weather4.toString());
        //Weather(id=1, area=null, datelabel=今日, telop=晴れ, min_temperature=2, min_fahrenheit=35.6, max_temperature=11, max_fahrenheit=51.8, comment=北風が強いので洗濯物に注意するべし, yyyymmdd=2018-01-06T05:00)

        /* 実行結果(整形後)
        [
            {
                "area": "東京",
                "comment": "北風が強いので洗濯物に注意するべし",
                "datelabel": "今日",
                "id": 1,
                "max_fahrenheit": 51.8,
                "max_temperature": 11,
                "min_fahrenheit": 35.6,
                "min_temperature": 2,
                "telop": "晴れ",
                "yyyymmdd": {
                    "date": {
                        "day": 6,
                        "month": 1,
                        "year": 2018
                    },
                    "time": {
                        "hour": 5,
                        "minute": 0,
                        "nano": 0,
                        "second": 0
                    }
                }
            },
            {
                "area": "東京",
                "comment": "夕方雨が降るかもしれないので折畳み傘を持つべし",
                "datelabel": "明日",
                "id": 1,
                "max_fahrenheit": 41.0,
                "max_temperature": 5,
                "min_fahrenheit": 33.8,
                "min_temperature": 1,
                "telop": "曇り",
                "yyyymmdd": {
                    "date": {
                        "day": 7,
                        "month": 1,
                        "year": 2018
                    },
                    "time": {
                        "hour": 5,
                        "minute": 0,
                        "nano": 0,
                        "second": 0
                    }
                }
            },
            {
                "area": "東京",
                "comment": "夜になると雨が強くなるので早く帰るべし",
                "datelabel": "明後日",
                "id": 1,
                "max_fahrenheit": 42.8,
                "max_temperature": 6,
                "min_fahrenheit": 37.4,
                "min_temperature": 3,
                "telop": "雨",
                "yyyymmdd": {
                    "date": {
                        "day": 8,
                        "month": 1,
                        "year": 2018
                    },
                    "time": {
                        "hour": 5,
                        "minute": 0,
                        "nano": 0,
                        "second": 0
                    }
                }
            }
        ]

         */


        /**
         * 項目名をキャメルに変換する
         */
        WeatherReportGirl weatherReportGirl = new WeatherReportGirl("曇後", "晴子", 23, LocalTime.of(5, 0, 0));

        Gson gson3 = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        Gson gson4 = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES).create();
        Gson gson5 = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Gson gson6 = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES).create();

        System.out.println("キャメルケース                   : " + gson3.toJson(weatherReportGirl));
        System.out.println("キャメルケース(区切りがスペース)   : " + gson4.toJson(weatherReportGirl));
        System.out.println("スネークケース                   : " + gson5.toJson(weatherReportGirl));
        System.out.println("スネークケース(区切りがアンダーバー): " + gson6.toJson(weatherReportGirl));

        /*
        キャメルケース                   : {"LastName":"曇後","FirstName":"晴子","Age":23,"StartingTime":{"Hour":5,"Minute":0,"Second":0,"Nano":0}}
        キャメルケース(区切りがスペース)   : {"Last Name":"曇後","First Name":"晴子","Age":23,"Starting Time":{"Hour":5,"Minute":0,"Second":0,"Nano":0}}
        スネークケース                   : {"last_name":"曇後","first_name":"晴子","age":23,"starting_time":{"hour":5,"minute":0,"second":0,"nano":0}}
        スネークケース(区切りがアンダーバー): {"last-name":"曇後","first-name":"晴子","age":23,"starting-time":{"hour":5,"minute":0,"second":0,"nano":0}}
         */

        // @SerializedName付けると形式が変更されない
        /*
        キャメルケース                   : {"lastName":"曇後","FirstName":"晴子","Age":23,"StartingTime":{"Hour":5,"Minute":0,"Second":0,"Nano":0}}
        キャメルケース(区切りがスペース)   : {"lastName":"曇後","First Name":"晴子","Age":23,"Starting Time":{"Hour":5,"Minute":0,"Second":0,"Nano":0}}
        スネークケース                   : {"lastName":"曇後","first_name":"晴子","age":23,"starting_time":{"hour":5,"minute":0,"second":0,"nano":0}}
        スネークケース(区切りがアンダーバー): {"lastName":"曇後","first-name":"晴子","age":23,"starting-time":{"hour":5,"minute":0,"second":0,"nano":0}}
         */
    }
}

