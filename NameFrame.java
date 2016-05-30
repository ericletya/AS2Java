import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameFrame extends JFrame {

    private String playerName;
    private boolean actionFlag = false;

    public NameFrame(String title, String playerNm){

        super(title);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        JLabel label = new JLabel("Type in player " + playerNm + " name: ");
        gc.gridx =0; gc.gridy = 0; add(label, gc);

        JTextField field = new JTextField(10);
        gc.gridx = 1; gc.gridy = 0; gc.fill = GridBagConstraints.HORIZONTAL; add(field, gc);

        JButton button = new JButton("Accept");
        gc.gridx = 1; gc.gridy = 1; add(button, gc);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPlayerName(field.getText());
                actionFlag = true;
                NameFrame.super.setVisible(false);
            }
        });

    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean isActionFlag() {
        return actionFlag;
    }
}
