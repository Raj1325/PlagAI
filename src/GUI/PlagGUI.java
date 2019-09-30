package GUI;

import DataReader.FileReaderBuilder;
import DataReader.Readable;
import Database.DBBuilder;
import Database.DBObject;
import ProjectMain.CopyLeakService;
import ProjectMain.Plagarism;
import ProjectMain.ProjectConstants;
import ProjectMain.User;
import TranslationService.Translator;
import TranslationService.TranslatorBuilder;
import TranslationService.YandexService;
import Utility.Helper;
import org.apache.http.entity.StringEntity;
import org.json.simple.JSONObject;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.Time;
import java.util.*;

public class PlagGUI extends javax.swing.JFrame {

    private javax.swing.JPanel LoginPagePanel;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JLabel LogoLabel;
    private javax.swing.JLabel LogoLabel1;
    private javax.swing.JLabel LogoLabel2;
    private javax.swing.JLabel LogoLabel3;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JMenuItem MenuActivity;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem MenuLogout;
    private javax.swing.JMenuItem MenuProfile;
    private javax.swing.JMenu MyMenu;
    private javax.swing.JPanel ProfilePanel;
    private javax.swing.JTabbedPane ProfileTabPane;
    private javax.swing.JPanel SignUpFormPanel;
    private javax.swing.JPanel SignUpPanel;
    private javax.swing.JPanel SiguUpFormPanel;
    private javax.swing.JTextArea TextSplitFan1;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnChooseFile;
    private javax.swing.JButton btnFileTranslate;
    private javax.swing.JButton btnHistoryBack;
    private javax.swing.JButton btnHistoryNext;
    private javax.swing.JButton btnProfileChangePassword;
    private javax.swing.JButton btnProfilePaneBack;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JButton btnSignUpBack;
    private javax.swing.JButton btnSignUpRegister;
    private javax.swing.JButton btnTextTranslate;
    private javax.swing.JComboBox<String> chooseFileComboBox;
    private javax.swing.JTextArea chooseFileSplitPan1;
    private javax.swing.JTextArea chooseFileSplitPan2;
    private javax.swing.JSplitPane chooseFileSplitPanMenu;
    private javax.swing.JLabel chooseFileTargetLanguage;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblHistoryDate;
    private javax.swing.JLabel lblHistoryDateActual;
    private javax.swing.JLabel lblHistoryFileName;
    private javax.swing.JLabel lblHistoryFileNameStatic;
    private javax.swing.JLabel lblHistoryLanguage;
    private javax.swing.JLabel lblHistoryLanguageActual;
    private javax.swing.JLabel lblHistoryResultstatic;
    private javax.swing.JLabel lblHistoryTime;
    private javax.swing.JLabel lblHistoryTimeActual;
    private javax.swing.JLabel lblLanguage;
    private javax.swing.JLabel lblLoginError;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblProfileChangePassError;
    private javax.swing.JLabel lblProfileConPassword;
    private javax.swing.JLabel lblProfileCurrPassword;
    private javax.swing.JLabel lblProfileEmail;
    private javax.swing.JLabel lblProfileEmailActual;
    private javax.swing.JLabel lblProfileName;
    private javax.swing.JLabel lblProfileNameActual;
    private javax.swing.JLabel lblProfileNewPassword;
    private javax.swing.JLabel lblSigiupError;
    private javax.swing.JLabel lblSignUpFormConPass;
    private javax.swing.JLabel lblSignUpFormEmail;
    private javax.swing.JLabel lblSignUpFormName;
    private javax.swing.JLabel lblSignUpFormPassword;
    private javax.swing.JLabel lblSignUpText;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTabbedPane menuTabPan;
    private javax.swing.JPanel tabUserHistory;
    private javax.swing.JPanel tabUserInfo;
    private javax.swing.JTextArea textSplitPan2;
    private javax.swing.JSplitPane textSplitPanMenu;
    private javax.swing.JTextArea txtHistory;
    private javax.swing.JLabel txtLanguage;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtProfileConfPass;
    private javax.swing.JPasswordField txtProfileCurrPass;
    private javax.swing.JPasswordField txtProfileNewPass;
    private javax.swing.JPasswordField txtSignUpFormConPass;
    private javax.swing.JTextField txtSignUpFormEmail;
    private javax.swing.JTextField txtSignUpFormName;
    private javax.swing.JPasswordField txtSignUpFormPassword;
    private javax.swing.JTextField txtUserName;

    boolean TextSplitFan1FocusGained = false;
    boolean TextSplitFan1FocusLost = false;
    boolean TextSplitFan1TextChanged = false;

    CardLayout pages   = new java.awt.CardLayout();
    HashMap<String , String> languageCode = new HashMap<>();
    File selectedFile = null;

    public PlagGUI() {
        initComponents();
    }

