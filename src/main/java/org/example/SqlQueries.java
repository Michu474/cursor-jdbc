package org.example;

public class SqlQueries {
    public static final String CREATE_TABLE = """
        CREATE TABLE IF NOT EXISTS user (
        id int PRIMARY KEY AUTO_INCREMENT,
        first_name varchar(50),
        last_name varchar(50),
        age int)
         """;
    public static final String DROP_TABLE = """
        DROP TABLE IF EXISTS user;
         """;
    public static final String INSERT_USERS = """
            insert into `cursor-jdbc`.`user` (`first_name`,`last_name`,`age`) values\s
            ('Anjelo','Burnam','12'),('Lilly','Page','10'),('Samantha','Ride','54'),('Carl','Swanson','36'),('Peter','Griffin','43')
            ,('Gandalf','Grey','11000'),('Dobby','Freeman','20'),('Sherlock','Holmes','30'),('John','Doe','10'),('Arnold','Schwarzenegger','54');
                        
            """;
    public static final String SELECT_USERS_UNDER_18 = """
            SELECT * FROM `cursor-jdbc`.user where age<'18';
                        
            """;
    public static final String SELECT_USERS_BETWEEN_18_60 = """
            SELECT * FROM `cursor-jdbc`.user where age between 18 and 60;
                        
            """;
    public static final String SELECT_USERS_ENDS_WITH_O = """
             SELECT * FROM `cursor-jdbc`.user where first_name like '%o';
                        
            """;
}
