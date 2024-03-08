package Streams.Concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectToMap {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "test1"));
        students.add(new Student(2, "test2"));
        students.add(new Student(3, "test3"));
        Map<Integer, String> IdToName = students.stream().collect(Collectors.toMap(Student::getId, Student::getName));
        System.out.println(IdToName);
    }
}
