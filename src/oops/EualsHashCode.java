package oops;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Divya.Gupta on 29-03-2018.
 */
public class EualsHashCode {

    public static void main(String[] args) {

        Student s1=new Student("H234");
        Student s2=new Student("H234");
        Student s3=s1;

        if(s1.equals(s2)) {
            System.out.println("s1s2 Equals");
            // not equals because the reference to the same object is not equal
            //works as ==
        }

        if(s1==s2)
            System.out.println("s1s2 ==");

        if(s1.equals(s3))
            System.out.println("s1s3 Equals");

        if(s1==s3)
            System.out.println("s1s3 ==");

        //className + @ Integer.hexInteger(hashcode())
        System.out.println(s1.toString());



        // checking collection equals method
        Map<Student,ReportCard> studentReportCardMap=new HashMap<>(5);

        studentReportCardMap.put(s1,new ReportCard());
        studentReportCardMap.put(s2,new ReportCard());
        studentReportCardMap.put(s3,new ReportCard());


        // only 2 objects as s1 is equal to s3
        // if equals method is also specified then, s1==s2
        System.out.println(studentReportCardMap.size());



    }


}


class Student{
    private String id;


    public Student(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        oops.Student student = (oops.Student) o;
//
//        return !(id != null ? !id.equals(student.id) : student.id != null);
//
//    }
//
//    @Override
//    public int hashCode() {
//        return id != null ? id.hashCode() : 0;
//    }
}



class ReportCard{

    int mathMarks;


    public ReportCard() {
        this.mathMarks =(int) (Math.random()*101)+1;
    }

    public int getMathMarks() {
        return mathMarks;
    }

    public void setMathMarks(int mathMarks) {
        this.mathMarks = mathMarks;
    }
}