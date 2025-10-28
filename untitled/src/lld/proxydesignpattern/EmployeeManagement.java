package lld.proxydesignpattern;

/**
 * @author Anirudh
 * @since 28/10/25
 */
public class EmployeeManagement {
    public static void main(String[] args) {
        System.out.println("===== Proxy Design Pattern =====");


        EmployeeDao admin = new EmployeeDaoProxy(1, "John", "HR",
                30000.00, UserRole.ADMIN);
        admin.getEmployeeInfo();
        admin.displayEmployeeDetails();
        admin.createEmployee();
        admin.updateSalary(40000.00);
        admin.deleteEmployee();


        EmployeeDao hr = new EmployeeDaoProxy(2, "Jane", "HR",
                25000.00, UserRole.HR);
        hr.getEmployeeInfo();
        hr.displayEmployeeDetails();
        // hr.createEmployee(); // Access Denied
        hr.updateSalary(30000.00);
        // hr.deleteEmployee(); // Access Denied
    }
}
