package missGrantController;

import java.util.Scanner;

public class View {
    private MissGrantController missGrantController = new MissGrantController();
    private static String PASSWORD = "151220140";
    private static String CLOSEPANEL = "Close Panel";

    private void handleInput(String input){
        if(input.equals(PASSWORD))
            missGrantController.handle(missGrantController.inputCorrectPassword);
        else if(input.equals(CLOSEPANEL))
            missGrantController.handle(missGrantController.closePanel);
        else
            missGrantController.handle(missGrantController.inputIncorrectPassword);
    }

    public static void main(String[] args){
        System.out.println("This is Miss Grant's Controller.");
        System.out.print("Input Password : ");
        Scanner scanner = new Scanner(System.in);
        View view = new View();
        while(true){

            String input = scanner.nextLine();
            if(input.equals("exit"))
                break;
            view.handleInput(input);
            if(view.missGrantController.machine.getState().getName().equals(view.missGrantController.failure_1stState.getName())) {
                System.out.println("failure first");
                System.out.print("Input Password : ");
            }
            else if(view.missGrantController.machine.getState().getName().equals(view.missGrantController.failure_2ndState.getName())) {
                System.out.println("failure second");
                System.out.print("Input Password : ");
            }
            else if(view.missGrantController.machine.getState().getName().equals(view.missGrantController.failure_3rdState.getName()))
                System.out.println("Lock forever!");
            else if(view.missGrantController.machine.getState().getName().equals(view.missGrantController.unlockPanelState.getName())) {
                System.out.println("Open panel!");
                System.out.print("You can print Close Panel to lock the panel: ");
            }
            else if(view.missGrantController.machine.getState().getName().equals(view.missGrantController.idle.getName())) {
                System.out.println("Panel closed!");
                System.out.print("Input Password : ");
            }
        }
    }
}
