package lld.proxydesignpattern;

/**
 * @author Anirudh
 * @since 28/10/25
 */
public class EmployeeDaoImpl implements EmployeeDao {

    int id;
    String name;
    String department;
    Double salary;
    UserRole role;

    public EmployeeDaoImpl(int id, String name, String department, Double salary, UserRole role) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.role = role;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmployeeDaoImpl{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", department='").append(department).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void getEmployeeInfo() {
        System.out.println("Employee Info:" + " Name: " + name + ", Department: " + department);

    }

    @Override
    public void createEmployee() {
        System.out.println("Employee with name "+name +" has been created");
    }

    @Override
    public void deleteEmployee() {
        System.out.println("Employee with name "+name +" has been deleted");
    }

    @Override
    public void updateSalary(double updatedSalary) {
        this.salary = updatedSalary;
        System.out.println("salary updated to " + updatedSalary);
    }

    @Override
    public void displayEmployeeDetails() {
        System.out.println(this);
    }
}
