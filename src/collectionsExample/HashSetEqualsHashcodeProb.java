package collectionsExample;

import java.util.HashMap;
import java.util.Map;

public class HashSetEqualsHashcodeProb {

    public static void main(String[] args) {
        // write your code here

        Student s1 = new Student("ab", "Divya");
        Student s2 = new Student("de", "Gupta");
        Student s3 = new Student("ab", "Divya");
        Student s4 = new Student();


        Map m = new HashMap<Student, Integer>();
        m.put(s1, 1);
        m.put(s2, 2);
        m.put(s3, 3);
//        m.put(s4, 4);

        System.out.println(m.size());

        System.out.println(m.get(s1));
        System.out.println(m.get(s2));
        System.out.println(m.get(s3));
//        System.out.println(m.get(new Student()));


    }


}

class Student {

    String id;
    String name;

    public Student() {
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId().equals(student.getId()) &&
                getName().equals(student.getName());
    }

    @Override
    public int hashCode() {
//        return Objects.hash(getId(), getName());
        return 1;
    }
}