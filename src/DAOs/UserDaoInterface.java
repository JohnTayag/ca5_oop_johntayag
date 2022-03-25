package DAOs;

import DTOs.Product;
import Exceptions.DaoException;

import java.util.List;

public interface UserDaoInterface {

    List<Product> findAllProducts() throws DaoException;

    Product findProductByID(int Id) throws DaoException;

    Product deleteProductByID(int Id) throws DaoException;

    Product addProduct( Product product ) throws DaoException;

    List<Product> filterProducts(double filterQuery) throws DaoException;
}