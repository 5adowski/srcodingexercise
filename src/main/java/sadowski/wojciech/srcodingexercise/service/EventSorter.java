package sadowski.wojciech.srcodingexercise.service;

import sadowski.wojciech.srcodingexercise.model.Event;

import java.util.Comparator;
import java.util.List;

public class EventSorter {

    public List<Event> sortByMostProbableResults(List<Event> events) {
        events.sort(Comparator.comparing(EventSorter::getMaxProbability));
        return events;
    }

    private static Float getMaxProbability(Event event) {
        return Math.max(Math.max(event.getProbabilityHomeTeamWinner(), event.getProbabilityDraw()), event.getProbabilityAwayTeamWinner());
    }

}
