package org.testngmetadatalibs.client;

import org.testngmetadatalibs.dao.SessionDAO;
import org.testngmetadatalibs.model.SessionModel;
import org.testngmetadatalibs.model.TestResultPayload;

public class PortalClient {
  private final SessionDAO sessionDAO;

  public PortalClient() {
    sessionDAO = new SessionDAO();
  }

  public void send(TestResultPayload payload) {
    //code
  }

  public void send(SessionModel sessionModel){
    sessionDAO.insertSession(sessionModel.getSession_id(),sessionModel.getSession_name());
  }
}
