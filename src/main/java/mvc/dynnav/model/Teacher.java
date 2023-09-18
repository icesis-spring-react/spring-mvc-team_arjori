package mvc.dynnav.model;

public class Teacher {
    private String username;
    private String password;
    private String fullName;
    private AcademicDegree academicDegree;

    public Teacher(String username, String password, String fullName, AcademicDegree academicDegree) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.academicDegree = academicDegree;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(AcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }
}