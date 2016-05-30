import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class test {
    public static void main(String[] args){

        SpecialFrame frame = new SpecialFrame("Message", "You cannot use this card");
        frame.setSize(300, 100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
