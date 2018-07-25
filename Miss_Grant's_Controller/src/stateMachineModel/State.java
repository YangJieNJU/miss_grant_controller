package stateMachineModel;

import java.util.*;

public class State {
    private String name;
    private List<Command> actions = new ArrayList<Command>();
    private Map<String,Transition> transitions = new HashMap<String, Transition>();

    public State(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addAction(Command action){
        actions.add(action);
    }

    public void addTransition(Event event,State targetState){
        assert null != targetState;
        transitions.put(event.getName(),new Transition(this,event,targetState));
    }

    public boolean hasTransition(String eventName){
        return transitions.containsKey(eventName);
    }

    public State targetState(String eventName){
        return transitions.get(eventName).getTarget();
    }


}
