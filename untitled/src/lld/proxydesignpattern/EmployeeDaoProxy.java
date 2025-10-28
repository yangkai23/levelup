package lld.proxydesignpattern;

/**
 * @author Anirudh
 * @since 28/10/25
 */
public class EmployeeDaoProxy implements EmployeeDao {
    EmployeeDaoImpl realEmployee;

    public EmployeeDaoProxy(int id, String name, String department, Double salary, UserRole role) {
        this.realEmployee = new EmployeeDaoImpl(id, name, department, salary, role);
    }

    @Override
    public void getEmployeeInfo() {
        if (hasAccessForRole(AccessType.VIEW_BASIC_INFO,
                this.realEmployee.role)) {
            this.realEmployee.getEmployeeInfo();
        }
    }

    @Override
    public void createEmployee() {
        if (hasAccessForRole(AccessType.DELETE, this.realEmployee.role)) {
            this.realEmployee.createEmployee();
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

    @Override
    public void deleteEmployee() {
        if (hasAccessForRole(AccessType.DELETE, this.realEmployee.role)) {
            this.realEmployee.deleteEmployee();
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

    @Override
    public void updateSalary(double updatedSalary) {
        if (hasAccessForRole(AccessType.UPDATE,
                this.realEmployee.role)) {
            this.realEmployee.updateSalary(updatedSalary);
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

    @Override
    public void displayEmployeeDetails() {
        if (hasAccessForRole(AccessType.VIEW_ALL_DETAILS,
                this.realEmployee.role)) {
            this.realEmployee.displayEmployeeDetails();

        } else {
            throw new RuntimeException("Access Denied");

        }

    }

    private boolean hasAccessForRole(AccessType accessType, UserRole role) {
        return switch (accessType) {
            case CREATE, DELETE -> role == UserRole.ADMIN;
            case UPDATE -> role == UserRole.ADMIN || role == UserRole.HR;
            case VIEW_ALL_DETAILS -> role == UserRole.HR || role == UserRole.MANAGER || role == UserRole.ADMIN;
            case VIEW_BASIC_INFO ->
                    role == UserRole.HR || role == UserRole.MANAGER || role == UserRole.ADMIN || role == UserRole.EMPLOYEE;
        };
    }
}
