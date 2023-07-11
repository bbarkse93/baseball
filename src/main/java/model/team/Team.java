package model.team;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class Team {

    private int id;
    private int stadiumId;
    private String name;
    private Timestamp createdAt;

    @Builder
    public Team(int id, int stadiumId, String name, Timestamp createdAt) {
        this.id = id;
        this.stadiumId = stadiumId;
        this.name = name;
        this.createdAt = createdAt;
    }
}
