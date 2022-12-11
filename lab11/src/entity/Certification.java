package entity;

public class Certification {
    private String employeeId;
    private int planeId;
    public Certification() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Certification(String employeeId, int planeId) {
        this.employeeId = employeeId;
        this.planeId = planeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }
}
