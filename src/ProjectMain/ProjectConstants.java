package ProjectMain;

public class ProjectConstants {

    //File Constants
    public static int wordFile = 1;
    public static int pdfFile  = 2;
    public static int textFile = 3;
    public static int stringText = 4;

    public static String txtExtension  = ".txt";
    public static String wordExtension = ".docx";
    public static String pdfExtension  = ".pdf";
    public static String unknownExtension  = "unknown";

    public static char fullStop         = '.';
    public static char questionMark     = '?';
    public static char newLine          = '\n';

    public static int InvalidParameter      = 502;
    public static int InvalidApikey         = 401;
    public static int OperationSuccessfull  = 200;
    public static int BlockedAPIKey         = 402;
    public static int ExceededLimit         = 404;

    public static String YandexSupport      = "https://translate.yandex.net/api/v1.5/tr.json/getLangs";
    public static String YandexDetect       = "https://translate.yandex.net/api/v1.5/tr.json/detect";
    public static String YandexTranslate    = "https://translate.yandex.net/api/v1.5/tr.json/translate";
    public static String YandexKey          = "trnsl.1.1.20180803T043237Z.135e5cb693c8dcef.74a39521687e200996dc01b9768b0b710b1fee2d";
    public static String Yandex             = "Yandex";

    public static String COPY_LEAK_LOGIN    = "https://api.copyleaks.com/v1/account/login-api";
    public static String COPY_LEAK_CREATE_TEXT  = "https://api.copyleaks.com/v1/businesses/create-by-text";
    public static String COPY_LEAK_CREATE_FILE  = "https://api.copyleaks.com/v2/businesses/create-by-file";
    public static String COPY_LEAK_STATUS       = "https://api.copyleaks.com/v1/businesses/";
    public static String COPY_LEAK_RESULT       = "https://api.copyleaks.com/v2/businesses/";
    public static String COPY_LEAK_KEY   = "7743793A-2F92-430B-91AF-D2998639EA86";
    public static String COPY_LEAK_EMAIL = "stenil.stephen07@gmail.com";

    public static String APP_JSON   = "application/json";
    public static String APP_TEXT   = "text/plain";

    public static int ALL_GOOD              = 0;
    public static int INVALID_EMAIL         = 1;
    public static int INVALID_PASSWORD      = 2;

    public static int TEXT_TAB              = 0;
    public static int FILE_TAB              = 1;


}
