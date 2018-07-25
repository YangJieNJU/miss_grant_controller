package missGrantController;

import stateMachineModel.*;

public class MissGrantController {
    private Controller controller = new Controller();

    Event inputIncorrectPassword = new Event();
    Event inputCorrectPassword = new Event();
    Event closePanel = new Event();

    Command lockPanelCmd = new Command();
    Command openPanelCmd = new Command();
    Command lockPanelForeverCmd = new Command();

    State idle = new State("idle");
    State failure_1stState = new State("faliure_1st");
    State failure_2ndState = new State("failure_2nd");
    State failure_3rdState = new State("failure_3rd");
    State unlockPanelState = new State("unlockPanel");

    StateMachine machine = new StateMachine(idle);

    public MissGrantController(){
        inputIncorrectPassword.setName("inputIncorrectPassword");
        inputCorrectPassword.setName("inputCorrectPassword");
        closePanel.setName("closePanel");

        lockPanelCmd.setName("lockPanel");
        openPanelCmd.setName("openPanel");
        lockPanelForeverCmd.setName("lockPanelForever");

        idle.addTransition(inputCorrectPassword,unlockPanelState);
        idle.addTransition(inputIncorrectPassword,failure_1stState);
        idle.addAction(lockPanelCmd);

        failure_1stState.addTransition(inputCorrectPassword,unlockPanelState);
        failure_1stState.addTransition(inputIncorrectPassword,failure_2ndState);

        failure_2ndState.addTransition(inputCorrectPassword,unlockPanelState);
        failure_2ndState.addTransition(inputIncorrectPassword,failure_3rdState);

        failure_3rdState.addAction(lockPanelForeverCmd);

        unlockPanelState.addAction(openPanelCmd);
        unlockPanelState.addTransition(closePanel,idle);
    }

    public void handle(Event event){
        machine.setState(controller.handle(machine.getState(),event.getName()));
    }
}
