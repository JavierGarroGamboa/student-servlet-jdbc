package cr.una.backend.model;

public class Student {

    private int id;
    private String name;
    private String course;
    private String rating;

    public Student() {
    }

    public Student(int id, String name, String course, String rating) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name +
                ", course='" + course +
                ", rating='" + rating +
                '}';
    }
}
