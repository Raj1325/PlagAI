package Database;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MysqlDB implements DBObject {

    public String dbName;
    public String user;
    public String password;
    public String driver;
    public String location;
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;
    public boolean isAlive;

    public MysqlDB(String dbName , String user , String password , String location)
    {
        this.dbName = dbName;
        this.user   = user;
        this.password = password;
        this.location = location;
        this.driver = "com.mysql.jdbc.Driver";
    }

    @Override
    public void open() {

        try {
            Class.forName(driver);
            String url = "jdbc:mysql://"+location+"/"+dbName;
            this.conn = DriverManager.getConnection(url,user,password);
            this.isAlive = true;
            this.stmt = conn.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean insert(JSONObject data) {
        boolean status = true;
        String tableName = (String) data.get("tableName");
        ArrayList<String> colNames = new ArrayList<String>();
        ArrayList<String> values = new ArrayList<String>();
        JSONObject valueObj = (JSONObject) data.get("values");

        for (Iterator itr = valueObj.keySet().iterator(); itr.hasNext(); ) {
            String key = (String) itr.next();
            colNames.add(key);
            values.add((String) valueObj.get(key));
        }

        String query = "INSERT INTO " + tableName + " (";
        for (int itr = 0; itr < colNames.size(); itr++){

            query += colNames.get(itr);
            if(itr < (colNames.size()-1))
            {
                query += ",";
            }

        }
        query += ") VALUES (";

        for (int itr = 0; itr < values.size(); itr++){

            query += "'"+values.get(itr)+"'";
            if(itr < (values.size()-1))
            {
                query += ",";
            }

        }
        query += ");";
        try {
            System.out.println(query);
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            //e.printStackTrace();
            status = false;
        }
        //System.out.println(query);
        return status;

    }

    @Override
    public boolean update(JSONObject data) {
        boolean status = true;
        String tableName = (String) data.get("tableName");
        String primaryCol = (String) data.get("primaryCol");
        String primaryValue = (String) data.get("primaryValue");
        ArrayList<String> colNames = new ArrayList<String>();
        ArrayList<String> values = new ArrayList<String>();
        JSONObject valueObj = (JSONObject) data.get("values");

        for (Iterator itr = valueObj.keySet().iterator(); itr.hasNext(); ) {
            String key = (String) itr.next();
            colNames.add(key);
            values.add((String) valueObj.get(key));
        }

        String query = "UPDATE " + tableName + " SET ";
        for (int itr = 0; itr < colNames.size(); itr++){

            query += colNames.get(itr);
            query += "=";
            query += "'"+values.get(itr)+"'";
            if(itr < (colNames.size()-1))
            {
                query += ",";
            }

        }

        query += " WHERE "+primaryCol+"='"+primaryValue+"';";
        System.out.println(query);
        try {
            stmt.executeUpdate(query);
            System.out.println("Updated Values...");
        } catch (SQLException e) {
            e.printStackTrace();
            status = false;
        }

        return status;
    }

    @Override
    public JSONObject fetch(JSONObject metaData) {


        ArrayList<String> metaKeys     = new ArrayList<String>();
        ArrayList<String> metaValues   = new ArrayList<String>();

        String tableName = (String)metaData.get("tableName");
        JSONObject primaryObject = (JSONObject) metaData.get("primaryValues");
        for(Iterator it = primaryObject.keySet().iterator() ; it.hasNext() ; )
        {
            String key = (String)it.next();
            metaKeys.add(key);
            metaValues.add((String)primaryObject.get(key));
        }

        ArrayList<String> cols = getColumnNamesFromTable(tableName);

        String query = "Select * from "+tableName+" where ";
        for(int itr = 0 ; itr < metaKeys.size() ; itr++)
        {
            query += metaKeys.get(itr) + "='" + metaValues.get(itr)+"'";
            if(itr < (metaKeys.size()-1))
            {
                query += " and ";
            }
        }

        System.out.println(query);
        String JsonString = "{ \"Result\" : [";
        try {
            rs = stmt.executeQuery(query);
            while (rs.next())
            {
                JsonString += " { ";
                for(int itr=0 ; itr < cols.size() ; itr++)
                {
                    JsonString += "\""+cols.get(itr)+"\"" + ":" + "\""+rs.getString(cols.get(itr))+"\"";
                    if(itr < (cols.size()-1))
                    {
                        JsonString += ",";
                    }
                }
                JsonString += "},";
            }
            JsonString = JsonString.substring(0 , JsonString.length()-1);
            JsonString += "]}";
        } catch (SQLException e) {
            //e.printStackTrace();
            return null;
        }

        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        try {
            obj = (JSONObject)parser.parse(JsonString);
        } catch (ParseException e) {
            //e.printStackTrace();
            obj = null;
        }
        return obj;
    }

    @Override
    public boolean isConnected() {
        return this.isAlive;
    }

    @Override
    public void close() {

        try {
            isAlive = false;
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> getColumnNamesFromTable(String tableName)
    {
        ArrayList<String> cols   = new ArrayList<String>();

        String query = "SHOW COLUMNS FROM "+tableName+";";
        System.out.println(query);
        try {
            rs = stmt.executeQuery(query);
            while(rs.next())
            {
                cols.add(rs.getString("Field"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  cols;
    }
}
