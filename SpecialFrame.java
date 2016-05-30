import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialFrame extends JFrame {

    private String choice;
    private boolean actionFlag;

    SpecialFrame(String title, String message){

        super(title);

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JLabel label = new JLabel(message);
        gc.gridx = 0; gc.gridy = 0;
        add(label);
    }
    SpecialFrame(String title){

        super(title);
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JButton button = new JButton("Yes");
        pressButton(button);

        JButton button1 = new JButton("No");
        pressButton(button1);

    }
    private void pressButton(JButton button){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = button.getName();
                actionFlag = true;
                SpecialFrame.super.setVisible(false);
            }
        });
    }

    public boolean isActionFlag() {
        return actionFlag;
    }

    public String getChoice() {
        return choice;
    }
}
