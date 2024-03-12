import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homepage {
    public static void LoginPage(DataModel dataModel) {
        boolean success = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Part time teacher program");
        while (!success) {
            System.out.print("Enter your user ID: ");
            int id = input.nextInt();
            input.nextLine();
            System.out.print("Enter your password: ");
            String password = input.nextLine();

            if ((dataModel.administratorLogin(id, password, dataModel)) != null) {
                 AdministratorPage.printAdministratorPage(dataModel, dataModel.administratorLogin(id, password, dataModel));
                success=true;
            } else if ((dataModel.directorLogin(id, password, dataModel)) != null) {
                new DirectorPage().printDirectorPage(dataModel, dataModel.directorLogin(id, password, dataModel));
                success=true;
            }else{
                System.out.println("There is no User");
            }

        }

    }
}
