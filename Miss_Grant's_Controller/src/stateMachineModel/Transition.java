package stateMachineModel;

public class Transition {
    private final State source,target;
    private final Event trigger;

    public Transition(State source,Event trigger,State target){
        this.source = source;
        this.trigger = trigger;
        this.target = target;
    }

    public State getTarget() {
        return target;
    }

}
