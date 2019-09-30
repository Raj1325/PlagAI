package Database;

import org.json.simple.JSONObject;

public interface DBObject {

    public void open();

    public boolean insert(JSONObject data);

    public boolean update(JSONObject data);

    public JSONObject fetch(JSONObject metaData);

    public boolean isConnected();

    public void close();

}
