package org.testngmetadatalibs.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.testngmetadatalibs.enums.TestSeverity;

public class TestResultPayload {

  @JsonProperty("suiteId")
  private String suiteId;

  @JsonProperty("testcaseId")
  private String testcaseId;

  @JsonProperty("suiteGroup")
  private String[] suiteGroup;

  @JsonProperty("severity")
  private String severity;

  @JsonProperty("status")
  private String status;

  @JsonProperty("duration")
  private Double duration;

  @JsonProperty("className")
  private String className;

  @JsonProperty("methodName")
  private String methodName;

  public TestResultPayload() {
  }

  public String getSuiteId(){
    return this.suiteId;
  }

  public void setSuiteId(String suiteId){
    this.suiteId = suiteId;
  }

  public String getTestcaseId() {
    return testcaseId;
  }

  public void setTestcaseId(String testcaseId) {
    this.testcaseId = testcaseId;
  }

  public void setSeverity(String severity){
    this.severity = severity;
  }

  public String getSeverity(){
    return this.severity;
  }

  public String[] getSuiteGroup() {
    return suiteGroup;
  }

  public void setSuiteGroup(String[] suiteGroup) {
    this.suiteGroup = suiteGroup;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Double getDuration() {
    return duration;
  }

  public void setDuration(Double duration) {
    this.duration = duration;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public String getMethodName() {
    return methodName;
  }

  public void setMethodName(String methodName) {
    this.methodName = methodName;
  }
}
