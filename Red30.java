
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class Red30 extends JFrame {
    // Mass
    final private double GRAM_TO_OUNCES = 0.0353;
    final private double GRAM_TO_POUND = 0.002205;
    final private double GRAM_TO_STONE = 0.000157;
    final private double GRAM_TO_US_TONNE = 0.000001;
    // ------------------------------------------------
    final private double KILOGRAM_TO_OUNCES = 35.27;
    final private double KILOGRAM_TO_POUND = 2.2046;
    final private double KILOGRAM_TO_STONE = 0.1574;
    final private double KILOGRAM_TO_US_TONNE = 0.001102;

    // ------------------------------------------------
    // Length
    final private double CENTIMETER_TO_INCHES = 0.3937;
    final private double CENTIMETER_TO_FEET = 0.0328;
    final private double CENTIMETER_TO_YARD = 0.0109;
    final private double CENTIMETER_TO_MILES = 0.0000062;
    // ------------------------------------------------
    final private double METER_TO_INCHES = 39.37;
    final private double METER_TO_FEET = 3.2808;
    final private double METER_TO_YARD = 1.0936;
    final private double METER_TO_MILES = 0.0006214;
    // ------------------------------------------------
    final private double KILOMETER_TO_INCHES = 39370.079;
    final private double KILOMETER_TO_FEET = 3280.8399;
    final private double KILOMETER_TO_YARD = 1093.613;
    final private double KILOMETER_TO_MILES = 0.6214;

    private int calculation, calculation2;
    private int clickCount;
    private double num, answer;
    private int progTemp;
    private String sciOperationChoice;
    private String userTempChoice;
    private String progMode;
    private String selectedProgItems;
    private String inptHex;
    private String selectedMassItems;
    private String metricMass;
    private String selectedLenItems;
    private String metricLength;
    private String selectedImpItem;
    private String selMassImperial;
    private String selLenItem;
    private String imperialLen;
    private JPanel contentPane;
    private JTextField displayArea;
    private JTextField historyDisplay;
    private JTextField historyDisplay2;
    private JTextField displayArea2;
    private JTextField convertFromDisplay;
    private JTextField convertToDisplay;
    private JTextField convertLenDisplay2;
    private JTextField convertLenDisplay1;
    private JTextField convertMassDisplay1;
    private JTextField convertMassDisplay2;
    private JTextField progDisplay2;
    private JTextField progDisplay1;
    private JComboBox convertFrom;
    private JButton btnE;
    private JButton btnD;
    private JButton btnC;
    private JButton btnB;
    private JButton btnA;
    private JButton btnF;
    protected String selectedToProgItems;
    protected String selConvertTo;
    private JButton btn2_1_1;
    private JButton btn3_1_1;
    private JButton btn4_1_1;
    private JButton btn5_1_1;
    private JButton btn6_1_1;
    private JButton btn7_1_1;
    private JButton btn8_1_1;
    private JButton btn9_1_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        try {
            // Set System L&F
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
        try {
            Red30 frame = new Red30();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the frame and GUI
     */
    public Red30() {
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setTitle("Calculator By Red30");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 646, 500); // 100, 100, 646, 572
        setResizable(false);

        /////////////////////////////////
        // main background-panel
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        //////////// right menu panel for user options /////////////////////
        JPanel menuPanel = new JPanel();
        menuPanel.setFont(new Font("Open Sans", Font.PLAIN, 11));
        menuPanel.setOpaque(false);
        contentPane.add(menuPanel, BorderLayout.WEST);
        menuPanel.setPreferredSize(new Dimension(160, 10)); // 150, 10
        menuPanel.setLayout(null);

        ////////// Calculator panel that contains number buttons ///////////
        JPanel parentPanel = new JPanel();
        parentPanel.setOpaque(false);
        contentPane.add(parentPanel, BorderLayout.CENTER);
        parentPanel.setLayout(new CardLayout(0, 0));

        /****** Welcome Page ******/
        JPanel welcome = new JPanel();
        welcome.setOpaque(false);
        welcome.setLayout(null);
        parentPanel.add("welcome", welcome);

        JLabel lblWelcome = new JLabel("WELCOME");
        lblWelcome.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 30));
        lblWelcome.setBounds(126, 11, 191, 64);
        welcome.add(lblWelcome);

        String messageForUser = "Choose the options on the side for different operations.";
        String msglbl1 = "Standard - Basic addition, substraction, multiplication and division.";
        String msglbl2 = "Scientific - All standard function with Power, modulo, square & cube roots.";
        String msglbl3 = "Programmers - Convert from Binary to Decimal, Hexadecimal to Decimal and vice-versa.";
        String msglbl4 = "Temperature - Conversion from Celsius to Fahrenheit or Fahrenheit to Celsius.";
        String msglbl5 = "Length - Conversion from cm to inches or inches to cm.";
        String msglbl6 = "Weight & Mass - Conversion from g to oz or oz to g etc.";
        String msglbl7 = "You cannot come back to this page once you leave.";

        JLabel lblmessage = new JLabel(messageForUser);
        lblmessage.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
        lblmessage.setBounds(10, 74, 400, 23);
        welcome.add(lblmessage);

        JLabel lblStandardmsg = new JLabel(msglbl1);
        lblStandardmsg.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblStandardmsg.setBounds(18, 123, 323, 14);
        welcome.add(lblStandardmsg);

        JLabel lblSciMsg = new JLabel(msglbl2);
        lblSciMsg.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblSciMsg.setBounds(18, 148, 360, 14);
        welcome.add(lblSciMsg);

        JLabel lblProgrammerMsg = new JLabel(msglbl3);
        lblProgrammerMsg.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblProgrammerMsg.setBounds(18, 173, 432, 14);
        welcome.add(lblProgrammerMsg);

        JLabel lblTempMsg = new JLabel(msglbl4);
        lblTempMsg.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblTempMsg.setBounds(18, 198, 400, 14);
        welcome.add(lblTempMsg);

        JLabel lblLengthMsg = new JLabel(msglbl5);
        lblLengthMsg.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblLengthMsg.setBounds(18, 223, 323, 14);
        welcome.add(lblLengthMsg);

        JLabel lblWgtMassMsg = new JLabel(msglbl6);
        lblWgtMassMsg.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblWgtMassMsg.setBounds(18, 248, 323, 14);
        welcome.add(lblWgtMassMsg);

        JLabel lblNewLabel_6 = new JLabel(msglbl7);
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_6.setBounds(10, 291, 371, 31);
        welcome.add(lblNewLabel_6);

        //////////////// Standard Calculator Panel ///////////////////
        JPanel standardPnl = new JPanel();
        parentPanel.add("standard", standardPnl);
        standardPnl.setLayout(null);

        JLabel StandardPnl = new JLabel("Standard");
        StandardPnl.setBounds(22, 5, 100, 60);
        StandardPnl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        StandardPnl.setHorizontalAlignment(SwingConstants.LEFT);
        standardPnl.add(StandardPnl);

        // Display
        displayArea = new JTextField();
        displayArea.setBorder(null);
        displayArea.setFocusTraversalKeysEnabled(false);
        displayArea.setFocusable(false);
        displayArea.setMaximumSize(new Dimension(435, 0));
//        displayArea.setBorder(null);
        displayArea.setEditable(false);
        displayArea.setOpaque(false);
        displayArea.setRequestFocusEnabled(false);
        displayArea.setBounds(17, 70, 435, 83);
        displayArea.setHorizontalAlignment(SwingConstants.RIGHT);
        displayArea.setFont(new Font("Digital-7 Mono", Font.BOLD, 40));
        standardPnl.add(displayArea);

        // History display
        historyDisplay = new JTextField();
        historyDisplay.setBorder(null);
        historyDisplay.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        historyDisplay.setEditable(false);
        historyDisplay.setFocusable(false);
        historyDisplay.setFont(new Font("Digital-7 Mono", Font.PLAIN, 20));
        historyDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        historyDisplay.setOpaque(false);
        historyDisplay.setRequestFocusEnabled(false);
        historyDisplay.setBounds(141, 21, 311, 44);
        historyDisplay.setColumns(10);
        standardPnl.add(historyDisplay);

        /**************** Buttons ********************/

        JButton btnAllClear = new JButton("AC");
        btnAllClear.setBounds(17, 158, 105, 53);
        btnAllClear.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btnAllClear);

        btnAllClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("");
                historyDisplay.setText("");
            }
        });

//    -----------------------------------------------------
        JButton btnClear = new JButton("C");
        btnClear.setBounds(127, 158, 105, 53);
        btnClear.setPreferredSize(new Dimension(105, 53));
        btnClear.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btnClear);

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(" ");
                historyDisplay.setText(" ");
                answer = 0.0;
                num = 0.0;
            }
        });

//    -----------------------------------------------------
        JButton btnBackspace = new JButton("←");
        btnBackspace.setBounds(237, 158, 105, 53);
        btnBackspace.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btnBackspace);

        // if backspace is pressed
        btnBackspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(backSpace(displayArea.getText()));
            }
        });

//    -----------------------------------------------------
        JButton btnDivide = new JButton("÷");
        btnDivide.setBounds(347, 158, 105, 53);
        btnDivide.setPreferredSize(new Dimension(105, 53));
        btnDivide.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btnDivide);

        // if divide button is pressed
        btnDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(displayArea.getText());
                calculation = 3;
                displayArea.setText("");
                historyDisplay.setText(num + "/");
            }
        });

//    -----------------------------------------------------
        JButton btn7 = new JButton("7");
        btn7.setBounds(17, 216, 105, 53);
        btn7.setPreferredSize(new Dimension(105, 53));
        btn7.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btn7);

        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(displayArea.getText() + "7");
            }
        });

//    -----------------------------------------------------
        JButton btn8 = new JButton("8");
        btn8.setBounds(127, 216, 105, 53);
        btn8.setPreferredSize(new Dimension(105, 53));
        btn8.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btn8);

        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(displayArea.getText() + "8");
            }
        });

//    -----------------------------------------------------
        JButton btn9 = new JButton("9");
        btn9.setBounds(237, 216, 105, 53);
        btn9.setPreferredSize(new Dimension(105, 53));
        btn9.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btn9);

        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(displayArea.getText() + "9");
            }
        });

