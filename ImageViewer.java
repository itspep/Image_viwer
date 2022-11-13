import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class ImageViewer extends JFrame {
    final int WIDTH = 350;
    final int LENGTH = 120;
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem imageItem;
    private JLabel imageLabel;
    private JPanel imagePanel;

    // create the constructor
    public ImageViewer() {
        setTitle("Image Viewer");
        setSize(WIDTH, LENGTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the layout manager
        setLayout(new BorderLayout());
        // build the image label panel
        buildImagePanel();
        // build the menu bar panel
        buildMenuBarPanel();
        // add the image panel to the content pane
        add(imagePanel, BorderLayout.CENTER);
        // pack the layouts
        pack();
        // set the window visibility to true
        setVisible(true);
    }

    public void buildImagePanel() {
        imageLabel = new JLabel("Place the image here.");
        imagePanel = new JPanel();
        imagePanel.add(imageLabel);
    }

    public void buildMenuBarPanel() {
        menuBar = new JMenuBar();
        buildFileMenu();
        menuBar.add(file);
        setJMenuBar(menuBar);
    }

    public void buildFileMenu() {
        file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        // create the image item
        imageItem = new JMenuItem("Open Image");
        imageItem.addActionListener(new ItemListener());
        file.add(imageItem);
    }

    // build the action listener class
    private class ItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // build the file chooser
            File myFile;
            String fileName;
            ImageIcon image;
            JFileChooser fileChooser = new JFileChooser();
            int status = fileChooser.showOpenDialog(ImageViewer.this);
            if (status == JFileChooser.APPROVE_OPTION) {
                // decfine the image object and assign the chosen file to it
                myFile = fileChooser.getSelectedFile();
                fileName = myFile.getPath();
                image = new ImageIcon(fileName);
                imageLabel.setIcon(image);
                imageLabel.setText(null);
                pack();
            }

        }
    }

    public static void main(String[] args) {
        new ImageViewer();
    }
}
