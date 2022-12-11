package entity;

import java.sql.Time;

public class Flight {

    private String flightId;
    private String goStation;
    private String arrivalStation;
    private int length;
    private Time departureTime;
    private Time  arriveTime;
    private int cost;

    public Flight() {
    }

    public Flight(String flightId, String goStation, String arrivalStation, int length, Time departureTime, Time arriveTime, int cost) {
        this.flightId = flightId;
        this.goStation = goStation;
        this.arrivalStation = arrivalStation;
        this.length = length;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
        this.cost = cost;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getGoStation() {
        return goStation;
    }

    public void setGoStation(String goStation) {
        this.goStation = goStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Time arriveTime) {
        this.arriveTime = arriveTime;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                ", goStation='" + goStation + '\'' +
                ", arrivalStation='" + arrivalStation + '\'' +
                ", length=" + length +
                ", departureTime=" + departureTime +
                ", arriveTime=" + arriveTime +
                ", cost=" + cost +
                '}';
    }
}
