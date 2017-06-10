package org.frc1058.robot.commands

import edu.wpi.first.wpilibj.command.Command;
import org.frc1058.robot.subsystems.Climber;


public class Climb: Command {
	
	var climberSpeed: Double = 0.0;
	
	public constructor(speed: Double){
		requires(Climber);
		climberSpeed = speed;
	}
	
	override protected fun initialize() {
		
	}
	
	override protected fun execute() {
		Climber.setClimberOutput(climberSpeed);
	}
	
	override protected fun isFinished(): Boolean {
		 return false;
	}
	
	override protected fun end() {
		Climber.setClimberOutput(0.0);
    }
	
	override protected fun interrupted() {
		Climber.setClimberOutput(0.0);
    }
}