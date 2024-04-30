package DesignPatterns.Command;

public class Coach {
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void executeStrategy(){
        command.execute();
    }
}

//Invoker
