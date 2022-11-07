package UI;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageFrame extends JFrame implements ActionListener {

    JButton returnButton = new JButton();

    MessageFrame(String message) {

        JTextArea textArea = new JTextArea(message);
        JScrollPane messagePane = new JScrollPane(textArea);

        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.Y_AXIS));
        ButtonPanel.setBackground(new Color(0x310000)); // semanın fax hexcode

        returnButton.setText("Return");
        returnButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
        returnButton.setFocusable(false);
        returnButton.setAlignmentX(CENTER_ALIGNMENT);
        returnButton.addActionListener(this);

        ButtonPanel.add(returnButton);
        ButtonPanel.add(Box.createRigidArea(new Dimension(0, 30))); // buffer

        JPanel bufferPanelEast = new JPanel();
        JPanel bufferPanelWest = new JPanel();
        JPanel bufferPanelNorth = new JPanel();
        bufferPanelEast.setBackground(new Color(0x310000)); // semanın fax hexcode
        bufferPanelWest.setBackground(new Color(0x310000)); // semanın fax hexcode
        bufferPanelNorth.setBackground(new Color(0x310000)); // semanın fax hexcode

        this.setLayout(new BorderLayout(30, 30));
        this.getContentPane().setBackground(new Color(0x310000)); // semanın fax hexcode

        this.add(messagePane, BorderLayout.CENTER);
        this.add(ButtonPanel, BorderLayout.SOUTH);
        this.add(bufferPanelEast, BorderLayout.EAST);
        this.add(bufferPanelWest, BorderLayout.WEST);
        this.add(bufferPanelNorth, BorderLayout.NORTH);

        this.setTitle("Message");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit when pressed X
        this.setResizable(false);
        this.setSize(450, 450);
        this.setVisible(true);
        this.setLocationRelativeTo(null); // set frame initialization location to centre of the screen
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black)); // black outline

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton) {
            this.dispose();
            new AccessFrame();
        }

    }

}
