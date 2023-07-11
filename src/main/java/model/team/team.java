package model.team;

import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
public class team {

    private int Id;
    private int StadiumId;
    private String Name;
    private Timestamp CreatedAt;

    public team(int id, int stadiumId, String name, Timestamp createdAt) {
        Id = id;
        StadiumId = stadiumId;
        Name = name;
        CreatedAt = createdAt;
    }
}
