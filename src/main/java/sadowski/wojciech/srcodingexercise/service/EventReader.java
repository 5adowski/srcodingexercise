package sadowski.wojciech.srcodingexercise.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import sadowski.wojciech.srcodingexercise.model.Event;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class EventReader {
    private final String DEFAULT_FILE_PATH = "src/main/resources/BE_data.json";

    public List<Event> getEvents(File file) {
        List<Event> events = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            EventWrapper wrapper = objectMapper.readValue(file, EventWrapper.class);
            events = wrapper.getEvents();
        } catch (FileNotFoundException e) {
            System.out.printf("File %s doesn't exist", file.getAbsolutePath());
        } catch (IOException e) {
            System.out.printf("Unexpected error:\n%s", e.getMessage());
        }
        return events;
    }

    public List<Event> getEvents() {
        return getEvents(new File(DEFAULT_FILE_PATH));
    }

}
