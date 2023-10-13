package problem1;

public class Student {

    private String name;
    private String courses;
    private double fee;

    public Student() {
    }

    public Student(String name, String courses, double fee) {
        this.name = name;
        this.courses = courses;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", courses='" + courses + '\'' +
                ", fee=" + fee +
                '}';
    }
}
