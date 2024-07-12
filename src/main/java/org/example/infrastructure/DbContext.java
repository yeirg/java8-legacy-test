package org.example.infrastructure;

import javax.inject.Singleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//@Singleton
public class DbContext {
    private String url;
    private String user;
    private String password;
    
    public DbContext() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.url = System.getenv("DB_URL");
            this.user = System.getenv("DB_USER");
            this.password = System.getenv("DB_PASSWORD");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
