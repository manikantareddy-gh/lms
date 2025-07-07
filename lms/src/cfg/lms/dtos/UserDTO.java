package cfg.lms.dtos;

import cfg.lms.exceptions.UserNameInvalidException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String email;
    private String username;
    private String password;

    public void setUsername(String username) throws UserNameInvalidException {
        if (username.length() < 10) {
            throw new UserNameInvalidException("Username should have at least 10 characters.");
        }
        this.username = username;
    }
}
