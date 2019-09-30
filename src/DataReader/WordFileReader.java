package DataReader;

import ProjectMain.ProjectConstants;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.util.ArrayList;

public class WordFileReader implements Readable {

    public ArrayList<String> sentences = new ArrayList<String>();

    @Override
    public Readable openFile(String fileName) {

        try {
            FileInputStream fis = new FileInputStream(fileName);
            XWPFDocument doc = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
            String lines[] = extractor.getText().split("\\n\\r");
            for(String line : lines)
            {
                sentences.add(line);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
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
        return ProjectConstants.wordFile;
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
