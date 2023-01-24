package sadowski.wojciech.srcodingexercise.service;

import sadowski.wojciech.srcodingexercise.model.Competitor;
import sadowski.wojciech.srcodingexercise.model.Event;

import java.util.List;
import java.util.TreeSet;

public class EventPrinter {

    public void printResults(List<Event> events, int resultsAmount) {
        if (resultsAmount > events.size()) System.out.println("Insufficient number of results! Try entering fewer");
        if (resultsAmount <= events.size()) {
            System.out.println("Most probable results are:");
            for (int i = 0; i < resultsAmount; i++) {
                print(events, i);
            }
        }
    }

    public void printAllCompetitors(List<Event> events) {
        TreeSet<String> competitors = new TreeSet<>();
        for (Event e : events) {
            competitors.add(e.getCompetitors().get(0).getName());
            competitors.add(e.getCompetitors().get(1).getName());
        }
        for (String s : competitors) System.out.println(s);
    }

    private Float getMostProbableResult(Event event) {
        return Math.max(event.getProbabilityHomeTeamWinner(), Math.max(event.getProbabilityDraw(), event.getProbabilityAwayTeamWinner()));
    }

    private void print(List<Event> events, int i) {
        Event event = events.get(i);
        Competitor competitor1 = event.getCompetitors().get(0);
        Competitor competitor2 = event.getCompetitors().get(1);
        if (getMostProbableResult(event).equals(event.getProbabilityHomeTeamWinner()))
            System.out.printf("%d. HOME TEAM HAS %.2f%% PROBABILITY TO WIN\n", i + 1, event.getProbabilityHomeTeamWinner());
        if (getMostProbableResult(event).equals(event.getProbabilityAwayTeamWinner()))
            System.out.printf("%d. AWAY TEAM HAS %.2f%% PROBABILITY TO WIN\n", i + 1, event.getProbabilityAwayTeamWinner());
        if (getMostProbableResult(event).equals(event.getProbabilityDraw()))
            System.out.printf("%d. GREATEST PROBABILITY TO DRAW = %.2f%%\n", i + 1, event.getProbabilityDraw());
        if (competitor1.getQualifier().equals("home"))
            System.out.printf("\tHOME TEAM NAME = %s\n", competitor1.getName());
        if (competitor2.getQualifier().equals("home"))
            System.out.printf("\tHOME TEAM NAME = %s\n", competitor2.getName());
        if (competitor1.getQualifier().equals("away"))
            System.out.printf("\tAWAY TEAM NAME = %s\n", competitor1.getName());
        if (competitor2.getQualifier().equals("away"))
            System.out.printf("\tAWAY TEAM NAME = %s\n", competitor2.getName());
        if (event.getVenue() == null)
            System.out.printf("\tDATE: %s, UNKNOWN VENUE\n", event.getStartDate());
        if (event.getVenue() != null)
            System.out.printf("\tDATE: %s AT %s, %s, %s\n",
                    event.getStartDate(),
                    event.getVenue().getName(),
                    event.getVenue().getCountryName(),
                    event.getVenue().getCityName());
    }

}
