package application;

import model.dao.DaoFactory;
import model.dao.InterfaceDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDaoJDBC sellerDao = (SellerDaoJDBC) DaoFactory.createSellerDao();

        System.out.println("====== TESTE 1: seller FindById ======");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println();

        System.out.println("====== TESTE 2: seller FindByDepartment ======");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        list.stream().forEach(System.out::println);

        System.out.println();

        System.out.println("====== TESTE 3#: seller FindAll ======");
        List<Seller> listAll = sellerDao.findAll();

        listAll.stream().forEach(System.out::println);

        System.out.println();

        System.out.println("====== TESTE 4#: seller insert ======");
        Seller seller1 = new Seller(null, "Greg", "greg@gmail.com",new Date(), 4000.0, department);
        sellerDao.insert(seller1);
        System.out.println("Inserted! New id: " + seller1.getId());

        System.out.println();

        System.out.println("====== TESTE 5#: seller update ======");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);

        System.out.println("Update Completed!");
    }
}
