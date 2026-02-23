package org.testngmetadatalibs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
  private static String DB_FILE_CONFIG = "src/main/resources/dbConfig.properties";
  private static Properties LoadConfigFile(String location){
    try {
      InputStream stream = new FileInputStream(location);
      Properties properties = new Properties();
      properties.load(stream);
      return properties;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static String getPortalUrl(){
    return LoadConfigFile("src/main/resources/portalconfig.properties").getProperty("portal.url");
  }

  public static String[] getDBConfigProp(){
    String url = LoadConfigFile(DB_FILE_CONFIG).getProperty("dbURL");
    String userName = LoadConfigFile(DB_FILE_CONFIG).getProperty("username");
    String password = LoadConfigFile(DB_FILE_CONFIG).getProperty("password");
    return new String[]{url,userName,password};
  }
}
