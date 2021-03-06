import javax.swing.*;
import java.awt.*;

// This class extends JFrame to serve as the
// UI window. We will embed custom JPanel objects
// inside this JFrame to make up a simple UI.
public class AppContainer extends JFrame {

    // Subcomponents
    private StatusSearch statusSearch;

    public AppContainer(){
        super("StatusSearch");

        // Create and add the main component
        this.statusSearch = new StatusSearch(this);
        this.add(statusSearch);
        this.getContentPane().add(this.statusSearch);

        // Set size parameters, 'pack' everything tightly together, and set visible.
        this.setMinimumSize(new Dimension(340, 400));
        this.pack();
        this.setVisible(true);
    }
}
