package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaterCalculator extends JFrame implements ActionListener {
    JLabel qLablel;
    JLabel wLable;
    JTextField jTextField;
    JButton jButton;
    public WaterCalculator(){
        super("Water Calculator");
        setSize(240, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponent();
    }
    private void initComponent(){
        qLablel = new JLabel("How much water show I take?");
        wLable = new JLabel("My weight");
        jTextField = new JTextField(5);
        jButton = new JButton("Calculate");

        setLayout(new FlowLayout());
        add(qLablel);
        add(wLable);
        add(jTextField);
        add(jButton);

        jButton.addActionListener(this);
    }
    public static void main(String args[]){
        new WaterCalculator().setVisible(true);
    }

    private float calculateAmount(float weight){
        return (weight / 10f) * 0.4f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = "Hey buddy you should drink %.1f L a day";
        float weight = Float.parseFloat(jTextField.getText());
        float waterAmount = calculateAmount(weight);

        message = String.format(message, waterAmount);

        JOptionPane.showMessageDialog(this, message);


    }
}
