package eventmaker.dao;

import eventmaker.data.Company;
import eventmaker.data.User;
import eventmaker.repository.ICompanyRepository;
import eventmaker.repository.exceptions.RepositoryException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompanyDAO implements ICompanyRepository{
    
    private final ConnectionFactory _connectionFactory = ConnectionFactory.getInstance();

    @Override
    public List<Company> getListCurrent(User user) {
        String sql = 
                "select "
                    + "company.id as id, "
                    + "company.description as description, "
                    + "company.name as name "
                + "from "
                    + "company "
                + "where "
                    + "uid = ?";
        
        List<Company> list = new ArrayList<Company>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = _connectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getId());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Company company = new Company();
                company.setId(resultSet.getInt("id"));
                company.setDescription(resultSet.getString("description"));
                company.setName(resultSet.getString("name"));
                company.setOrganazer(user);
                list.add(company);
            }
        } catch (SQLException ex) {
                Logger.getLogger(CompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();                
            } catch (SQLException ex) {
                Logger.getLogger(CompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public Company get(Object identifier) throws RepositoryException {
        String sql = 
                "select "
                    + "company.id as id, "
                    + "company.description as description, "
                    + "company.name as name, "
                    + "app_user.id as uid, "
                    + "app_user.fname as fname, "
                    + "app_user.lname as lname, "
                    + "app_user.info as info, "
                    + "app_user.login as login, "
                    + "app_user.is_admin as is_admin "
                + "from "
                    + "company "
                + "left join "
                    + "app_user "
                + "on "
                    + "company.id = app_user.id "
                + "where "
                    + "company.id = ?";
        
        Company company = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = _connectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, (Integer) identifier);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("uid"));
                user.setFirstName(resultSet.getString("fname"));
                user.setLastName(resultSet.getString("lname"));
                user.setLogin(resultSet.getString("login"));
                user.setInfo(resultSet.getString("info"));
                user.changeAdminState(resultSet.getBoolean("is_admin"));
                
                company = new Company();
                company.setId(resultSet.getInt("id"));
                company.setDescription(resultSet.getString("description"));
                company.setName(resultSet.getString("name"));
                company.setOrganazer(user);
            }
         
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return company;
    }

    @Override
    public List<Company> getList() throws RepositoryException {
        String sql = 
                "select "
                    + "company.id as id, "
                    + "company.description as description, "
                    + "company.name as name, "
                    + "app_user.id as uid, "
                    + "app_user.fname as fname, "
                    + "app_user.lname as lname, "
                    + "app_user.info as info, "
                    + "app_user.login as login, "
                    + "app_user.is_admin as is_admin "
                + "from "
                    + "company "
                + "left join "
                    + "app_user "
                + "on "
                    + "app_user.id = company.id";
        
        List<Company> list = new ArrayList<Company>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = _connectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("uid"));
                user.setFirstName(resultSet.getString("fname"));
                user.setLastName(resultSet.getString("lname"));
                user.setLogin(resultSet.getString("login"));
                user.setInfo(resultSet.getString("info"));
                user.changeAdminState(resultSet.getBoolean("is_admin"));
                
                Company company = new Company();
                company.setId(resultSet.getInt("id"));
                company.setDescription(resultSet.getString("description"));
                company.setName(resultSet.getString("name"));
                company.setOrganazer(user);
                list.add(company);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public void remove(Company entity) throws RepositoryException {
        String sql = 
                "delete from company where id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = _connectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, entity.getId());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void store(Company entity) throws RepositoryException {
        String sql = 
                "insert into company (id, description, name, uid) values (?,?,?,?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = _connectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getDescription());
            statement.setString(3, entity.getName());
            statement.setInt(4, entity.getOrganizer().getId());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void storeBatch(Company... entities) throws RepositoryException {
        for (Company company : entities) {
            store(company);
        }
    }
    
}
