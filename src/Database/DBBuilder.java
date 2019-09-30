package Database;

public class DBBuilder {

    public static DBObject connectDB(String dbProvider ,
                                     String dbName ,
                                     String userName ,
                                     String password)
    {

        DBObject returnObject = null;

        if(dbProvider.equals("mysql"))
        {
            returnObject = new MysqlDB(dbName , userName , password , "localhost");
        }

        return returnObject;

    }

}
