package com.selenium.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by THOODI on 3/18/2017.
 */
public class ReadPropertyFile {
    static Properties prop = null;
    InputStream input = ReadPropertyFile.class.getClassLoader().getResourceAsStream("Repository.Properties");
    public ReadPropertyFile() throws IOException
    {
        prop = new Properties();
        prop.load(input);
    }

    public String getUsername()
    {
        return prop.getProperty("username");
    }
    public String getUrl()
    {
        return prop.getProperty("url");
    }

    public String getPassword()
    {
        return prop.getProperty("password");
    }

    public String getConnectionString()
    {
        return prop.getProperty("DBConnectionString");
    }
    public void getBrowserCmd()
    {
        prop.getProperty("browser");
    }
    public String getQuery()
    {
        return prop.getProperty("query");
    }
    public String[] getColumn()
    {

        String[] dbColumns = prop.getProperty("dbColumn").split(",");
        for (String w : dbColumns) {
            prop.getProperty("dbColumn");
        }

        return dbColumns;
    }
}
