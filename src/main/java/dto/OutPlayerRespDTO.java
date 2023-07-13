package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class OutPlayerRespDTO {

    //선수
    private Integer id;
    private String name;
    private String position;
    // 퇴출 선수
    private String reason;
    private Timestamp createdAt;

    @Builder
    public OutPlayerRespDTO(Integer id, String name, String position, String reason, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.reason = reason;
        this.createdAt = createdAt;
    }

}
