import org.command.*;

//https://github.com/geekific-official/geekific-youtube/blob/main/pattern-behavioral-command/src/main/java/com/youtube/geekific/components/FloorLamp.java
// //https://www.educative.io/courses/software-design-patterns-best-practices/NE06o49n7P2
public class CommandMain {
    public static void main(String[] args) {


        Light light =  new Light();
        Command switchOnCommand =  new SwitchOnCommand(light);
        Command switchOffCommand = new SwitchOffCommand(light);

        ControlPanel controlPanel =  new ControlPanel();
        controlPanel.setCommand(0,switchOnCommand);
        controlPanel.setCommand(1,switchOffCommand);


        //System.out.println("Is Light On : "+ light.isSwitchedOn());
        controlPanel.switchOn();
        System.out.println("Is Light On : "+ light.isSwitchedOn());
        controlPanel.switchOff();
        System.out.println("Is Light On : "+ light.isSwitchedOn());

    }
}