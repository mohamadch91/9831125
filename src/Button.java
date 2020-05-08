import javax.swing.*;

public class Button {
    CalculatorGUI calculator1;
    JPanel test;
    public Button(CalculatorGUI calculator, JPanel m){
        calculator1=calculator;
        test=m;
    }

    public void setCalculatorGUI(CalculatorGUI calculatorGUI) {
        this.calculator1 = calculatorGUI;
    }

    public void setTest(JPanel test) {
        this.test = test;
    }
    public void addENG(){
        calculator1.addButton(test,"e");
        calculator1.addButton(test,"log");
        calculator1.addButton(test,"sin/cos");
        calculator1.addButton(test,"tan/cot");
        calculator1.addButton(test,"pi");
        calculator1.addButton(test,"exp");
        calculator1.addButton(test,"shift");
    }
    public void DEFAULT()
    {
        for (int i = 1; i <=9 ; i++) {
        calculator1.addButton(test,""+i);
    }
        calculator1.addButton(test,"+");
        calculator1.addButton(test,"0");
        calculator1.addButton(test,"-");
        calculator1.addButton(test,"=");
        calculator1.addButton(test,"*");
        calculator1.addButton(test,"/");
    }

    public CalculatorGUI getCalculator1() {
        return calculator1;
    }

    public JPanel getTest() {
        return test;
    }
}
