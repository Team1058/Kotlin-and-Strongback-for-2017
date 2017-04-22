package org.frc1058.robot.commands

import edu.wpi.first.wpilibj.command.Command
import org.frc1058.robot.subsystems.DriveBase
import org.frc1058.robot.GamepadHelper
import org.frc1058.robot.OI


class DriveSplitArcade : Command{
	
	public constructor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(DriveBase);
    }
	
    // Called just before this Command runs the first time
    override protected fun initialize() {
		DriveBase.changeMode(DriveBase.DriveBaseMode.PERCENTVBUS);
    }

    // Called repeatedly when this Command is scheduled to run
    override protected fun execute(){
		var rotation : Double;
		var speed : Double;
		var left : Double;
		var right : Double;
		
		rotation = GamepadHelper.ValueWithDeadBand(OI.driverGamepad.getRightStickX());
		speed = GamepadHelper.ValueWithDeadBand(OI.driverGamepad.getLeftStickY());
		
		left = speed + rotation;
		right = speed - rotation;

		if(OI.driverGamepad.getLeftBumper() == true){
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