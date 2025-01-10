package application;

import model.dao.DaoFactory;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

import java.util.List;

public class ProgramDepartmentTest {
    public static void main(String[] args) {
        DepartmentDaoJDBC departmentDao = (DepartmentDaoJDBC) DaoFactory.createDepartmentDao();

        System.out.println("====== TESTE 1: department insert ======");
        Department department = new Department(null, "Cars");
        departmentDao.insert(department);
        System.out.println("Insert completed! New id: " + department.getId());

        System.out.println();

        System.out.println("====== TESTE 2: department findById ======");
        department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println();

        System.out.println("====== TESTE 3: department update ======");
        department = departmentDao.findById(9);
        department.setName("CarsUp");
        departmentDao.update(department);
        System.out.println("Update completed!");

        System.out.println();

        System.out.println("====== TESTE 4: department deleteById ======");
        departmentDao.deleteById(5);
        System.out.println("Delete completed!");


        System.out.println();

        System.out.println("====== TESTE 5: department findAll ======");
        List<Department> list = departmentDao.findAll();
        list.stream().forEach(System.out::println);

    }
}
