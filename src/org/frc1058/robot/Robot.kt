package org.frc1058.robot;

import org.strongback.Strongback;
import org.frc1058.robot.subsystems.DriveBase;

import edu.wpi.first.wpilibj.IterativeRobot;

public object Robot : IterativeRobot() {
	
	public val oi = OI;
    public val driveBase = DriveBase;
	
    override public fun robotInit() {
		driveBase.initDriveBase();
    }

    override public fun teleopInit() {
        // Start Strongback functions ...
        Strongback.start();
    }
    
    override public fun teleopPeriodic() {
    }

    override public fun disabledInit() {
        // Tell Strongback that the robot is disabled so it can flush and kill commands.
        Strongback.disable();
    }

}
