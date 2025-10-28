package lld.proxydesignpattern;

/**
 * @author Anirudh
 * @since 28/10/25
 */
public interface EmployeeDao {
    public void getEmployeeInfo();

    public void createEmployee();

    public void deleteEmployee();

    public void updateSalary(double updatedSalary);

    public void displayEmployeeDetails();
}
