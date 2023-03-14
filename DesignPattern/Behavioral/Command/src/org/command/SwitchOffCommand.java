package org.command;

//Its a specific command/instruction that will be applied to the component
// So we dont have to conditionally check for condition and do stuffs in component(Control Panel)
// we will attach behavior and the behaviour will be executed
public class SwitchOffCommand implements Command{
    private final Light light;

    public SwitchOffCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.switchOff();
    }
}
