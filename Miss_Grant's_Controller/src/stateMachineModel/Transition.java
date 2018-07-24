package stateMachineModel;

public class Transition {
    private final State source,target;
    private final Event trigger;

    public Transition(State source,Event trigger,State target){
        this.source = source;
        this.trigger = trigger;
        this.target = target;
    }

    public State getSource() {
        return source;
    }

    public Event getTrigger() {
        return trigger;
    }

    public State getTarget() {
        return target;
    }

    public String getEventCode(){
        return trigger.getCode();
    }
}
