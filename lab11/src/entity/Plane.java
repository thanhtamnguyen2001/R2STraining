package entity;

public class Plane {

    private  int planeId;

    private String type;

    private int flightRange;

    public Plane() {
    }

    public Plane(int planeId, String type, int flightRange) {
        this.planeId = planeId;
        this.type = type;
        this.flightRange = flightRange;
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(int flightRange) {
        this.flightRange = flightRange;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "planeId=" + planeId +
                ", type='" + type + '\'' +
                ", flightRange=" + flightRange +
                '}';
    }
}
