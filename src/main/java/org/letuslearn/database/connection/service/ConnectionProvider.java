// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.connection.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 
 * @author aksharaaaa This class provided the Connection
 *
 */
public class ConnectionProvider {
  private ConnectionProvider() {

  }

  private static ConnectionProvider instance;

  public static ConnectionProvider getInstance() {
    if (null == instance) {
      instance = new ConnectionProvider();
    }
    return instance;
  }

  public Connection getConnection() {
    // System.out.println("in Connection Provider");
    Connection connection = null;
    DataSource ds;

    try {
      // InitializeParameters ip = InitializeParameters.getInstance();
      // ConnectionParametersProvider cpp = ip.getCpp();

      InitialContext context = new InitialContext(); // context.PROVIDER_URL // Context con = new
      // System.out.println("out of 1");
      // Iterator it = context.getEnvironment().keySet().iterator();
      // This is by using JNDI
      ds = (DataSource) context.lookup("java:comp/env/jdbc/postgres");

      connection = ds.getConnection();

    } catch (NamingException ne) {

    } catch (SQLException sql) {

    } // System.out.println(connection);

    return connection;

    // return ConnectionProviderUtility.getInstance().getRdbmsConnection();
  }
}
