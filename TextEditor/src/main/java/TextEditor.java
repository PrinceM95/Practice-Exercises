import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditor extends JFrame implements ActionListener {

    //Declaration of an instance variable
    JTextArea textArea;

    //Constructor
    TextEditor(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Text Editor");
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(450, 450));

        this.add(textArea);
        this.setVisible(true);

    }

    @Override
    //When an action event occurs, such as a button click, the actionPerformed() method is invoked, and any code within it is executed.
    public void actionPerformed(ActionEvent e) {
        //TODO Auto-generated method stub
    }

}
