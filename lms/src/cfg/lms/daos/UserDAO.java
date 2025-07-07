package cfg.lms.daos;

import java.sql.*;

import cfg.lms.entities.UserEntity;

public class UserDAO {

	public void fetchAllUsers() throws ClassNotFoundException, SQLException {
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/derby", "derby", "derby")) {
        String sql = "SELECT * FROM library.users";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        System.out.println("--- All Users ---");
        while (rs.next()) {
            System.out.println("UID: " + rs.getString("uid"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Username: " + rs.getString("username"));
            System.out.println("Password: " + rs.getString("password"));
            System.out.println("Email: " + rs.getString("email"));
            System.out.println("-------------------------");
        }
        System.out.println("---- End of User List ----");
    }
}


	public int checkUserCount(String username) throws ClassNotFoundException, SQLException {
		int userCount = 0;
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/derby", "derby", "derby")) {
			PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM library.users WHERE username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				userCount = rs.getInt(1);
			}
		}
		return userCount;
	}
	static int userCount = 3;

	public void saveUser(UserEntity user) throws ClassNotFoundException, SQLException {
	    Class.forName("org.apache.derby.jdbc.ClientDriver");
	    try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/derby", "derby", "derby")) {
	        String sql = "insert into library.users (uid, name, username, password, email) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1,"u"+(++userCount));    // set uid here
	        ps.setString(2, user.getName());
	        ps.setString(3, user.getUsername());
	        ps.setString(4, user.getPassword());
	        ps.setString(5, user.getEmail());

	        int rows = ps.executeUpdate();
	        if (rows > 0) {
	            System.out.println(" User registered successfully.");
	        } else {
	            System.out.println(" Failed to register user.");
	        }
	    }
	}
	
	public boolean deleteUser(String username) throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/derby", "derby", "derby")) {
            String sql = "DELETE FROM library.users WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User with username '" + username + "' deleted successfully.");
                return true;
            } else {
                System.out.println("No user found with username '" + username + "'.");
                return false;
            }
        }
    }
}
