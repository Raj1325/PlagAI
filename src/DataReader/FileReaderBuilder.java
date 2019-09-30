package DataReader;


import ProjectMain.ProjectConstants;

public class FileReaderBuilder {

    public static Readable  createReader(String fileName , String data){

        Readable  objectToReturn = null;

        if( fileName.toLowerCase().contains( ProjectConstants.txtExtension.toLowerCase() ) && data=="" ){
            objectToReturn = new TextFileReader().openFile(fileName);
        }
        else if( fileName.toLowerCase().contains( ProjectConstants.wordExtension.toLowerCase() ) && data=="" ){
            objectToReturn = new WordFileReader().openFile(fileName);
        }
        else if( fileName.toLowerCase().contains( ProjectConstants.pdfExtension.toLowerCase() ) && data=="" ) {
            objectToReturn = new PdfFileReader().openFile(fileName);
        }
        else if(data != null && fileName == "") {
            objectToReturn = new StringFile().openFile(data);
        }

        return objectToReturn;

    }

}
