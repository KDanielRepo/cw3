import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Calc implements ActionListener {
    private JButton[] buttons;
    private JTextField result; //zrob 2 resulty
    private JPanel resultWindow;
    private JPanel buttony;
    private String operation;
    private double liczbaA;
    private double liczbaB;
    private int lenght;
    List<String> names = new ArrayList<>();

    public Calc(){
        JFrame calc = new JFrame("Kalkulator na 5");
        calc.setSize(450,640);
        calc.setLayout(new GridLayout(2,1));
        calc.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        resultWindow = new JPanel();
        resultWindow.setLayout(new BorderLayout());
        calc.add(resultWindow);
        result = new JTextField();
        resultWindow.add(result);
        result.setEditable(false);
        result.setFont(new Font("New Times Roma",Font.PLAIN,26));

        buttony = new JPanel();
        buttony.setLayout(new GridLayout(6,4));
        buttony.setSize(680,412);
        buttony.setLocation(0,68);
        buttons = new JButton[24];
        setNames();
        for (int i = 0; i < 24; i++) {
            buttony.add(buttons[i] = new JButton(names.get(i)));
            buttons[i].addActionListener(this);
        }
        calc.add(buttony);
        calc.setVisible(true);
    }
    public void setNames(){
        names.add("Hex");
        names.add("Oct");
        names.add("Bin");
        names.add(" ");
        names.add("Clr");
        names.add("_/-");
        names.add("^");
        names.add("%");
        names.add("7");
        names.add("8");
        names.add("9");
        names.add("-");
        names.add("4");
        names.add("5");
        names.add("6");
        names.add("+");
        names.add("1");
        names.add("2");
        names.add("3");
        names.add("/");
        names.add("*");
        names.add("0");
        names.add(",");
        names.add("=");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();
        switch (name){
            case "Hex":
                liczbaA = Double.parseDouble(result.getText());
                result.setText(null);
                while (liczbaA > 1){
                    int temp = (int) liczbaA;
                    int temp2 = temp % 16;
                    liczbaA = liczbaA/16;
                    switch (temp2){
                        case 10:
                            result.setText(result.getText()+"A");
                            break;
                        case 11:
                            result.setText(result.getText()+"B");
                            break;
                        case 12:
                            result.setText(result.getText()+"C");
                            break;
                        case 13:
                            result.setText(result.getText()+"D");
                            break;
                        case 14:
                            result.setText(result.getText()+"E");
                            break;
                        case 15:
                            result.setText(result.getText()+"F");
                            break;
                        default:
                            result.setText(result.getText()+temp2);
                            break;
                    }
                    lenght++;
                }
                String backwrd = result.getText();
                result.setText(null);
                for(int i = lenght-1; i>=0;i--){
                    result.setText(result.getText()+backwrd.charAt(i));
                }
                lenght=0;
                break;
            case "Oct":
                liczbaA = Double.parseDouble(result.getText());
                result.setText(null);
                while (liczbaA > 1){
                    int temp = (int) liczbaA;
                    int temp2 = temp % 8;
                    liczbaA = liczbaA/8;
                    result.setText(result.getText()+temp2);
                    lenght++;
                }
                backwrd = result.getText();
                result.setText(null);
                for(int i = lenght-1; i>=0;i--){
                    result.setText(result.getText()+backwrd.charAt(i));
                }
                lenght=0;
                break;
            case "Bin":
                liczbaA = Double.parseDouble(result.getText());
                result.setText(null);
                while (liczbaA > 1){
                    int temp2 = (int) liczbaA;
                    int temp3 = temp2 % 2;
                    liczbaA = liczbaA/2;
                    result.setText(result.getText()+temp3);
                    lenght++;
                }
                backwrd = result.getText();
                result.setText(null);
                for(int i = lenght-1; i>=0;i--){
                    result.setText(result.getText()+backwrd.charAt(i));
                }
                lenght=0;
                break;
            case "Clr":
                liczbaA = 0;
                liczbaB = 0;
                result.setText(" ");
                break;
            case "_/-":
                liczbaA = Double.parseDouble(result.getText());
                setOperation("sqrt");
                result.setText(Double.toString(liczbaA));
                break;
            case "^":
                liczbaA = Double.parseDouble(result.getText());
                setOperation("pow");
                result.setText(null);
                break;
            case "%":
                liczbaA = Double.parseDouble(result.getText());
                setOperation("per");
                result.setText(null);
                break;
            case "7":
                result.setText(result.getText()+"7");
                break;
            case "8":
                result.setText(result.getText()+"8");
                break;
            case "9":
                result.setText(result.getText()+"9");
                break;
            case "-":
                liczbaA = Double.parseDouble(result.getText());
                setOperation("sub");
                result.setText(null);
                break;
            case "4":
                result.setText(result.getText()+"4");
                break;
            case "5":
                result.setText(result.getText()+"5");
                break;
            case "6":
                result.setText(result.getText()+"6");
                break;
            case "+":
                liczbaA = Double.parseDouble(result.getText());
                setOperation("add");
                result.setText(null);
                break;
            case "1":
                result.setText(result.getText()+"1");
                break;
            case "2":
                result.setText(result.getText()+"2");
                break;
            case "3":
                result.setText(result.getText()+"3");
                break;
            case "/":
                liczbaA = Double.parseDouble(result.getText());
                setOperation("div");
                result.setText(null);
                break;
            case "*":
                liczbaA = Double.parseDouble(result.getText());
                setOperation("tms");
                result.setText(null);
                break;
            case "0":
                result.setText(result.getText()+"0");
                break;
            case ",":
                result.setText(result.getText()+".");
                break;
            case "=":
                liczbaB = Double.parseDouble(result.getText());
                getOperation();
                result.setText(Double.toString(liczbaA));
                break;
        }
    }
    public void setOperation(String a){
        operation = a;
    }
    public void getOperation(){
        switch (operation){
            case "add" :
                liczbaA = liczbaA+liczbaB;
                break;
            case "sub" :
                liczbaA = liczbaA-liczbaB;
                break;
            case "sqrt" :
                liczbaA = Math.sqrt(liczbaA);
                result.setText(Double.toString(liczbaA));
                break;
            case "pow" :
                liczbaA = Math.pow(liczbaA,liczbaB);
                break;
            case "div" :
                liczbaA = liczbaA/liczbaB;
                break;
            case "per" :
                liczbaA = liczbaA*(liczbaB/100);
                break;
            case "tms" :
                liczbaA = liczbaA*liczbaB;
                break;
        }
    }
}
