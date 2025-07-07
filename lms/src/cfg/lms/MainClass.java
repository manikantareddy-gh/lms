package cfg.lms;

import java.sql.SQLException;

import cfg.lms.daos.UserDAO;
import cfg.lms.dtos.UserDTO;
import cfg.lms.exceptions.UserAlreadyExistException;
import cfg.lms.exceptions.UserNameInvalidException;
import cfg.lms.services.UserService;

public class MainClass {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserService service = new UserService();
        UserDAO dao = new UserDAO(); 
		UserDTO user = new UserDTO();
		
		
		                                         // here we are inserting the data in the database
//		user.setName("vijay");
//		user.setEmail("vijay@example.com");
//		user.setPassword("vijaypass");
//
//		try {
//			user.setUsername("vijayuser01");
//		} catch (UserNameInvalidException e) {
//			System.out.println("Username error: " + e.getMessage());
//			return;
//		}
//
//		try {
//			service.register(user);
//		} catch (UserAlreadyExistException e) {
//			System.out.println("Error: " + e.getMessage());
//		}
		
		
		
		
		
		
                                                     //		here we are deleteing the data in the database based on the username
		 try {
	            // Set the username you want to delete
	            user.setUsername("vijayuser01");
	        } catch (UserNameInvalidException e) {
	            System.out.println("Invalid username: " + e.getMessage());
	            return;
	        }

	        // Now perform deletion
	        boolean deleted = service.deleteUser(user.getUsername());
	        if (deleted) {
	            System.out.println("User deleted successfully.");
	        } else {
	            System.out.println("User deletion failed or user not found.");
	        }
	        
		
		
		
		
		
		
	                                               //for fetching the datab from database by name
//	        user.setName("manikanta");
//	        System.out.println("\nFetching user info for name: " + user.getName());
//	        dao.fetchUser(user.getName());
	        
	        
		
													//here iam fething all users in the database
//        dao.fetchAllUsers();
        
        
        											//here iam counting the how many members are there with the same username
//        try {
//            user.setUsername("vijayuser01");
//        } catch (UserNameInvalidException e) {
//            System.out.println("Invalid username: " + e.getMessage());
//            return;
//        }
//
//        // Call checkUserCount and print result
//        int count = dao.checkUserCount(user.getUsername());
//        System.out.println("User count with username '" + user.getUsername() + "': " + count);

	}
}
