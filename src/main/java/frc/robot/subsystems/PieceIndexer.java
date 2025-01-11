// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PieceIndexer extends SubsystemBase {
  /** Creates a new PieceIndexer. */
  public static TalonSRX Indexer = new TalonSRX(4);

  public static void RunInderxer () {
    Indexer.set(ControlMode.PercentOutput, .2);
  }

  public static void ReverseIndexer () {
    Indexer.set(ControlMode.PercentOutput, -.2);
  }

  public PieceIndexer() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
