package TranslationService;

import Networking.Https;
import ProjectMain.Plagarism;
import ProjectMain.ProjectConstants;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class YandexService implements Translator{

    public boolean hasLanguageDB            = false;
    public HashMap<String,String> langCode  = new HashMap<String , String>();

    public YandexService()
    {
        getSupportedLanguages();
        hasLanguageDB = true;
    }

    @Override
    public boolean getSupportedLanguages() {
        ArrayList<String>keys       = new ArrayList<String>();
        ArrayList<String>values     = new ArrayList<String>();

        keys.add("key");
        values.add(ProjectConstants.YandexKey);

        keys.add("ui");
        values.add("en");

        Reader reader = Https.executeQuery(ProjectConstants.YandexSupport , keys , values );
        JSONParser parser = new JSONParser();
        String key = "";
        try {
            JSONObject obj = (JSONObject)parser.parse(reader);
            JSONObject langs = (JSONObject)obj.get("langs");
            Set keysSet = langs.keySet();
            Iterator<String> it  = keysSet.iterator();
            while(it.hasNext())
            {
                key = it.next();
                langCode.put(key , (String)langs.get(key));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return hasLanguageDB;
    }

    @Override
    public AbstractMap.SimpleEntry<String,String> detectLanguage(String text) {

        ArrayList<String> keys       = new ArrayList<String>();
        ArrayList<String> values     = new ArrayList<String>();

        keys.add("key");
        values.add(ProjectConstants.YandexKey);

        keys.add("text");
        values.add(text);

        Reader reader = Https.executeQuery(ProjectConstants.YandexDetect , keys , values );
        JSONParser parser = new JSONParser();

        try{
            JSONObject obj = (JSONObject)parser.parse(reader);
            String code    = (String)obj.get("lang");
            String value   = langCode.get(code);
            AbstractMap.SimpleEntry<String,String> keyValPair = new AbstractMap.SimpleEntry<String,String>(code , value);
            return keyValPair;
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e .printStackTrace();
        }

        return null;
    }

    @Override
    public String translateText(String text , String translationDirection) {

        ArrayList<String>keys       = new ArrayList<String>();
        ArrayList<String>values     = new ArrayList<String>();

        keys.add("key");
        values.add(ProjectConstants.YandexKey);

        keys.add("text");
        values.add(text);

        keys.add("lang");
        values.add(translationDirection);

        if(Plagarism.guiObject != null)
        {
            Plagarism.guiObject.setTitle("Translating Text...");
        }
        Reader reader = Https.executeQuery(ProjectConstants.YandexTranslate , keys , values );
        JSONParser parser = new JSONParser();
        try{
            JSONObject obj = (JSONObject)parser.parse(reader);
            String result = "";
            if(obj.containsKey("text")) {
                result = (String) ((((JSONArray) obj.get("text")).get(0)));
            }
            if(Plagarism.guiObject != null)
            {
                Plagarism.guiObject.setTitle("");
            }
            return result;

        }
        catch (ParseException e)
        {
            e.printStackTrace();
            if(Plagarism.guiObject != null)
            {
                Plagarism.guiObject.setTitle("Error Translating...");
            }
        }
        catch(IOException e)
        {
            if(Plagarism.guiObject != null)
            {
                Plagarism.guiObject.setTitle("Error Translating...");
            }
            e.printStackTrace();
        }

        return null;
    }
}
