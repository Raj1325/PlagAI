package DataReader;

import ProjectMain.ProjectConstants;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PdfFileReader implements Readable {

    public ArrayList<String> sentences = new ArrayList<String>();

    @Override
    public Readable openFile(String fileName) {

        try {
            PDDocument document = PDDocument.load(new File(fileName) );

            PDFTextStripperByArea stripper = new PDFTextStripperByArea();
            stripper.setSortByPosition(true);

            PDFTextStripper tStripper = new PDFTextStripper();

            String pdfFileInText = tStripper.getText(document);

            // split by whitespace
            String lines[] = pdfFileInText.split("\\n\\r");
            for (String line : lines) {
                sentences.add(line);
            }

        }
        catch (InvalidPasswordException e)
        {
            e.printStackTrace();
            return null;
        }
        catch (IOException e){
            e.printStackTrace();
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
        return ProjectConstants.pdfFile;
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