    private void initComponents() {

        LoginPagePanel = new javax.swing.JPanel();
        LoginPanel = new javax.swing.JPanel();
        lblUserName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        lblLoginError = new javax.swing.JLabel();
        SignUpPanel = new javax.swing.JPanel();
        lblSignUpText = new javax.swing.JLabel();
        btnSignUp = new javax.swing.JButton();
        LogoLabel = new javax.swing.JLabel();
        SiguUpFormPanel = new javax.swing.JPanel();
        SignUpFormPanel = new javax.swing.JPanel();
        lblSignUpFormName = new javax.swing.JLabel();
        lblSignUpFormEmail = new javax.swing.JLabel();
        lblSignUpFormPassword = new javax.swing.JLabel();
        lblSignUpFormConPass = new javax.swing.JLabel();
        txtSignUpFormName = new javax.swing.JTextField();
        txtSignUpFormEmail = new javax.swing.JTextField();
        txtSignUpFormPassword = new javax.swing.JPasswordField();
        txtSignUpFormConPass = new javax.swing.JPasswordField();
        btnSignUpRegister = new javax.swing.JButton();
        lblSigiupError = new javax.swing.JLabel();
        LogoLabel1 = new javax.swing.JLabel();
        btnSignUpBack = new javax.swing.JButton();
        MainPanel = new javax.swing.JPanel();
        LogoLabel2 = new javax.swing.JLabel();
        menuTabPan = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        textSplitPanMenu = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextSplitFan1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        textSplitPan2 = new javax.swing.JTextArea();
        btnTextTranslate = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnChooseFile = new javax.swing.JButton();
        chooseFileSplitPanMenu = new javax.swing.JSplitPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        chooseFileSplitPan1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        chooseFileSplitPan2 = new javax.swing.JTextArea();
        btnFileTranslate = new javax.swing.JButton();
        chooseFileComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        chooseFileTargetLanguage = new javax.swing.JLabel();
        lblLanguage = new javax.swing.JLabel();
        txtLanguage = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        ProfilePanel = new javax.swing.JPanel();
        LogoLabel3 = new javax.swing.JLabel();
        ProfileTabPane = new javax.swing.JTabbedPane();
        tabUserInfo = new javax.swing.JPanel();
        lblProfileName = new javax.swing.JLabel();
        lblProfileEmail = new javax.swing.JLabel();
        lblProfileNameActual = new javax.swing.JLabel();
        lblProfileEmailActual = new javax.swing.JLabel();
        btnChangePassword = new javax.swing.JButton();
        lblProfileCurrPassword = new javax.swing.JLabel();
        lblProfileNewPassword = new javax.swing.JLabel();
        lblProfileConPassword = new javax.swing.JLabel();
        txtProfileNewPass = new javax.swing.JPasswordField();
        txtProfileConfPass = new javax.swing.JPasswordField();
        btnProfileChangePassword = new javax.swing.JButton();
        lblProfileChangePassError = new javax.swing.JLabel();
        txtProfileCurrPass = new javax.swing.JPasswordField();
        tabUserHistory = new javax.swing.JPanel();
        lblHistoryFileNameStatic = new javax.swing.JLabel();
        lblHistoryFileName = new javax.swing.JLabel();
        lblHistoryResultstatic = new javax.swing.JLabel();
        btnHistoryNext = new javax.swing.JButton();
        btnHistoryBack = new javax.swing.JButton();
        lblHistoryDate = new javax.swing.JLabel();
        lblHistoryDateActual = new javax.swing.JLabel();
        lblHistoryTime = new javax.swing.JLabel();
        lblHistoryTimeActual = new javax.swing.JLabel();
        lblHistoryLanguage = new javax.swing.JLabel();
        lblHistoryLanguageActual = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtHistory = new javax.swing.JTextArea();
        btnProfilePaneBack = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        MyMenu = new javax.swing.JMenu();
        MenuProfile = new javax.swing.JMenuItem();
        MenuActivity = new javax.swing.JMenuItem();
        MenuLogout = new javax.swing.JMenuItem();

        ArrayList<String> supportedLanguage = new ArrayList<String>();
        Translator yandex = (YandexService)TranslatorBuilder.createTranslator(ProjectConstants.Yandex);
        Iterator it = ((YandexService) yandex).langCode.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            supportedLanguage.add((String) pair.getValue());
            languageCode.put((String) pair.getValue(), (String) pair.getKey());
            it.remove();
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(pages);

        LoginPagePanel.setBackground(new java.awt.Color(102, 102, 102));
        LoginPagePanel.setForeground(new java.awt.Color(255, 255, 255));

        LoginPanel.setBackground(new java.awt.Color(6, 99, 127));
        LoginPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Existing User", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        LoginPanel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        lblUserName.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 255, 255));
        lblUserName.setText("User");

        lblPassword.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password");

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login!");
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblLoginError.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        lblLoginError.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
                LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LoginPanelLayout.createSequentialGroup()
                                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtUserName)
                                        .addComponent(txtPassword))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(92, 92, 92))
                        .addGroup(LoginPanelLayout.createSequentialGroup()
                                .addComponent(lblLoginError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(45, 45, 45))
        );
        LoginPanelLayout.setVerticalGroup(
                LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LoginPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblUserName)
                                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPassword)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblLoginError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SignUpPanel.setBackground(new java.awt.Color(112, 161, 159));
        SignUpPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "New User", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        SignUpPanel.setForeground(new java.awt.Color(255, 255, 255));
        SignUpPanel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        lblSignUpText.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblSignUpText.setForeground(new java.awt.Color(255, 255, 255));
        lblSignUpText.setText("SignUp, to use the service...");

        btnSignUp.setBackground(new java.awt.Color(102, 102, 102));
        btnSignUp.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnSignUp.setForeground(new java.awt.Color(255, 255, 255));
        btnSignUp.setText("SignUp!");
        btnSignUp.setBorderPainted(false);
        btnSignUp.setFocusPainted(false);
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SignUpPanelLayout = new javax.swing.GroupLayout(SignUpPanel);
        SignUpPanel.setLayout(SignUpPanelLayout);
        SignUpPanelLayout.setHorizontalGroup(
                SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SignUpPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblSignUpText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27))
                        .addGroup(SignUpPanelLayout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(btnSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                .addGap(107, 107, 107))
        );
        SignUpPanelLayout.setVerticalGroup(
                SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SignUpPanelLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(lblSignUpText, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addComponent(btnSignUp)
                                .addGap(41, 41, 41))
        );

        LogoLabel.setIcon(new javax.swing.ImageIcon("Resources/Images/PlagAIlogo.png")); // NOI18N

        javax.swing.GroupLayout LoginPagePanelLayout = new javax.swing.GroupLayout(LoginPagePanel);
        LoginPagePanel.setLayout(LoginPagePanelLayout);
        LoginPagePanelLayout.setHorizontalGroup(
                LoginPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPagePanelLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(SignUpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(91, 91, 91)
                                .addComponent(LoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(216, 216, 216))
                        .addGroup(LoginPagePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LoginPagePanelLayout.setVerticalGroup(
                LoginPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPagePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                                .addGroup(LoginPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(LoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(SignUpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(197, 197, 197))
        );

        SignUpPanel.getAccessibleContext().setAccessibleName("");

        getContentPane().add(LoginPagePanel, "card2");

        SiguUpFormPanel.setBackground(new java.awt.Color(102, 102, 102));
        SiguUpFormPanel.setForeground(new java.awt.Color(255, 255, 255));

        SignUpFormPanel.setBackground(new java.awt.Color(0, 0, 0));
        SignUpFormPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SignUP Form", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        SignUpFormPanel.setForeground(new java.awt.Color(255, 255, 255));

        lblSignUpFormName.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblSignUpFormName.setForeground(new java.awt.Color(255, 255, 255));
        lblSignUpFormName.setText("Name");

        lblSignUpFormEmail.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblSignUpFormEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblSignUpFormEmail.setText("Email");

        lblSignUpFormPassword.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblSignUpFormPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblSignUpFormPassword.setText("Password");

        lblSignUpFormConPass.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblSignUpFormConPass.setForeground(new java.awt.Color(255, 255, 255));
        lblSignUpFormConPass.setText("Confirm Password");

        txtSignUpFormName.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N

        txtSignUpFormEmail.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N

        txtSignUpFormPassword.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        txtSignUpFormConPass.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        btnSignUpRegister.setBackground(new java.awt.Color(0, 0, 0));
        btnSignUpRegister.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnSignUpRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnSignUpRegister.setText("Register!");
        btnSignUpRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpRegisterActionPerformed(evt);
            }
        });

        lblSigiupError.setBackground(new java.awt.Color(0, 0, 0));
        lblSigiupError.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        lblSigiupError.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout SignUpFormPanelLayout = new javax.swing.GroupLayout(SignUpFormPanel);
        SignUpFormPanel.setLayout(SignUpFormPanelLayout);
        SignUpFormPanelLayout.setHorizontalGroup(
                SignUpFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SignUpFormPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(SignUpFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblSignUpFormConPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblSignUpFormPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblSignUpFormEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblSignUpFormName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(SignUpFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSignUpFormName)
                                        .addComponent(txtSignUpFormEmail)
                                        .addComponent(txtSignUpFormPassword)
                                        .addComponent(txtSignUpFormConPass))
                                .addGap(153, 153, 153))
                        .addGroup(SignUpFormPanelLayout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(btnSignUpRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                .addGap(255, 255, 255))
                        .addGroup(SignUpFormPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblSigiupError, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SignUpFormPanelLayout.setVerticalGroup(
                SignUpFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SignUpFormPanelLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(SignUpFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSignUpFormName)
                                        .addComponent(txtSignUpFormName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(SignUpFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSignUpFormEmail)
                                        .addComponent(txtSignUpFormEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(SignUpFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSignUpFormPassword)
                                        .addComponent(txtSignUpFormPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(SignUpFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSignUpFormConPass)
                                        .addComponent(txtSignUpFormConPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSigiupError, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnSignUpRegister)
                                .addContainerGap(102, Short.MAX_VALUE))
        );

        LogoLabel1.setIcon(new javax.swing.ImageIcon("Resources/Images/PlagAIlogo.png")); // NOI18N

        btnSignUpBack.setBackground(new java.awt.Color(0, 0, 0));
        btnSignUpBack.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnSignUpBack.setForeground(new java.awt.Color(255, 255, 255));
        btnSignUpBack.setText("Back");
        btnSignUpBack.setBorderPainted(false);
        btnSignUpBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSignUpBack.setFocusPainted(false);
        btnSignUpBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SiguUpFormPanelLayout = new javax.swing.GroupLayout(SiguUpFormPanel);
        SiguUpFormPanel.setLayout(SiguUpFormPanelLayout);
        SiguUpFormPanelLayout.setHorizontalGroup(
                SiguUpFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SiguUpFormPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LogoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(SiguUpFormPanelLayout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addGroup(SiguUpFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(SiguUpFormPanelLayout.createSequentialGroup()
                                                .addComponent(btnSignUpBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(SiguUpFormPanelLayout.createSequentialGroup()
                                                .addComponent(SignUpFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(149, 149, 149))))
        );
        SiguUpFormPanelLayout.setVerticalGroup(
                SiguUpFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SiguUpFormPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LogoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                .addComponent(btnSignUpBack, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SignUpFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(143, 143, 143))
        );

        getContentPane().add(SiguUpFormPanel, "card3");

        MainPanel.setBackground(new java.awt.Color(102, 102, 102));
        MainPanel.setForeground(new java.awt.Color(255, 255, 255));

        LogoLabel2.setIcon(new javax.swing.ImageIcon("Resources/Images/PlagAIlogo.png")); // NOI18N

        menuTabPan.setBackground(new java.awt.Color(0, 0, 0));
        menuTabPan.setForeground(new java.awt.Color(255, 255, 255));
        menuTabPan.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        menuTabPan.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        textSplitPanMenu.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        textSplitPanMenu.setAutoscrolls(true);
        textSplitPanMenu.setOneTouchExpandable(true);

        TextSplitFan1.setColumns(20);
        TextSplitFan1.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        TextSplitFan1.setRows(5);
        TextSplitFan1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Original Text", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 16), new java.awt.Color(255, 153, 51))); // NOI18N
        TextSplitFan1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextSplitFan1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextSplitFan1FocusLost(evt);
            }
        });
        TextSplitFan1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                TextSplitFan1InputMethodTextChanged(evt);
            }
        });
        TextSplitFan1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextSplitFan1KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(TextSplitFan1);

        textSplitPanMenu.setLeftComponent(jScrollPane2);

        textSplitPan2.setColumns(20);
        textSplitPan2.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        textSplitPan2.setRows(5);
        textSplitPan2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Translated Text", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 16), new java.awt.Color(51, 0, 255))); // NOI18N
        textSplitPan2.setEnabled(false);
        jScrollPane1.setViewportView(textSplitPan2);

        textSplitPanMenu.setRightComponent(jScrollPane1);

        btnTextTranslate.setBackground(new java.awt.Color(0, 0, 0));
        btnTextTranslate.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnTextTranslate.setForeground(new java.awt.Color(255, 255, 255));
        btnTextTranslate.setText("Translate");
        btnTextTranslate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTextTranslateActionPerformed(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(0, 0, 0));
        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(supportedLanguage.toArray(new String[supportedLanguage.size()])));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Target Language :");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(textSplitPanMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(83, 83, 83)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnTextTranslate, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textSplitPanMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnTextTranslate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox1)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(49, Short.MAX_VALUE))
        );

        menuTabPan.addTab("Text", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        btnChooseFile.setBackground(new java.awt.Color(0, 0, 0));
        btnChooseFile.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnChooseFile.setForeground(new java.awt.Color(255, 255, 255));
        btnChooseFile.setText("Choose File");
        btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFileActionPerformed(evt);
            }
        });

        chooseFileSplitPanMenu.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        chooseFileSplitPanMenu.setAutoscrolls(true);
        chooseFileSplitPanMenu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        chooseFileSplitPanMenu.setOneTouchExpandable(true);

        chooseFileSplitPan1.setColumns(20);
        chooseFileSplitPan1.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        chooseFileSplitPan1.setRows(5);
        chooseFileSplitPan1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Original Text", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 16), new java.awt.Color(255, 153, 0))); // NOI18N
        chooseFileSplitPan1.setEnabled(false);
        jScrollPane4.setViewportView(chooseFileSplitPan1);

        chooseFileSplitPanMenu.setLeftComponent(jScrollPane4);

        chooseFileSplitPan2.setColumns(20);
        chooseFileSplitPan2.setRows(5);
        chooseFileSplitPan2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Translated Text", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 16), new java.awt.Color(51, 51, 255))); // NOI18N
        chooseFileSplitPan2.setEnabled(false);
        jScrollPane3.setViewportView(chooseFileSplitPan2);

        chooseFileSplitPanMenu.setRightComponent(jScrollPane3);

        btnFileTranslate.setBackground(new java.awt.Color(0, 0, 0));
        btnFileTranslate.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnFileTranslate.setForeground(new java.awt.Color(255, 255, 255));
        btnFileTranslate.setText("Translate");
        btnFileTranslate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileTranslateActionPerformed(evt);
            }
        });

        chooseFileComboBox.setBackground(new java.awt.Color(0, 0, 0));
        chooseFileComboBox.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        chooseFileComboBox.setForeground(new java.awt.Color(255, 255, 255));
        chooseFileComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(supportedLanguage.toArray(new String[supportedLanguage.size()])));
        chooseFileComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Traget Language :");

        chooseFileTargetLanguage.setBackground(new java.awt.Color(0, 0, 0));
        chooseFileTargetLanguage.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        chooseFileTargetLanguage.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(chooseFileSplitPanMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(btnChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(73, 73, 73)
                                                .addComponent(chooseFileComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(chooseFileTargetLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnFileTranslate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chooseFileSplitPanMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnFileTranslate)
                                        .addComponent(btnChooseFile)
                                        .addComponent(chooseFileComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(chooseFileTargetLanguage, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                                .addGap(29, 29, 29))
        );

        menuTabPan.addTab("Chose File", jPanel2);

        lblLanguage.setBackground(new java.awt.Color(0, 0, 0));
        lblLanguage.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblLanguage.setForeground(new java.awt.Color(255, 255, 255));
        lblLanguage.setText("Source Language :");

        txtLanguage.setBackground(new java.awt.Color(0, 0, 0));
        txtLanguage.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtLanguage.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Check");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LogoLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(menuTabPan)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addComponent(lblLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(432, 432, 432))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(menuTabPan)
                                        .addComponent(LogoLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(168, 168, 168))
        );

        getContentPane().add(MainPanel, "card4");

        ProfilePanel.setBackground(new java.awt.Color(102, 102, 102));
        ProfilePanel.setForeground(new java.awt.Color(255, 255, 255));

        LogoLabel3.setIcon(new javax.swing.ImageIcon("Resources/Images/PlagAIlogo.png")); // NOI18N

        ProfileTabPane.setBackground(new java.awt.Color(0, 0, 0));
        ProfileTabPane.setForeground(new java.awt.Color(255, 255, 255));
        ProfileTabPane.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ProfileTabPane.setOpaque(true);

        tabUserInfo.setBackground(new java.awt.Color(0, 0, 0));
        tabUserInfo.setForeground(new java.awt.Color(255, 255, 255));
        tabUserInfo.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        lblProfileName.setBackground(new java.awt.Color(0, 0, 0));
        lblProfileName.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblProfileName.setForeground(new java.awt.Color(255, 255, 255));
        lblProfileName.setText("Name");

        lblProfileEmail.setBackground(new java.awt.Color(0, 0, 0));
        lblProfileEmail.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblProfileEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblProfileEmail.setText("Email");

        lblProfileNameActual.setBackground(new java.awt.Color(0, 0, 0));
        lblProfileNameActual.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblProfileNameActual.setForeground(new java.awt.Color(255, 255, 255));

        lblProfileEmailActual.setBackground(new java.awt.Color(0, 0, 0));
        lblProfileEmailActual.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblProfileEmailActual.setForeground(new java.awt.Color(255, 255, 255));

        btnChangePassword.setBackground(new java.awt.Color(0, 0, 0));
        btnChangePassword.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnChangePassword.setForeground(new java.awt.Color(255, 255, 255));
        btnChangePassword.setText("Change Password");
        btnChangePassword.setFocusPainted(false);
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        lblProfileCurrPassword.setBackground(new java.awt.Color(0, 0, 0));
        lblProfileCurrPassword.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblProfileCurrPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblProfileCurrPassword.setText("Current Password");

        lblProfileNewPassword.setBackground(new java.awt.Color(0, 0, 0));
        lblProfileNewPassword.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblProfileNewPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblProfileNewPassword.setText("New Password");

        lblProfileConPassword.setBackground(new java.awt.Color(0, 0, 0));
        lblProfileConPassword.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblProfileConPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblProfileConPassword.setText("Confirm Password");

        txtProfileNewPass.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N

        txtProfileConfPass.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N

        btnProfileChangePassword.setBackground(new java.awt.Color(0, 0, 0));
        btnProfileChangePassword.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnProfileChangePassword.setForeground(new java.awt.Color(255, 255, 255));
        btnProfileChangePassword.setText("Change");
        btnProfileChangePassword.setFocusPainted(false);
        btnProfileChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileChangePasswordActionPerformed(evt);
            }
        });

        lblProfileChangePassError.setBackground(new java.awt.Color(0, 0, 0));
        lblProfileChangePassError.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        lblProfileChangePassError.setForeground(new java.awt.Color(255, 255, 255));

        txtProfileCurrPass.setBackground(new java.awt.Color(0, 0, 0));
        txtProfileCurrPass.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtProfileCurrPass.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tabUserInfoLayout = new javax.swing.GroupLayout(tabUserInfo);
        tabUserInfo.setLayout(tabUserInfoLayout);
        tabUserInfoLayout.setHorizontalGroup(
                tabUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tabUserInfoLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(tabUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(tabUserInfoLayout.createSequentialGroup()
                                                .addGroup(tabUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(tabUserInfoLayout.createSequentialGroup()
                                                                .addGroup(tabUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(lblProfileName, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                                                        .addComponent(lblProfileEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(tabUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblProfileNameActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lblProfileEmailActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabUserInfoLayout.createSequentialGroup()
                                                                .addComponent(btnChangePassword, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                                                .addGap(187, 187, 187)))
                                                .addGap(430, 430, 430))
                                        .addGroup(tabUserInfoLayout.createSequentialGroup()
                                                .addGroup(tabUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(tabUserInfoLayout.createSequentialGroup()
                                                                .addGroup(tabUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(lblProfileConPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                                                        .addComponent(lblProfileNewPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lblProfileCurrPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(tabUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(txtProfileNewPass)
                                                                        .addComponent(txtProfileConfPass)
                                                                        .addGroup(tabUserInfoLayout.createSequentialGroup()
                                                                                .addGap(17, 17, 17)
                                                                                .addComponent(btnProfileChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(txtProfileCurrPass, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)))
                                                        .addComponent(lblProfileChangePassError, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        tabUserInfoLayout.setVerticalGroup(
                tabUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tabUserInfoLayout.createSequentialGroup()
                                .addGroup(tabUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(tabUserInfoLayout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(lblProfileName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(tabUserInfoLayout.createSequentialGroup()
                                                .addGap(76, 76, 76)
                                                .addComponent(lblProfileNameActual, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(tabUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblProfileEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblProfileEmailActual, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(btnChangePassword)
                                .addGap(25, 25, 25)
                                .addGroup(tabUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblProfileCurrPassword)
                                        .addComponent(txtProfileCurrPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(tabUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblProfileNewPassword)
                                        .addComponent(txtProfileNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(tabUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblProfileConPassword)
                                        .addComponent(txtProfileConfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblProfileChangePassError, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnProfileChangePassword)
                                .addGap(31, 31, 31))
        );

        ProfileTabPane.addTab("User Details", tabUserInfo);

        tabUserHistory.setBackground(new java.awt.Color(0, 0, 0));
        tabUserHistory.setForeground(new java.awt.Color(255, 255, 255));
        tabUserHistory.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        lblHistoryFileNameStatic.setBackground(new java.awt.Color(0, 0, 0));
        lblHistoryFileNameStatic.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblHistoryFileNameStatic.setForeground(new java.awt.Color(255, 255, 255));
        lblHistoryFileNameStatic.setText("File Name :");

        lblHistoryFileName.setBackground(new java.awt.Color(0, 0, 0));
        lblHistoryFileName.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        lblHistoryFileName.setForeground(new java.awt.Color(255, 255, 255));
        lblHistoryFileName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHistoryFileNameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHistoryFileNameMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblHistoryFileNameMouseReleased(evt);
            }
        });

        lblHistoryResultstatic.setBackground(new java.awt.Color(0, 0, 0));
        lblHistoryResultstatic.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblHistoryResultstatic.setForeground(new java.awt.Color(255, 255, 255));
        lblHistoryResultstatic.setText("Result :");

        btnHistoryNext.setBackground(new java.awt.Color(102, 102, 102));
        btnHistoryNext.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHistoryNext.setForeground(new java.awt.Color(255, 255, 255));
        btnHistoryNext.setText("Next");
        btnHistoryNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryNextActionPerformed(evt);
            }
        });

        btnHistoryBack.setBackground(new java.awt.Color(102, 102, 102));
        btnHistoryBack.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHistoryBack.setForeground(new java.awt.Color(255, 255, 255));
        btnHistoryBack.setText("Back");
        btnHistoryBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryBackActionPerformed(evt);
            }
        });

        lblHistoryDate.setBackground(new java.awt.Color(0, 0, 0));
        lblHistoryDate.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblHistoryDate.setForeground(new java.awt.Color(255, 255, 255));
        lblHistoryDate.setText("Date : ");

        lblHistoryDateActual.setBackground(new java.awt.Color(0, 0, 0));
        lblHistoryDateActual.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblHistoryDateActual.setForeground(new java.awt.Color(255, 255, 255));

        lblHistoryTime.setBackground(new java.awt.Color(0, 0, 0));
        lblHistoryTime.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblHistoryTime.setForeground(new java.awt.Color(255, 255, 255));
        lblHistoryTime.setText("Time : ");

        lblHistoryTimeActual.setBackground(new java.awt.Color(0, 0, 0));
        lblHistoryTimeActual.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblHistoryTimeActual.setForeground(new java.awt.Color(255, 255, 255));

        lblHistoryLanguage.setBackground(new java.awt.Color(0, 0, 0));
        lblHistoryLanguage.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblHistoryLanguage.setForeground(new java.awt.Color(255, 255, 255));
        lblHistoryLanguage.setText("Language : ");

        lblHistoryLanguageActual.setBackground(new java.awt.Color(0, 0, 0));
        lblHistoryLanguageActual.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblHistoryLanguageActual.setForeground(new java.awt.Color(255, 255, 255));

        txtHistory.setColumns(20);
        txtHistory.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtHistory.setRows(5);
        jScrollPane5.setViewportView(txtHistory);

        javax.swing.GroupLayout tabUserHistoryLayout = new javax.swing.GroupLayout(tabUserHistory);
        tabUserHistory.setLayout(tabUserHistoryLayout);
        tabUserHistoryLayout.setHorizontalGroup(
                tabUserHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabUserHistoryLayout.createSequentialGroup()
                                .addGap(313, 313, 313)
                                .addComponent(btnHistoryBack, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addGap(92, 92, 92)
                                .addComponent(btnHistoryNext, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                .addGap(273, 273, 273))
                        .addGroup(tabUserHistoryLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(tabUserHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(tabUserHistoryLayout.createSequentialGroup()
                                                .addComponent(jScrollPane5)
                                                .addContainerGap())
                                        .addGroup(tabUserHistoryLayout.createSequentialGroup()
                                                .addComponent(lblHistoryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblHistoryDateActual, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblHistoryTime, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblHistoryTimeActual, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblHistoryLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblHistoryLanguageActual, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(tabUserHistoryLayout.createSequentialGroup()
                                                .addComponent(lblHistoryFileNameStatic, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47)
                                                .addComponent(lblHistoryFileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(174, 174, 174))
                                        .addGroup(tabUserHistoryLayout.createSequentialGroup()
                                                .addComponent(lblHistoryResultstatic, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        tabUserHistoryLayout.setVerticalGroup(
                tabUserHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tabUserHistoryLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(tabUserHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblHistoryFileNameStatic)
                                        .addComponent(lblHistoryFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(tabUserHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(tabUserHistoryLayout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(tabUserHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblHistoryDate)
                                                        .addComponent(lblHistoryDateActual, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(tabUserHistoryLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(tabUserHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblHistoryTime)
                                                        .addComponent(lblHistoryTimeActual, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(tabUserHistoryLayout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(tabUserHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblHistoryLanguageActual, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblHistoryLanguage))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(lblHistoryResultstatic)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(tabUserHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnHistoryNext)
                                        .addComponent(btnHistoryBack))
                                .addContainerGap())
        );

        ProfileTabPane.addTab("History", tabUserHistory);

        btnProfilePaneBack.setBackground(new java.awt.Color(0, 0, 0));
        btnProfilePaneBack.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnProfilePaneBack.setForeground(new java.awt.Color(255, 255, 255));
        btnProfilePaneBack.setText("Back");
        btnProfilePaneBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfilePaneBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProfilePanelLayout = new javax.swing.GroupLayout(ProfilePanel);
        ProfilePanel.setLayout(ProfilePanelLayout);
        ProfilePanelLayout.setHorizontalGroup(
                ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ProfilePanelLayout.createSequentialGroup()
                                .addGroup(ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ProfilePanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(LogoLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(ProfilePanelLayout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(ProfileTabPane)
                                                        .addGroup(ProfilePanelLayout.createSequentialGroup()
                                                                .addComponent(btnProfilePaneBack, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGap(94, 94, 94))
        );
        ProfilePanelLayout.setVerticalGroup(
                ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ProfilePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LogoLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(btnProfilePaneBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ProfileTabPane)
                                .addGap(134, 134, 134))
        );

        getContentPane().add(ProfilePanel, "card5");

        MenuBar.setBackground(new java.awt.Color(255, 255, 255));

        MyMenu.setBackground(new java.awt.Color(255, 255, 255));
        MyMenu.setText("Menu");
        MyMenu.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N

        MenuProfile.setBackground(new java.awt.Color(255, 255, 255));
        MenuProfile.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        MenuProfile.setText("Profile");
        MenuProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuProfileActionPerformed(evt);
            }
        });
        MyMenu.add(MenuProfile);

        MenuActivity.setBackground(new java.awt.Color(255, 255, 255));
        MenuActivity.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        MenuActivity.setText("Activity");
        MenuActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActivityActionPerformed(evt);
            }
        });
        //MyMenu.add(MenuActivity);

        MenuLogout.setBackground(new java.awt.Color(255, 255, 255));
        MenuLogout.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        MenuLogout.setText("Logout");
        MenuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLogoutActionPerformed(evt);
            }
        });
        MyMenu.add(MenuLogout);

        MenuBar.add(MyMenu);
        MenuBar.setVisible(false);
        hideChangePassword();
        setJMenuBar(MenuBar);
        chooseFileTargetLanguage.setText("English");
        jLabel3.setText("English");
        pack();
    }// </editor-fold>

    private void hideChangePassword()
    {
        lblProfileCurrPassword.setVisible(false);
        lblProfileChangePassError.setVisible(false);
        lblProfileConPassword.setVisible(false);
        lblProfileNewPassword.setVisible(false);
        txtProfileConfPass.setVisible(false);
        txtProfileCurrPass.setVisible(false);
        txtProfileNewPass.setVisible(false);
        btnProfileChangePassword.setVisible(false);

    }

    private void unhideChangePassword()
    {
        lblProfileCurrPassword.setVisible(true);
        lblProfileChangePassError.setVisible(true);
        lblProfileConPassword.setVisible(true);
        lblProfileNewPassword.setVisible(true);
        txtProfileConfPass.setVisible(true);
        txtProfileCurrPass.setVisible(true);
        txtProfileNewPass.setVisible(true);
        btnProfileChangePassword.setVisible(true);

    }

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {
        MenuBar.setVisible(false);
        pages.show(getContentPane() , "card3");
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {

        String email = txtUserName.getText();
        String password = new String( txtPassword.getPassword() );
        int status = Helper.getInstance().validateLogin(email , password);
        if( status == ProjectConstants.ALL_GOOD)
        {
            MenuBar.setVisible(true);
            lblLoginError.setVisible(false);
            pages.show(getContentPane() , "card4");
            txtUserName.setText("");
            txtPassword.setText("");
            Plagarism.currentUser = new User(email , password);
            Plagarism.currentUser.showNextResult(lblHistoryFileName , txtHistory , lblHistoryDateActual ,
                    lblHistoryTimeActual , lblHistoryLanguageActual);
        }
        else if(status == ProjectConstants.INVALID_EMAIL){
            MenuBar.setVisible(false);
            lblLoginError.setVisible(true);
            lblLoginError.setText("Invalid Email");
        }
        else if(status == ProjectConstants.INVALID_PASSWORD){
            MenuBar.setVisible(false);
            lblLoginError.setVisible(true);
            lblLoginError.setText("Invalid Password");
        }

    }

    private void MenuLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        MenuBar.setVisible(false);
        pages.show(getContentPane() , "card2");
        lblHistoryFileName.setText("");
        txtHistory.setText("");
        textSplitPan2.setText("");
        TextSplitFan1.setText("");
        chooseFileSplitPan1.setText("");
        chooseFileSplitPan2.setText("");
        Plagarism.currentUser = null;
    }

    private void btnSignUpBackActionPerformed(java.awt.event.ActionEvent evt) {
        MenuBar.setVisible(false);
        pages.show(getContentPane() , "card2");
    }

    private void btnSignUpRegisterActionPerformed(java.awt.event.ActionEvent evt) {

        String name , email , password , confirmPassword;
        name    = txtSignUpFormName.getText();
        email   = txtSignUpFormEmail.getText();
        password= new String(txtSignUpFormPassword.getPassword());
        confirmPassword = new String(txtSignUpFormConPass.getPassword());

        boolean passwordCheck = password.equals(confirmPassword);
        boolean emailCheck = false;
        boolean emailLengthCheck = (email.length() < 100);
        boolean passwordLegthCheck = (password.length() < 10);
        boolean nameLengthCheck    = (name.length() < 50);
        boolean passwordEmptyCheck = !password.isEmpty();
        boolean emailEmptyCheck     = !email.isEmpty();
        boolean nameEmptyCheck     = !name.isEmpty();
        //System.out.println(nameEmptyCheck);
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
            emailCheck = true;
        } catch (AddressException ex) {
            emailCheck = false;
        }
        if(passwordCheck && emailCheck && emailLengthCheck
                && nameLengthCheck && passwordLegthCheck &&
                passwordEmptyCheck && nameEmptyCheck && passwordEmptyCheck)
        {
            ArrayList<String> col = new ArrayList<String>();
            ArrayList<String> val = new ArrayList<String>();

            col.add("name");
            col.add("email");
            col.add("password");

            val.add(name);
            val.add(email);
            val.add(password);

            JSONObject insertJson = Helper.getInstance().createInsertJson("Login" , col , val );
            DBObject db = DBBuilder.connectDB("mysql" , "plagarism" , "root" , "");
            db.open();
            boolean status1 = db.insert(insertJson);

            col.clear();
            val.clear();
            col.add("email");
            col.add("files");
            col.add("results");
            col.add("date");
            col.add("time");
            col.add("language");

            val.add(email);
            val.add("");
            val.add("");
            val.add("");
            val.add("");
            val.add("");

            JSONObject insertHistoryJson = Helper.getInstance().createInsertJson("history" , col , val );
            boolean status2 = db.insert(insertHistoryJson);

            db.close();
            if(!status1 || !status2)
            {
                lblSigiupError.setVisible(true);
                if(!status1)
                {
                    lblSigiupError.setText("Try another email...");
                }
                else{
                    lblSigiupError.setText("Error creating history");
                }

            }
            else{
                lblSigiupError.setText("");
                lblSigiupError.setVisible(false);
                txtSignUpFormName.setText("");
                txtSignUpFormEmail.setText("");
                txtSignUpFormPassword.setText("");
                txtSignUpFormConPass.setText("");
                MenuBar.setVisible(true);
                pages.show(getContentPane() , "card4");
                Plagarism.currentUser = new User(email , password);
                Plagarism.currentUser.showNextResult(lblHistoryFileName , txtHistory , lblHistoryDateActual ,
                        lblHistoryTimeActual , lblHistoryLanguageActual);
            }
        }
        else{
            lblSigiupError.setVisible(true);

            if(!nameEmptyCheck)
            {
                lblSigiupError.setText("Name cannot be empty");
            }
            else if(!emailEmptyCheck)
            {
                lblSigiupError.setText("Email Cannot be empty");
            }
            else if(!passwordEmptyCheck)
            {
                lblSigiupError.setText("Password cannot be empty");
            }
            else if(!passwordCheck)
            {
                lblSigiupError.setText("Password mismatch...");
            }
            else if(!emailCheck)
            {
                lblSigiupError.setText("Email invalid...");
            }
            else if(!emailLengthCheck)
            {
                lblSigiupError.setText("Email Length should be within 100 characters...");
            }
            else if(!nameLengthCheck)
            {
                lblSigiupError.setText("Name should be within 50 characters");
            }
            else if(!passwordLegthCheck)
            {
                lblSigiupError.setText("Password should be less than 10 characters");
            }
        }
    }

    private void MenuProfileActionPerformed(java.awt.event.ActionEvent evt) {

        MenuBar.setVisible(true);
        pages.show(getContentPane() , "card5");
        lblProfileNameActual.setText(Plagarism.currentUser.name);
        lblProfileEmailActual.setText(Plagarism.currentUser.email);
    }

    private void btnProfilePaneBackActionPerformed(java.awt.event.ActionEvent evt) {

        MenuBar.setVisible(true);
        pages.show(getContentPane() , "card4");
    }

    private void MenuActivityActionPerformed (java.awt.event.ActionEvent evt) {


    }

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {
        unhideChangePassword();

    }

    private void btnProfileChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {
        unhideChangePassword();
        String newPassword = new String(txtProfileNewPass.getPassword());
        String confPassword = new String(txtProfileConfPass.getPassword());
        String currPass = new String(txtProfileCurrPass.getPassword());

        if(currPass.equals(Plagarism.currentUser.password))
        {
            if(newPassword.equals(confPassword))
            {
                ArrayList<String> col = new ArrayList<>();
                ArrayList<String> val = new ArrayList<>();

                col.add("password");
                val.add(newPassword);

                JSONObject updateJson  = Helper.getInstance().createUpdateJson("login" , "email",
                        Plagarism.currentUser.email,
                        col , val);

                DBObject db = DBBuilder.connectDB("mysql" , "plagarism" , "root" , "");
                db.open();
                boolean status = db.update(updateJson);
                if(!status)
                {
                    lblProfileChangePassError.setVisible(true);
                    lblProfileChangePassError.setText("Error updating password, please try again later...");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Password Updated..");
                    Plagarism.currentUser.password = newPassword;
                    hideChangePassword();
                }
            }
            else{
                lblProfileChangePassError.setVisible(true);
                lblProfileChangePassError.setText("Password missmatch...");
            }
        }
        else{
            lblProfileChangePassError.setVisible(true);
            lblProfileChangePassError.setText("Invalid Current Password...");
        }
    }

    private void lblHistoryFileNameMouseReleased(java.awt.event.MouseEvent evt) {
        File f = new File(lblHistoryFileName.getText());
        if(f.exists() && !f.isDirectory()) {
            Helper.getInstance().openFileInOS(lblHistoryFileName.getText());
        }
    }

    private void lblHistoryFileNameMouseEntered(java.awt.event.MouseEvent evt) {
        File f = new File(lblHistoryFileName.getText());
        if(f.exists() && !f.isDirectory()) {
            lblHistoryFileName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    private void lblHistoryFileNameMouseExited(java.awt.event.MouseEvent evt) {
        lblHistoryFileName.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void btnHistoryBackActionPerformed(java.awt.event.ActionEvent evt) {
        Plagarism.currentUser.showPreviousResult(lblHistoryFileName , txtHistory , lblHistoryDateActual ,
                lblHistoryTimeActual , lblHistoryLanguageActual);
    }

    private void btnHistoryNextActionPerformed(java.awt.event.ActionEvent evt) {
        Plagarism.currentUser.showNextResult(lblHistoryFileName , txtHistory , lblHistoryDateActual ,
                lblHistoryTimeActual , lblHistoryLanguageActual);


    }

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {

        GregorianCalendar gcalendar = new GregorianCalendar();
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
                "Oct", "Nov", "Dec"};

        String fileName;

        String date    = months[gcalendar.get(Calendar.MONTH)] + " ";
        date += Integer.toString(gcalendar.get(Calendar.DATE)) +" ";
        date += Integer.toString(gcalendar.get(Calendar.YEAR)) + " ";

        String time     = Integer.toString(gcalendar.get(Calendar.HOUR)) + ":";
        time += Integer.toString(gcalendar.get(Calendar.MINUTE)) + ":";
        time += Integer.toString(gcalendar.get(Calendar.SECOND));

        CopyLeakService plagService = new CopyLeakService();
        plagService.login();

        String language = txtLanguage.getText();

        JTextArea dest = null;
        if(menuTabPan.getSelectedIndex() == ProjectConstants.TEXT_TAB) {
            dest = textSplitPan2;
            fileName = "Unknown";
        }
        else {
            dest = chooseFileSplitPan2;
            fileName = selectedFile.getAbsolutePath();
        }

            Plagarism.currentUser.files.add(fileName);
            Plagarism.currentUser.date.add(date);
            Plagarism.currentUser.time.add(time);
            Plagarism.currentUser.language.add(language);


            plagService.createByText(dest.getText());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(!plagService.isResultReady())
            {
                if(Plagarism.guiObject != null)
                {
                    Plagarism.guiObject.setTitle("");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            String result = plagService.getResult();
            if(result.equals(""))
            {
                result = "No Plagarism Detected...";
            }
            Plagarism.currentUser.results.add(result.replaceAll("\'" , ""));

            ArrayList<String> col = new ArrayList<String>();
            ArrayList<String> val = new ArrayList<String>();
            col.add("files");
            col.add("results");
            col.add("date");
            col.add("time");
            col.add("language");

            String files = "" , results = "" , dates="" , times="" , languages="";
            for(int itr=0 ; itr < Plagarism.currentUser.files.size() ; itr++)
            {
                files += Plagarism.currentUser.files.get(itr);
                results += Plagarism.currentUser.results.get(itr);
                dates += Plagarism.currentUser.date.get(itr);
                times += Plagarism.currentUser.time.get(itr);
                languages += Plagarism.currentUser.language.get(itr);

                if(itr < (Plagarism.currentUser.files.size()-1))
                {
                    files += ",";
                    results += ",%,";
                    dates += ",";
                    times += ",";
                    languages += ",";
                }

            }
            val.add(files);
            val.add(results);
            val.add(dates);
            val.add(times);
            val.add(languages);

            DBObject DB = DBBuilder.connectDB("mysql" , "plagarism" , "root" , "");
            DB.open();
            JSONObject updateJson = Helper.getInstance().createUpdateJson("history" , "email" , Plagarism.currentUser.email,
                    col , val);
            DB.update(updateJson);
            DB.close();

        JTextArea textArea = new JTextArea();
        textArea.setColumns(30);
        textArea.setRows(10);
        textArea.setFont(new java.awt.Font("Times New Roman", 0, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.append(result);
        textArea.setSize(textArea.getPreferredSize().width, 1);
        JOptionPane.showMessageDialog(null, new JScrollPane( textArea), "Result!",
                JOptionPane.PLAIN_MESSAGE);

    }

    private void btnChooseFileActionPerformed(java.awt.event.ActionEvent evt) {

        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            selectedFile = fileChooser.getSelectedFile();
            Readable FileObject     = FileReaderBuilder.createReader(selectedFile.getAbsolutePath() , "");
            if( FileObject == null)
            {
                System.err.println("Error Reading file");
                System.exit(0);
            }
            chooseFileSplitPan1.setText("");
            String content = "";
            for(int itr = 0 ; itr < FileObject.getTotalSentences() ; itr++)
            {
                content += FileObject.getContent(itr) + "\n";
            }
            chooseFileSplitPan1.setText(content);
        }


    }

    private void TextSplitFan1FocusGained(java.awt.event.FocusEvent evt) {

    }

    private void TextSplitFan1FocusLost(java.awt.event.FocusEvent evt) {

    }

    private void TextSplitFan1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {

    }

    private void TextSplitFan1KeyTyped(java.awt.event.KeyEvent evt) {

    }

    private void btnTextTranslateActionPerformed(java.awt.event.ActionEvent evt) {

        translate(TextSplitFan1 , textSplitPan2);

    }

    private void btnFileTranslateActionPerformed(java.awt.event.ActionEvent evt) {
        translate(chooseFileSplitPan1 , chooseFileSplitPan2);
    }

    private void translate(JTextArea source , JTextArea destination)
    {
        destination.setEnabled(true);
        destination.setEditable(true);
        destination.setText("");
        destination.setEnabled(false);
        destination.setEditable(false);
        Translator yandex = TranslatorBuilder.createTranslator(ProjectConstants.Yandex);
        Readable textReaderObj = FileReaderBuilder.createReader("" , source.getText());
        //System.out.println("Contents : "+textReaderObj.getContent(0));
        AbstractMap.SimpleEntry<String , String> language = yandex.detectLanguage(textReaderObj.getContent(0));
        txtLanguage.setText(language.getValue());

        String translationDirection = "";
        String target = "";
        int index = menuTabPan.getSelectedIndex();
        if(index == ProjectConstants.TEXT_TAB)
        {
            target = (String)languageCode.get(jLabel3.getText());
        }
        else if(index == ProjectConstants.FILE_TAB)
        {
            target = (String)languageCode.get(chooseFileTargetLanguage.getText());
        }
        //System.out.println("Target : "+target);
        int docSentences = textReaderObj.getTotalSentences();
        for(int itr = 0 ; itr < docSentences ; itr++)
        {
            language = yandex.detectLanguage(textReaderObj.getContent(itr));
            translationDirection = language.getKey()+"-"+target;
            String res = yandex.translateText( textReaderObj.getContent(itr), translationDirection);
            destination.setEnabled(true);
            destination.setEditable(true);
            destination.append(res+"\n");
            destination.setEnabled(false);
            destination.setEditable(false);
        }
    }

    private void chooseFileComboBoxActionPerformed(java.awt.event.ActionEvent evt) {

        chooseFileTargetLanguage.setText(chooseFileComboBox.getSelectedItem().toString());
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {

        jLabel3.setText(jComboBox1.getSelectedItem().toString());
    }




    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlagGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlagGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlagGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlagGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlagGUI().setVisible(true);
            }
        });
    }


}

