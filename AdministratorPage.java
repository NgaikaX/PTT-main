import java.util.List;
import java.util.Scanner;

public class AdministratorPage {
    public AdministratorPage() {
    }

    public void printAdministratorPage(DataModel dataModel,Administrator administrator) {
        boolean back = false;
        while (!back) {
            System.out.println("----------------Welcome to Administrator Panel----------------");
            System.out.println("Please chose a number: \n" +
                    "1. View the teaching requirements\n" +
                    "2. View the part-time teachers information\n" +
                    "3. Assign class number to the teacher\n" +
                    "4. Assign training to the part time teacher\n" +
                    "5. View all the available training\n" +
                    "6. Leave");
            System.out.println("----------------Enter a number below----------------");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            if (option == 1) {
                optionOne(dataModel);
            } else if (option == 2) {
                optionTwo(dataModel);
            } else if (option == 3) {
                optionThree(dataModel);
            } else if (option == 4) {
                //optionFour(dataModel);
            } else if (option == 5) {
                //optionFive(dataModel);
            } else if (option == 6) {
                back = true;
            } else {
                System.out.println("Sorry, this is not a valid option, please enter a number from 1 to 6.");
            }
        }
    }

    //option 1
    public void optionOne(DataModel dataModel){
        boolean black = false;
        while (!black) {
            System.out.println("You are viewing the information of part-time teachers");
            System.out.println("--------------------------");
            for (int i = 0; i < dataModel.getTeachingRequirements().size(); i++) {
                Requirement requirement = dataModel.getTeachingRequirements().get(i);
                System.out.print("Requirement " + i +": ");
                System.out.println(requirement);
            }
            System.out.println();
            black=true;
        }
    }
    //option 2
    public void optionTwo(DataModel dataModel){
        boolean black = false;
        while (!black) {
            System.out.println("You are viewing the information of part-time teachers");
            System.out.println("------------------------");
            for (PTT ptt : dataModel.getPTTs()) {
                System.out.println(ptt);
            }
            black=true;
        }

    }

    //option 3
    public void optionThree(DataModel dataModel){
        boolean black = false;
        while (!black) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("You are assigning a teacher to a class, please select a class number to check the requirement:");
            int classNum = scanner.nextInt();
            scanner.nextLine();

            Requirement selectedRequirement = dataModel.getRequirementList().get(requirementNum);
            System.out.print("You will handle this requirement: "+"Requirement " + requirementNum);
            System.out.print(selectedRequirement);
            System.out.println();

            for (PTT ptt : dataModel.getPTTs()) {
                if(ptt.getMajor().equals(selectedRequirement.getMajor())){
                    System.out.println(ptt);
                }
            }

            System.out.println("----------------Enter the teacher ID number below----------------");
            int pttId = scanner.nextInt();
            scanner.nextLine();

            PTT selectedPTT = dataModel.getPttById(pttId);
            if(selectedPTT!=null){
                selectedPTT.setClassNumber(selectedRequirement.classNumber);
                selectedRequirement.setAssigned(true);
                black=true;
            }

        }
    }
/*    public void optionFour(DataModel dataModel) {
        boolean black = false;
        while (!black) {
            System.out.println("You are assigning training to the part-time teachers，\n" +
                    "please enter the Part-time teacher ID to assign the training to：");
            System.out.println("----------------Enter a ID below----------------");
            Scanner scanner = new Scanner(System.in);
            int PTTID = scanner.nextInt();//TODO：check error input
            checkPTT(dataModel, PTTID);
            System.out.println("You are assigning training to the part-time teachers，\n" +
                    "please enter the training you would like to assign teacher to：");
            System.out.println("----------------Enter a training below or enter -1 to leave and go back to Administrator Panel----------------");
            String training = scanner.nextLine();//TODO：check error input
            if (training.equals("-1")) {
                black = true;
            } else {
                addTraining(dataModel, PTTID, training);
            }
        }
    }*/
/*    public void optionFive(DataModel dataModel) {
        boolean back = false;
        while (!back){
            checkTrainingList(dataModel);
            System.out.println("----------------Enter -1 to leave and go back to Administrator Panel----------------");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            if(option == -1) {
                back = true;
            }else{
                //TODO：check error input
            }
        }

    }*/




}
