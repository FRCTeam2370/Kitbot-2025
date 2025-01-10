// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {
  /** Creates a new Climb. */
  public static Spark Climber = new Spark(5);

  public static void RunClimber () {
    Climber.set(.2);
  }

  public static void LowerClimber () {
    Climber.set(-.2);
  }


  public Climb() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
