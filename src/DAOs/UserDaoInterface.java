package DAOs;

import DTOs.Product;
import Exceptions.DaoException;

import java.util.List;

public interface UserDaoInterface {

    List<Product> findAllProducts() throws DaoException;

//    public Product findProductByID(int ID) throws DaoException;
}