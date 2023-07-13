package dto;

import lombok.Builder;

import java.sql.Timestamp;

public class OutPlayerRespDTO {

    //플레이어
    private int id;
    private int teamId;
    private String name;
    private String position;
    private Timestamp createdAt;


    //아웃 플레이어
    private int playerId;
    private String reason;

    @Builder
    public OutPlayerRespDTO(int id, int teamId, String name, String position, Timestamp createdAt, int playerId, String reason){
        this.id = id;
        this.teamId = teamId;
        this.name = name;
        this.position = position;
        this.createdAt = createdAt;
        this.playerId = playerId;
        this.reason = reason;
    }

}
