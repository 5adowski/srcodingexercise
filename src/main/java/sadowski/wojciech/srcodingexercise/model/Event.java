package sadowski.wojciech.srcodingexercise.model;

import lombok.Data;

import java.util.List;

@Data
public class Event {
    private String sportEventId;
    private String startDate;
    private String sportName;
    private String competitionName;
    private String competitionId;
    private String seasonName;
    private List<Competitor> competitors;
    private Venue venue;
    private Float probabilityHomeTeamWinner;
    private Float probabilityDraw;
    private Float probabilityAwayTeamWinner;

}
