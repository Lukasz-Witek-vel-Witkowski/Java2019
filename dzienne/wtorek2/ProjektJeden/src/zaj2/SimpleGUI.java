package zaj2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Krzysztof Podlaski on 26.02.2019.
 */
public class SimpleGUI {
    private JTextField shortTextField;
    private JButton button1;
    private JTextArea textArea1;
    private JPanel mainPanel;

    public SimpleGUI() {
        ActionListener aL = new ActionListener() {
            @Override
            public void actionPerformed(
                    ActionEvent e) {
                String t = shortTextField.getText();
                textArea1.append(t+" ");
                shortTextField.setText("");
            }
        };

        button1.addActionListener(aL);
        shortTextField.addActionListener(aL);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SimpleGUI");
        frame.setContentPane(
                new SimpleGUI().mainPanel);
        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
