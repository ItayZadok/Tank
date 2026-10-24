// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.spikes2212.command.drivetrains.tankdrivetrains.TankDrivetrain;
import com.spikes2212.command.drivetrains.tankdrivetrains.commands.DriveTank;
import com.spikes2212.util.smartmotorcontrollers.TalonFXWrapper;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

    private TankDrivetrain tankDrivetrain;

    @Override
    public void robotInit() {
        tankDrivetrain = new TankDrivetrain(
                new TalonFXWrapper(RobotMap.CAN.LEFT_MASTER),
                new TalonFXWrapper(RobotMap.CAN.LEFT_SLAVE),
                new TalonFXWrapper(RobotMap.CAN.RIGHT_MASTER),
                new TalonFXWrapper(RobotMap.CAN.RIGHT_SLAVE)
        );
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void disabledInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void disabledPeriodic() {

    }

    @Override
    public void autonomousInit() {

    }

    @Override
    public void autonomousPeriodic() {

    }

    @Override
    public void teleopInit() {
        OI oi = new OI();
        CommandScheduler.getInstance().schedule(new DriveTank(tankDrivetrain, oi::getLeftY, oi::getRightY));
    }

    @Override
    public void teleopPeriodic() {

    }

    @Override
    public void testInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void testPeriodic() {

    }

    @Override
    public void simulationInit() {

    }

    @Override
    public void simulationPeriodic() {

    }
}
