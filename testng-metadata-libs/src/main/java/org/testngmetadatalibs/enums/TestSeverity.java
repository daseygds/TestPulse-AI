package org.testngmetadatalibs.enums;

public enum TestSeverity {
  HIGH("High"),
  MEDIUM("Medium"),
  LOW("Low");

  private final String severity;

  TestSeverity(String severity){
    this.severity = severity;
  }

  public String getSeverity(){
    return this.severity;
  }
}
