package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MainPanel extends JPanel {

    JButton[] quantityButtons, sellQtyButtons;
    JButton buyKey, sellKey;
    Integer[] quantities = new Integer[]{100, 200, 300, 400, 500, 600};
    public MainPanel() {
        initComponents();
    }

    private void initComponents() {
        quantityButtons = new JButton[6];
        sellQtyButtons = new JButton[6];
        buyKey = new JButton("UP - ARROW - BUY ");
        sellKey = new JButton("DOWN - ARROW - SELL");
        buyKey.setBackground(Color.GREEN);
        sellKey.setBackground(Color.RED);
        final GridLayout gridLayout = new GridLayout(6, 6);


        final AtomicInteger start = new AtomicInteger(-1);
        Arrays.stream(quantities).forEach(a -> {
            JButton jButton = new JButton(a + "");
            JButton sButton = new JButton(a + "");
            final int i = start.incrementAndGet();
            quantityButtons[i] = jButton;
            sellQtyButtons[i] = sButton;
            jButton.setBackground(Color.GREEN);
            sButton.setBackground(Color.RED);
            add(jButton);
            add(sButton);
            jButton.setVisible(true);
        });


        add(buyKey);
        add(sellKey);

        addKeyListener(new MyKeyListener()); // add KeyListener
        setFocusable(true); // set focusable to true
    }

    static class MyKeyListener extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == '\177') {
                // delete row method (when "delete" is typed)
                System.out.println("Key \"Delete\" Typed");
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

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


    }
}