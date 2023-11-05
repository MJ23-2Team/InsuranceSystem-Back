package server.app.insurance.user.employee.state;

public enum InsuranceType {
    FIRE("화재");

    private String name;
    InsuranceType(String name) {
        this.name = name;
    }
}
