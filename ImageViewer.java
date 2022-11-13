import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ImageViewer extends JFrame{
   final int WIDTH=350;
   final int LENGTH=120;
   JPanel panel=new JPanel();
   JMenuBar menuBar;
   JMenu file;
   JMenuItem imageItem;
   //create the constructor
   public ImageViewer(){
    setTitle("Image Viewer");
    setSize(WIDTH, LENGTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //set the layout manager
    setLayout(new BoarderLaout());
    //build the menu bar panel
    buildMenuBarPanel();
    //pack the layouts
    pack();
    //set the window visibility to true
    setVisible(true);
   }
   public void buildMenuBarPanel(){
    menuBar=new JMenuBar();
    buildFileMenu();
    menuBar.add(file);
    setJMenuBar(menuBar);
    }
    public void buildFileMenu(){
        file=new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        //create the image item
        imageItem=new JMenuItem("Open Image");
        imageItem.addActionListener(new ItemListener());
        file.add(imageItem);
    }
    //build the action listener class
    private class ItemListener implements ActionListener{
        public void actionPerformed(actionEvent e){
            //build the file chooser
            JFileChooser fileChooser=new JFileChooser();
            int status=fileChooser.showOpenDialog(menuBar);
            if(status==JFileChooser.APPROVE_OPTION){
                //decfine the image object and assign the chosen file to it
                imageIcon myImage=new imageIcon();
                myImage=fileChooser.getSelectedFile();

            }
           
        }
    }
   }

}
