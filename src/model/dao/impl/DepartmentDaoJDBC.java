package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.InterfaceDao;
import model.entities.Department;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements InterfaceDao<Department> {

    Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department department) {
        PreparedStatement st = null;

        try{
            st = conn.prepareStatement("INSERT INTO department"
            + "(Name)"
            + "VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, department.getName());

            int rowsAffected = st.executeUpdate();

            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    department.setId(id);
                }
                DB.closeResultSet(rs);
            }

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatment(st);
        }
    }

    @Override
    public void update(Department department) {
        PreparedStatement st = null;

        try{
            st = conn.prepareStatement("UPDATE department" +
                    " SET Name = ? WHERE id = ?");

            st.setString(1, department.getName());
            st.setInt(2, department.getId());

            st.executeUpdate();

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatment(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try{
            st = conn.prepareStatement("DELETE FROM department WHERE id = ?");
            st.setInt(1, id);

            int rowsAffected = st.executeUpdate();

            if(rowsAffected <= 0){
                System.out.println("Ins't possible find this id!");
            }
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatment(st);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Department dp = null;
        try{
            st = conn.prepareStatement("SELECT * FROM department WHERE id = ? ORDER By Name");
            st.setInt(1, id);

            rs = st.executeQuery();

            if(rs.next()){
                dp = new Department();
                dp.setId(rs.getInt("Id"));
                dp.setName(rs.getString("Name"));
            }

            return dp;

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatment(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Department> list = new ArrayList<>();

        try{
            st = conn.prepareStatement("SELECT * FROM department");
            rs = st.executeQuery();

            while (rs.next()){
                Department dp = new Department(rs.getInt("Id"), rs.getString("Name"));
                list.add(dp);
            }

            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatment(st);
        }
    }
}
