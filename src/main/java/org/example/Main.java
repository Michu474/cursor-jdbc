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
            ResultSet resultSetOverEighteen = null;
            ResultSet resultSetContainsA = null;

//            statement.execute(SqlQueries.CREATE_TABLE);
//            statement.execute(SqlQueries.INSERT_USERS);

            resultSetEndsWithO = statement.executeQuery(SqlQueries.SELECT_USERS_ENDS_WITH_O);
            endsWithO = OperationsWithListsOfPeople.fillTheListWith(resultSetEndsWithO,endsWithO);

            resultSetUnderEighteen = statement.executeQuery(SqlQueries.SELECT_USERS_UNDER_18);
            underEighteen = OperationsWithListsOfPeople.fillTheListWith(resultSetUnderEighteen,underEighteen);

            resultSetBetweenEighteenAndSixty = statement.executeQuery(SqlQueries.SELECT_USERS_BETWEEN_18_60);
            betweenEighteenAndSixty = OperationsWithListsOfPeople.fillTheListWith(resultSetBetweenEighteenAndSixty,betweenEighteenAndSixty);

            resultSetContainsA = statement.executeQuery(SqlQueries.SELECT_USERS_CONTAINS_A);
            resultSetOverEighteen = statement.executeQuery(SqlQueries.SELECT_USERS_OVER_18);

            OperationsWithListsOfPeople.ShowSavedList(endsWithO,"endsWithO");
            OperationsWithListsOfPeople.ShowSavedList(underEighteen,"underEighteen");
            OperationsWithListsOfPeople.ShowSavedList(betweenEighteenAndSixty,"betweenEighteenAndSixty");
            OperationsWithListsOfPeople.ShowCountOfPeople(resultSetContainsA,"resultSetContainsA\n");
            OperationsWithListsOfPeople.ShowCountOfPeople(resultSetOverEighteen,"resultSetOverEighteen\n");
        }
        catch(SQLException e){
            System.out.println("Error"+e.getMessage());
        }
    }
}