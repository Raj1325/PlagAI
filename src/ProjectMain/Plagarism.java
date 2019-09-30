package ProjectMain;
import GUI.PlagGUI;
import org.apache.commons.text.StringEscapeUtils;


public class Plagarism {

    public static User currentUser;
    public static PlagGUI guiObject = null;

    public static void main(String args[]) {
        currentUser = null;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                guiObject = new PlagGUI();
                guiObject.setVisible(true);
            }
        });
        /*
        String s =  "url: https://en.wikipedia.org/wiki/Pranav_Mistry\n" +
                "totalMatchPercentage: 100\n" +
                "totalMatchedWords: 104\n" +
                "text: Mistry was born on 14 May 1981 in Palanpur, North Gujarat, India to Kirti Mistry and Nayna.[citation needed] He has two sisters, Jigna and Sweta. He completed his bachelor&#x27;s degree in Computer Science and Engineering from the Nirma Institute ...\n" +
                "\n" +
                "\n" +
                "url: https://www.quora.com/What-is-the-rank-of-a-student-in-the-JEE-who-is-getting-a-high-salary-package\n" +
                "totalMatchPercentage: 68\n" +
                "totalMatchedWords: 71\n" +
                "text: completed his bachelor&#x27;s degree in Computer Science and Engineering from the Nirma Institute of Technology in Ahmedabad, Gujarat. Pranav holds a master&#x27;s degree in Media Arts and Sciences from MIT and Master of Design from Industrial Desig\n" +
                "\n" +
                "\n" +
                "url: https://www.quora.com/Has-anyone-from-India-been-selected-into-MIT-for-an-undergraduate-course-Could-you-please-also-state-their-your-academic-record-extracurricular-activities-and-how-did-they-you-got-selected\n" +
                "totalMatchPercentage: 62\n" +
                "totalMatchedWords: 65\n" +
                "text: state in India. He has completed his Bachelor&#x27;s Degree in Computer Science and Engineering from the Nirma Institute of Technology in Ahmedabad, Gujarat. Pranav holds a Master&#x27;s degree in Media Arts and Sciences from MIT and Master of Design\n" +
                "\n" +
                "\n" +
                "url: https://www.procaffenation.com/man-latest-innovation-samsung-galaxy-gear-smartwatch/\n" +
                "totalMatchPercentage: 28\n" +
                "totalMatchedWords: 30\n" +
                "text: Pranav Mistry, the Global Senior Vice President of Research at Samsung and the head of Think Tank Team is the man behind Samsung Galaxy Gear Smartwatch.\n" +
                "\n" +
                "\n" +
                "url: https://www.facebook.com/PISPOOfficial/\n" +
                "totalMatchPercentage: 49\n" +
                "totalMatchedWords: 51\n" +
                "text: People INDIA should Proud of - PISPO. 39 likes. The people INDIA should Proud of are here...:)\n" +
                "\n" +
                "\n" +
                "url: http://www.compuhelpindia.com/tech-news.php\n" +
                "totalMatchPercentage: 89\n" +
                "totalMatchedWords: 93\n" +
                "text: d Sweta. He has completed his bachelor&#x27;s degree in Computer Science and Engineering from the Nirma Institute of Technology in Ahmedabad, Gujarat. Pranav holds a master&#x27;s degree in Media Arts and Sciences from MIT and Master of Design from I\n" +
                "\n" +
                "\n" +
                "url: http://eventstoryzone.blogspot.com/\n" +
                "totalMatchPercentage: 89\n" +
                "totalMatchedWords: 93\n" +
                "text: ए तुम्हे एक प्रश्न का उत्तर देना होगा ...और अगर तुम उत्तर न दे पायी तो तुम्हे हमेशा -हमेशा के लिए मेरा पीछा छोड़ना होगा ...” पत्नी का भूत बोला ,” मंजूर है ...पूछो अपना प्रश्न ” आदमी ने फ़ौरन ज़मीन पर पड़े बहुत सारे छोटे -छोटे कंकड़ अपनी मुट्ठी में\n" +
                "\n" +
                "\n" +
                "url: https://ohbly.com/technology/top-5-indian-hackers-you-should-know-famous-indian-hackers/\n" +
                "totalMatchPercentage: 26\n" +
                "totalMatchedWords: 28\n" +
                "text: Top 5 Indian Hackers You Should Know - Famous Indian Hackers - Hackers are always treated as celebrities,doesn't matter whether they fall under the ...\n" +
                "\n" +
                "\n" +
                "url: https://www.darpanmagazine.com/people/newsmakers/pranav-mistry-changing-the-face-of-technology/\n" +
                "totalMatchPercentage: 45\n" +
                "totalMatchedWords: 47\n" +
                "text: The computer genius has created some of the most thought-provoking interfaces till date &ndash; namely Quickies, sticky notes that can be searched and can send reminders; a&nbsp;pen that draws in 3D; TaPuMa, a tangible public map for the physical world;&nb\n" +
                "\n" +
                "\n" +
                "url: https://howlingpixel.com/i-en/Pranav_Mistry\n" +
                "totalMatchPercentage: 92\n" +
                "totalMatchedWords: 96\n" +
                "text: He has two sisters, Jigna and Sweta. He completed his bachelor&#x27;s degree in Computer Science and Engineering from the Nirma Institute of Technology in Ahmedabad, Gujarat. Pranav holds a master&#x27;s degree in Media Arts and Sciences from the ...\n" +
                "\n" +
                "\n" +
                "url: http://tophackersinindia.blogspot.com/2015/07/top-5-hackers-in-india.html\n" +
                "totalMatchPercentage: 87\n" +
                "totalMatchedWords: 91\n" +
                "text: Mistry was born on 14 May 1981 in Palanpur, North Gujarat, India to Kirti Mistry and Nayna. He has two sisters, Jigna and Sweta. He has completed his Bachelor&#x27;s Degree in Computer Science and Engineering from the Nirma Institute of Technology in\n" +
                "\n" +
                "\n" +
                "url: https://upclosed.com/people/pranav-mistry/\n" +
                "totalMatchPercentage: 90\n" +
                "totalMatchedWords: 94\n" +
                "text: completed his bachelor&#x27;s degree in Computer Science and Engineering from the Nirma Institute of Technology in Ahmedabad, Gujarat. Pranav holds a master&#x27;s degree in Media Arts and Sciences from MIT and Master of Design from Industrial Design\n" +
                "\n" +
                "\n" +
                "url: https://everipedia.org/wiki/Pranav_Mistry/\n" +
                "totalMatchPercentage: 90\n" +
                "totalMatchedWords: 94\n" +
                "text: Pranav Mistry's wiki:        Pranav Mistry  (born 14 May 1981) is a  computer scientist and Inventor. At present, he is the Global Senior Vice President of Research at  Samsung and the head of Think Tank Team. He is best known for his work on  SixthSense, \n" +
                "\n" +
                "\n" +
                "url: https://wikivisually.com/wiki/SixthSense\n" +
                "totalMatchPercentage: 89\n" +
                "totalMatchedWords: 93\n" +
                "text: The entire wikipedia with video and photo galleries for each article. Find something interesting to watch in seconds.\n" +
                "\n" +
                "\n" +
                "url: https://www.guidetogo.in/pranav-mistry-2/\n" +
                "totalMatchPercentage: 89\n" +
                "totalMatchedWords: 93\n" +
                "text: FSDFS\"DFS";
        System.out.println(s.replaceAll("\'" , ""));*/

    }

}
