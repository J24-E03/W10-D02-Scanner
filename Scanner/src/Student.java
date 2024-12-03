public class Student {

    private static int idIncrement = 0;
    private int id;
    private String name;
    private String course;
    private String city;
    private boolean isEuropean;

    public Student(int id, String name, String course, String city, boolean isEuropean) {
        idIncrement+=1;
        this.id = idIncrement;
        this.name = name;
        this.course = course;
        this.city = city;
        this.isEuropean = isEuropean;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isEuropean() {
        return isEuropean;
    }

    public void setEuropean(boolean european) {
        isEuropean = european;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", city='" + city + '\'' +
                ", isEuropean=" + isEuropean +
                '}';
    }

    public void printStudentInfo(){
        if(course.toLowerCase().equals("java")){
            System.out.println(this);
        }
        else{
            System.out.println("Sorry, but we only allow students of the java course, Try again some other time");
        }
    }
}
