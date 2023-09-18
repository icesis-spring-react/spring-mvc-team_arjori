package mvc.dynnav.data;

import mvc.dynnav.model.AcademicDegree;
import mvc.dynnav.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("teacherRepository")
public class TeacherRepository {
    private static final List<Teacher> teacherList = new ArrayList<>();

    static {
        teacherList.add(new Teacher("alan_t", "ilikeapples", "Alan Turing", AcademicDegree.DOCTOR_OF_PHILOSOPHY));
        teacherList.add(new Teacher("dijkstra1130", "whatashortpath", "Edsger Dijkstra", AcademicDegree.MASTER_OF_SCIENCE));
    }

    public static void add(Teacher teacher) {
        teacherList.add(teacher);
    }

    public static Teacher find(String username) {
        for (Teacher teacher : teacherList) {
            if (teacher.getUsername().equals(username))
                return teacher;
        }
        return null;
    }
    public static List<Teacher> getTeacherList(){
        return teacherList;
    }
}