package TranslationService;

import ProjectMain.ProjectConstants;

public class TranslatorBuilder {

    public static Translator createTranslator(String serviceName)
    {
        if(serviceName.toLowerCase().equals(ProjectConstants.Yandex.toLowerCase()))
        {
            return new YandexService();
        }

        return null;
    }

}
