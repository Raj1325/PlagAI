package ProjectMain;

import Networking.Https;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class CopyLeakService {

    public class Result{
        String url ;
        long totalMatchedPercents;
        long totalMatchedWords;
        String title;
        String text;

        public Result(JSONObject data)
        {
            url = (String)data.get("url");
            totalMatchedPercents = (Long) data.get("totalMatchedPercents");
            totalMatchedWords = (Long) data.get("totalMatchedWords");
            title = (String)data.get("title");
            text  = (String)data.get("introduction");
        }
    }

    public ArrayList<Result> results = new ArrayList<>();
    String accessToken = "";
    String processId = "";

    public void login()
    {
        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();

        keys.add("Email");
        values.add(ProjectConstants.COPY_LEAK_EMAIL);

        keys.add("ApiKey");
        values.add(ProjectConstants.COPY_LEAK_KEY);


        Reader reader = Https.executeCustomQuery(true , ProjectConstants.COPY_LEAK_LOGIN ,
                keys , values , ProjectConstants.APP_JSON ,null , null);


        BufferedReader in = new BufferedReader(reader);
        String line = null;
        StringBuilder rslt = new StringBuilder();
        try {
            while ((line = in.readLine()) != null) {
                rslt.append(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(rslt.toString());


        JSONParser parser = new JSONParser();

        try {
            JSONObject obj = (JSONObject) parser.parse(rslt.toString());
            accessToken = (String)obj.get("access_token");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void createByText(String text)
    {
        Reader reader = Https.executeCustomQuery(true , ProjectConstants.COPY_LEAK_CREATE_TEXT ,
                null , null , ProjectConstants.APP_TEXT ,accessToken , text);


        BufferedReader in = new BufferedReader(reader);
        String line = null;
        StringBuilder rslt = new StringBuilder();
        try {
            while ((line = in.readLine()) != null) {
                rslt.append(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(rslt.toString());


        JSONParser parser = new JSONParser();

        try {
            JSONObject obj = (JSONObject) parser.parse(rslt.toString());
            processId = (String)obj.get("ProcessId");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public boolean isResultReady()
    {
        if( !processId.equals(""))
        {
            String url = ProjectConstants.COPY_LEAK_STATUS+processId+"/status";
            Reader reader = Https.executeCustomQuery(false , url ,
                    null , null , null ,accessToken , null);


            BufferedReader in = new BufferedReader(reader);
            String line = null;
            StringBuilder rslt = new StringBuilder();
            try {
                while ((line = in.readLine()) != null) {
                    rslt.append(line);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            if(Plagarism.guiObject != null)
            {
                Plagarism.guiObject.setTitle(rslt.toString());
            }

            JSONParser parser = new JSONParser();

            try {
                JSONObject obj = (JSONObject) parser.parse(rslt.toString());
                String status = (String)obj.get("Status");
                return status.equals("Finished");

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public String getResult()
    {
        String url = ProjectConstants.COPY_LEAK_RESULT+processId+"/result";
        Reader reader = Https.executeCustomQuery(false , url ,
                null , null , null ,accessToken , null);


        BufferedReader in = new BufferedReader(reader);
        String line = null;
        StringBuilder rslt = new StringBuilder();
        try {
            while ((line = in.readLine()) != null) {
                rslt.append(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //System.out.println(rslt.toString());


        JSONParser parser = new JSONParser();

        try {
            JSONObject obj = (JSONObject) parser.parse(rslt.toString());
            JSONArray resultArray = (JSONArray) obj.get("results");
            for(int itr=0 ; itr < resultArray.size() ; itr++)
            {
                JSONObject resObj = (JSONObject)resultArray.get(itr);
                results.add(new Result(resObj));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        String result = "";
        Result atomicRes;
        for(int itr = 0 ; itr < results.size() ; itr++)
        {
            atomicRes = results.get(itr);
            result += "url: "+atomicRes.url+"\n";
            result += "totalMatchPercentage: "+atomicRes.totalMatchedPercents+"\n";
            result += "totalMatchedWords: "+atomicRes.totalMatchedWords+"\n";
            result += "text: "+atomicRes.text+"\n";
            result += "\n\n";
        }

        return result;
    }
}
