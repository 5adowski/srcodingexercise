package sadowski.wojciech.srcodingexercise.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import sadowski.wojciech.srcodingexercise.model.Event;

import java.util.List;

@Data
public class EventWrapper {
    @JsonProperty("Events")
    private List<Event> events;

}