//    -----------------------------------------------------
        JButton btnMultiply = new JButton("×");
        btnMultiply.setBounds(347, 216, 105, 53);
        btnMultiply.setPreferredSize(new Dimension(105, 53));
        btnMultiply.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btnMultiply);

        // if multiply button is pressed
        btnMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(displayArea.getText());
                calculation = 4;
                displayArea.setText("");
                historyDisplay.setText(num + "*");
            }
        });

//    -----------------------------------------------------
        JButton btn4 = new JButton("4");
        btn4.setBounds(17, 274, 105, 53);
        btn4.setPreferredSize(new Dimension(105, 53));
        btn4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btn4);

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(displayArea.getText() + "4");
            }
        });

//    -----------------------------------------------------
        JButton btn5 = new JButton("5");
        btn5.setBounds(127, 274, 105, 53);
        btn5.setPreferredSize(new Dimension(105, 53));
        btn5.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btn5);

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(displayArea.getText() + "5");
            }
        });

//    -----------------------------------------------------
        JButton btn6 = new JButton("6");
        btn6.setBounds(237, 274, 105, 53);
        btn6.setPreferredSize(new Dimension(105, 53));
        btn6.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btn6);

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(displayArea.getText() + "6");
            }
        });

//    -----------------------------------------------------
        JButton btnMinus = new JButton("-");
        btnMinus.setBounds(347, 274, 105, 53);
        btnMinus.setPreferredSize(new Dimension(105, 53));
        btnMinus.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btnMinus);

        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(displayArea.getText());
                calculation = 2;
                displayArea.setText("");
                historyDisplay.setText(num + "-");
            }
        });

//    -----------------------------------------------------
        JButton btn1 = new JButton("1");
        btn1.setBounds(17, 332, 105, 53);
        btn1.setPreferredSize(new Dimension(105, 53));
        btn1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btn1);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(displayArea.getText() + "1");
            }
        });

//    -----------------------------------------------------
        JButton btn2 = new JButton("2");
        btn2.setBounds(127, 332, 105, 53);
        btn2.setPreferredSize(new Dimension(105, 53));
        btn2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btn2);

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(displayArea.getText() + "2");
            }
        });

//    -----------------------------------------------------

        JButton btn3 = new JButton("3");
        btn3.setBounds(237, 332, 105, 53);
        btn3.setPreferredSize(new Dimension(105, 53));
        btn3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btn3);

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(displayArea.getText() + "3");
            }
        });

//    -----------------------------------------------------
        JButton btnAdd = new JButton("+");
        btnAdd.setBounds(347, 332, 105, 53);
        btnAdd.setPreferredSize(new Dimension(105, 53));
        btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btnAdd);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(displayArea.getText());
                calculation = 1;
                displayArea.setText("");
                historyDisplay.setText(num + " + ");
            }
        });

//    -----------------------------------------------------
        JButton btnSpecialDot = new JButton(".");
        btnSpecialDot.setBounds(237, 390, 105, 53);
        btnSpecialDot.setPreferredSize(new Dimension(105, 53));
        btnSpecialDot.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        standardPnl.add(btnSpecialDot);

        btnSpecialDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(displayArea.getText() + ".");
            }
        });

