package TranslationService;

import java.util.AbstractMap;

public interface Translator {

    boolean getSupportedLanguages();

    AbstractMap.SimpleEntry<String,String> detectLanguage(String text);

    String translateText(String text , String translationDirection);


}
