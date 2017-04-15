package org.frc1058.robot.commands

import edu.wpi.first.wpilibj.command.Command
import org.frc1058.robot.Robot

class DriveSplitArcade() : Command() {
	
	public fun DriveSplitArcade() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		//requires(Robot.drivebase);
		requires(Robot.drivebase)
    }

    // Called just before this Command runs the first time
    override protected fun initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    override protected fun execute() {
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