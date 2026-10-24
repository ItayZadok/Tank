package frc.robot;

import com.spikes2212.util.PlaystationControllerWrapper;

public class OI {

    private final PlaystationControllerWrapper controller;

    public OI() {
        controller = new PlaystationControllerWrapper(0);
    }

    public double getRightY() {
        return controller.getRightY();
    }

    public double getLeftY() {
        return controller.getLeftY();
    }
}
