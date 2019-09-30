package Utility;

import Database.DBBuilder;
import Database.DBObject;
import ProjectMain.ProjectConstants;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Helper {


    private Helper(){};

    private static class SingletonHelper{
        private static final Helper instance = new Helper();
    }

    public static Helper getInstance()
    {
        return SingletonHelper.instance;
    }

    public JSONObject createUpdateJson(String tableName,
                                       String primaryCol,
                                       String primaryVal,
                                       ArrayList<String> colToUpdate,
                                       ArrayList<String> colNewValue)
    {

        String json = "{\"tableName\":\""+tableName+"\",";
        json += "\"primaryCol\":\""+primaryCol+"\",";
        json += "\"primaryValue\":\""+primaryVal+"\",";
        json += "\"values\":{";

        for(int itr=0 ; itr < colToUpdate.size() ; itr++)
        {
            json += "\""+colToUpdate.get(itr)+"\":\""+colNewValue.get(itr)+"\",";
            if(itr <(colToUpdate.size()-1))
            {
                json += ",";
            }
        }

        json += "} }";

        JSONObject returnObject = null;
        JSONParser parser = new JSONParser();
        try {
            returnObject = (JSONObject)parser.parse(json);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return returnObject;
    }

    public JSONObject createInsertJson(String tableName,
                                       ArrayList<String> cols,
                                       ArrayList<String> values)
    {

        String json = "{";
        json += "\"tableName\":\""+tableName+"\",";
        json += "\"values\" : {";
        for(int itr = 0 ; itr < cols.size() ; itr++)
        {
            json += "\""+cols.get(itr)+"\":\""+values.get(itr)+"\"";
            if(itr < (cols.size()-1) )
            {
                json += ",";
            }
        }

        json += "}}";

        JSONParser parser = new JSONParser();
        JSONObject obj = null;

        try {
            obj = (JSONObject)parser.parse(json);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  obj;

    }

    public JSONObject createFetchJson(String tableName,
                                      ArrayList<String> cols,
                                      ArrayList<String> values)
    {

        String json = "{";
        json += "\"tableName\":\""+tableName+"\",";
        json += "\"primaryValues\": {";

        for(int itr = 0 ; itr < cols.size() ; itr++)
        {
            json += "\""+cols.get(itr)+"\":\""+values.get(itr)+"\"";
            if(itr < (cols.size()-1) )
            {
                json += ",";
            }
        }
        json += "}}";

        JSONParser parser = new JSONParser();
        JSONObject obj = null;

        try {
            obj = (JSONObject)parser.parse(json);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  obj;

    }

    public void openFileInOS(String fileName)
    {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(fileName));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public int validateLogin(String email , String password)
    {
        int status = ProjectConstants.ALL_GOOD;
        ArrayList<String> primaryCol = new ArrayList<String>();
        ArrayList<String> values   = new ArrayList<String>();

        primaryCol.add("email");
        values.add(email);
        JSONObject fetchJson = createFetchJson("login" , primaryCol , values);

        DBObject db = DBBuilder.connectDB("mysql" , "plagarism" , "root" , "");
        db.open();
        JSONObject JsonResult = db.fetch(fetchJson);
        if(JsonResult != null)
        {
            JSONArray resultArray = (JSONArray)JsonResult.get("Result");
            String actualPassword = (String)( ((JSONObject)(resultArray.get(0)) ).get("password"));
            if(!actualPassword.equals(password))
            {
                status = ProjectConstants.INVALID_PASSWORD;
            }
        }
        else
        {
            status = ProjectConstants.INVALID_EMAIL;
        }
        return status;
    }

}
