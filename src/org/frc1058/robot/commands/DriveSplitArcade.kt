package org.frc1058.robot.commands

import edu.wpi.first.wpilibj.command.Command
import org.frc1058.robot.ControllerModes
import org.frc1058.robot.subsystems.DriveBase
import org.frc1058.robot.GamepadHelper
import org.frc1058.robot.OI


class DriveSplitArcade// Use requires() here to declare subsystem dependencies
// eg. requires(chassis);
    : Command() {

    // Called just before this Command runs the first time
    override fun initialize() {
		DriveBase.changeMode(ControllerModes.PERCENTVBUS)
    }

    // Called repeatedly when this Command is scheduled to run
    override fun execute(){
		val rotation : Double = GamepadHelper.ValueWithDeadBand(OI.driverGamepad.getRightStickX())
        val speed : Double = GamepadHelper.ValueWithDeadBand(OI.driverGamepad.getLeftStickY())
        var left : Double
        var right : Double

        left = speed + rotation
        right = speed - rotation

        if(OI.driverGamepad.getLeftBumper()){
        	left *= .5
            right *= .5
        }
		
		DriveBase.driveTank(left,right)

    }

    // Make this return true when this Command no longer needs to run execute()
    override fun isFinished(): Boolean {
        return false
    }

    // Called once after isFinished returns true
    override fun end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    override fun interrupted() {
    }
	
}