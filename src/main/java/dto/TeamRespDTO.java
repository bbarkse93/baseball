package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class TeamRespDTO {
    //팀
    private Integer id;
    private Integer stadiumId;
    private String name;
    private Timestamp createdAt;

    //스타디움

    private String stadiumName;

    @Builder
    public TeamRespDTO(Integer id, Integer stadiumId, String name, Timestamp createdAt, String stadiumName) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.stadiumId = stadiumId;
        this.stadiumName = stadiumName;
    }

}
