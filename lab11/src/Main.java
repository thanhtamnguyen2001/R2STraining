import entity.Certification;
import entity.Employee;
import entity.Flight;
import entity.Plane;
import repository.CertificationRepository;
import repository.EmployeeRepository;
import repository.FlightRepository;
import repository.PlaneRepository;
import service.CertificationService;
import service.EmployeeService;

import java.util.List;
import java.util.Scanner;
//tnguyen has changed
public class Main {
    public static void main(String[] args) throws Exception
    {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        CertificationRepository certificationRepository = new CertificationRepository();
        FlightRepository flightRepository = new FlightRepository();
        PlaneRepository planeRepository = new PlaneRepository();

        while (true) {
            System.out.println("1. List of employee information");
            System.out.println("2. List of flight information");
            System.out.println("3. List of aircraft information");
            Scanner scanner = new Scanner(System.in);
            String selection = scanner.nextLine();
            if (selection.equals("1")) {
                boolean notQuitSelectionOne = true;
                while (notQuitSelectionOne) {
                    System.out.println("1. Tìm các nhân viên có lương nhỏ hơn 10,000");
                    System.out.println("2. Cho biết tổng số lương phải trả cho các nhân viên.");
                    System.out.println("3. Cho biết mã số của các phi công lái máy báy Boeing..");
                    System.out.println("4. Cho biết các nhân viên có thể lái máy bay có mã số 747.");
                    System.out.println("5. Cho biết tên của các phi công lái máy bay Boeing.");
                    selection = scanner.nextLine();
                    switch (selection) {
                        case "1": {
                            List<Employee> employees = employeeRepository.getSalary1000();
                            employeeRepository.displayListEmployee(employees);
                            break;
                        }
                        case "2": {
                            int totalSalary = employeeRepository.sumSalary();
                            System.out.println("Total Salary is: " + totalSalary);
                            break;
                        }
                        case "3": {
                            System.out.println("List Employee Id");
                            break;
                        }
                        case "4": {
                            List<Employee> employees = employeeRepository.pilotBoeingAndAirbus();
                            employeeRepository.displayListEmployee(employees);
                            break;
                        }
                        default: {
                            if (selection.equals("Q") || selection.equals("q")) {
                                notQuitSelectionOne = false;
                                break;
                            } else {
                                System.out.println("Enter selection again!!");
                            }
                        }
                    }
                }
            } else if (selection.equals("2")) {
                boolean notQuitSelectionTwo = true;
                while (notQuitSelectionTwo) {
                    System.out.println("1. Cho biết các chuyến bay đi Đà Lạt (DAD).");
                    System.out.println("2. Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km");
                    System.out.println("3. Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).");
                    System.out.println("4. Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN)");
                    System.out.println("5. Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320.");
                    String selectionOne = scanner.nextLine();
                    switch (selectionOne) {
                        case "1": {
                            List<Flight> flights = flightRepository.findDADFlight();
                            flightRepository.displayListFlight(flights);
                            break;
                        }
                        case "2": {
                            List<Flight> flights = flightRepository.findLenght8and10();
                            flightRepository.displayListFlight(flights);
                            break;
                        }
                        case "3": {
                            List<Flight> flights = flightRepository.findSGNandBMV();
                            flightRepository.displayListFlight(flights);
                            break;
                        }
                        case "4": {
                            List<Flight> flights = flightRepository.findSGN();
                            flightRepository.displayListFlight(flights);
                            break;
                        }
                        case "5": {
                            List<Flight> flights = flightRepository.flyByAirbusA320();
                            flightRepository.displayListFlight(flights);
                            break;
                        }
                        default: {
                            if (selectionOne.equals("Q") || selectionOne.equals("q")) {
                                notQuitSelectionTwo = false;
                                break;
                            } else {
                                System.out.println("Enter selection again!!");
                            }
                        }
                    }
                }
            } else if (selection.equals("3")) {
                boolean notQuitSelectionThree = true;
                while (notQuitSelectionThree) {
                    System.out.println("1. Cho biết các loại máy bay có tầm bay lớn hơn 10,000km");
                    System.out.println("2. Có bao nhiêu loại máy báy Boeing.");
                    System.out.println("3. Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.");
                    System.out.println("4. Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.");
                    selection = scanner.nextLine();
                    switch (selection) {
                        case "1": {
                            List<Plane> planes = planeRepository.findAllPlane();
                            planeRepository.displayListPlane(planes);
                            break;
                        }
                        case "2": {
                            List<Plane> planes = planeRepository.getTypeBoeing();
                            planeRepository.displayListPlane(planes);
                            break;
                        }
                        case "3": {
                            System.out.println("List Plane Id of Pilot's name is Nguyen: ");
                            List<Plane> planeList = planeRepository.driverByNguyen();
                            planeList.stream().forEach(planeId -> System.out.println(planeId));
                            break;
                        }
                        case "4": {
                            List<Plane> planes = planeRepository.planeCanVN280();
                            planeRepository.displayListPlane(planes);
                            break;
                        }
                        default: {
                            if (selection.equals("Q") || selection.equals("q")) {
                                notQuitSelectionThree = false;
                                break;
                            } else {
                                System.out.println("Enter selection again!!");
                            }
                        }
                    }
                }
            } else {
                if (selection.equals("Q") || selection.equals("q")) {
                    break;
                } else {
                    System.out.println("Enter selection again!!");
                }
            }
        }

    }
}