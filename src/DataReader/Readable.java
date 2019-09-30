package DataReader;

public interface Readable {

    Readable openFile(String fileName);

    void displayContents();

    int getDocumentType();

    String getContent(int index);

    int getTotalSentences();
}
