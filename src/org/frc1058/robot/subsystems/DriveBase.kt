package org.frc1058.robot.subsystems

import com.ctre.CANTalon
import edu.wpi.first.wpilibj.AnalogGyro
import edu.wpi.first.wpilibj.Solenoid
import edu.wpi.first.wpilibj.command.Subsystem
import org.frc1058.robot.RobotMap
import org.frc1058.robot.commands.DriveSplitArcade

public class DriveBase() : Subsystem(){
	
	var driveBaseMode: Int = 0;
	
	val l1 = CANTalon(RobotMap.LEFT_DRIVE_1_TALON_ID);
	val r1 = CANTalon(RobotMap.RIGHT_DRIVE_1_TALON_ID);
	val l2 = CANTalon(RobotMap.LEFT_DRIVE_2_TALON_ID);
	val r2 = CANTalon(RobotMap.RIGHT_DRIVE_2_TALON_ID);
	val gyro = AnalogGyro(0);
	
	val gearLed = Solenoid(RobotMap.GEAR_LED_RING_CHANNEL);
	val shooterLed = Solenoid(RobotMap.SHOOTER_LED_RING_CHANNEL);
	
	override public fun initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		DriveSplitArcade();
    }
	
	public fun initDriveBase(mode : Int){
		
		driveBaseMode = mode;
		
		l1.setSafetyEnabled(false);
		r1.setSafetyEnabled(false);
		l2.setSafetyEnabled(false);
		r2.setSafetyEnabled(false);
		
		l1.enableControl();
		r1.enableControl();
		
		l1.reverseSensor(true);
		r1.reverseSensor(true);
		
		l1.configEncoderCodesPerRev(256);
		r1.configEncoderCodesPerRev(256);
		
		l1.setFeedbackDevice(com.ctre.CANTalon.FeedbackDevice.QuadEncoder);
		r1.setFeedbackDevice(com.ctre.CANTalon.FeedbackDevice.QuadEncoder);
		when (mode){
			0 -> {
				 l1.changeControlMode(com.ctre.CANTalon.TalonControlMode.PercentVbus);
		         l2.changeControlMode(com.ctre.CANTalon.TalonControlMode.Follower);
		         r1.changeControlMode(com.ctre.CANTalon.TalonControlMode.PercentVbus);
		         r2.changeControlMode(com.ctre.CANTalon.TalonControlMode.Follower);
				
				 l1.enableBrakeMode(false);
		         r1.enableBrakeMode(false);
		         l2.enableBrakeMode(false);
		         r2.enableBrakeMode(false);
			}
			1 -> {
				 l1.changeControlMode(com.ctre.CANTalon.TalonControlMode.Speed);
				 r1.changeControlMode(com.ctre.CANTalon.TalonControlMode.Follower);
				 l2.changeControlMode(com.ctre.CANTalon.TalonControlMode.Speed);
				 r2.changeControlMode(com.ctre.CANTalon.TalonControlMode.Follower);
				 l1.setPID(RobotMap.DRIVEBASE_kP, RobotMap.DRIVEBASE_kI, RobotMap.DRIVEBASE_kD, RobotMap.DRIVEBASE_kF, 0, 0.0, 0);
				 r1.setPID(RobotMap.DRIVEBASE_kP, RobotMap.DRIVEBASE_kI, RobotMap.DRIVEBASE_kD, RobotMap.DRIVEBASE_kF, 0, 0.0, 0);
				 l1.configMaxOutputVoltage(12.0);
				 r1.configMaxOutputVoltage(12.0);
			}
			2 -> {
				 l1.changeControlMode(com.ctre.CANTalon.TalonControlMode.Position);
				 l2.changeControlMode(com.ctre.CANTalon.TalonControlMode.Follower);
				 r1.changeControlMode(com.ctre.CANTalon.TalonControlMode.Position);
				 r2.changeControlMode(com.ctre.CANTalon.TalonControlMode.Follower);
				
				 //TODO: FIX THIS GARBAGE
				 //WHY ARE THE P AND I VALUES DIFFERENT
				
				 l1.setPID(0.52, 0.0, RobotMap.DRIVEBASE_kD, 0.0, 0, 500.0, 0);
				 r1.setPID(0.52, 0.0, RobotMap.DRIVEBASE_kD, 0.0, 0, 500.0, 0);
				
				 l1.configMaxOutputVoltage(4.0);
				 r1.configMaxOutputVoltage(4.0);
			}
			
			else -> {
				 println("Invalid DriveBase mode, you big lame-O.");
			}
				
				
		}
	}
		
		
}
	
