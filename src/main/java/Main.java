import javax.swing.*;

public class Main {
    public static void main(String args[]) {
        // Creates a UI thread that will launch our AppContainer JFrame
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AppContainer();
            }
        });

        AccountCreation acc = new AccountCreation();
        acc.setTitle("Account Creation");
        acc.setLocationRelativeTo(null); // Center the frame
        acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        acc.setSize(340, 400);
        acc.setVisible(true);



    }
}

