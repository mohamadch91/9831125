import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * calculate simulator.
 * @author Mohammad
 */
public class CalculatorGUI {
    JFrame calcFrame;// frame
    JPanel keyboardPanel;// for text show
    JPanel default1;// for default1 calculator
    JPanel eng;// for engineering
    JTabbedPane tp;
    JTextArea display;
    String[] save = new String[5];// for actions
    JMenuBar menuBar;
    JMenu first;// use menu bar
    String copy = "";// for copy

    public CalculatorGUI(String name) {
// make frame and set size
        calcFrame = new JFrame();
        calcFrame.setTitle(name);
        calcFrame.setResizable(true);
        calcFrame.setSize(325, 450);
        calcFrame.setLocation(100, 100);
        calcFrame.setLayout(null);
        // make menu bars and options
        menuBar = new JMenuBar();
        first = new JMenu("Menu");
        JMenuItem exit = new JMenuItem("EXIT");
        exit.setMnemonic('E');
        JMenuItem copy = new JMenuItem("COPY");
        exit.setMnemonic('C');
        JMenuItem paste = new JMenuItem("PASTE");
        exit.setMnemonic('v');
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        exit.addActionListener(new MenuListener());
        copy.addActionListener(new MenuListener());
        paste.addActionListener(new MenuListener());
        first.add(exit);
        first.add(copy);
        first.add(paste);
        menuBar.add(first);
        calcFrame.setJMenuBar(menuBar);
        // set numbers empty string
        save[0] = "";
        save[1] = "";
        save[2] = "";
        save[3] = "";
        save[4] = "";
        tp = new JTabbedPane();
        default1 = new JPanel();
        keyboardPanel = new JPanel();
        // text area
        keyboardPanel.setLayout(new GridLayout(1, 2));
        keyboardPanel.setSize(300, 50);

        keyboardPanel.setLocation(0, 0);
        addText();
        // make new panels
        panelMaker(default1, "default1", 6, 3);
        eng = new JPanel();
        panelMaker(eng, "ENGINEER", 9, 3);
        default1(default1);
        addENG(eng);
        tp.setLocation(50, 0);
        tp.setBounds(0, 50, 300, 300);
        calcFrame.add(tp, BorderLayout.CENTER);
        calcFrame.add(keyboardPanel, BorderLayout.NORTH);

        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // give color
        color();
        // make tool tips
        toolTip();

    }

    /**
     * Make tool tips for items.
     */
    public void toolTip() {
        keyboardPanel.setToolTipText("FOR SHOW OR ENTER NUMBER");
        tp.setToolTipText("BOTH CALCULATORS SHOW");
        first.setToolTipText(" exit copy \n paste");
        eng.setToolTipText("engineering calculator");
        default1.setToolTipText("default1 calculator");
    }

    /**
     * just show frame.
     */
    public void show() {
        calcFrame.setVisible(true);
    }

    /**
     * set new Jpnael.
     * @param p2 panel to set.
     * @param name name of panel.
     * @param row number of rows in gridlayout.
     * @param column nymber of column in gridlayout.
     * @return Jpanel.
     */
    public JPanel panelMaker(JPanel p2, String name, int row, int column) {
        p2.setSize(200, 200);
        p2.setLocation(10, 50);
        p2.setLayout(new GridLayout(row, column));
        tp.add(name, p2);
        return p2;
    }

    /**
     * add default1 bottons.
     * and add eng bottons.
     * @param test
     */
    public void addENG(JPanel test) {
        default1(test);
        addButton(test, "e");
        addButton(test, "log");
        addButton(test, "sin");
        addButton(test, "tan");
        addButton(test, "pi");
        addButton(test, "exp");
        addButton(test, "shift");
    }

    /**
     * give color to components.
     */
    public void color() {
        default1.setBackground(Color.ORANGE);
        eng.setBackground(Color.ORANGE);
        calcFrame.setBackground(Color.cyan);
        keyboardPanel.setBackground(Color.green);
    }

    /**
     * add default bottons to panel.
     * @param test panel to add.
     */
    public void default1(JPanel test) {
        for (Integer i = 1; i <= 9; i++) {
            addButton(test, "" + i);
        }
        addButton(test, "+");
        addButton(test, "0");
        addButton(test, "-");
        addButton(test, "=");
        addButton(test, "*");
        addButton(test, "/");
        addButton(test, "%");
        addButton(test, "cls");
        addButton(test, "c");
    }

    /**
     * add one botton to panel.
     * @param panel oanel to add.
     * @param text botton name.
     */
    public void addButton(JPanel panel, String text) {
        JButton tanBtn = new JButton();
        tanBtn.setOpaque(true);
        tanBtn.setToolTipText(" to show  "+text);
        tanBtn.setBackground(Color.cyan);
        tanBtn.addKeyListener(new KeyHandler());
        tanBtn.addMouseListener(new BottonHandler());

        tanBtn.setText(text);
        panel.add(tanBtn);
    }

