package repository;

import config.JdbcConnection;
import entity.Plane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaneRepository {

    private final Connection connection;

    public PlaneRepository() {
        connection = JdbcConnection.getConnection();
    }

    public void displayListPlane(List<Plane> planes) {
        planes.forEach(p -> System.out.println("Plane{" +
                "planeId=" + p.getPlaneId() +
                ", type='" + p.getType() + '\'' +
                ", flightRange=" + p.getFlightRange() +
                '}'));
    }

    public List<Plane> findAllPlane() {
        List<Plane> planeList = new ArrayList<>();
        String sql = "SELECT * FROM MAYBAY";
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Plane plane = new Plane();
                plane.setPlaneId(resultSet.getInt(1));
                plane.setType(resultSet.getString(2));
                plane.setFlightRange(resultSet.getInt(3));
                planeList.add(plane);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeList;
    }

    public List<Plane> findRange() {
        List<Plane> planeList = new ArrayList<>();
        String sql = "SELECT MaMB, Loai, TamBay\n" +
                "FROM MAYBAY WHERE TamBay > 1000";
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Plane plane = new Plane();
                plane.setPlaneId(resultSet.getInt(1));
                plane.setType(resultSet.getString(2));
                plane.setFlightRange(resultSet.getInt(3));
                planeList.add(plane);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeList;
    }

    public List<Plane> getTypeBoeing() {
        List<Plane> planeList = new ArrayList<>();
        String sql = "SELECT MaMB, Loai, TamBay\n" +
                "FROM MAYBAY WHERE Loai LIKE '%Boeing%'";
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Plane plane = new Plane();
                plane.setPlaneId(resultSet.getInt(1));
                plane.setType(resultSet.getString(2));
                plane.setFlightRange(resultSet.getInt(3));
                planeList.add(plane);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeList;
    }

    public List<Plane> driverByNguyen() throws Exception {
        List<Plane> planeList = new ArrayList<>();
        String sql = "SELECT MB.MaMB\n" +
                "FROM NHANVIEN NV JOIN CHUNGNHAN CN ON NV.MaNV = CN.MaNV JOIN MAYBAY MB ON CN.MaMB = MB.MaMB\n" +
                "WHERE NV.Ten LIKE '%Nguyen%'";
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Plane plane = new Plane();
                plane.setPlaneId(resultSet.getInt(1));
                planeList.add(plane);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeList;

    }

    public List<Plane> planeCanVN280() {
        List<Plane> planeList = new ArrayList<>();
        String sql = "SELECT MB.Loai\n" +
                "FROM CHUYENBAY CB JOIN MAYBAY MB ON CB.DoDai < MB.TamBay\n" +
                "WHERE CB.MaCB = 'VN280'";
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Plane plane = new Plane();

                plane.setType(resultSet.getString(1));

                planeList.add(plane);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeList;
    }
}
