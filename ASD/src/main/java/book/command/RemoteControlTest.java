package book.command;

import java.util.Collection;
import java.util.stream.Stream;

public class RemoteControlTest {//client
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();//Invoker, it will be passed a command object that can be used to make requests

        //Create an object that will be the receiver of the request.
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();

        //create a command and pass a receiver to it.
        Command lighOn = new LightOnCommand(light);
        Command doorOpened = new GarageDoorOpenCommand(garageDoor);

        //here pass the command to the invoker
        remote.setCommand(lighOn);
        remote.buttonWasPressed();//and then we simulate the button being pressed

        remote.setCommand(doorOpened);
        remote.buttonWasPressed();//and then we simulate the button being pressed

    }
}
