package sadowski.wojciech.srcodingexercise.service;

import lombok.Data;
import sadowski.wojciech.srcodingexercise.model.Event;

import java.util.List;

@Data
public class EventWrapper {
    private List<Event> events;
}
