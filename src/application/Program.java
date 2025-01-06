package application;

import model.dao.DaoFactory;
import model.dao.InterfaceDao;
import model.entities.Department;
import model.entities.Seller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {
    public static void main(String[] args) {

        InterfaceDao<Seller> sellerDao = DaoFactory.createSellerDao();

        System.out.println("====== TESTE 1: seller FindById ======");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
    }
}
