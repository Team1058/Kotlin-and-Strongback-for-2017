package org.frc1058.robot.commands

import edu.wpi.first.wpilibj.command.Command
import org.frc1058.robot.subsystems.DriveBase
import org.frc1058.robot.Robot

class DriveSplitArcade() : Command(){
	
	public fun DriveSplitArcade() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
	
    // Called just before this Command runs the first time
    override protected fun initialize() {
		requires(DriveBase);
		DriveBase.initDriveBase(0);
    }

    // Called repeatedly when this Command is scheduled to run
    override protected fun execute(){
		var rotation : Double = 0.0;
		var speed : Double = 0.0;
		var left : Double;
		var right : Double;
		val deadband : Double = .15;
		
		if(Math.abs(Robot.oi.driverGamepad.getRightStickX()) > deadband){
			rotation = Robot.oi.driverGamepad.getRightStickX();
		}
		
		if(Math.abs(Robot.oi.driverGamepad.getLeftStickY()) > deadband){
			speed = Robot.oi.driverGamepad.getLeftStickY();
		}
		
		left = speed + rotation;
		right = speed - rotation;

		if(Robot.oi.driverGamepad.getLeftBumper() == true){
        	left *= .5;
			right *= .5;
		}
		
		DriveBase.driveTank(left,right);
		
    }

    // Make this return true when this Command no longer needs to run execute()
    override protected fun isFinished(): Boolean {
        return false;
    }

    // Called once after isFinished returns true
    override protected fun end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    override protected fun interrupted() {
    }
	
}