package gui;

import domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
        mainPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()) {

                    case KeyEvent.VK_1:

                        System.out.println("Key \"1\" Pressed");
                        break;

                    case KeyEvent.VK_2:
                        System.out.println("Key \"2\" Pressed");
                        break;

                    case KeyEvent.VK_3:
                        System.out.println("Key \"3\" Pressed");
                        break;

                    case KeyEvent.VK_DELETE:
                        System.out.println("Key \"Delete\" Pressed");
                        break;

                    //Issue Buy Order
                    case KeyEvent.VK_UP:
                        System.out.println("Key \"UP\" Pressed");
                        break;

                    //Issue Sell  Order
                    case KeyEvent.VK_DOWN:
                        System.out.println("Key \"DOWN\" Pressed");
                        break;

                }

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
