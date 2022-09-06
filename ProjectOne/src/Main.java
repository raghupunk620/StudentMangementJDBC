import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        StudentOperations studentOperations = new StudentOperations();
        ValidationFunction validationFunction = new ValidationFunction();
        boolean flag = true;
        //Menu Loop
        while (flag) {
            System.out.println("Please Choose from the Given Options:");
            System.out.println("1. Show Students List");
            System.out.println("2. Add Student ");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student Record");
            System.out.println("5. To exit the Application");
            int response = validationFunction.validateMenuOptions();
            switch (response) {
                case 1:
                    studentOperations.showStudents();
                    break;
                case 2:
                    System.out.println("Please Enter Student ID Number");
                    int UserId = validationFunction.validateId();
                    System.out.println("Please enter the Name of the Student");
                    String name = validationFunction.validateName();
                    System.out.println("Please enter the Age of the Student");
                    int Age = validationFunction.validateAge();
                    System.out.println("Enter the email of the Student");
                    String email = validationFunction.validateEmail();
                    System.out.println("Enter the ContactNumber of the Student");
                    String contactNumber = validationFunction.validateContactNumber();
                    Student student = new Student(UserId, name, Age, email, contactNumber);
                    boolean result = studentOperations.insertStudents(student);
                    if (result) {
                        System.out.println("Student record inserted Successfully");
                        System.out.println("Student Record" + student.toString());
                    } else {
                        System.out.println("Something went Wrong Record Could not be inserted.....");
                    }
                    break;

                case 3:
                    System.out.println("Please enter the studentID to recognise the student");
                    int studentID = scanner.nextInt();
                    boolean b =  studentOperations.updateStudentRecord(studentID);
                    if (b) {
                        System.out.println("The Record Update Successfully");
                    }
                    else {
                        System.out.println("Something went Wrong Record Could not be updated");
                    }
                    break;
                case 4:
                    System.out.println("Please enter the Id of the student which you wanted to deleted");
                    int userID = scanner.nextInt();
                    boolean response4 = studentOperations.deleteStudent(userID);
                    if (response4) {
                        System.out.println("Student Record deleted Successfully");
                    } else {
                        System.out.println("Something Went Wrong Record Could not be deleted");
                    }

                    break;

                case 5:
                    System.out.println("Thank you for Using the Application");
                    flag = false ;
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    System.out.println("******************************");
            }
        }

    }
}