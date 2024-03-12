import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdministratorPage {

    public static void printAdministratorPage(DataModel dataModel, Administrator administrator) {
        boolean back = false;
        while (!back) {
            System.out.println("----------------Welcome to Administrator Panel----------------");
            System.out.println("Please chose a number: \n" +
                    "1. View the teaching requirements\n" +
                    "2. View the part-time teachers information\n" +
                    "3. Assign class number and training to the teacher\n" +
                    "4. View teachers needed to have training\n" +
                    "5. Leave");
            System.out.println("----------------Enter a number below----------------");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            if (option == 1) {
                optionOne(dataModel, administrator);
            } else if (option == 2) {
                optionTwo(dataModel, administrator);
            } else if (option == 3) {
                optionThree(dataModel, administrator);
            } else if (option == 4) {
                optionFive(dataModel, administrator);
            } else if (option == 5) {
                Homepage.LoginPage(dataModel);
            } else {
                System.out.println("Sorry, this is not a valid option, please enter a number from 1 to 6.");
            }
        }
    }

    //option 1
    public static void optionOne(DataModel dataModel, Administrator administrator) {
        boolean back = false;

        System.out.println("You are viewing the information of part-time teachers");
        System.out.println("--------------------------");
        for (int i = 0; i < dataModel.getTeachingRequirements().size(); i++) {
            Requirement requirement = dataModel.getTeachingRequirements().get(i);
            System.out.print("Requirement " + i + ": ");
            System.out.println(requirement);
        }
        System.out.println();

        while (!back) {
            //go back
            System.out.println("------------Enter -1 to go back to Administrator Panel------------");
            Scanner scanner = new Scanner(System.in);
            int operation = scanner.nextInt();
            if (operation == -1) {
                back = true;
            } else {
                System.out.println("please enter -1 to go back to  Administrator Panel");
            }
        }
        printAdministratorPage(dataModel, administrator);
    }

    //option 2
    public static void optionTwo(DataModel dataModel, Administrator administrator) {
        boolean back = false;
        System.out.println("You are viewing the information of part-time teachers");
        System.out.println("------------------------");
        for (PTT ptt : dataModel.getPTTs()) {
            System.out.println(ptt);
        }
        System.out.println();

        //go back
        while (!back) {
            //go back
            System.out.println("------------Enter -1 to go back to Administrator page------------");
            Scanner scanner = new Scanner(System.in);
            int operation = scanner.nextInt();
            if (operation == -1) {
                printAdministratorPage(dataModel, administrator);
            } else {
                System.out.println("please enter -1 to go back to Administrator Panel");
            }
        }
    }

    //option 3
    public static void optionThree(DataModel dataModel, Administrator administrator) {
        boolean back = false;
        while (!back) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("You are assigning a teacher to a class, please select a requirement to assign:");
            int requirementNum = scanner.nextInt();
            scanner.nextLine();

            Requirement selectedRequirement = dataModel.getRequirementList().get(requirementNum);
            System.out.print("You will handle this requirement: " + "Requirement " + requirementNum);//TODO: 需要判断逻辑？
            System.out.print(selectedRequirement + "\n");
            System.out.println();

            //assign teachers based on the number of the requirement

            for (int s = 0; s < selectedRequirement.getPTTNumber(); s++) {
                List<PTT> validTeachers = new ArrayList<>();

                System.out.println("the teachers can be assigned to this class : ");
                for (PTT ptt : dataModel.getPTTs()) {
                    if (ptt.getMajor().equals(selectedRequirement.getMajor())&&(ptt.getClassNumber()==0)) {
                        System.out.println(ptt);
                        validTeachers.add(ptt);
                    }
                }
                System.out.println();

                //check if there is enough teachers
                if(validTeachers.isEmpty()){
                    System.out.println("Sorry, there are no relevant teachers");
                    System.out.println();
                    break;
                }else{
                    System.out.println("----------------Enter the teacher ID number below----------------");
                    int pttId = scanner.nextInt();
                    scanner.nextLine();

                    PTT selectedPTT = dataModel.getPttById(pttId);
                    if (selectedPTT != null) {
                        selectedPTT.setClassNumber(selectedRequirement.classNumber);
                        if(selectedPTT.getMajorLevel() < selectedRequirement.getMajorLevel()){//TODO: not sure: check if the teacher need training
                            System.out.println("------------------------");
                            System.out.println("The selected teacher needs training, do you want to assign a training to her/him");
                            System.out.println("----------------Enter 1 stands for yes, 2 stands for no----------------");
                            int trainingOrNot = scanner.nextInt();
                            scanner.nextLine();

                            if(trainingOrNot == 1){
                                selectedPTT.setNeedTraining(true);
                                dataModel.addTrainingList(selectedPTT);
                            }else if(trainingOrNot == 2){
                                break;
                            }
                        }
                        System.out.println("successfully assign a teacher to class " + selectedRequirement.getClassNumber());
                    }else{
                        System.out.println("Sorry the teacher is not exist, please enter a correct ID");
                        continue;
                    }
                    //check if finish the reqirement:
                    if(s==selectedRequirement.getPTTNumber()-1){
                        selectedRequirement.setAssigned(true);
                        System.out.println("You finished the selected requirement");
                    }
                }
            }

            //go back
            System.out.println("------------Enter -1 to go back to Administrator page or 0 to continue ------------");
            int operation = scanner.nextInt();
            scanner.nextLine();

            if (operation == -1) {
                back=true;
                printAdministratorPage(dataModel, administrator);
            }
        }
    }

    public static void optionFive(DataModel dataModel, Administrator administrator) {
        boolean back = false;

        System.out.println("You are viewing the training list of the part-time teachers");
        System.out.println("--------------------------");
        for (int i = 0; i < dataModel.getTrainingList().size(); i++) {
            PTT trainingPtt = dataModel.getTrainingList().get(i);
            System.out.println(trainingPtt);
        }
        System.out.println();

        while (!back) {
            //go back
            System.out.println("------------Enter -1 to go back to Administrator Panel------------");
            Scanner scanner = new Scanner(System.in);
            int operation = scanner.nextInt();
            if (operation == -1) {
                back = true;
            } else {
                System.out.println("please enter -1 to go back to  Administrator Panel");
            }
        }
        printAdministratorPage(dataModel, administrator);

    }


}