//    -----------------------------------------------------
        JButton btn0 = new JButton("0");
        btn0.setBounds(17, 390, 215, 53);
        btn0.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn0.setPreferredSize(new Dimension(105, 53));
        standardPnl.add(btn0);

        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(displayArea.getText() + "0");
            }
        });

        JButton btnEquals = new JButton("=");
        btnEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    operations();
                    historyDisplay.setText(historyDisplay.getText() + answer + " ");
                } catch (NumberFormatException e1) {
                    historyDisplay.setText("0");
                }
            }
        });
        btnEquals.setBounds(347, 390, 105, 53);
        btnEquals.setPreferredSize(new Dimension(105, 53));
        standardPnl.add(btnEquals);

        //////////////////////////////////////////////////
        JPanel scientificPnl = new JPanel();
        scientificPnl.setOpaque(false);
        parentPanel.add("scientific", scientificPnl);
        scientificPnl.setLayout(null);

        JLabel ScientificLbl = new JLabel("Scientific");
        ScientificLbl.setHorizontalAlignment(SwingConstants.LEFT);
        ScientificLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        ScientificLbl.setBounds(22, 5, 100, 60);
        scientificPnl.add(ScientificLbl);

        historyDisplay2 = new JTextField();
        historyDisplay2.setBorder(null);
        historyDisplay2.setRequestFocusEnabled(false);
        historyDisplay2.setOpaque(false);
        historyDisplay2.setHorizontalAlignment(SwingConstants.RIGHT);
        historyDisplay2.setFont(new Font("Digital-7 Mono", Font.PLAIN, 20));
        historyDisplay2.setFocusable(false);
        historyDisplay2.setEditable(false);
        historyDisplay2.setColumns(10);
        historyDisplay2.setBounds(141, 21, 311, 44);
        scientificPnl.add(historyDisplay2);

        displayArea2 = new JTextField();
        displayArea2.setBorder(null);
        displayArea2.setRequestFocusEnabled(false);
        displayArea2.setOpaque(false);
        displayArea2.setMaximumSize((Dimension) null);
        displayArea2.setHorizontalAlignment(SwingConstants.RIGHT);
        displayArea2.setFont(new Font("Digital-7 Mono", Font.BOLD, 40));
        displayArea2.setEditable(false);
        displayArea2.setBounds(17, 70, 435, 83);
        scientificPnl.add(displayArea2);

        JButton btn7_1 = new JButton("7");
        btn7_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea2.setText(displayArea2.getText() + "7");
            }
        });
        btn7_1.setPreferredSize(new Dimension(105, 53));
        btn7_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn7_1.setBounds(17, 217, 80, 53);
        scientificPnl.add(btn7_1);

        JButton btn8_1 = new JButton("8");
        btn8_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea2.setText(displayArea2.getText() + "8");
            }
        });
        btn8_1.setPreferredSize(new Dimension(105, 53));
        btn8_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn8_1.setBounds(104, 217, 80, 53);
        scientificPnl.add(btn8_1);

        JButton btn9_1 = new JButton("9");
        btn9_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea2.setText(displayArea2.getText() + "9");
            }
        });
        btn9_1.setPreferredSize(new Dimension(105, 53));
        btn9_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn9_1.setBounds(191, 217, 80, 53);
        scientificPnl.add(btn9_1);

        JButton btn6_1 = new JButton("6");
        btn6_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea2.setText(displayArea2.getText() + "6");
            }
        });
        btn6_1.setPreferredSize(new Dimension(105, 53));
        btn6_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn6_1.setBounds(191, 275, 80, 53);
        scientificPnl.add(btn6_1);

        JButton btn4_1 = new JButton("4");
        btn4_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea2.setText(displayArea2.getText() + "4");
            }
        });
        btn4_1.setPreferredSize(new Dimension(105, 53));
        btn4_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn4_1.setBounds(17, 275, 80, 53);
        scientificPnl.add(btn4_1);

        JButton btn5_1 = new JButton("5");
        btn5_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea2.setText(displayArea2.getText() + "5");
            }
        });
        btn5_1.setPreferredSize(new Dimension(105, 53));
        btn5_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn5_1.setBounds(104, 275, 80, 53);
        scientificPnl.add(btn5_1);

        JButton btn1_1 = new JButton("1");
        btn1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea2.setText(displayArea2.getText() + "1");
            }
        });
        btn1_1.setPreferredSize(new Dimension(105, 53));
        btn1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn1_1.setBounds(17, 333, 80, 53);
        scientificPnl.add(btn1_1);

        JButton btn2_1 = new JButton("2");
        btn2_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea2.setText(displayArea2.getText() + "2");
            }
        });
        btn2_1.setPreferredSize(new Dimension(105, 53));
        btn2_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn2_1.setBounds(104, 333, 80, 53);
        scientificPnl.add(btn2_1);

        JButton btn3_1 = new JButton("3");
        btn3_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea2.setText(displayArea2.getText() + "3");
            }
        });
        btn3_1.setPreferredSize(new Dimension(105, 53));
        btn3_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn3_1.setBounds(191, 333, 80, 53);
        scientificPnl.add(btn3_1);

        JButton btn0_1 = new JButton("0");
        btn0_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea2.setText(displayArea2.getText() + "0");
            }
        });
        btn0_1.setPreferredSize(new Dimension(105, 53));
        btn0_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn0_1.setBounds(17, 390, 254, 53);
        scientificPnl.add(btn0_1);

        JButton btnAllClear_1 = new JButton("AC");
        btnAllClear_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea2.setText("");
                historyDisplay2.setText("");
                sciOperationChoice = "";
                answer = 0.0;
                num = 0.0;
            }
        });
        btnAllClear_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnAllClear_1.setBounds(17, 159, 80, 53);
        scientificPnl.add(btnAllClear_1);

        JButton btnBackspace_1 = new JButton("←");
        btnBackspace_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea2.setText(backSpace(displayArea2.getText()));
            }
        });
        btnBackspace_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        btnBackspace_1.setBounds(191, 159, 80, 53);
        scientificPnl.add(btnBackspace_1);

        JButton btnClear_1 = new JButton("C");
        btnClear_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea2.setText(" ");
                historyDisplay2.setText(" ");
                sciOperationChoice = "";
                answer = 0.0;
                num = 0.0;
            }
        });
        btnClear_1.setPreferredSize(new Dimension(105, 53));
        btnClear_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnClear_1.setBounds(104, 159, 80, 53);
        scientificPnl.add(btnClear_1);

        JButton btnDivide_1 = new JButton("÷");
        btnDivide_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(displayArea2.getText());
                calculation2 = 3;
                displayArea2.setText("");
                historyDisplay2.setText(num + " / ");
            }
        });
        btnDivide_1.setPreferredSize(new Dimension(105, 53));
        btnDivide_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnDivide_1.setBounds(372, 159, 80, 53);
        scientificPnl.add(btnDivide_1);

        JButton btnMultiply_1 = new JButton("×");
        btnMultiply_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(displayArea2.getText());
                calculation2 = 4;
                displayArea2.setText("");
                historyDisplay2.setText(num + " * ");
            }
        });
        btnMultiply_1.setPreferredSize(new Dimension(105, 53));
        btnMultiply_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnMultiply_1.setBounds(372, 217, 80, 53);
        scientificPnl.add(btnMultiply_1);

        JButton btnMinus_1 = new JButton("-");
        btnMinus_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(displayArea2.getText());
                calculation2 = 2;
                displayArea2.setText("");
                historyDisplay2.setText(num + " - ");
            }
        });
        btnMinus_1.setPreferredSize(new Dimension(105, 53));
        btnMinus_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnMinus_1.setBounds(372, 275, 80, 53);
        scientificPnl.add(btnMinus_1);

        JButton btnAdd_1 = new JButton("+");
        btnAdd_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(displayArea2.getText());
                calculation2 = 1;
                displayArea2.setText("");
                historyDisplay2.setText(num + " + ");
            }
        });
        btnAdd_1.setPreferredSize(new Dimension(105, 53));
        btnAdd_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnAdd_1.setBounds(372, 333, 80, 53);
        scientificPnl.add(btnAdd_1);

        JButton btnEquals_1 = new JButton("=");
        btnEquals_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (sciOperationChoice != "") {
                        scientificOperation();
                    } else {
                        operation2();
                    }
                    historyDisplay2.setText(historyDisplay2.getText() + answer + " ");
                } catch (NumberFormatException e1) {
                    historyDisplay2.setText("0");
                }
                sciOperationChoice = "";
                answer = 0.0;
                num = 0.0;
            }
        });
        btnEquals_1.setPreferredSize(new Dimension(105, 53));
        btnEquals_1.setBounds(372, 390, 80, 53);
        scientificPnl.add(btnEquals_1);

        JButton btnSpecialDot_1 = new JButton(".");
        btnSpecialDot_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea2.setText(".");
            }
        });
        btnSpecialDot_1.setPreferredSize(new Dimension(105, 53));
        btnSpecialDot_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnSpecialDot_1.setBounds(278, 390, 80, 53);
        scientificPnl.add(btnSpecialDot_1);

        JButton btnPow = new JButton("xª");
        btnPow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(displayArea2.getText());
                sciOperationChoice = "power";
                displayArea2.setText("");
                historyDisplay2.setText(num + " ^ ");
            }
        });
        btnPow.setFont(new Font("Blackadder ITC", Font.PLAIN, 30));
        btnPow.setBounds(278, 159, 80, 53);
        scientificPnl.add(btnPow);

        JButton btnMod1 = new JButton("mod");
        btnMod1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(displayArea2.getText());
                sciOperationChoice = "mod";
                displayArea2.setText("");
                historyDisplay2.setText(num + " mod ");
            }
        });
        btnMod1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnMod1.setBounds(278, 217, 80, 53);
        scientificPnl.add(btnMod1);

        JButton btnSqrRoot = new JButton("√");
        btnSqrRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sciOperationChoice = "sqrRoot";
                    scientificOperation();
                } catch (NumberFormatException e2) {
                    historyDisplay2.setText("0");
                }
            }
        });
        btnSqrRoot.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnSqrRoot.setBounds(278, 275, 80, 53);
        scientificPnl.add(btnSqrRoot);

        JButton btnCubeRoot = new JButton("3√");
        btnCubeRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sciOperationChoice = "cubeRoot";
                    scientificOperation();
                } catch (NumberFormatException e2) {
                    historyDisplay2.setText("0");
                }

            }
        });
        btnCubeRoot.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnCubeRoot.setBounds(278, 333, 80, 53);
        scientificPnl.add(btnCubeRoot);

        JPanel programmerPnl = new JPanel();
        programmerPnl.setOpaque(false);
        parentPanel.add("programmer", programmerPnl);
        programmerPnl.setLayout(null);

        JLabel StandardPnl_1 = new JLabel("Programmer");
        StandardPnl_1.setHorizontalAlignment(SwingConstants.LEFT);
        StandardPnl_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        StandardPnl_1.setBounds(17, 11, 123, 60);
        programmerPnl.add(StandardPnl_1);

        btn8_1_1 = new JButton("8");
        btn8_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (progMode == "DEC") {
                        progDisplay1.setText(progDisplay1.getText() + "8");
                    } else if (progMode == "HEX") {
                        progDisplay1.setText(progDisplay1.getText() + "8");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                programmerFunctions();
            }
        });
        btn8_1_1.setPreferredSize(new Dimension(105, 53));
        btn8_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn8_1_1.setBounds(237, 224, 105, 50);
        programmerPnl.add(btn8_1_1);

        JButton btnClear3 = new JButton("C");
        btnClear3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progDisplay1.setText("");
                progDisplay2.setText("");
                inptHex = "";
                progTemp = 0;
                clickCount = 0;
            }
        });
        btnClear3.setPreferredSize(new Dimension(105, 53));
        btnClear3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnClear3.setBounds(237, 165, 105, 50);
        programmerPnl.add(btnClear3);

        JButton btnBackspace3 = new JButton("←");
        btnBackspace3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progDisplay1.setText(backSpace(progDisplay1.getText()));
                if (clickCount > 0) {
                    clickCount -= 1;
                }
                try {
                    programmerFunctions();
                } catch (NumberFormatException e2) {
                    progDisplay1.setText("");
                    progDisplay2.setText("0");
                }
            }
        });
        btnBackspace3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnBackspace3.setBounds(347, 165, 105, 50);
        programmerPnl.add(btnBackspace3);

        btn9_1_1 = new JButton("9");
        btn9_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (progMode == "DEC") {
                        progDisplay1.setText(progDisplay1.getText() + "9");
                    } else if (progMode == "HEX") {
                        progDisplay1.setText(progDisplay1.getText() + "9");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                programmerFunctions();
            }
        });
        btn9_1_1.setPreferredSize(new Dimension(105, 53));
        btn9_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn9_1_1.setBounds(347, 224, 105, 50);
        programmerPnl.add(btn9_1_1);

        btn7_1_1 = new JButton("7");
        btn7_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (progMode == "DEC") {
                        progDisplay1.setText(progDisplay1.getText() + "7");
                    } else if (progMode == "HEX") {
                        progDisplay1.setText(progDisplay1.getText() + "7");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                programmerFunctions();
            }
        });
        btn7_1_1.setPreferredSize(new Dimension(105, 53));
        btn7_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn7_1_1.setBounds(127, 224, 105, 50);
        programmerPnl.add(btn7_1_1);

        btn4_1_1 = new JButton("4");
        btn4_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (progMode == "DEC") {
                        progDisplay1.setText(progDisplay1.getText() + "4");
                    } else if (progMode == "HEX") {
                        progDisplay1.setText(progDisplay1.getText() + "4");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                programmerFunctions();
            }
        });
        btn4_1_1.setPreferredSize(new Dimension(105, 53));
        btn4_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn4_1_1.setBounds(127, 283, 105, 50);
        programmerPnl.add(btn4_1_1);

        btn5_1_1 = new JButton("5");
        btn5_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (progMode == "DEC") {
                        progDisplay1.setText(progDisplay1.getText() + "5");
                    } else if (progMode == "HEX") {
                        progDisplay1.setText(progDisplay1.getText() + "5");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                programmerFunctions();
            }
        });
        btn5_1_1.setPreferredSize(new Dimension(105, 53));
        btn5_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn5_1_1.setBounds(237, 283, 105, 50);
        programmerPnl.add(btn5_1_1);

        btn6_1_1 = new JButton("6");
        btn6_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (progMode == "DEC") {
                        progDisplay1.setText(progDisplay1.getText() + "6");
                    } else if (progMode == "HEX") {
                        progDisplay1.setText(progDisplay1.getText() + "6");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                programmerFunctions();
            }
        });
        btn6_1_1.setPreferredSize(new Dimension(105, 53));
        btn6_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn6_1_1.setBounds(347, 283, 105, 50);
        programmerPnl.add(btn6_1_1);

        JButton btn1_1_1 = new JButton("1");
        btn1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (progMode == "DEC") {
                        progDisplay1.setText(progDisplay1.getText() + "1");
                    } else if (progMode == "HEX") {
                        progDisplay1.setText(progDisplay1.getText() + "1");
                    } else if (progMode == "BIN") {
                        progDisplay1.setText(progDisplay1.getText() + "1");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                programmerFunctions();
            }
        });
        btn1_1_1.setPreferredSize(new Dimension(105, 53));
        btn1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn1_1_1.setBounds(127, 342, 105, 50);
        programmerPnl.add(btn1_1_1);

        btn2_1_1 = new JButton("2");
        btn2_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (progMode == "DEC") {
                        progDisplay1.setText(progDisplay1.getText() + "2");
                    } else if (progMode == "HEX") {
                        progDisplay1.setText(progDisplay1.getText() + "2");
                    } else if (progMode == "BIN") {
                        progDisplay1.setText(progDisplay1.getText() + "2");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                programmerFunctions();
            }
        });
        btn2_1_1.setPreferredSize(new Dimension(105, 53));
        btn2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn2_1_1.setBounds(237, 342, 105, 50);
        programmerPnl.add(btn2_1_1);

        btn3_1_1 = new JButton("3");
        btn3_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (progMode == "DEC") {
                        progDisplay1.setText(progDisplay1.getText() + "3");
                    } else if (progMode == "HEX") {
                        progDisplay1.setText(progDisplay1.getText() + "3");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                programmerFunctions();
            }
        });
        btn3_1_1.setPreferredSize(new Dimension(105, 53));
        btn3_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn3_1_1.setBounds(347, 342, 105, 50);
        programmerPnl.add(btn3_1_1);

        JButton btn0_1_1 = new JButton("0");
        btn0_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (progMode == "DEC") {
                        progDisplay1.setText(progDisplay1.getText() + "0");
                    } else if (progMode == "HEX") {
                        progDisplay1.setText(progDisplay1.getText() + "0");
                    } else if (progMode == "BIN") {
                        progDisplay1.setText(progDisplay1.getText() + "0");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                programmerFunctions();
            }
        });
        btn0_1_1.setPreferredSize(new Dimension(105, 53));
        btn0_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn0_1_1.setBounds(237, 401, 105, 50);
        programmerPnl.add(btn0_1_1);

        btnA = new JButton("A");
        btnA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    progDisplay1.setText(progDisplay1.getText() + "A");
                } else {
                    return;
                }
                clickCount += 1;
                programmerFunctions();
            }
        });
        btnA.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnA.setBounds(17, 165, 105, 50);
        programmerPnl.add(btnA);

        btnB = new JButton("B");
        btnB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    progDisplay1.setText(progDisplay1.getText() + "B");
                } else {
                    return;
                }
                clickCount += 1;
                programmerFunctions();
            }
        });
        btnB.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnB.setBounds(17, 224, 105, 50);
        programmerPnl.add(btnB);

        btnC = new JButton("C");
        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    progDisplay1.setText(progDisplay1.getText() + "C");
                } else {
                    return;
                }
                clickCount += 1;
                programmerFunctions();
            }
        });
        btnC.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnC.setBounds(17, 283, 105, 50);
        programmerPnl.add(btnC);

        btnD = new JButton("D");
        btnD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    progDisplay1.setText(progDisplay1.getText() + "D");
                } else {
                    return;
                }
                clickCount += 1;
                programmerFunctions();
            }
        });
        btnD.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnD.setBounds(17, 342, 105, 50);
        programmerPnl.add(btnD);

        btnE = new JButton("E");
        btnE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    progDisplay1.setText(progDisplay1.getText() + "E");
                } else {
                    return;
                }
                clickCount += 1;
                programmerFunctions();
            }
        });
        btnE.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnE.setBounds(17, 401, 105, 50);
        programmerPnl.add(btnE);

        btnF = new JButton("F");
        btnF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    progDisplay1.setText(progDisplay1.getText() + "F");
                } else {
                    return;
                }
                clickCount += 1;
                programmerFunctions();
            }
        });
        btnF.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnF.setBounds(127, 401, 105, 50);
        programmerPnl.add(btnF);

        String[] programmerItems = { "DEC", "HEX", "BIN" };
        convertFrom = new JComboBox(programmerItems);
        convertFrom.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        convertFrom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedProgItems = (String) convertFrom.getSelectedItem();
                switch (selectedProgItems) {
                case "DEC":
                    progMode = "DEC";
                    clickCount = 0;
                    progDisplay1.setText("");
                    disableHexBtn();
                    enableButtonForBinary();
                    break;
                case "HEX":
                    progMode = "HEX";
                    clickCount = 0;
                    progDisplay1.setText("");
                    enableHexBtn();
                    enableButtonForBinary();
                    break;
                case "BIN":
                    progMode = "BIN";
                    clickCount = 0;
                    progDisplay1.setText("");
                    disableHexBtn();
                    disableButtonForBinary();
                    break;
                default:
                    progMode = "";
                    break;
                }
            }
        });
        convertFrom.setBounds(17, 67, 105, 33);
        programmerPnl.add(convertFrom);

        progDisplay2 = new JTextField();
        progDisplay2.setBorder(null);
        progDisplay2.setEditable(false);
        progDisplay2.setFont(new Font("Segoe UI", Font.BOLD, 20));
        progDisplay2.setBounds(127, 121, 325, 33);
        programmerPnl.add(progDisplay2);
        progDisplay2.setColumns(10);

        progDisplay1 = new JTextField();
        progDisplay1.setBorder(null);
        progDisplay1.setEditable(false);
        progDisplay1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        progDisplay1.setColumns(10);
        progDisplay1.setBounds(127, 67, 325, 33);
        programmerPnl.add(progDisplay1);

        JPanel temperaturePnl = new JPanel();
        temperaturePnl.setOpaque(false);
        parentPanel.add("temperature", temperaturePnl);
        temperaturePnl.setLayout(null);

        JLabel TempLbl = new JLabel("Temperature");
        TempLbl.setHorizontalAlignment(SwingConstants.LEFT);
        TempLbl.setFont(new Font("Open Sans", Font.PLAIN, 22));
        TempLbl.setBounds(312, 17, 148, 41);
        temperaturePnl.add(TempLbl);

        JButton btn0_1_1_1 = new JButton("0");
        btn0_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 12) {
                    if (userTempChoice == "Fahrenheit") {
                        convertToDisplay.setText(convertToDisplay.getText() + "0");
                    }
                    if (userTempChoice == "Celcius") {
                        convertFromDisplay.setText(convertFromDisplay.getText() + "0");
                    }
                    temperatureConvert();
                    clickCount += 1;
                } else {
                    return;
                }
            }
        });
        btn0_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn0_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn0_1_1_1.setBounds(162, 397, 144, 47);
        temperaturePnl.add(btn0_1_1_1);

        JButton btn1_1_1_1 = new JButton("1");
        btn1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 12) {
                    if (userTempChoice == "Fahrenheit") {
                        convertToDisplay.setText(convertToDisplay.getText() + "1");
                    }
                    if (userTempChoice == "Celcius") {
                        convertFromDisplay.setText(convertFromDisplay.getText() + "1");
                    }
                    temperatureConvert();
                    clickCount += 1;
                } else {
                    return;
                }
            }
        });
        btn1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn1_1_1_1.setBounds(10, 343, 144, 47);
        temperaturePnl.add(btn1_1_1_1);

        JButton btn2_1_1_1 = new JButton("2");
        btn2_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 12) {
                    if (userTempChoice == "Fahrenheit") {
                        convertToDisplay.setText(convertToDisplay.getText() + "2");
                    }
                    if (userTempChoice == "Celcius") {
                        convertFromDisplay.setText(convertFromDisplay.getText() + "2");
                    }
                    temperatureConvert();
                    clickCount += 1;
                } else {
                    return;
                }
            }
        });
        btn2_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn2_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn2_1_1_1.setBounds(162, 343, 144, 47);
        temperaturePnl.add(btn2_1_1_1);

        JButton btn3_1_1_1 = new JButton("3");
        btn3_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 12) {
                    if (userTempChoice == "Fahrenheit") {
                        convertToDisplay.setText(convertToDisplay.getText() + "3");
                    }
                    if (userTempChoice == "Celcius") {
                        convertFromDisplay.setText(convertFromDisplay.getText() + "3");
                    }
                    temperatureConvert();
                    clickCount += 1;
                } else {
                    return;
                }
            }
        });
        btn3_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn3_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn3_1_1_1.setBounds(314, 343, 144, 47);
        temperaturePnl.add(btn3_1_1_1);

        JButton btn4_1_1_1 = new JButton("4");
        btn4_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 12) {
                    if (userTempChoice == "Fahrenheit") {
                        convertToDisplay.setText(convertToDisplay.getText() + "4");
                    }
                    if (userTempChoice == "Celcius") {
                        convertFromDisplay.setText(convertFromDisplay.getText() + "4");
                    }
                    temperatureConvert();
                    clickCount += 1;
                } else {
                    return;
                }
            }
        });
        btn4_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn4_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn4_1_1_1.setBounds(10, 289, 144, 47);
        temperaturePnl.add(btn4_1_1_1);

        JButton btn5_1_1_1 = new JButton("5");
        btn5_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 12) {
                    if (userTempChoice == "Fahrenheit") {
                        convertToDisplay.setText(convertToDisplay.getText() + "5");
                    }
                    if (userTempChoice == "Celcius") {
                        convertFromDisplay.setText(convertFromDisplay.getText() + "5");
                    }
                    temperatureConvert();
                    clickCount += 1;
                } else {
                    return;
                }
            }
        });
        btn5_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn5_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn5_1_1_1.setBounds(162, 289, 144, 47);
        temperaturePnl.add(btn5_1_1_1);

        JButton btn6_1_1_1 = new JButton("6");
        btn6_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 12) {
                    if (userTempChoice == "Fahrenheit") {
                        convertToDisplay.setText(convertToDisplay.getText() + "6");
                    }
                    if (userTempChoice == "Celcius") {
                        convertFromDisplay.setText(convertFromDisplay.getText() + "6");
                    }
                    temperatureConvert();
                    clickCount += 1;
                } else {
                    return;
                }
            }
        });
        btn6_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn6_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn6_1_1_1.setBounds(314, 289, 144, 47);
        temperaturePnl.add(btn6_1_1_1);

        JButton btn7_1_1_1 = new JButton("7");
        btn7_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 12) {
                    if (userTempChoice == "Fahrenheit") {
                        convertToDisplay.setText(convertToDisplay.getText() + "7");
                    }
                    if (userTempChoice == "Celcius") {
                        convertFromDisplay.setText(convertFromDisplay.getText() + "7");
                    }
                    temperatureConvert();
                    clickCount += 1;
                } else {
                    return;
                }
            }
        });
        btn7_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn7_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn7_1_1_1.setBounds(10, 235, 144, 47);
        temperaturePnl.add(btn7_1_1_1);

        JButton btn8_1_1_1 = new JButton("8");
        btn8_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 12) {
                    if (userTempChoice == "Fahrenheit") {
                        convertToDisplay.setText(convertToDisplay.getText() + "8");
                    }
                    if (userTempChoice == "Celcius") {
                        convertFromDisplay.setText(convertFromDisplay.getText() + "8");
                    }
                    temperatureConvert();
                    clickCount += 1;
                } else {
                    return;
                }
            }
        });
        btn8_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn8_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn8_1_1_1.setBounds(162, 235, 144, 47);
        temperaturePnl.add(btn8_1_1_1);

        JButton btn9_1_1_1 = new JButton("9");
        btn9_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 12) {
                    if (userTempChoice == "Fahrenheit") {
                        convertToDisplay.setText(convertToDisplay.getText() + "9");
                    }
                    if (userTempChoice == "Celcius") {
                        convertFromDisplay.setText(convertFromDisplay.getText() + "9");
                    }
                    temperatureConvert();
                    clickCount += 1;
                } else {
                    return;
                }
            }
        });
        btn9_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn9_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn9_1_1_1.setBounds(314, 235, 144, 47);
        temperaturePnl.add(btn9_1_1_1);

        JButton btnSpecialDot_1_1_1 = new JButton(".");
        btnSpecialDot_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 12) {
                    if (userTempChoice == "Fahrenheit") {
                        convertToDisplay.setText(convertToDisplay.getText() + ".");
                    }
                    if (userTempChoice == "Celcius") {
                        convertFromDisplay.setText(convertFromDisplay.getText() + ".");
                    }
                    clickCount += 1;
                } else {
                    return;
                }
            }
        });
        btnSpecialDot_1_1_1.setPreferredSize(new Dimension(105, 53));
        btnSpecialDot_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnSpecialDot_1_1_1.setBounds(314, 397, 144, 47);
        temperaturePnl.add(btnSpecialDot_1_1_1);

        JButton btnClear_1_1_1 = new JButton("C");
        btnClear_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertFromDisplay.setText("");
                convertToDisplay.setText("");
                answer = 0.0;
                clickCount = 0;
            }
        });
        btnClear_1_1_1.setPreferredSize(new Dimension(105, 53));
        btnClear_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnClear_1_1_1.setBounds(162, 181, 144, 47);
        temperaturePnl.add(btnClear_1_1_1);

        JButton btnBackspace_1_1_1 = new JButton("←");
        btnBackspace_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userTempChoice == "Fahrenheit") {
                    convertToDisplay.setText(backSpace(convertToDisplay.getText()));
                } else if (userTempChoice == "Celcius") {
                    convertFromDisplay.setText(backSpace(convertFromDisplay.getText()));
                } else {
                    return;
                }
                try {
                    temperatureConvert();
                } catch (Exception e2) {
                    convertFromDisplay.setText("");
                    convertToDisplay.setText("");
                }
                if (clickCount > 0) {
                    clickCount -= 1;
                }
            }
        });
        btnBackspace_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnBackspace_1_1_1.setBounds(314, 181, 144, 47);
        temperaturePnl.add(btnBackspace_1_1_1);

        JButton btnNewButton = new JButton("+/-");
        btnNewButton.setEnabled(false);
        btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnNewButton.setBounds(10, 397, 144, 47);
        temperaturePnl.add(btnNewButton);

        convertFromDisplay = new JTextField();
        convertFromDisplay.setOpaque(false);
        convertFromDisplay.setBorder(null);
        convertFromDisplay.setFont(new Font("Segoe UI", Font.BOLD, 20));
        convertFromDisplay.setEditable(false);
        convertFromDisplay.setFocusable(false);
        convertFromDisplay.setRequestFocusEnabled(false);
        convertFromDisplay.setBounds(32, 40, 268, 41);
        temperaturePnl.add(convertFromDisplay);
        convertFromDisplay.setColumns(10);

        convertToDisplay = new JTextField();
        convertToDisplay.setOpaque(false);
        convertToDisplay.setBorder(null);
        convertToDisplay.setEditable(false);
        convertToDisplay.setFont(new Font("Segoe UI", Font.BOLD, 20));
        convertToDisplay.setFocusable(false);
        convertToDisplay.setRequestFocusEnabled(false);
        convertToDisplay.setColumns(10);
        convertToDisplay.setBounds(32, 127, 268, 41);
        temperaturePnl.add(convertToDisplay);

        JRadioButton CelciusBtn = new JRadioButton("Celcius");
        CelciusBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        CelciusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userTempChoice = "Fahrenheit";
                convertToDisplay.setText("");
                convertFromDisplay.setText("");
                clickCount = 0;
            }
        });
        CelciusBtn.setBounds(10, 106, 109, 23);
        temperaturePnl.add(CelciusBtn);

        JRadioButton FahrenheitBtn = new JRadioButton("Fahrenheit");
        FahrenheitBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        FahrenheitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userTempChoice = "Celcius";
                convertFromDisplay.setText("");
                convertFromDisplay.setText("");
                clickCount = 0;
            }
        });
        FahrenheitBtn.setBounds(10, 19, 109, 23);
        temperaturePnl.add(FahrenheitBtn);

        JPanel lengthPnl = new JPanel();
        lengthPnl.setOpaque(false);
        parentPanel.add("length", lengthPnl);
        lengthPnl.setLayout(null);

        JButton btnClear_1_1_1_1 = new JButton("C");
        btnClear_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertLenDisplay1.setText("");
                convertLenDisplay2.setText("");
                answer = 0;
                clickCount = 0;
            }
        });
        btnClear_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btnClear_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnClear_1_1_1_1.setBounds(162, 181, 144, 47);
        lengthPnl.add(btnClear_1_1_1_1);

        JButton btnBackspace_1_1_1_1 = new JButton("←");
        btnBackspace_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertLenDisplay1.setText(backSpace(convertLenDisplay1.getText()));
                if (clickCount > 0) {
                    clickCount -= 1;
                }
                try {
                    convertLength();
                } catch (NumberFormatException e2) {
                    convertLenDisplay1.setText("");
                    convertLenDisplay2.setText("0");

                }
            }
        });
        btnBackspace_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnBackspace_1_1_1_1.setBounds(314, 181, 144, 47);
        lengthPnl.add(btnBackspace_1_1_1_1);

        JButton btn9_1_1_1_1 = new JButton("9");
        btn9_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricLength == "CENTIMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "9");
                    } else if (metricLength == "METER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "9");
                    } else if (metricLength == "KILOMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "9");
                    } else {
                        convertLenDisplay1.setText("");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                convertLength();
            }
        });
        btn9_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn9_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn9_1_1_1_1.setBounds(314, 235, 144, 47);
        lengthPnl.add(btn9_1_1_1_1);

        JButton btn8_1_1_1_1 = new JButton("8");
        btn8_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricLength == "CENTIMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "8");
                    } else if (metricLength == "METER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "8");
                    } else if (metricLength == "KILOMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "8");
                    } else {
                        convertLenDisplay1.setText("");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                convertLength();
            }
        });
        btn8_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn8_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn8_1_1_1_1.setBounds(162, 235, 144, 47);
        lengthPnl.add(btn8_1_1_1_1);

        JButton btn7_1_1_1_1 = new JButton("7");
        btn7_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricLength == "CENTIMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "7");
                    } else if (metricLength == "METER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "7");
                    } else if (metricLength == "KILOMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "7");
                    } else {
                        convertLenDisplay1.setText("");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                convertLength();
            }
        });
        btn7_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn7_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn7_1_1_1_1.setBounds(10, 235, 144, 47);
        lengthPnl.add(btn7_1_1_1_1);

        JButton btn4_1_1_1_1 = new JButton("4");
        btn4_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricLength == "CENTIMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "4");
                    } else if (metricLength == "METER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "4");
                    } else if (metricLength == "KILOMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "4");
                    } else {
                        convertLenDisplay1.setText("");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                convertLength();
            }
        });
        btn4_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn4_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn4_1_1_1_1.setBounds(10, 289, 144, 47);
        lengthPnl.add(btn4_1_1_1_1);

        JButton btn5_1_1_1_1 = new JButton("5");
        btn5_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricLength == "CENTIMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "5");
                    } else if (metricLength == "METER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "5");
                    } else if (metricLength == "KILOMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "5");
                    } else {
                        convertLenDisplay1.setText("");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                convertLength();
            }
        });
        btn5_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn5_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn5_1_1_1_1.setBounds(162, 289, 144, 47);
        lengthPnl.add(btn5_1_1_1_1);

        JButton btn6_1_1_1_1 = new JButton("6");
        btn6_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricLength == "CENTIMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "6");
                    } else if (metricLength == "METER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "6");
                    } else if (metricLength == "KILOMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "6");
                    } else {
                        convertLenDisplay1.setText("");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                convertLength();
            }
        });
        btn6_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn6_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn6_1_1_1_1.setBounds(314, 289, 144, 47);
        lengthPnl.add(btn6_1_1_1_1);

        JButton btn3_1_1_1_1 = new JButton("3");
        btn3_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricLength == "CENTIMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "3");
                    } else if (metricLength == "METER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "3");
                    } else if (metricLength == "KILOMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "3");
                    } else {
                        convertLenDisplay1.setText("");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                convertLength();
            }
        });
        btn3_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn3_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn3_1_1_1_1.setBounds(314, 343, 144, 47);
        lengthPnl.add(btn3_1_1_1_1);

        JButton btn1_1_1_1_1 = new JButton("1");
        btn1_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricLength == "CENTIMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "1");
                    } else if (metricLength == "METER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "1");
                    } else if (metricLength == "KILOMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "1");
                    } else {
                        convertLenDisplay1.setText("");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                convertLength();
            }
        });
        btn1_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn1_1_1_1_1.setBounds(10, 343, 144, 47);
        lengthPnl.add(btn1_1_1_1_1);

        JButton btn2_1_1_1_1 = new JButton("2");
        btn2_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricLength == "CENTIMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "2");
                    } else if (metricLength == "METER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "2");
                    } else if (metricLength == "KILOMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "2");
                    } else {
                        convertLenDisplay1.setText("");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                convertLength();
            }
        });
        btn2_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn2_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn2_1_1_1_1.setBounds(162, 343, 144, 47);
        lengthPnl.add(btn2_1_1_1_1);

        JButton btn0_1_1_1_1 = new JButton("0");
        btn0_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricLength == "CENTIMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "0");
                    } else if (metricLength == "METER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "0");
                    } else if (metricLength == "KILOMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + "0");
                    } else {
                        convertLenDisplay1.setText("");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                convertLength();
            }
        });
        btn0_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn0_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn0_1_1_1_1.setBounds(162, 397, 144, 47);
        lengthPnl.add(btn0_1_1_1_1);

        JButton btnSpecialDot_1_1_1_1 = new JButton(".");
        btnSpecialDot_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricLength == "CENTIMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + ".");
                    } else if (metricLength == "METER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + ".");
                    } else if (metricLength == "KILOMETER") {
                        convertLenDisplay1.setText(convertLenDisplay1.getText() + ".");
                    } else {
                        convertLenDisplay1.setText("");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                convertLength();
            }
        });
        btnSpecialDot_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btnSpecialDot_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnSpecialDot_1_1_1_1.setBounds(314, 397, 144, 47);
        lengthPnl.add(btnSpecialDot_1_1_1_1);

        convertLenDisplay2 = new JTextField();
        convertLenDisplay2.setBorder(null);
        convertLenDisplay2.setFont(new Font("Segoe UI", Font.BOLD, 20));
        convertLenDisplay2.setRequestFocusEnabled(false);
        convertLenDisplay2.setOpaque(false);
        convertLenDisplay2.setFocusable(false);
        convertLenDisplay2.setEditable(false);
        convertLenDisplay2.setColumns(10);
        convertLenDisplay2.setBounds(20, 127, 302, 41);
        lengthPnl.add(convertLenDisplay2);

        convertLenDisplay1 = new JTextField();
        convertLenDisplay1.setBorder(null);
        convertLenDisplay1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        convertLenDisplay1.setRequestFocusEnabled(false);
        convertLenDisplay1.setOpaque(false);
        convertLenDisplay1.setFocusable(false);
        convertLenDisplay1.setEditable(false);
        convertLenDisplay1.setColumns(10);
        convertLenDisplay1.setBounds(20, 40, 302, 41);
        lengthPnl.add(convertLenDisplay1);

        String[] lengthItems = { "CENTIMETER", "METER", "KILOMETER" };
        JComboBox convertFromItem2 = new JComboBox(lengthItems);
        convertFromItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedLenItems = (String) convertFromItem2.getSelectedItem();
                switch (selectedLenItems) {
                case "CENTIMETER":
                    metricLength = "CENTIMETER";
                    clickCount = 0;
                    convertLength();
                    break;
                case "METER":
                    metricLength = "METER";
                    clickCount = 0;
                    convertLength();
                    break;
                case "KILOMETER":
                    metricLength = "KILOMETER";
                    clickCount = 0;
                    convertLength();
                    break;
                default:
                    metricLength = "CENTIMETER";
                    break;
                }
            }
        });
        convertFromItem2.setBounds(20, 11, 144, 24);
        lengthPnl.add(convertFromItem2);

        JLabel lengthLbl = new JLabel("Length");
        lengthLbl.setBorder(null);
        lengthLbl.setHorizontalAlignment(SwingConstants.LEFT);
        lengthLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        lengthLbl.setBounds(342, 17, 118, 41);
        lengthPnl.add(lengthLbl);

        String[] toLengthItem = { "INCHES", "FEET", "YARDS", "MILES" };
        JComboBox convertToItem2 = new JComboBox(toLengthItem);
        convertToItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selLenItem = (String) convertToItem2.getSelectedItem();
                switch (selLenItem) {
                case "INCHES":
                    imperialLen = "INCHES";
                    clickCount = 0;
                    try {
                        convertLength();
                    } catch (Exception e2) {
                        return;
                    }
                    break;
                case "FEET":
                    imperialLen = "FEET";
                    clickCount = 0;
                    try {
                        convertLength();
                    } catch (Exception e2) {
                        return;
                    }
                    break;
                case "YARDS":
                    imperialLen = "YARDS";
                    clickCount = 0;
                    try {
                        convertLength();
                    } catch (Exception e2) {
                        return;
                    }
                    break;
                case "MILES":
                    imperialLen = "MILES";
                    clickCount = 0;
                    try {
                        convertLength();
                    } catch (Exception e2) {
                        return;
                    }
                    break;
                default:
                    imperialLen = "INCHES";
                    break;
                }
            }
        });
        convertToItem2.setBounds(20, 98, 144, 24);
        lengthPnl.add(convertToItem2);

        JPanel wgtMassPnl = new JPanel();
        wgtMassPnl.setOpaque(false);
        parentPanel.add("weightAndMass", wgtMassPnl);
        wgtMassPnl.setLayout(null);

        convertMassDisplay1 = new JTextField();
        convertMassDisplay1.setBorder(null);
        convertMassDisplay1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        convertMassDisplay1.setRequestFocusEnabled(false);
        convertMassDisplay1.setOpaque(false);
        convertMassDisplay1.setFocusable(false);
        convertMassDisplay1.setEditable(false);
        convertMassDisplay1.setColumns(10);
        convertMassDisplay1.setBounds(20, 40, 296, 41);
        wgtMassPnl.add(convertMassDisplay1);

        String[] MassUnitsItems = { "GRAM", "KILOGRAM" };
        JComboBox convertFromItem3 = new JComboBox(MassUnitsItems);
        convertFromItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedMassItems = (String) convertFromItem3.getSelectedItem();
                switch (selectedMassItems) {
                case "GRAM":
                    metricMass = "GRAM";
                    clickCount = 0;
                    convertWeight();
                    break;
                case "KILOGRAM":
                    metricMass = "KILOGRAM";
                    clickCount = 0;
                    convertWeight();
                    break;
                default:
                    metricMass = "GRAM";
                    break;
                }
            }
        });
        convertFromItem3.setBounds(20, 11, 144, 24);
        wgtMassPnl.add(convertFromItem3);

        convertMassDisplay2 = new JTextField();
        convertMassDisplay2.setBorder(null);
        convertMassDisplay2.setFont(new Font("Segoe UI", Font.BOLD, 20));
        convertMassDisplay2.setRequestFocusEnabled(false);
        convertMassDisplay2.setOpaque(false);
        convertMassDisplay2.setFocusable(false);
        convertMassDisplay2.setEditable(false);
        convertMassDisplay2.setColumns(10);
        convertMassDisplay2.setBounds(20, 127, 296, 41);
        wgtMassPnl.add(convertMassDisplay2);

        JButton btnClear_1_1_1_1_1 = new JButton("C");
        btnClear_1_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertMassDisplay1.setText("");
                convertMassDisplay2.setText("");
                answer = 0;
                clickCount = 0;
            }
        });
        btnClear_1_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btnClear_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnClear_1_1_1_1_1.setBounds(162, 181, 144, 47);
        wgtMassPnl.add(btnClear_1_1_1_1_1);

        JButton btnBackspace_1_1_1_1_1 = new JButton("←");
        btnBackspace_1_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertMassDisplay1.setText(backSpace(convertMassDisplay1.getText()));
                if (clickCount > 0) {
                    clickCount -= 1;
                }
                try {
                    convertWeight();
                } catch (NumberFormatException e2) {
                    convertMassDisplay1.setText("");
                    convertMassDisplay2.setText("0");
                }
            }
        });
        btnBackspace_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnBackspace_1_1_1_1_1.setBounds(314, 181, 144, 47);
        wgtMassPnl.add(btnBackspace_1_1_1_1_1);

        JButton btn9_1_1_1_1_1 = new JButton("9");
        btn9_1_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricMass == "GRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "9");
                    } else if (metricMass == "KILOGRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "9");
                    } else {
                        convertMassDisplay1.setText("");
                    }
                } else {
                    convertMassDisplay1.setText("");
                }
                clickCount += 1;
                convertWeight();
            }
        });
        btn9_1_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn9_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn9_1_1_1_1_1.setBounds(314, 235, 144, 47);
        wgtMassPnl.add(btn9_1_1_1_1_1);

        JButton btn7_1_1_1_1_1 = new JButton("7");
        btn7_1_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricMass == "GRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "7");
                    } else if (metricMass == "KILOGRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "7");
                    } else {
                        convertMassDisplay1.setText("");
                    }
                } else {
                    convertMassDisplay1.setText("");
                }
                clickCount += 1;
                convertWeight();
            }
        });
        btn7_1_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn7_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn7_1_1_1_1_1.setBounds(10, 235, 144, 47);
        wgtMassPnl.add(btn7_1_1_1_1_1);

        JButton btn8_1_1_1_1_1 = new JButton("8");
        btn8_1_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricMass == "GRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "8");
                    } else if (metricMass == "KILOGRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "8");
                    } else {
                        convertMassDisplay1.setText("");
                    }
                } else {
                    convertMassDisplay1.setText("");
                }
                clickCount += 1;
                convertWeight();
            }
        });
        btn8_1_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn8_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn8_1_1_1_1_1.setBounds(162, 235, 144, 47);
        wgtMassPnl.add(btn8_1_1_1_1_1);

        JButton btn4_1_1_1_1_1 = new JButton("4");
        btn4_1_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricMass == "GRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "4");
                    } else if (metricMass == "KILOGRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "4");
                    } else {
                        convertMassDisplay1.setText("");
                    }
                } else {
                    convertMassDisplay1.setText("");
                }
                clickCount += 1;
                convertWeight();
            }
        });
        btn4_1_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn4_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn4_1_1_1_1_1.setBounds(10, 289, 144, 47);
        wgtMassPnl.add(btn4_1_1_1_1_1);

        JButton btn5_1_1_1_1_1 = new JButton("5");
        btn5_1_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricMass == "GRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "5");
                    } else if (metricMass == "KILOGRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "5");
                    } else {
                        convertMassDisplay1.setText("");
                    }
                } else {
                    convertMassDisplay1.setText("");
                }
                clickCount += 1;
                convertWeight();
            }
        });
        btn5_1_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn5_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn5_1_1_1_1_1.setBounds(162, 289, 144, 47);
        wgtMassPnl.add(btn5_1_1_1_1_1);

        JButton btn6_1_1_1_1_1 = new JButton("6");
        btn6_1_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricMass == "GRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "6");
                    } else if (metricMass == "KILOGRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "6");
                    } else {
                        convertMassDisplay1.setText("");
                    }
                } else {
                    convertMassDisplay1.setText("");
                }
                clickCount += 1;
                convertWeight();
            }
        });
        btn6_1_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn6_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn6_1_1_1_1_1.setBounds(314, 289, 144, 47);
        wgtMassPnl.add(btn6_1_1_1_1_1);

        JButton btn1_1_1_1_1_1 = new JButton("1");
        btn1_1_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricMass == "GRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "1");
                    } else if (metricMass == "KILOGRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "1");
                    } else {
                        convertMassDisplay1.setText("");
                    }
                } else {
                    convertMassDisplay1.setText("");
                }
                clickCount += 1;
                convertWeight();
            }
        });
        btn1_1_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn1_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn1_1_1_1_1_1.setBounds(10, 343, 144, 47);
        wgtMassPnl.add(btn1_1_1_1_1_1);

        JButton btn2_1_1_1_1_1 = new JButton("2");
        btn2_1_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricMass == "GRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "2");
                    } else if (metricMass == "KILOGRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "2");
                    } else {
                        convertMassDisplay1.setText("");
                    }
                } else {
                    convertMassDisplay1.setText("");
                }
                clickCount += 1;
                convertWeight();
            }
        });
        btn2_1_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn2_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn2_1_1_1_1_1.setBounds(162, 343, 144, 47);
        wgtMassPnl.add(btn2_1_1_1_1_1);

        JButton btn3_1_1_1_1_1 = new JButton("3");
        btn3_1_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricMass == "GRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "3");
                    } else if (metricMass == "KILOGRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "3");
                    } else {
                        convertMassDisplay1.setText("");
                    }
                } else {
                    convertMassDisplay1.setText("");
                }
                clickCount += 1;
                convertWeight();
            }
        });
        btn3_1_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn3_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn3_1_1_1_1_1.setBounds(314, 343, 144, 47);
        wgtMassPnl.add(btn3_1_1_1_1_1);

        JButton btn0_1_1_1_1_1 = new JButton("0");
        btn0_1_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricMass == "GRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "0");
                    } else if (metricMass == "KILOGRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + "0");
                    } else {
                        convertMassDisplay1.setText("");
                    }
                } else {
                    convertMassDisplay1.setText("");
                }
                clickCount += 1;
                convertWeight();
            }
        });
        btn0_1_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btn0_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btn0_1_1_1_1_1.setBounds(162, 397, 144, 47);
        wgtMassPnl.add(btn0_1_1_1_1_1);

        JButton btnSpecialDot_1_1_1_1_1 = new JButton(".");
        btnSpecialDot_1_1_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickCount < 9) {
                    if (metricMass == "GRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + ".");
                    } else if (metricMass == "KILOGRAM") {
                        convertMassDisplay1.setText(convertMassDisplay1.getText() + ".");
                    } else {
                        convertMassDisplay1.setText("");
                    }
                } else {
                    return;
                }
                clickCount += 1;
                convertWeight();
            }
        });
        btnSpecialDot_1_1_1_1_1.setPreferredSize(new Dimension(105, 53));
        btnSpecialDot_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnSpecialDot_1_1_1_1_1.setBounds(314, 397, 144, 47);
        wgtMassPnl.add(btnSpecialDot_1_1_1_1_1);

        JLabel weightLbl = new JLabel("Weigth");
        weightLbl.setHorizontalAlignment(SwingConstants.LEFT);
        weightLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        weightLbl.setBounds(372, 17, 88, 41);
        wgtMassPnl.add(weightLbl);

        String[] toMassItem = { "OUNCES", "POUNDS", "STONE", "US-TONNE" };
        JComboBox convertToItem3 = new JComboBox(toMassItem);
        convertToItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedImpItem = (String) convertToItem3.getSelectedItem();
                switch (selectedImpItem) {
                case "OUNCES":
                    selMassImperial = "OUNCES";
                    clickCount = 0;
                    try {
                        convertWeight();
                    } catch (Exception e2) {
                        return;
                    }
                    break;
                case "POUNDS":
                    selMassImperial = "POUNDS";
                    clickCount = 0;
                    try {
                        convertWeight();
                    } catch (Exception e2) {
                        return;
                    }
                    break;
                case "STONE":
                    selMassImperial = "STONE";
                    clickCount = 0;
                    try {
                        convertWeight();
                    } catch (Exception e2) {
                        return;
                    }
                    break;
                case "US-TONNE":
                    selMassImperial = "US-TONNE";
                    clickCount = 0;
                    try {
                        convertWeight();
                    } catch (Exception e2) {
                        return;
                    }
                    break;
                default:
                    selMassImperial = "";
                    break;
                }
            }
        });
        convertToItem3.setBounds(20, 98, 144, 24);
        wgtMassPnl.add(convertToItem3);

        ///////////////// menu buttons /////////////////////
        /**************** Menu Group 1 *******************/
        JLabel menuItmGrp1 = new JLabel("Calculator");
        menuItmGrp1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menuItmGrp1.setBounds(10, 11, 81, 28);
        menuPanel.add(menuItmGrp1);

        JRadioButton menuItem1 = new JRadioButton("Standard");
        menuItem1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menuItem1.setBounds(10, 46, 125, 23);
        menuPanel.add(menuItem1);

        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(standardPnl);
                parentPanel.repaint();
                parentPanel.revalidate();

                displayArea2.setText("");
                historyDisplay2.setText("");
                progDisplay1.setText("");
                progDisplay2.setText("");
                convertFromDisplay.setText("");
                convertToDisplay.setText("");
                convertLenDisplay1.setText("");
                convertLenDisplay2.setText("");
                convertMassDisplay1.setText("");
                convertMassDisplay2.setText("");
            }
        });

