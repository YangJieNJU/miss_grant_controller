package stateMachineModel;

import java.util.*;

public class State {
    private String name;
    private List<Command> actions = new ArrayList<Command>();
    private Map<String,Transition> transitions = new HashMap<String, Transition>();

    public void addTransition(Event event,State targetState){
        assert null != targetState;
        transitions.put(event.getCode(),new Transition(this,event,targetState));
    }

    public Collection<State> getAllTargets(){
        List<State> result = new ArrayList<State>();
        for(Transition t : transitions.values())
            result.add(t.getTarget());
        return  result;
    }

    public boolean hasTransition(String eventCode){
        return transitions.containsKey(eventCode);
    }
    public State targetState(String eventCode){
        return transitions.get(eventCode).getTarget();
    }
    public void executeActions(CommandChannel commandsChannel){
        for(Command c : actions)
            commandsChannel.send(c.getCode());
    }

}
