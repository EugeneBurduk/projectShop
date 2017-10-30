package com.evgenya.DAO;




import com.evgenya.connection.MySQLConnectionDao;
import com.evgenya.model.Price;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

public class PriceDao implements GenericDao<Price>  {

    private static Connection connection;
    private static MySQLConnectionDao mySQLConnection = new MySQLConnectionDao();
    private static Properties prop = new Properties();

public PriceDao (){
    try{
    connection = mySQLConnection.getConnect();
    prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("queries.properties"));

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    @Override
    public void create(Price entity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(prop.getProperty("createPrice"));
        statement.setString(1, entity.getNameProduct());
        statement.setDouble(2, entity.getValue());
        statement.executeUpdate();
    }

    @Override
    public void update(Price entity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(prop.getProperty("updatePrice"));
        statement.setDouble(1, entity.getValue());
        statement.setString(2, entity.getNameProduct());
        statement.executeUpdate();
    }

    @Override
    public List<Price> getAll() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(prop.getProperty("selectUsers"));
        return getResults(statement);
    }

    List<Price> getResults(PreparedStatement statement) throws SQLException {
        List<Price> items = new ArrayList<Price>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Integer id = resultSet.getInt("id_prices");
            String nameProduct = resultSet.getString("name_product");
            Float value = resultSet.getFloat("value");
            Price price = new Price(id,nameProduct,value);
            items.add(price);
        }
        return items;
    }
    public Price find(String nameProduct) {
        PreparedStatement statement = null;
        List<Price> items = new ArrayList<>();
        try {
            statement = connection.prepareStatement(prop.getProperty("findPrice"));
            statement.setString(1, nameProduct);
            items = getResults(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (items.size() > 0) ? items.get(0) : null;
    }

    public  List<Price> findProductsByPrice(String startPrice, String finalPrice) {
        PreparedStatement statement = null;
        List<Price> items = new ArrayList<>();
        try {
            statement = connection.prepareStatement(prop.getProperty("findProduct"));
            statement.setString(1, startPrice);
            statement.setString(2, finalPrice);
            items = getResults(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
}
