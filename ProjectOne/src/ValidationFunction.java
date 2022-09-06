import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidationFunction {
    public static Scanner scanner = new Scanner(System.in);
    ValidationsClass validationsClass = new ValidationsClass();

    //FUNCTION TO VALIDATE THE ID
    public int validateId() {
        int id = 0;
        try {
            id = Integer.parseInt(scanner.next());
        } catch (Exception e) {
            System.out.println("Please give Valid input");
            id = validateId() ;
        }
        return id;
    }
    //FUNCTION TO VALIDATE THE NAME
    public String validateName(){
        String name = scanner.next();
        while (!validationsClass.isValidName(name)){
            System.out.println("Please Enter a valid name");
            name = scanner.next();
        }
        return name ;
    }
    //FUNCTION TO VALIDATE THE AGE
    public int validateAge(){

        int age = 0 ;
        try{
            age = Integer.parseInt(scanner.next());
        }catch (Exception e){
            System.out.println("Please give valid input");
            age = validateAge();
            if(age < 18 || age >100){
                System.out.println("Please enter Age in Valid range");
                age = validateAge();
            }
        }

        return age ;
    }
    //FUNCTION TO VALIDATE THE EMAIL
    public String validateEmail(){
        String email = scanner.next();
        while (!validationsClass.isValidEmail(email)){
            System.out.println("Please Enter a valid Email");
            email = scanner.next();
        }
        return email ;
    }
    //FUNCTION TO VALIDATE THE CONTACT NUMBER
    public String validateContactNumber(){
        String cn = scanner.next();
        while (!validationsClass.isValidContactNumber(cn)){
            System.out.println("Please Enter a valid ContactNumber");
            cn = scanner.next();
        }
        return cn ;
    }
    //FUNCTION TO VALIDATE THE OPTION MENU
    public int validateMenuOptions(){
        int option = 0 ;
        try{
            option = Integer.parseInt(scanner.next());
        }catch (Exception e){
            System.out.println("Please Enter Valid Input");
            option = validateMenuOptions();
        }

        return option;
    }


}
