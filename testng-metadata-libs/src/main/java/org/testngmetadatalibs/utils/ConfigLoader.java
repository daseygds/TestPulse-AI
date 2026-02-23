package org.testngmetadatalibs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
  private static Properties LoadConfigFile(){
    try {
      InputStream stream = new FileInputStream("src/main/resources/portalconfig.properties");
      Properties properties = new Properties();
      properties.load(stream);
      return properties;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static String getPortalUrl(){
    return LoadConfigFile().getProperty("portal.url");
  }
}
