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
}
