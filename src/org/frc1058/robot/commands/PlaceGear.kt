package org.frc1058.robot.commands

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1058.robot.RobotMap;

public class PlaceGear: CommandGroup {
	public constructor(){
		addSequential(DriveAndPivotGearIntake(RobotMap.INTAKE_PIVOT_GEARINTAKE_POSITION-400,-0.4, 6.0), 2.0);
		addSequential(PivotGearIntake(RobotMap.INTAKE_PIVOT_GEARINTAKE_POSITION-400, 6.0));
	}
}

