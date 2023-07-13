package model.out_player;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class OutPlayer {

    private int id;
    private int playerId;
    private String reason;
    private Timestamp createdAt;

    @Builder
    public OutPlayer(int id, int playerId, String reason, Timestamp createdAt) {
        this.id = id;
        this.playerId = playerId;
        this.reason = reason;
        this.createdAt = createdAt;
    }
}
