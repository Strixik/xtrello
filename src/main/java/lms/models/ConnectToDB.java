package lms.models;

public abstract class ConnectToDB {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/mydb?user=root&password=2259";

    public ConnectToDB(){
        try {
            Class.forName(JDBC_DRIVER).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
