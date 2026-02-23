package org.testngmetadatalibs.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.testngmetadatalibs.utils.ConfigLoader;
import org.testngmetadatalibs.model.TestResultPayload;

public class PortalClient {
  private final HttpClient client;
  private final ObjectMapper mapper;

  public PortalClient() {
    this(HttpClient.newHttpClient(), new ObjectMapper());
  }

  public PortalClient(HttpClient client, ObjectMapper mapper) {
    this.client = client;
    this.mapper = mapper;
  }

  public void send(TestResultPayload payload) {

    try {

      String portalUrl = ConfigLoader.getPortalUrl();
      if (portalUrl == null || portalUrl.isEmpty()) return;

      String json = mapper.writeValueAsString(payload);

      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(portalUrl))
          .header("Content-Type", "application/json")
          .POST(HttpRequest.BodyPublishers.ofString(json))
          .build();

      client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

    } catch (Exception e) {
      System.out.println("Error sending to portal: " + e.getMessage());
    }
  }
}
