// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PieceIndexer;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class IndexerForward extends Command {
  PieceIndexer mPieceIndexer;
  /** Creates a new IndexerForward. */
  public IndexerForward(PieceIndexer mPieceIndexer) {
    this.mPieceIndexer = mPieceIndexer;
    addRequirements(mPieceIndexer);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    PieceIndexer.RunInderxer();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    PieceIndexer.Indexer.set(ControlMode.PercentOutput, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
