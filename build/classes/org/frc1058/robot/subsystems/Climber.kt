package org.frc1058.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1058.robot.RobotMap;
import org.frc1058.robot.OI;
import com.ctre.CANTalon;

public object Climber : Subsystem(){
	
	public var climberMotor = CANTalon(RobotMap.CLIMBER_TALON_ID);
	
	override public fun initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
	}
	
	public fun setClimberOutput(voltage: Double){
	   if(OI.operatorGamepad.getStartButton()){
		   climberMotor.set(-voltage);
	   }
	   else{
		   climberMotor.set(voltage);
	   }
   }
}