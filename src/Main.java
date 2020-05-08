import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e)
        {
            System.err.println(" NOT FOUND");
            // If Nimbus is not available, you can set the GUI to another look and feel. }
        }
        CalculatorGUI calculator = new CalculatorGUI("AUT calculator");
        calculator.show();
    }
}