//    ----------------------------------------------------------
        JRadioButton menuItem2 = new JRadioButton("Scientific");
        menuItem2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menuItem2.setBounds(10, 72, 109, 23);
        menuPanel.add(menuItem2);

        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(scientificPnl);
                parentPanel.repaint();
                parentPanel.revalidate();

                displayArea.setText("");
                historyDisplay.setText("");
                progDisplay1.setText("");
                progDisplay2.setText("");
                convertFromDisplay.setText("");
                convertToDisplay.setText("");
                convertLenDisplay1.setText("");
                convertLenDisplay2.setText("");
                convertMassDisplay1.setText("");
                convertMassDisplay2.setText("");

                sciOperationChoice = "";
            }
        });

//    ----------------------------------------------------------
        JRadioButton menuItem3 = new JRadioButton("Programmer");
        menuItem3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menuItem3.setBounds(10, 98, 125, 23);
        menuPanel.add(menuItem3);

        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                displayArea.setText("");
                displayArea2.setText("");
                historyDisplay.setText("");
                historyDisplay2.setText("");
                convertFromDisplay.setText("");
                convertToDisplay.setText("");
                convertLenDisplay1.setText("");
                convertLenDisplay2.setText("");
                convertMassDisplay1.setText("");
                convertMassDisplay2.setText("");

                progMode = "DEC";
                selConvertTo = "HEX";
                parentPanel.removeAll();
                parentPanel.add(programmerPnl);
                parentPanel.repaint();
                parentPanel.revalidate();
            }
        });

        /******** Menu Group 2 ***********/
        JLabel menuItmGrp2 = new JLabel("Converter");
        menuItmGrp2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menuItmGrp2.setBounds(10, 161, 81, 28);
        menuPanel.add(menuItmGrp2);

        JRadioButton menuItem4 = new JRadioButton("Temperature");
        menuItem4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menuItem4.setBounds(10, 196, 109, 23);
        menuPanel.add(menuItem4);

        menuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(temperaturePnl);
                parentPanel.repaint();
                parentPanel.revalidate();

                displayArea.setText("");
                displayArea2.setText("");
                historyDisplay.setText("");
                historyDisplay2.setText("");
                progDisplay1.setText("");
                progDisplay2.setText("");
                convertLenDisplay1.setText("");
                convertLenDisplay2.setText("");
                convertMassDisplay1.setText("");
                convertMassDisplay2.setText("");
            }
        });

