package model.player;

import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
public class Player {

    private int Id;
    private int TeamId;
    private String Name;
    private String Position;
    private Timestamp CreatedAt;

    public Player(int id, int teamId, String name, String position, Timestamp createdAt) {
        Id = id;
        TeamId = teamId;
        Name = name;
        Position = position;
        CreatedAt = createdAt;
    }
}
