package org.example;

import java.sql.*;
import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {
        ArrayList<User> betweenEighteenAndSixty = new ArrayList<>();
        ArrayList<User> underEighteen = new ArrayList<>();
        ArrayList<User> endsWithO = new ArrayList<>();

        try (var connection = DriverManager.getConnection(JDBCConstants.URL,JDBCConstants.USERNAME,JDBCConstants.PASSWORD)) {
            var statement = connection.createStatement();

            ResultSet resultSetBetweenEighteenAndSixty = null;
            ResultSet resultSetUnderEighteen = null;
            ResultSet resultSetEndsWithO = null;

//            statement.execute(SqlQueries.CREATE_TABLE);
//            statement.execute(SqlQueries.INSERT_USERS);

           if(resultSetEndsWithO==null){
               resultSetEndsWithO = statement.executeQuery(SqlQueries.SELECT_USERS_ENDS_WITH_O);
               endsWithO = OperationsWithListsOfPeople.fillTheListWith(resultSetEndsWithO,endsWithO);

               System.out.println("endsWithO");
               OperationsWithListsOfPeople.ShowSavedList(endsWithO);
               System.out.println("\n");
           }
           if (resultSetUnderEighteen==null) {
               resultSetUnderEighteen = statement.executeQuery(SqlQueries.SELECT_USERS_UNDER_18);
               underEighteen = OperationsWithListsOfPeople.fillTheListWith(resultSetUnderEighteen,underEighteen);

               System.out.println("underEighteen");
               OperationsWithListsOfPeople.ShowSavedList(underEighteen);
               System.out.println("\n");
           }
           if (resultSetBetweenEighteenAndSixty==null) {
               resultSetBetweenEighteenAndSixty = statement.executeQuery(SqlQueries.SELECT_USERS_BETWEEN_18_60);
               betweenEighteenAndSixty = OperationsWithListsOfPeople.fillTheListWith(resultSetBetweenEighteenAndSixty,betweenEighteenAndSixty);

               System.out.println("betweenEighteenAndSixty");
               OperationsWithListsOfPeople.ShowSavedList(betweenEighteenAndSixty);
               System.out.println("\n");
           }
           else{
               System.out.println("endsWithO");
               OperationsWithListsOfPeople.ShowSavedList(endsWithO);
               System.out.println("underEighteen");
               OperationsWithListsOfPeople.ShowSavedList(underEighteen);
               System.out.println("betweenEighteenAndSixty");
               OperationsWithListsOfPeople.ShowSavedList(betweenEighteenAndSixty);
           }


        }catch(SQLException e){
            System.out.println("Error"+e.getMessage());
        }
    }
}