package org.example.infrastructure;

import org.example.domain.Good;
import org.example.domain.IGoodsRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@Singleton
public class GoodsRepository implements IGoodsRepository {
    private DbContext dbContext = new DbContext();
    
    //@Inject
    /*public GoodsRepository(DbContext dbContext) {
        this.dbContext = dbContext;
    }*/
    
    @Override
    public boolean save(Good good) {
        String sql = "INSERT INTO goods (name, price) VALUES (?, ?)";
        try (Connection connection = dbContext.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) 
        {
            statement.setString(1, good.getName());
            statement.setInt(2, good.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
        
        return true;
    }

    @Override
    public List<Good> findAll() {
        String sql = "SELECT * FROM goods";
        List<Good> goods = new ArrayList<>();
        
        try (Connection connection = dbContext.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) 
        {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                
                Good good = new Good(id, name, price);
                goods.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return goods;
    }
}
