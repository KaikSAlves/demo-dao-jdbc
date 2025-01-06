package model.dao;

import model.dao.impl.SellerDaoJDBC;
import model.entities.Seller;

public class DaoFactory {
    public static InterfaceDao<Seller> createSellerDao(){
        return new SellerDaoJDBC();
    }
}
