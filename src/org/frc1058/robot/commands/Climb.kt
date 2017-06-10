package org.frc1058.robot.commands

import edu.wpi.first.wpilibj.command.Command
import org.frc1058.robot.subsystems.Climber


class Climb(speed: Double) : Command() {
	
	var climberSpeed: Double = speed

    override fun initialize() {
		
	}
	
	override fun execute() {
		Climber.setClimberOutput(climberSpeed)
    }
	
	override fun isFinished(): Boolean {
		 return false
    }
	
	override fun end() {
		Climber.setClimberOutput(0.0)
    }
	
	override fun interrupted() {
		Climber.setClimberOutput(0.0)
    }
}