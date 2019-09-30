package ProjectMain;

import Database.DBBuilder;
import Database.DBObject;
import Utility.Helper;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.xmlbeans.impl.jam.JSourcePosition;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class User {

    public String name;
    public String email;
    public String password;
    public ArrayList<String> files = new ArrayList<String>();
    public ArrayList<String> results = new ArrayList<String>();
    public ArrayList<String> date = new ArrayList<String>();
    public ArrayList<String> time = new ArrayList<String>();
    public ArrayList<String> language = new ArrayList<String>();

    public boolean isInitilized;

    private int currentDisplayPointer = 0;

    public User(String email , String password)
    {
        init(email , password);
    }

    private void init(String email , String password)
    {
        this.email   = email;
        this.password   = password;

        ArrayList<String> pcol = new ArrayList<String>();
        ArrayList<String> pval = new ArrayList<String>();

        pcol.add("email");
        pval.add(email);
        JSONObject fetchLoginJson = Helper.getInstance().createFetchJson("login" , pcol , pval);
        JSONObject fetchHistoryJson = Helper.getInstance().createFetchJson("history" , pcol , pval);
        DBObject db = DBBuilder.connectDB("mysql" , "plagarism" , "root" , "");
        db.open();
        JSONObject refetchObject = db.fetch(fetchLoginJson);
        JSONObject reHistoryObject = db.fetch(fetchHistoryJson);

        if(refetchObject != null && reHistoryObject != null)
        {
            JSONObject loginDetails = (JSONObject)( (JSONArray)refetchObject.get("Result") ).get(0);
            this.name = (String)loginDetails.get("name");
            System.out.println(this.name);
            JSONObject historyDetails = (JSONObject)( (JSONArray)reHistoryObject.get("Result") ).get(0);
            System.out.println(historyDetails.toString());
            String fileNames[] = ((String)historyDetails.get("files")).split("\\,");
            String results[] = ((String)historyDetails.get("results")).split(",%,");
            String dates[] = ((String)historyDetails.get("date")).split("\\,");
            String times[] = ((String)historyDetails.get("time")).split("\\,");
            String languages[] = ((String)historyDetails.get("language")).split("\\,");

            for(int itr = 0 ; itr < fileNames.length ; itr++)
            {
                if(!fileNames[itr].equals("")){
                    this.files.add(fileNames[itr]);
                    this.results.add(results[itr]);
                    this.date.add(dates[itr]);
                    this.time.add(times[itr]);
                    this.language.add(languages[itr]);
                }
            }
            isInitilized = true;
        }
        else{
            isInitilized = false;
        }
        if(this.results.size() != 0)
        {
            currentDisplayPointer = this.results.size()-1;
        }
        else{
            currentDisplayPointer = 0;
        }

    }

    public void showNextResult(JLabel fileName , JTextArea result , JLabel date , JLabel time , JLabel language)
    {
        result.setEditable(true);
        if(files.size() > 0) {
            currentDisplayPointer++;
            if (!(currentDisplayPointer < this.files.size())) {
                currentDisplayPointer--;
            }
            fileName.setText(this.files.get(currentDisplayPointer));
            result.setText(this.results.get(currentDisplayPointer));
            date.setText(this.date.get(currentDisplayPointer));
            time.setText(this.time.get(currentDisplayPointer));
            language.setText(this.language.get(currentDisplayPointer));
        }
        result.setEditable(false);
    }

    public void showPreviousResult(JLabel fileName , JTextArea result , JLabel date , JLabel time , JLabel language)
    {
        result.setEditable(true);
        if(files.size() > 0) {
            currentDisplayPointer--;
            if (!(currentDisplayPointer > 0)) {
                currentDisplayPointer = 0;
            }
            fileName.setText(this.files.get(currentDisplayPointer));
            result.setText(this.results.get(currentDisplayPointer));
            date.setText(this.date.get(currentDisplayPointer));
            time.setText(this.time.get(currentDisplayPointer));
            language.setText(this.language.get(currentDisplayPointer));
        }
        result.setEditable(false);

    }

}
