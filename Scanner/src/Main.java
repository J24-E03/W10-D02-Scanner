import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        setting up the scanner
        Scanner scanner = new Scanner(System.in);

//        nextLine(): takes a string from the user


//        teacher(scanner);

        student(scanner);




        scanner.close();
    }

    public static void teacher(Scanner scanner){
        System.out.println("Input your course: ");

        String myCourse = scanner.nextLine().trim();

        System.out.println("Enter your age: ");

//        nextInt(): takes an int value from the user
        int age =0;

        try{
            age = Integer.parseInt(scanner.nextLine());

        }catch(InputMismatchException e){
            System.out.println("Please input a valid integer");
        }

        System.out.println("Are you german(true/false): ");
        boolean isGerman = Boolean.parseBoolean(scanner.nextLine());
//        scanner.nextLine();

        System.out.println("Please input your name as well: ");
        String name = scanner.nextLine();

        System.out.println("Your name is "+ name);
        System.out.println("Your course is " + myCourse);

        System.out.println("and your age is " + age);


        Teacher teacher1 = new Teacher(name,myCourse,age,isGerman);

        System.out.println("New teacher is " + teacher1);
    }

    public static void student(Scanner scanner){
        System.out.println("Enter Student name: ");
        String studentName = scanner.nextLine();

        System.out.println("Enter student id");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Enter Student Course");

        String course = scanner.nextLine();

        System.out.println("Enter city: ");

        String city = scanner.nextLine();

        System.out.println("Are you based in Europe(true/false)?");

        boolean isEuropean = scanner.nextBoolean();

        Student student1 = new Student(id,studentName,course,city,isEuropean);

        student1.printStudentInfo();



    }



}


/*
    Exercise 1:
    1. create a similar class to the Teacher class for student
    2. should have the following fields: String name, String course, String city, boolean isEuropean, int id
    3. Write a method in the Student class that will display the user information in the terminal if they are in the java course: printStudentInfo()
    4. otherwise it should print "Sorry, but we only allow students of the java course, Try again some other time"
    5. BONUS: compare in the method the string for course case-insensitive (meaning "java" == "Java")
    6. BONUS 2: have the ids automatically increase with each new student without having to input the ids
*/


