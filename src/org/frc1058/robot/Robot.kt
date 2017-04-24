package org.frc1058.robot;

import org.strongback.Strongback;
import org.frc1058.robot.subsystems.DriveBase;
import org.frc1058.robot.subsystems.GearManipulator;

import edu.wpi.first.wpilibj.IterativeRobot;

public object Robot : IterativeRobot() {
	
    override public fun robotInit() {
		DriveBase.initDriveBase();
		DriveBase.gyro.calibrate();
    }
	
	override public fun autonomousInit(){
		GearManipulator.pivotMotor.setPosition(0.0);
		GearManipulator.pivotMotor.setSetpoint(0.0);
	}

    override public fun teleopInit() {
        // Start Strongback functions ...
        Strongback.start();
		DriveBase.changeMode(DriveBase.DriveBaseMode.SPEEDPID);
    }
    
    override public fun teleopPeriodic() {
    }

    override public fun disabledInit() {
        // Tell Strongback that the robot is disabled so it can flush and kill commands.
        Strongback.disable();
    }

}
