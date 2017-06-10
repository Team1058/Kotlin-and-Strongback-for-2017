package org.frc1058.robot.subsystems

import com.ctre.CANTalon
import edu.wpi.first.wpilibj.command.Subsystem
import org.frc1058.robot.RobotMap
import org.frc1058.robot.OI

object Climber : Subsystem(){
	
	var climberMotor = CANTalon(RobotMap.CLIMBER_TALON_ID)

    override fun initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
	}
	
	fun setClimberOutput(voltage: Double){
	   if(OI.operatorGamepad.getStartButton()){
		   climberMotor.set(-voltage)
       }
	   else{
		   climberMotor.set(voltage)
       }
   }
}