//    -----------------------------------------------------------
        JRadioButton menuItem5 = new JRadioButton("Length");
        menuItem5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menuItem5.setBounds(10, 222, 109, 23);
        menuPanel.add(menuItem5);

        menuItem5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(lengthPnl);
                parentPanel.repaint();
                parentPanel.revalidate();

                displayArea.setText("");
                displayArea2.setText("");
                historyDisplay.setText("");
                historyDisplay2.setText("");
                progDisplay1.setText("");
                progDisplay2.setText("");
                convertFromDisplay.setText("");
                convertToDisplay.setText("");
                convertMassDisplay1.setText("");
                convertMassDisplay2.setText("");

                metricLength = "CENTIMETER";
                imperialLen = "INCHES";
            }
        });

//    ----------------------------------------------------------
        JRadioButton menuItem6 = new JRadioButton("Weight & Mass");
        menuItem6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menuItem6.setBounds(10, 248, 125, 23);
        menuPanel.add(menuItem6);

        menuItem6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(wgtMassPnl);
                parentPanel.repaint();
                parentPanel.revalidate();

                displayArea.setText("");
                displayArea2.setText("");
                historyDisplay.setText("");
                historyDisplay2.setText("");
                progDisplay1.setText("");
                progDisplay2.setText("");
                convertFromDisplay.setText("");
                convertToDisplay.setText("");
                convertLenDisplay1.setText("");
                convertLenDisplay2.setText("");

                metricMass = "GRAM";
                selMassImperial = "OUNCES";
            }
        });

        ButtonGroup group = new ButtonGroup();
        group.add(menuItem1);
        group.add(menuItem2);
        group.add(menuItem3);
        group.add(menuItem4);
        group.add(menuItem5);
        group.add(menuItem6);

        ButtonGroup group2 = new ButtonGroup();
        group2.add(FahrenheitBtn);
        group2.add(CelciusBtn);

        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
        btnD.setEnabled(false);
        btnE.setEnabled(false);
        btnF.setEnabled(false);

        String[] convertToItem = { "HEX", "DEC" };
        JComboBox convertTo = new JComboBox(convertToItem);
        convertTo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedToProgItems = (String) convertTo.getSelectedItem();
                switch (selectedToProgItems) {
                case "HEX":
                    selConvertTo = "HEX";
                    clickCount = 0;
                    try {
                        programmerFunctions();
                    } catch (Exception e2) {
                        return;
                    }
                    break;
                case "DEC":
                    selConvertTo = "DEC";
                    clickCount = 0;
                    try {
                        programmerFunctions();
                    } catch (Exception e2) {
                        return;
                    }
                }
            }
        });
        convertTo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        convertTo.setBounds(17, 121, 105, 33);
        programmerPnl.add(convertTo);
    }

    //////////////////////////////////// formatting for output
    static String getFormattedText(double temp) {
        String outText = "" + temp;
        if (outText.lastIndexOf(".0") > 0)
            outText = outText.substring(0, outText.length() - 2);
        return outText;
    }

    ///////////////////////////////////

    static String formatDouble(double temp) {
        String outText = "" + temp;
        if (outText.lastIndexOf(".0") > 0) {
            outText = outText.substring(0, outText.length() - 2);
            return outText;
        } else {
            return String.format("%.3f", temp);
        }
    }

    /////////////////////// Simple math operation by Taron
    public void operations() {
        double temp = 0;
        switch (calculation) {
        // Addition
        case 1:
            answer = Double.parseDouble(displayArea.getText());
            temp = num + answer;
            displayArea.setText(getFormattedText(temp));
            break;

        // Subtraction
        case 2:
            answer = Double.parseDouble(displayArea.getText());
            temp = num - answer;
            displayArea.setText(getFormattedText(temp));
            break;

        // Division
        case 3:
            answer = Double.parseDouble(displayArea.getText());
            temp = num / answer;
            displayArea.setText(getFormattedText(temp));
            break;

        // Multiplication
        case 4:
            answer = Double.parseDouble(displayArea.getText());
            temp = num * answer;
            displayArea.setText(getFormattedText(temp));
            break;
        }
    }

    /////////////////////////
    public void operation2() {
        double temp = 0;
        switch (calculation2) {
        // Addition
        case 1:
            answer = Double.parseDouble(displayArea2.getText());
            temp = num + answer;
            displayArea2.setText(formatDouble(temp));
            break;

        // Subtraction
        case 2:
            answer = Double.parseDouble(displayArea2.getText());
            temp = num - answer;
            displayArea2.setText(formatDouble(temp));
            break;

        // Division
        case 3:
            answer = Double.parseDouble(displayArea2.getText());
            temp = num / answer;
            displayArea2.setText(formatDouble(temp));
            break;

        // Multiplication
        case 4:
            answer = Double.parseDouble(displayArea2.getText());
            temp = num * answer;
            displayArea2.setText(formatDouble(temp));
            break;
        }
    }

    ////////////////////////// Contribution by Miguel Cruz
    public void scientificOperation() {
        double temp = 0;
        if (sciOperationChoice == "power") {
            answer = Double.parseDouble(displayArea2.getText());
            temp = Math.pow(num, answer);
            displayArea2.setText(formatDouble(temp));
        }

        if (sciOperationChoice == "mod") {
            answer = Double.parseDouble(displayArea2.getText());
            temp = num % answer;
            displayArea2.setText(formatDouble(temp));
        }

        if (sciOperationChoice == "sqrRoot") {
            answer = Double.parseDouble(displayArea2.getText());
            temp = Math.sqrt(answer);
            displayArea2.setText(formatDouble(temp));
        }

        if (sciOperationChoice == "cubeRoot") {
            answer = Double.parseDouble(displayArea2.getText());
            temp = Math.cbrt(answer);
            displayArea2.setText(formatDouble(temp));
        }
    }

    /////////////////////////////////

    /////////////////////////////// Contribution by Taron
    public void temperatureConvert() {
        double temp = 0.0;
        if (userTempChoice == "Fahrenheit") {
            answer = Double.parseDouble(convertToDisplay.getText());
            temp = (answer * 9 / 5) + 32;
            convertFromDisplay.setText(formatDouble(temp));
        }
        if (userTempChoice == "Celcius") {
            answer = Double.parseDouble(convertFromDisplay.getText());
            temp = (answer - 32) * 5 / 9;
            convertToDisplay.setText(formatDouble(temp));
        }
    }

    ///////////////////////////////////

    /////////////////////////////// Contribution by Casper
    public void programmerFunctions() {
        final char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
                'E', 'F' };
        final String HEX_DIGITS = "0123456789ABCDEF";

        if ((progMode == "DEC") && (selConvertTo == "HEX")) {
            String outpHex = "";
            progTemp = Integer.parseInt(progDisplay1.getText());
            int remainder = 0;
            while (progTemp > 0) {
                remainder = progTemp % 16;
                outpHex = HEX[remainder] + outpHex;
                progTemp = progTemp / 16;
            }
            progDisplay2.setText(outpHex);

        } else if ((progMode == "HEX") && (selConvertTo == "DEC")) {
            inptHex = progDisplay1.getText();
            inptHex = inptHex.toUpperCase();
            long tempDec = 0;
            long alt = 0;
            char character = ' ';
            for (int i = 0; i < inptHex.length(); i++) {
                character = inptHex.charAt(i);
                alt = HEX_DIGITS.indexOf(character);
                tempDec = 16 * tempDec + alt;
            }
            progDisplay2.setText("" + tempDec);

            /////////////////////////////////////////////// Contribution by Ali
        } else if ((progMode == "BIN") && (selConvertTo == "DEC")) {
            progTemp = Integer.parseInt(progDisplay1.getText());
            int power = 0;
            int decimalNum = 0;
            while (progTemp != 0) {
                int rem = progTemp % 10;
                decimalNum += rem * Math.pow(2, power);
                power++;
                progTemp = progTemp / 10;
            }
            progDisplay2.setText("" + decimalNum);
        }
    }

    ///////////////////////// Contribution by Russel
    public void convertWeight() {
        double temp = 0.0;
        if ((metricMass.equals("GRAM")) && (selMassImperial.equals("OUNCES"))) {
            if (convertMassDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertMassDisplay1.getText());
            }
            temp = answer * GRAM_TO_OUNCES;
        } else if ((metricMass.equals("GRAM")) && (selMassImperial.equals("POUNDS"))) {
            if (convertMassDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertMassDisplay1.getText());
            }
            temp = answer * GRAM_TO_POUND;
        } else if ((metricMass.equals("GRAM")) && (selMassImperial.equals("STONE"))) {
            if (convertMassDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertMassDisplay1.getText());
            }
            temp = answer * GRAM_TO_STONE;
        } else if ((metricMass.equals("GRAM")) && (selMassImperial.equals("US-TONNE"))) {
            if (convertMassDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertMassDisplay1.getText());
            }
            temp = answer * GRAM_TO_US_TONNE;
        }

        else if ((metricMass.equals("KILOGRAM")) && (selMassImperial.equals("OUNCES"))) {
            if(convertMassDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertMassDisplay1.getText());
            }
            temp = answer * KILOGRAM_TO_OUNCES;
        } else if ((metricMass.equals("KILOGRAM")) && (selMassImperial.equals("POUNDS"))) {
            if(convertMassDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertMassDisplay1.getText());
            }
            temp = answer * KILOGRAM_TO_POUND;
        } else if ((metricMass.equals("KILOGRAM")) && (selMassImperial.equals("STONE"))) {
            if(convertMassDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertMassDisplay1.getText());
            }
            temp = answer * KILOGRAM_TO_STONE;
        } else if ((metricMass.equals("KILOGRAM")) && (selMassImperial.equals("US-TONNE"))) {
            if(convertMassDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertMassDisplay1.getText());
            }
            temp = answer * KILOGRAM_TO_US_TONNE;
        }
        convertMassDisplay2.setText(formatDouble(temp));
    }

    ///////////////////////// Contribution by Russel
    public void convertLength() {
        double temp = 0.0;
        if ((metricLength.equals("CENTIMETER")) && (imperialLen.equals("INCHES"))) {
            if (convertLenDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertLenDisplay1.getText());
            }
            temp = answer * CENTIMETER_TO_INCHES;
        } else if ((metricLength.equals("CENTIMETER")) && (imperialLen.equals("FEET"))) {
            if (convertLenDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertLenDisplay1.getText());
            }
            temp = answer * CENTIMETER_TO_FEET;
        } else if ((metricLength.equals("CENTIMETER")) && (imperialLen.equals("YARDS"))) {
            if (convertLenDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertLenDisplay1.getText());
            }
            temp = answer * CENTIMETER_TO_YARD;
        } else if ((metricLength.equals("CENTIMETER")) && (imperialLen.equals("MILES"))) {
            if (convertLenDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertLenDisplay1.getText());
            }
            temp = answer * CENTIMETER_TO_MILES;
        }

        //// Meters
        else if ((metricLength.equals("METER")) && (imperialLen.equals("INCHES"))) {
            if (convertLenDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertLenDisplay1.getText());
            }
            temp = answer * METER_TO_INCHES;
        } else if ((metricLength.equals("METER")) && (imperialLen.equals("FEET"))) {
            if (convertLenDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertLenDisplay1.getText());
            }
            temp = answer * METER_TO_FEET;
        } else if ((metricLength.equals("METER")) && (imperialLen.equals("YARDS"))) {
            if (convertLenDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertLenDisplay1.getText());
            }
            temp = answer * METER_TO_YARD;
        } else if ((metricLength.equals("METER")) && (imperialLen.equals("MILES"))) {
            if (convertLenDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertLenDisplay1.getText());
            }
            temp = answer * METER_TO_MILES;
        }

        //// Kilometers
        else if ((metricLength.equals("KILOMETER")) && (imperialLen.equals("INCHES"))) {
            if (convertLenDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertLenDisplay1.getText());
            }
            temp = answer * KILOMETER_TO_INCHES;
        } else if ((metricLength.equals("KILOMETER")) && (imperialLen.equals("FEET"))) {
            if (convertLenDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertLenDisplay1.getText());
            }
            temp = answer * KILOMETER_TO_FEET;
        } else if ((metricLength.equals("KILOMETER")) && (imperialLen.equals("YARDS"))) {
            if (convertLenDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertLenDisplay1.getText());
            }
            temp = answer * KILOMETER_TO_YARD;
        } else if ((metricLength.equals("KILOMETER")) && (imperialLen.equals("MILES"))) {
            if (convertLenDisplay1.getText().isEmpty()) {
                answer = 0.0;
            } else {
                answer = Double.parseDouble(convertLenDisplay1.getText());
            }
            temp = answer * KILOMETER_TO_MILES;
        }
        convertLenDisplay2.setText(formatDouble(temp));
    }

    /////////////////////////
    public void enableHexBtn() {
        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
        btnD.setEnabled(true);
        btnE.setEnabled(true);
        btnF.setEnabled(true);
    }

    /////////////////////////
    public void disableHexBtn() {
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
        btnD.setEnabled(false);
        btnE.setEnabled(false);
        btnF.setEnabled(false);
    }

    public void disableButtonForBinary() {
        btn2_1_1.setEnabled(false);
        btn3_1_1.setEnabled(false);
        btn4_1_1.setEnabled(false);
        btn5_1_1.setEnabled(false);
        btn6_1_1.setEnabled(false);
        btn7_1_1.setEnabled(false);
        btn8_1_1.setEnabled(false);
        btn9_1_1.setEnabled(false);
    }

    public void enableButtonForBinary() {
        btn2_1_1.setEnabled(true);
        btn3_1_1.setEnabled(true);
        btn4_1_1.setEnabled(true);
        btn5_1_1.setEnabled(true);
        btn6_1_1.setEnabled(true);
        btn7_1_1.setEnabled(true);
        btn8_1_1.setEnabled(true);
        btn9_1_1.setEnabled(true);
    }

    // function for deleting the last character from String
    private static String backSpace(String s) {
        StringBuilder displayed = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            displayed.append(s.charAt(i));
        }
        return displayed.toString();
    }
}
