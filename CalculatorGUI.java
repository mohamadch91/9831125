import javax.swing.*;
import java.awt.*;

public class CalculatorGUI {
    JFrame calcFrame;

    public CalculatorGUI() {
        calcFrame = new JFrame();
        calcFrame.setTitle("AUT Calculator");
        calcFrame.setSize(300, 300);
        calcFrame.setLocation(100, 200);
        calcFrame.setLayout(null);
        JPanel p2=new JPanel();
        JTabbedPane tp=new JTabbedPane();
        tp.setBounds(50,50,200,200);
        calcFrame.add(tp);
        calcFrame.setSize(400,400);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcFrame.setVisible(true);
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setSize(300, 300);
        keyboardPanel.setLocation(10, 50);
        keyboardPanel.setLayout(new GridLayout(6, 3));
        p2.setSize(200,200);
        p2.setLocation(10,50);
        p2.setLayout(new GridLayout(4,3));
        tp.add("Defualt",keyboardPanel);
        tp.add("Eng",p2);
        JButton sinBtn = new JButton();
        sinBtn.setText("sin/cos");
        p2.add(sinBtn);
        JButton tanBtn = new JButton();
        tanBtn.setText("tan/cot");
        p2.add(tanBtn);
        JButton logBtn = new JButton();
        logBtn.setText("log");
        p2.add(logBtn);
        JButton expBtn = new JButton();
        expBtn.setText("exp");
        p2.add(expBtn);
        JButton piBtn = new JButton();
        piBtn.setText("pi");
        p2.add(piBtn);
        JButton eBtn = new JButton();
        eBtn.setText("e");
        p2.add(eBtn);
        for (int i = 1; i <= 9; i++) {
            JButton btn = new JButton();
            btn.setText("" + i);
            keyboardPanel.add(btn);
        }
        JButton sumBtn = new JButton();
        sumBtn.setText("+");
        keyboardPanel.add(sumBtn);
        JButton zeroBtn = new JButton();
        zeroBtn.setText("0");
        keyboardPanel.add(zeroBtn);
        JButton doBtn = new JButton();
        doBtn.setText("=");
        keyboardPanel.add(doBtn);
        JButton minusBtn = new JButton();
        minusBtn.setText("-");
        keyboardPanel.add(minusBtn);
        JButton zrbBtn = new JButton();
        zrbBtn.setText("*");
        keyboardPanel.add(zrbBtn);
        JButton taghsimBtn = new JButton();
        taghsimBtn.setText("/");
        keyboardPanel.add(taghsimBtn);
        JButton modBtn = new JButton();
        modBtn.setText("%");
        keyboardPanel.add(modBtn);
        JTextArea display = new JTextArea(3, 10);
        display.setEditable(false);
        display.setFont(new Font("Arial", 14, 14));
        display.setVisible(true);
        display.setLocation(0,0);
        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setPreferredSize(new Dimension(200, 100));
        scrollPane.setLocation(50, 20);
        calcFrame.getContentPane().add(scrollPane);
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("GTK".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) { // If Nimbus is not available, you can set the GUI to another look and feel. }
        }
    }
}