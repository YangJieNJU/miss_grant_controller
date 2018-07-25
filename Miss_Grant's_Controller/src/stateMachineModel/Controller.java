package stateMachineModel;

public class Controller {

    public State handle(State currentState,String eventName){
        if(currentState.hasTransition(eventName)){
            return currentState.targetState(eventName);
    }
    else
        return currentState;
    }
}
