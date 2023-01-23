package sadowski.wojciech.srcodingexercise.model;

import lombok.Data;

@Data
public class Venue {
    private String id;
    private String name;
    private int capacity;
    private String cityName;
    private String countryName;
    private String mapCoordinates;
    private String countryCode;

}
