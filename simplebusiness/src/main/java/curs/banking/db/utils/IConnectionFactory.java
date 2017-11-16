package curs.banking.db.utils;

import java.sql.Connection;

public interface IConnectionFactory {
  Connection getConnection() throws Exception ;
}
