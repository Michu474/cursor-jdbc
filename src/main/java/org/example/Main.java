package org.example;

import java.sql.*;
import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {
        ArrayList<User> betweenEighteenAndSixty = new ArrayList<>();
        ArrayList<User> underEighteen = new ArrayList<>();
        ArrayList<User> endsWithO = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBCConstants.URL,JDBCConstants.USERNAME,JDBCConstants.PASSWORD);
             Statement statement = connection.createStatement()) {


            ResultSet resultSetBetweenEighteenAndSixty;
            ResultSet resultSetUnderEighteen;
            ResultSet resultSetEndsWithO;
            ResultSet resultSetOverEighteen;
            ResultSet resultSetContainsA;

//            statement.execute(SqlQueries.CREATE_TABLE);
//            statement.execute(SqlQueries.INSERT_USERS);

            resultSetEndsWithO = statement.executeQuery(SqlQueries.SELECT_USERS_ENDS_WITH_O);
            endsWithO = OperationsWithListsOfPeople.fillTheListWith(resultSetEndsWithO,endsWithO);

            resultSetUnderEighteen = statement.executeQuery(SqlQueries.SELECT_USERS_UNDER_18);
            underEighteen = OperationsWithListsOfPeople.fillTheListWith(resultSetUnderEighteen,underEighteen);

            resultSetBetweenEighteenAndSixty = statement.executeQuery(SqlQueries.SELECT_USERS_BETWEEN_18_60);
            betweenEighteenAndSixty = OperationsWithListsOfPeople.fillTheListWith(resultSetBetweenEighteenAndSixty,betweenEighteenAndSixty);

            resultSetContainsA = statement.executeQuery(SqlQueries.SELECT_USERS_CONTAINS_A);
            OperationsWithListsOfPeople.ShowCountOfPeople(resultSetContainsA,"resultSetContainsA\n");

            resultSetOverEighteen = statement.executeQuery(SqlQueries.SELECT_USERS_OVER_18);
            OperationsWithListsOfPeople.ShowCountOfPeople(resultSetOverEighteen,"resultSetOverEighteen\n");


            OperationsWithListsOfPeople.ShowSavedList(endsWithO,"endsWithO");
            OperationsWithListsOfPeople.ShowSavedList(underEighteen,"underEighteen");
            OperationsWithListsOfPeople.ShowSavedList(betweenEighteenAndSixty,"betweenEighteenAndSixty");


//



        }
        catch(SQLException e){
            System.out.println("Error"+e.getMessage());
        }
       

    }
}