    /**
     * make area for text type and show.
     */
    public void addText() {
        display = new JTextArea(10, 8);
        display.setLineWrap(true);
        display.setEditable(true);
        display.setFont(new Font("Arial", 14, 14));
        display.setLocation(100, 1);
        display.setSize(10, 10);

        JScrollPane scrollPane = new JScrollPane(display);

        scrollPane.setPreferredSize(new Dimension(100, 30));
        scrollPane.setLocation(0, 0);

        keyboardPanel.add(scrollPane);

    }

    /**
     * calculate result for actions.
     * on the actions
     */
    private void calculate() {
        double num1 = Double.parseDouble(save[0]);
        if (save[2].equals(""))
            save[2] = "1";
        double num2 = Double.parseDouble(save[2]);
        double result = 0;
        if (save[1].equals("+"))
            result = num1 + num2;
        if (save[1].equals("-"))
            result = num1 - num2;
        if (save[1].equals("*"))
            result = num1 * num2;
        if (save[1].equals("/"))
            result = num1 / num2;
        if (save[1].equals("%"))
            result = num1 % num2;
        if (save[3].equals("e")) {
            result = Math.exp(1.0);
        }
        if (save[3].equals("exp"))
            result = Math.exp(num1);
        if (save[3].equals("sin") && save[4].equals("")) {
            result = Math.sin(num1);
            System.out.println("hi");
        } else if (save[3].equals("sin") && save[4].equals("shift"))
            result = Math.cos(num1);
        if (save[3].equals("tan") && save[4].equals(""))
            result = Math.tan(num1);
        else if (save[3].equals("tan") && save[4].equals("shift"))
            result = 1 / Math.tan(num1);
        if (save[3].equals("log"))
            result = Math.log(num1);
        if (save[3].equals("pi"))
            result = Math.PI;
        // empty all numbers and just save result
        save[1] = "";
        Double x = result;
        save[0] = x.toString();
        save[2] = "";
        save[3] = "";
        save[4] = "";
        display.setText(display.getText() + "=" + result);
    }

    /**
     * class for handle mouse.
     */
    private class BottonHandler extends MouseAdapter {

        /**
         * look witch botton pressed and do.
         * @param e
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton test = (JButton) e.getSource();
            String b = test.getText();
            // first and second number.
            if (b.equals("1") || b.equals("0") || b.equals("2") || b.equals("3") || b.equals("4") || b.equals("5") ||
                    b.equals("6") || b.equals("7") || b.equals("8") || b.equals("9")) {
                if (save[1].equals(""))
                    save[0] = save[0] + b;
                else
                    save[2] = save[2] + b;
                display.setText(display.getText() + "" + b);
// pi botton
            } else if (b.equals("pi")) {
                Double pi = Math.PI;
                if (save[1].equals(""))
                    save[0] = pi.toString();
                else
                    save[2] = pi.toString();
                display.setText(display.getText() + "" + b);

            } else if (b.equals("cls")) {
                display.setText(" ");
            } else if (b.equals("c")) {
                save[0] = "";
                save[2] = "";
                display.setText(" ");
            } else if (b.equals("/") || b.equals("*") || b.equals("+") || b.equals("%") || b.equals("-")) {
                save[1] = b;
                display.setText(display.getText() + "" + b);
            } else if (b.equals("=")) {
                calculate();
            } else if (b.equals("shift")) {
                if (save[4] == b)
                    save[4] = "";
                else
                    save[4] = b;
            } else {
                save[3] = b;
                display.setText(display.getText() + "" + b + "(" + save[0] + ")");
            }
        }


    }

    /**
     * handle keyboard .
     */
    private class KeyHandler implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

            char b = e.getKeyChar();
            System.out.println(b);
            if (b == '1' || b == '0' || b == '2' || b == '3' || b == '4' || b == '5' ||
                    b == '6' || b == '7' || b == '8' || b == '9') {
                if (save[1] == (""))
                    save[0] = save[0] + b;
                else
                    save[2] = save[2] + b;
                display.setText(display.getText() + "" + b);

            } else if (b == 'c') {
                save[0] = "";
                save[2] = "";
                display.setText(" ");
            } else if (b == '/' || b == '*' || b == '+' || b == '%' || b == '-') {
                save[1] = "" + b;
                display.setText(display.getText() + "" + b);
            } else if (b == '=' || b == '\n') {
                calculate();

            } else if (b == 's') {
                if (save[4] == "shift")
                    save[4] = "";
                else
                    save[4] = "shift";
            }

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    /**
     * handle menu actions.
     */
    private class MenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem x = (JMenuItem) e.getSource();
            if (x.getText().equals("EXIT"))
                System.exit(0);
            else if (x.getText().equals("COPY")) {
                copy = display.getText();
            } else if (x.getText().equals("PASTE")) {
                display.setText(copy);
            }

        }
    }
}
