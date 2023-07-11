package model.stadium;

import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
public class Stadium {

    private int Id;
    private String Name;
    private Timestamp CreatedAt;

    public Stadium(int id, String name, Timestamp createdAt) {
        Id = id;
        Name = name;
        CreatedAt = createdAt;
    }
}
