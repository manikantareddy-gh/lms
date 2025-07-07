package cfg.lms.services;

import java.sql.SQLException;

import cfg.lms.daos.UserDAO;
import cfg.lms.dtos.UserDTO;
import cfg.lms.entities.UserEntity;
import cfg.lms.exceptions.UserAlreadyExistException;

public class UserService {

    public void register(UserDTO user) throws UserAlreadyExistException, ClassNotFoundException, SQLException {
        boolean isUserExists = checkIfUserExists(user.getUsername());
        if (!isUserExists) {
            UserDAO dao = new UserDAO();
            UserEntity entity = new UserEntity();
            entity.setName(user.getName());
            entity.setUsername(user.getUsername());
            entity.setPassword(user.getPassword());
            entity.setEmail(user.getEmail());

            dao.saveUser(entity);
        } else {
            throw new UserAlreadyExistException("User already exists with username: " + user.getUsername());
        }
    }

    private boolean checkIfUserExists(String username) throws ClassNotFoundException, SQLException {
        UserDAO dao = new UserDAO();
        return dao.checkUserCount(username) > 0;
    }
    
    public boolean deleteUser(String username) throws ClassNotFoundException, SQLException {
        UserDAO dao = new UserDAO();
        return dao.deleteUser(username);
    }
}
