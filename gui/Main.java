package gui;

import com.ib.client.EClientSocket;
import domain.Connection;
import domain.OrderManager;

import javax.swing.*;
import java.util.function.Consumer;

public class Main {
    private static MainForm frame = null;

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {
        UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
        frame.setDefaultLookAndFeelDecorated(true);
        frame = new MainForm("My TWS App");

//https://www.youtube.com/watch?v=Gxf4T-4Ix-w
        UIManager.put("Button.arc", 999);
        UIManager.put("Component.arc", 999);
        UIManager.put("CheckBox.arc", 999);
        UIManager.put("ProgressBar.arc", 999);
        UIManager.put("Component.focusWidth", 1);
        UIManager.put("Component.innerFocusWidth", 1);
        UIManager.put("Button.innerFocusWidth", 1);
        UIManager.put("Component.hideMnemonics", false);
        frame.setVisible(true);

        //frame.getInfo()
        Connection connection=new Connection();
        final JTextArea info  = frame.getInfo();

        final Consumer consumer = s -> info.setText(s + "");
        final EClientSocket connect = connection.connect(consumer);

        OrderManager orderManager =new OrderManager(connection, connect);

    }

}
