package com.codegym.dao.category;

import com.codegym.dao.DBConnection;
import com.codegym.model.Category;
import com.codegym.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CategoryDao implements ICategoryDao {
    public static final String SELECT_ALL_CATEGORY = "SELECT * from category;";
//    public static final String SELECT_CATEGPRY_BY_PRODUCT_ID = "select * from category join product p on category.Id = p.CategoryId where p.Id = ?;";
    private Connection connection = DBConnection.getConnection();

    @Override
    public List findAll() {
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean updateById(int id, Category category) {
        return false;
    }

    @Override
    public boolean create(Category category) {
        return false;
    }


}
