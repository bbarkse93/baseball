package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class PositionRespDTO {
    private String name;
    private String teamName;
    private String position;


    @Builder
    public PositionRespDTO(String name, String teamName, String position) {
        this.name = name;
        this.teamName = teamName;
        this.position = position;
    }
}


