package com.designpattern.command;

public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        remote.setCommand(new LightOnCommand(light));
        remote.buttonWasPressed();
        Stereo stereo = new Stereo();
        remote.setCommand(new StereoWithCDCommand(stereo));
        remote.buttonWasPressed();
        remote.setCommand(new StereoOffCommand(stereo));
        remote.buttonWasPressed();
    }


}
