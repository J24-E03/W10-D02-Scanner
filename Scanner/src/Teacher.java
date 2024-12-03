public class Teacher {

    private String name;
    private String course;
    private int age;
    private boolean isGerman;

    public Teacher(String name, String course, int age, boolean isGerman) {
        this.name = name;
        this.course = course;
        this.age = age;
        this.isGerman = isGerman;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGerman() {
        return isGerman;
    }

    public void setGerman(boolean german) {
        isGerman = german;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", age=" + age +
                ", isGerman=" + isGerman +
                '}';
    }
}
