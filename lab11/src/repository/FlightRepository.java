package repository;

import config.JdbcConnection;
import entity.Flight;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FlightRepository {

    private final Connection connection;

    public FlightRepository() {
        connection = JdbcConnection.getConnection();
    }

    public void displayListFlight(List<Flight> flights) {
        flights.forEach(f -> System.out.println("Flight{" +
                "flightId='" + f.getFlightId() + '\'' +
                ", goStation='" + f.getGoStation() + '\'' +
                ", arrivalStation='" + f.getArrivalStation() + '\'' +
                ", length=" + f.getLength() +
                ", departureTime=" + f.getDepartureTime() +
                ", arriveTime=" + f.getArriveTime() +
                ", cost=" + f.getCost() +
                '}'));
    }

    public List<Flight> findAllFlight() throws SQLException {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT * FROM CHUYENBAY";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setFlightId(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLength(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            statement.close();
            connection.close();
        }
        return flightList;
    }

    public List<Flight> findDADFlight() throws SQLException {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB, GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi\n" +
                "FROM CHUYENBAY WHERE GaDen = 'DAD'";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setFlightId(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLength(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            statement.close();
            connection.close();
        }
        return flightList;
    }

    public List<Flight> findLenght8and10() throws SQLException {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB, GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi\n" +
                "FROM CHUYENBAY WHERE DoDai< 10000 AND DoDai > 8000";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setFlightId(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLength(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            statement.close();
            connection.close();
        }
        return flightList;
    }


    public List<Flight> findSGNandBMV() throws SQLException {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB, GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi\n" +
                "FROM CHUYENBAY WHERE GaDi = 'SGN' and GaDen = 'BMV'";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setFlightId(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLength(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            statement.close();
            connection.close();
        }
        return flightList;
    }


    public List<Flight> findSGN() throws SQLException {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB, GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi\n" +
                "FROM CHUYENBAY WHERE GaDi = 'SGN'";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setFlightId(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLength(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            statement.close();
            connection.close();
        }
        return flightList;
    }

    public List<Flight> flyByAirbusA320() throws SQLException {
        List<Flight> flightList = new ArrayList<>();
        String sql = "SELECT MaCB, GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi\n" +
                "FROM CHUYENBAY CB JOIN MAYBAY MB ON CB.DoDai < MB.TamBay\n" +
                "WHERE MB.Loai LIKE '%Airbus A320%'";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setFlightId(resultSet.getString(1));
                flight.setGoStation(resultSet.getString(2));
                flight.setArrivalStation(resultSet.getString(3));
                flight.setLength(resultSet.getInt(4));
                flight.setDepartureTime(resultSet.getTime(5));
                flight.setArriveTime(resultSet.getTime(6));
                flight.setCost(resultSet.getInt(7));
                flightList.add(flight);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            statement.close();
            connection.close();
        }
        return flightList;
    }

}
