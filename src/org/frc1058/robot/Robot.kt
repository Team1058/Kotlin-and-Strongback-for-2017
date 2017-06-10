package org.frc1058.robot

import edu.wpi.first.wpilibj.IterativeRobot
import org.frc1058.robot.OI.OI
import org.frc1058.robot.subsystems.DriveBase
import org.frc1058.robot.subsystems.GearManipulator
import org.strongback.Strongback

object Robot : IterativeRobot() {
	
    override fun robotInit() {
		DriveBase.initDriveBase()
        DriveBase.gyro.calibrate()
        OI()
    }
	
	override fun autonomousInit(){
        GearManipulator.pivotMotor.position = 0.0
        GearManipulator.pivotMotor.setpoint = 0.0
    }

    override fun teleopInit() {
        // Start Strongback functions ...
        Strongback.start()
        DriveBase.changeMode(ControllerModes.PID)
    }
    
    override fun teleopPeriodic() {
    }

    override fun disabledInit() {
        // Tell Strongback that the robot is disabled so it can flush and kill commands.
        Strongback.disable()
    }

}
