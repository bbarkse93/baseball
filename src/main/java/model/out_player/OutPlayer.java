package model.out_player;

import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
public class OutPlayer {

    private int Id;
    private int PlayerId;
    private String Reason;
    private Timestamp CreatedAt;

    public OutPlayer(int id, int playerId, String reason, Timestamp createdAt) {
        Id = id;
        PlayerId = playerId;
        Reason = reason;
        CreatedAt = createdAt;
    }
}
