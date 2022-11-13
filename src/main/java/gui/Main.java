package gui;

import com.ib.client.EClientSocket;
import domain.Connection;
import domain.OrderManager;
import domain.OrderSubmitter;
import domain.Order_Contract;

import javax.swing.*;
import java.util.function.Consumer;

public class Main {
    private static gui.MainForm frame = null;

    //https://www.youtube.com/watch?v=Gxf4T-4Ix-w
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {
        UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");

        //frame.getInfo()
        Connection connection=new Connection();
        final JTextArea info  = frame.getInfo();

        final Consumer consumer = s -> info.setText(s + "");
        final EClientSocket connect = connection.connect(consumer);


        frame.setDefaultLookAndFeelDecorated(true);
        final OrderSubmitter os = new OrderSubmitter(connection, connect);
        frame = new MainForm("My TWS App", os);
        UIManager.put("Button.arc", 999);
        UIManager.put("Component.arc", 999);
        UIManager.put("CheckBox.arc", 999);
        UIManager.put("ProgressBar.arc", 999);
        UIManager.put("Component.focusWidth", 1);
        UIManager.put("Component.innerFocusWidth", 1);
        UIManager.put("Button.innerFocusWidth", 1);
        UIManager.put("Component.hideMnemonics", false);
        frame.setVisible(true);

    }

}
