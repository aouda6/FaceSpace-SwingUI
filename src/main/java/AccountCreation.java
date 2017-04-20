import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Abdulla on 2017-04-03.
 */

public class AccountCreation extends JFrame{

    JTextField accountName ;
    JButton createAccountButton ;
    JLabel accountInfo ;
    JLabel message ;

    public AccountCreation() {

        accountName = new JTextField(15);
        accountName.setSize(8, 3);
        createAccountButton = new JButton("Create Account!");
        createAccountButton.setSize(3, 4);
        accountInfo = new JLabel("Name: ");
        message = new JLabel("Message: ...");

        // Initialize this component

        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        // Add subcomponents to this JPanel
        add(accountName);
        add(createAccountButton);
        add(accountInfo);
        add(message);

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = accountName.getText();
                accountInfo.setText("Name: " + userName);
                try {

                    message.setText("Message: " + sendPOST("http://localhost:8080/AccountCreation/createAccount?userName=" + userName));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }

        private static String sendPOST(String URL) throws IOException {
            URL obj = new URL(URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
        //    con.setRequestProperty("User-Agent", USER_AGENT);

            // For POST only - START
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
         //   os.write(POST_PARAMS.getBytes());
            os.flush();
            os.close();
            // For POST only - END

            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return("Account created successfully");
            } else {
                return("Operation Failed");
            }

    }

}
