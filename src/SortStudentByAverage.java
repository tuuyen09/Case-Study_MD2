import java.util.Comparator;

public class SortStudentByAverage implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getAverage(), o2.getAverage());
    }



}
