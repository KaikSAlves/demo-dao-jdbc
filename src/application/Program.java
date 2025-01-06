package application;

import model.dao.DaoFactory;
import model.dao.InterfaceDao;
import model.entities.Department;
import model.entities.Seller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Department d = new Department(1, "books");

        Seller s = new Seller(12,"Kaik", "kaik@gmail.com", new Date(), 3000.0, d);

        InterfaceDao<Seller> sellerDao = DaoFactory.createSellerDao();

        System.out.println(s);
    }
}
