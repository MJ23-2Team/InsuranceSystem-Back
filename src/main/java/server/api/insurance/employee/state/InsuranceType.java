package server.api.insurance.employee.state;

public enum InsuranceType {
    FIRE("화재");

    private String name;
    InsuranceType(String name) {
        this.name = name;
    }
}
