package stateMachineModel;

public class StateMachine {
    private State start;

    public StateMachine(State start){
        this.start = start;
    }

    public State getState(){
        return start;
    }

    public void setState(State state){
        this.start = state;
    }
}
