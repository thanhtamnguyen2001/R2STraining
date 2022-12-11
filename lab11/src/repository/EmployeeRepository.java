package repository;

import config.JdbcConnection;
import entity.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private final Connection connection;

    public EmployeeRepository() {
        connection = JdbcConnection.getConnection();
    }

    public void displayListEmployee(List<Employee> employees) {
        employees.forEach(employee -> System.out.println("Employee{" +
                "employeeId='" + employee.getEmployeeId() + '\'' +
                ", name='" + employee.getName() + '\'' +
                ", salary=" + employee.getSalary() +
                '}'));
    }
    public List<Employee> getAllEmployee() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT * FROM NHANVIEN";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getString(1));
                employee.setName(resultSet.getString(2));
                employee.setSalary(resultSet.getInt(3));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            statement.close();
            connection.close();
        }
        return employeeList;

    }

    public void insertEmployee(String id, String name, int salary) throws SQLException {
        String sql = "INSERT INTO NHANVIEN (MaNV, Ten, Luong)"
                + "VALUES ('" + id + "', '" + name + "', " + salary + ")";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            statement.close();
            connection.close();
        }
    }

    public List<Employee> getSalary1000() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT MaNV, Ten, Luong\n" +
                "FROM NHANVIEN WHERE Luong < 10000";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getString(1));
                employee.setName(resultSet.getString(2));
                employee.setSalary(resultSet.getInt(3));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            statement.close();
            connection.close();
        }
        return employeeList;

    }

    public int sumSalary() throws Exception {
        int sum = 0;
        String sql = "SELECT SUM(Luong)\n" +
                "FROM NHANVIEN";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                sum = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            statement.close();
            connection.close();
        }
        return sum;

    }

    public List<Employee> codePilotBoeing() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT MaNV\n" +
                "FROM CHUNGNHAN CN JOIN MAYBAY MB ON CN.MaMB = MB.MaMB\n" +
                "WHERE MB.Loai LIKE '%Boeing%'";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getString(1));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            statement.close();
            connection.close();
        }
        return employeeList;

    }


    public List<Employee> pilot747() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT NV.MaNV, NV.Ten, NV.Luong\n" +
                "FROM NHANVIEN NV JOIN CHUNGNHAN CN ON NV.MaNV = CN.MaNV JOIN MAYBAY MB ON CN.MaMB = MB.MaMB\n" +
                "WHERE MB.MaMB = 747";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getString(1));
                employee.setName(resultSet.getString(2));
                employee.setSalary(resultSet.getInt(3));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            statement.close();
            connection.close();
        }
        return employeeList;

    }

    public List<Employee> pilotBoeingAndAirbus() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT MaNV\n" +
                "FROM CHUNGNHAN CN JOIN MAYBAY MB ON CN.MaMB = MB.MaMB\n" +
                "WHERE MB.Loai LIKE '%Boeing%' AND MB.Loai LIKE '%Airbus%'";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getString(1));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            statement.close();
            connection.close();
        }
        return employeeList;

    }

    public List<Employee> pilotBoeing() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT NV.Ten\n" +
                "FROM NHANVIEN NV JOIN CHUNGNHAN CN ON NV.MaNV = CN.MaNV JOIN MAYBAY MB ON CN.MaMB = MB.MaMB\n" +
                "WHERE MB.Loai LIKE '%Boeing%'\n" +
                "GROUP BY NV.Ten";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setName(resultSet.getString(1));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            statement.close();
            connection.close();
        }
        return employeeList;

    }
}
