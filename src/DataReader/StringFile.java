package DataReader;

import ProjectMain.ProjectConstants;

import java.io.*;
import java.util.ArrayList;

public class StringFile implements Readable {

    public ArrayList<String> sentences = new ArrayList<String>();

    @Override
    public Readable openFile(String text) {

        try {
            BufferedReader br = new BufferedReader(new StringReader(text));
            String str;
            while( (str=br.readLine()) != null )
            {
                sentences.add(str);
            }

        }
        catch(IOException E) {
            return null;
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
        return ProjectConstants.stringText;
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
