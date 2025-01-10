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

        System.out.println("====== TESTE 3#: seller FindByDepartment ======");
        List<Seller> listAll = sellerDao.findAll();

        listAll.stream().forEach(System.out::println);
    }
}
