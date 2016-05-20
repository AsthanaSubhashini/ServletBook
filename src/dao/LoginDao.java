package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.LoginDTO;

public class LoginDao extends Dao {
	public boolean Validate(LoginDTO logindto) throws SQLException
	{
		boolean success=false;
		PreparedStatement statement = this.connection.prepareStatement("select username, password from users where username=? and password =?");
		statement.setString(1, logindto.getUsername());
		statement.setString(2,logindto.getPassword());
		ResultSet resultSet = statement.executeQuery();
		success= resultSet.next();
		resultSet.close();
		return success;
	}

}
