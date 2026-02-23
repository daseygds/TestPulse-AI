package org.testngmetadatalibs.listeners;

import static org.testngmetadatalibs.enums.TestStatus.FAIL;
import static org.testngmetadatalibs.enums.TestStatus.PASS;
import static org.testngmetadatalibs.utils.GenerateUUID.getHashCode;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testngmetadatalibs.annotations.Severity;
import org.testngmetadatalibs.annotations.SuiteGroup;
import org.testngmetadatalibs.annotations.TestCaseID;
import org.testngmetadatalibs.client.PortalClient;
import org.testngmetadatalibs.enums.TestSeverity;
import org.testngmetadatalibs.enums.TestStatus;
import org.testngmetadatalibs.model.SessionModel;
import org.testngmetadatalibs.model.TestResultPayload;

public class PortalListener implements ITestListener, ISuiteListener {

  private PortalClient client = new PortalClient();
  private static String suiteCode = null;

  @Override
  public void onStart(ISuite suite){
    try {
      suiteCode = getHashCode(suite.getName());
      String suiteName = suite.getName();
      client.send(new SessionModel(suiteCode,suiteName));
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    send(result,PASS);
  }

  @Override
  public void onTestFailure(ITestResult result){
    send(result,FAIL);
  }

  private void send(ITestResult result, TestStatus status){
    Method method =
        result.getMethod().getConstructorOrMethod().getMethod();
    TestCaseID testCaseID = method.getAnnotation(TestCaseID.class);
    SuiteGroup suiteGroup = method.getAnnotation(SuiteGroup.class);
    Severity severity = method.getAnnotation(Severity.class);

    String tcID = testCaseID != null ? testCaseID.testcaseId() : "NA";
    String[] suiteGrp =
        suiteGroup != null ? suiteGroup.suiteGroup() : new String[0];
    TestSeverity severityValue = severity != null ?
        severity.severity() : TestSeverity.MEDIUM;

    TestResultPayload payload = new TestResultPayload();
    payload.setSuiteId(suiteCode);
    payload.setTestcaseId(tcID);
    payload.setSuiteGroup(suiteGrp);
    payload.setSeverity(severityValue.getSeverity());
    payload.setStatus(status.getStatus());
    payload.setDuration((result.getEndMillis() - result.getStartMillis())/1000.0);
    payload.setClassName(result.getTestClass().getName());
    payload.setMethodName(result.getMethod().getMethodName());
    //client.send(payload);
  }
}
