package com.designpattern.command;

public class StereoWithCDCommand implements Command {
    private Stereo stereo;

    public StereoWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(12);
    }
}
