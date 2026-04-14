import javax.swing.*;

public class kalkBMI extends JFrame{
    private JPanel panel1;
    private JTextField podajKg;
    private JTextField podajCm;
    private JButton obliczBMIButton;
    private JLabel labelCm;
    private JLabel labelKg;
    private JLabel wynikBMI;

    public kalkBMI() {
        setContentPane(panel1);
        setTitle("Kalkulator BMI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
        obliczBMIButton.addActionListener(e ->{
            if(isNumeric(podajKg.getText()) && isNumeric(podajCm.getText())) {
                double waga = Double.parseDouble(podajKg.getText());
                double wzrost = Double.parseDouble(podajCm.getText()) / 100;
                double wynik = waga / (wzrost * wzrost);
                wynikBMI.setText(String.format("BMI: %.2f", wynik));
            }else{
                wynikBMI.setText("Podaj tylko liczby!");
            }
        });

    }
    public static boolean isNumeric(String str){
        return str.matches("-?\\d+(\\.\\d+)?");
    }

public static void main(String[] args){
    new kalkBMI();
}
}
