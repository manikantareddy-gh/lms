package cfg.lms.entities;

import lombok.Data;

@Data
public class UserEntity {
    private int uid;          // add this
    private String name;
    private String email;
    private String username;
    private String password;
}
