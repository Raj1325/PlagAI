package DataReader;

import ProjectMain.ProjectConstants;

import java.io.*;
import java.util.ArrayList;

public class TextFileReader implements Readable {

    public ArrayList<String> sentences = new ArrayList<String>();

    @Override
    public Readable openFile(String fileName) {

        File fileObj = new File(fileName);
        if( !fileObj.exists()){
            return null;
        }

        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(fileName), "utf-8");
            BufferedReader br = new BufferedReader(reader);
            String str;
            while( (str=br.readLine()) != null )
            {
                sentences.add(str);
            }

        }
        catch(FileNotFoundException e)
        {
            System.err.println(" File Not Found : "+fileName);
            return null;
        }
        catch(IOException E) {
            System.err.println(" Error Reading File : " + fileName);
            return null;
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return this;

    }

    @Override
    public void displayContents() {

        for(String sentenc : sentences){
            System.out.println(sentenc);
        }

    }

    @Override
    public int getDocumentType() {
        return ProjectConstants.textFile;
    }

    @Override
    public String getContent(int index) {

        if(this.sentences != null)
        {
            return this.sentences.get(index);
        }

        return null;
    }

    @Override
    public int getTotalSentences() {
        if(this.sentences != null)
        {
            return this.sentences.size();
        }
        return 0;
    }

}
