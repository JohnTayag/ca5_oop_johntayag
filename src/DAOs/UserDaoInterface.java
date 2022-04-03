package DAOs;

import DTOs.Product;
import Exceptions.DaoException;

import java.util.List;

public interface UserDaoInterface {

    List<Product> findAllProducts() throws DaoException;

    String findAllProductsJSON() throws DaoException;

    Product findProductByID(int Id) throws DaoException;

    String findProductIDJSON(int Id) throws DaoException;

    void deleteProductByID(int Id) throws DaoException;

    Product addProduct( Product product ) throws DaoException;

    List<Product> filterProducts(double filterQuery) throws DaoException;
}