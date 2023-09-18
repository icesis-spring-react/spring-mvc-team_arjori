package mvc.dynnav.model;

public enum AcademicDegree {
    BACHELOR_OF_ARTS("Bachelor of Arts (B.A.)"),
    BACHELOR_OF_SCIENCE("Bachelor of Science (B.Sc.)"),
    MASTER_OF_ARTS("Master of Arts (M.A.)"),
    MASTER_OF_SCIENCE("Master of Science (M.Sc.)"),
    DOCTOR_OF_PHILOSOPHY("Doctor of Philosophy (Ph.D.)");

    private final String value;

    AcademicDegree(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}