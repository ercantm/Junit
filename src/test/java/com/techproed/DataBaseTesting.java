package com.techproed;

import java.sql.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class DataBaseTesting {

String url = "jdbc:mysql://107.182.225.121:3306/LibraryMgmt";
String username = "techpro";
String password = "tchpr2020";
Connection connection;
Statement statement;
ResultSet resultSet;
@Before
public void setup() throws SQLException {

     connection = DriverManager.getConnection(url, username, password);
     //We need to create a statement 
     statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
}
     @Test	public void jdbcTest1() throws SQLException{
     //Now we gonna run a query, so for that we need to create a result set
     resultSet = statement.executeQuery("SELECT * FROM Book;");
     //next() method returns boolean, so we can get value based on the column name
          //we need to skip first record, because it start from 0
          resultSet.next();//+1
          String value1 = resultSet.getString("BookName");
          System.out.println("VALUE 1 : "+value1);

     int rowCount=1;
     //print the BookName values on the Book Table
     while(resultSet.next()) {
     //getRow() return the number of row you are on
          // getObject is similar to getString
     Object val=   resultSet.getObject("BookName");
     System.out.println(resultSet.getRow()+" : "+val);
     rowCount++;
     }
//
      System.out.println("Number Of Row in BookName : "+rowCount);
//        We can move to a specific row using .absolute method
          resultSet.absolute(5);
          //We are getting the data oin teh 5th row
          String value5 = resultSet.getString("Bookname");
          System.out.println("The value on row 5 : "+value5);
           // Verify the value on the 5th row = Java
          Assert.assertEquals("Java", value5);
          //we can go back to first row
          resultSet.first();
          //getting the current row using getRow method
          int currentRow=resultSet.getRow();
         //printing the first row
          System.out.println("FIRST ROW : "+currentRow);
         //getting the current value on first row
          String Value1 = resultSet.getString("BookName");
          System.out.println(Value1);
          //we get go to the last row
          resultSet.last();
          //getting the current row using getRow method
          int lastRow=resultSet.getRow();
          //printing teh value on the current row(which is last row)
          System.out.println("LAST ROW : "+lastRow);
          String ValueLast = resultSet.getString("BookName");
         System.out.println("LAST VALUE : "+ValueLast);
         //Verifying the last row is UIPath
          Assert.assertTrue(ValueLast.equals("UIPath"));

}

     @Test
     public void jdbctest2() throws SQLException {
     //Now we gonna run a query, so for that we need to create a result set
     resultSet = statement.executeQuery("SELECT * FROM Book;");
     //we need to skip first record, because it start from 0
     resultSet.next();
     //we are getting first record based on the column name
     String value = resultSet.getString("BookName");
     //print
     System.out.println(value);
     //resultSet.afterLast();
     String value2 = resultSet.getString("BookName");
     //just to output result into terminal
     System.out.println(value2);



     }
     @Test
     public void jdbctest3() throws SQLException {
          //Now we gonna run a query, so for that we need to create a result set
          resultSet = statement.executeQuery("SELECT * FROM Book;");
          resultSet.last();
          String value = resultSet.getString("Bookname");
          System.out.println(value);
          int actualRowNum=resultSet.getRow();
          int expectedRowNum=14;
          Assert.assertEquals(actualRowNum, actualRowNum);
          Assert.assertEquals("UIPath", value);
          System.out.println("------END OF TEST 3--------");

     }

     //Metadata about data base
     @Test
     public void jdbctest4() throws SQLException {
          //So we want to get metadata about DB
          DatabaseMetaData dbmetadata = connection.getMetaData();
          System.out.println("Username: "+dbmetadata.getUserName());
          //String expcetedDBType = "MySQL";
          String actual = dbmetadata.getDatabaseProductName();
          System.out.println(actual);
          //Assert.assertEquals(expcetedDBType, actual);
          System.out.println(actual+" : "+dbmetadata.getDatabaseProductVersion());
          System.out.println("------END OF TEST 4--------");
     }

     //Metadata about resultset, means metadata about or query
     @Test
     public void jdbctest5() throws SQLException {
          resultSet = statement.executeQuery("SELECT * FROM Book;");
          ResultSetMetaData resultsetmetadata = resultSet.getMetaData();
          //to get amount of columns
          System.out.println(resultsetmetadata.getColumnCount());
          //to get column name based on the index
          System.out.println(resultsetmetadata.getColumnName(4));
          System.out.println(resultsetmetadata.getColumnDisplaySize(4));
          System.out.println(resultsetmetadata.getColumnTypeName(4));
          System.out.println("------END OF TEST 5--------");
     }

     @Test
     public void jdbctest6() throws SQLException {
          // get all columns names
          resultSet = statement.executeQuery("SELECT * FROM Book;");
          ResultSetMetaData resultsetmetadata = resultSet.getMetaData();
          for (int i = 1; i <= resultsetmetadata.getColumnCount(); i++){
		System.out.println("Name of a specific column with index:"+resultsetmetadata.getColumnName(i));
		System.out.println("------END OF TEST 6--------");
          }
     }
     //to output data types and column names of Book table
     @Test
     public void jdbctest7() throws SQLException {
          //resultset returns data based of query
          resultSet = statement.executeQuery("SELECT * FROM Book;");
          //resultsetmetadata (data about data) gives us idea about Result Set
          ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
          //We need to know amount columns
          int numOfColumn = resultSetMetaData.getColumnCount();
          //getting column name and data type
          for(int i = 1 ; i <= numOfColumn ; i ++) {
               System.out.println("column type with index: " + i + " ==> " + resultSetMetaData.getColumnTypeName(i)+" : "
                       +resultSetMetaData.getColumnName(i));

          }
          System.out.println("------END OF TEST 7--------");
     }

     //to output data types and column names of employees table
     @Test
     public void jdbctest8() throws SQLException {
          //resultset returns data based of query
          resultSet = statement.executeQuery("SELECT * FROM BookBorrow;");
          //resultsetmetadata (data about data) gives us idea about Result Set
          ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
          //We need to know amount columns
          int numOfColumn = resultSetMetaData.getColumnCount();
          //step by step we are getting column name and data type
          for(int i = 1 ; i <= numOfColumn ; i ++) {
               System.out.println("column type with index: " + i + " ==> " + resultSetMetaData.getColumnTypeName(i)+" : "
                       +resultSetMetaData.getColumnName(i));
          }
          System.out.println("------END OF TEST 8--------");
     }

     @After
     public void teardown() throws SQLException {
     //TO close stream of data (connection)
     connection.close();
     statement.close();
    }
}
