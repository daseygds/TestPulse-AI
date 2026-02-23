package org.testngmetadatalibs.enums;

public enum TestStatus {
  PASS("Pass"),
  FAIL("Fail");

  private final String status;

  TestStatus(String status){
    this.status = status;
  }

  public String getStatus(){
    return this.status;
  }
}
