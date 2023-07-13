package model.player;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class Player {

    private int id;
    private int teamId;
    private String name;
    private String position;
    private Timestamp createdAt;

    @Builder
    public Player(int id, int teamId, String name, String position, Timestamp createdAt) {
        this.id = id;
        this.teamId = teamId;
        this.name = name;
        this.position = position;
        this.createdAt = createdAt;
    }
}
