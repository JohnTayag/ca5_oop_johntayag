package DAOs;

import DTOs.Product;
import Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductDao extends MySqlDao implements UserDaoInterface
{
    @Override
    public List<Product> findAllProducts() throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Product> productsList = new ArrayList<>();

        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM PRODUCT";
            ps = connection.prepareStatement(query);

            resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                int product_Id = resultSet.getInt("PRODUCT_ID");
                String name = resultSet.getString("NAME");
                double price = resultSet.getDouble("PRICE");
                double size = resultSet.getDouble("PRODUCT_SIZE");

                Product u = new Product(name, product_Id, price, size);
                productsList.add(u);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findAllProductResultSet() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllProducts() " + e.getMessage());
            }
        }
        return productsList;
    }

    @Override
    public Product findProductByID(int Id) throws DaoException
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = null;
        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                int product_Id = resultSet.getInt("PRODUCT_ID");
                String name = resultSet.getString("NAME");
                double price = resultSet.getDouble("PRICE");
                double size = resultSet.getDouble("PRODUCT_SIZE");

                product = new Product(name, product_Id, price, size);

            }
        } catch (SQLException e)
        {
            throw new DaoException("findProductById() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findProductById() " + e.getMessage());
            }
        }
        return product;     // reference to User object, or null value
    }

    @Override
    public Product deleteProductByID(int Id) throws DaoException
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = null;
        try
        {
            connection = this.getConnection();

            String query = "DELETE * FROM PRODUCT WHERE PRODUCT_ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                int product_Id = resultSet.getInt("PRODUCT_ID");
                String name = resultSet.getString("NAME");
                double price = resultSet.getDouble("PRICE");
                double size = resultSet.getDouble("PRODUCT_SIZE");

                product = new Product(name, product_Id, price, size);

            }
        } catch (SQLException e)
        {
            throw new DaoException("deleteProductById() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("deleteProductById() " + e.getMessage());
            }
        }
        return product;     // reference to User object, or null value
    }

    @Override
    public Product addProduct(Product product) throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
//        List<Product> productsList = new ArrayList<>();

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

//            String name = "";
//            Double price = 0.0;
//            Double size = 0.0;


            String query = "INSERT INTO product VALUES(NULL, ?, ?, ?, ?)";
            ps = connection.prepareStatement(query);
            ps.setInt(1, product.getID());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setDouble(4, product.getPrice());

            ps.executeUpdate();

            //Using a PreparedStatement to execute SQL...
        } catch (SQLException e)
        {
            throw new DaoException("addProduct() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("addProduct() " + e.getMessage());
            }
        }
        return product;     // may be empty
    }
}
