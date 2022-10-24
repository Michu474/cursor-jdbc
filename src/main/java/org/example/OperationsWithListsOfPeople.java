package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OperationsWithListsOfPeople {
    public static ArrayList<User> fillTheListWith(ResultSet resultSet, ArrayList<User> arrayList){
        try {
            while(resultSet.next())
            {

            User user = new User();


                user.setId(resultSet.getInt("id"));
                user.setAge(resultSet.getInt("age"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                arrayList.add(user);

            }

            return arrayList;

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }




    }
    public static void ShowSavedList(ArrayList<User> arrayList){
        for (User user:arrayList) {

            System.out.println(user.getFirst_name()+" "+ user.getLast_name()+" "+ user.getAge());


        }

    }
}

