package repository;

import config.JdbcConnection;
import entity.Certification;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CertificationRepository {
    public Connection connection;

    public CertificationRepository() {
        connection = JdbcConnection.getConnection();
    }

    public List<Certification> getAllCertification() throws Exception {
        String sql = "SELECT * FROM CHUNGNHAN";
        Statement statement = null;
        List<Certification> certificationList = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Certification certification = new Certification();
                certification.setEmployeeId(resultSet.getString(1));
                certification.setPlaneId(resultSet.getInt(2));
                certificationList.add(certification);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            statement.close();
            connection.close();
        }
        return certificationList;
    }

}
