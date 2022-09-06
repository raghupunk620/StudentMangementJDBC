import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class StudentOperations {

    Scanner scanner = new Scanner(System.in) ;
    ValidationFunction validationFunction  = new ValidationFunction() ;

    //DISPLAY STUDENT RECORDS
    public void showStudents() {
        boolean f = false;
        try{
            Connection con = Driver.createc();
            Statement st = con.createStatement();
            ResultSet set = st.executeQuery("select * from students");
            LinkedHashMap<Integer, Student> map = new LinkedHashMap<Integer, Student>();
            while(set.next()) {
                Student student = new Student();
                student.setStudentID(set.getInt(1));
                student.setName(set.getString(2));
                student.setAge(set.getInt(3));
                student.setEmail(set.getString(4));
                student.setContactNumber(set.getString(5));
                map.put(student.studentID, student);
            }
            System.out.println(map);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //INSERT STUDENT RECORDS IN DATABASE
    public boolean insertStudents(Student student){
        boolean response = false ;
        try {
            Connection connection = Driver.createc();
            String query = "insert into students(id,name,age,email,contact) values(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, student.getStudentID());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getContactNumber());
            ps.executeUpdate();
            response = true ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return response ;
    }

    //DELETE STUDENT RECORDS
    public boolean deleteStudent(int UserID){
        boolean response = false ;
        try{
            Connection connection = Driver.createc() ;
            String query = "delete from students where id=?" ;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, UserID);
            preparedStatement.executeUpdate();
            response = true ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return response ;
    }


    //UPDATE STUDENT RECORDS
    public boolean updateStudentRecord(int studentID){
        boolean result = false ;
        try{
            Connection connection = Driver.createc();
            PreparedStatement preparedStatement = null;
            String query = "select * from students where id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                System.out.println("Student ID : " + studentID);
                System.out.println("Name : " + resultSet.getString(2));
                System.out.println("Age : " + resultSet.getInt(3));
                System.out.println("Email : " + resultSet.getString(4));
                System.out.println("Contact Number : " + resultSet.getString(5));
                System.out.println("------------------------------------");
            }
            System.out.println("Please Select What you would Like to Update");
            System.out.println("1. Update the Name of the Student");
            System.out.println("2. Update the Age of the Student");
            System.out.println("3. Update the Email of the Student");
            System.out.println("4. Update the email of the Student");
            int response2 = scanner.nextInt();
            switch (response2){
                case 1:
                    System.out.println("Please enter the name which you wanted to update");
                    String Name = validationFunction.validateName();
                    preparedStatement = connection.prepareStatement("update students set name = ? where id = ?");
                    preparedStatement.setString(1, Name);
                    preparedStatement.setInt(2, studentID);
                    break;
                case 2:
                    System.out.println("Please enter the Age which you want to update");
                    int Age = validationFunction.validateAge();
                    preparedStatement = connection.prepareStatement("update students set age = ? where id = ?");
                    preparedStatement.setInt(1, Age);
                    preparedStatement.setInt(2, studentID);
                    break;

                case 3:
                    System.out.println("Please enter the email which you wanted to update");
                    String email = validationFunction.validateEmail();
                    preparedStatement = connection.prepareStatement("update students set email = ? where id = ?");
                    preparedStatement.setString(1, email);
                    preparedStatement.setInt(2, studentID);
                    break;

                case 4:
                    System.out.println("Please enter Contact Number which you wanted to update");
                    String contactNumber = validationFunction.validateContactNumber();
                    preparedStatement = connection.prepareStatement("update students set contact = ? where id = ?");
                    preparedStatement.setString(1,contactNumber);
                    preparedStatement.setInt(2, studentID);
                    break;
            }
            preparedStatement.executeUpdate();
            result = true ;

        }catch (Exception e){
            e.printStackTrace();
        }
        return result ;
    }
}






