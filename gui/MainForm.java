package gui;

import domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JPanel mainPanel;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPanel MainPanel;
    private JButton buyButton;
    private JButton sellButton;
    private JTextArea info;
    private JButton cancel;
    OrderSubmitter orderSubmitter;

    public MainForm(String title, OrderSubmitter orderSubmitter) throws HeadlessException {

         this.orderSubmitter = orderSubmitter;
        this.setTitle(title);
        JFrame.setDefaultLookAndFeelDecorated(true);
        final Dimension size = new Dimension(1000, 500);
        setMinimumSize(size);
        setPreferredSize(size);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setResizable(true);
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final MyContract myc = ContractSamples.contracts.get("AAPL");
                Order_Contract order_contract = new Order_Contract(Order_Contract.QUANTITY_ENUM.MICRO, myc, Order_Contract.BUY_SELL_ENUM.BUY, Order_Contract.ORDER_TYPE.SINGLE_MKT);
                orderSubmitter.submit(order_contract);
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JTextArea getInfo() {
        return info;
    }

    public void setInfo(JTextArea info) {
        this.info = info;
    }

    private void createUIComponents() {

    }
}
