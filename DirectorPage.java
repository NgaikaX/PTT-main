import java.util.List;
import java.util.Scanner;

public class DirectorPage {
    private static Scanner scanner= new Scanner(System.in);



    public static void printDirectorPage(DataModel dataModel, Director director) {
        System.out.println("-------------------------");
        System.out.println("Please select an option:");
        System.out.println("0. Add a new requirement");
        System.out.println("1. View all existing requirements");
        System.out.println("2. Exit program");
        System.out.println("-------------------------");

        String input = scanner.nextLine();

        switch (input) {
            case "0":
                addRequirement(dataModel, director);
                break;
            case "1":
                listRequirement(dataModel, director);
                break;
            case "2":
                System.exit(0);
            default:
                System.out.println("Invalid operation");
                break;
        }
    }

    private static void addRequirement(DataModel dataModel, Director director) {
        System.out.println();
        System.out.println("-------------------------");

        System.out.println("Please enter the major of the teacher you need:");
        String major = scanner.nextLine();

        System.out.println("Please enter the level required for the teacher's major:");
        int level = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter the number of teachers you need for this major:");
        int numberOfTeachers = scanner.nextInt();
        scanner.nextLine();

        Requirement requirement = new Requirement(director.getClassNumber(), major, level, numberOfTeachers, false);
        dataModel.addRequirement(requirement);

        System.out.println("-------------------------");
        System.out.println("Added successfully!");
        System.out.println("-------------------------");
        //back to DirectorPage
        printDirectorPage(dataModel, director);
    }


    private static void listRequirement(DataModel dataModel, Director director) {
        System.out.println();
        List<Requirement> requirementList = dataModel.getRequirementList();
        for (int i = 0; i < requirementList.size(); i++) {
            Requirement requirement = requirementList.get(i);
            if (requirement.getClassNumber() == director.getClassNumber()) {
                System.out.println("Requirement " + i +
                        ": classNumber=" + requirement.getClassNumber() +
                        ", major=" + requirement.getMajor() +
                        ", majorLevel=" + requirement.getMajorLevel() +
                        ", PTTNumber=" + requirement.getPTTNumber());
            }
        }

        System.out.println("-------------------------");
        System.out.println("Please select an option:");
        System.out.println("0. Update a requirement");
        System.out.println("1. Back to homepage");
        System.out.println("2. Exit program");
        System.out.println("-------------------------");

        String input = scanner.nextLine();

        switch (input) {
            case "0":
                updateRequirement(dataModel, director);
                break;
            case "1":
                printDirectorPage(dataModel, director);
                break;
            case "2":
                System.exit(0);
            default:
                System.out.println("Invalid operation");
                break;
        }
    }

    private static void updateRequirement(DataModel dataModel, Director director) {
        System.out.println("-------------------------");
        System.out.println("Please enter the number of requirement you want to update:");
        int updateNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter the major of the teacher you need:");
        String major = scanner.nextLine();

        System.out.println("Please enter the level required for the teacher's major:");
        int level = scanner.nextInt();
        scanner.nextLine();


        System.out.println("Please enter the number of teachers you need for this major:");
        int numberOfTeachers = scanner.nextInt();
        scanner.nextLine();
        System.out.println("-------------------------");

        Requirement requirement = new Requirement(director.getClassNumber(), major, level, numberOfTeachers, false);
        dataModel.updateRequirementList(updateNumber, requirement);
        System.out.println("Updated successfully!");
        System.out.println("-------------------------");

        listRequirement(dataModel, director);
    }


}
