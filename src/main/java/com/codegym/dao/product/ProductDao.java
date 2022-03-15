package com.codegym.dao.product;

import com.codegym.dao.DBConnection;
import com.codegym.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    public static final String SELECT_ALL_PRODUCT = "select product.*, c.Name from product join category c on c.Id = product.CategoryId;";
    public static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM product where id = ?;";
    public static final String INSERT_PRODUCT = "INSERT INTO product (Name, Price, Quantity, color, Description, CategoryId) VALUES (?,?,?,?,?,?);";
    public static final String UPDATE_PRODUCT = "UPDATE product SET name = ?, price = ?, quantity = ?, color = ?, description = ?, categoryid = ? where id = ?;";
    public static final String DELETE_PRODUCT = "DELETE from product where id = ?;";
    public static final String SELECT_PRODUC_BY_NAME = "SELECT * from product where name like ?;";
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                float price = resultSet.getFloat(3);
                int quantity = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String description = resultSet.getString(6);
                int categoryId = resultSet.getInt(7);
                String categoryName = resultSet.getString(8);
                Product product = new Product(id, name, price, quantity, color, description, categoryId,categoryName);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                float price = resultSet.getFloat(3);
                int quantity = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String description = resultSet.getString(6);
                int categoryId = resultSet.getInt(7);
                product = new Product(id, name, price, quantity, color, description, categoryId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean create(Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getCategoryId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateById(int id, Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getCategoryId());
            preparedStatement.setInt(7, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> findAllProductByName(String name) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUC_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nameFromSQL = resultSet.getString(2);
                float price = resultSet.getFloat(3);
                int quantity = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String description = resultSet.getString(6);
                int categoryId = resultSet.getInt(7);
                Product product = new Product(id, nameFromSQL, price, quantity, color, description, categoryId);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

}
