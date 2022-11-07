package UI;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccessFrame extends JFrame implements ActionListener {

    JButton viewButton = new JButton();
    JButton resetButton = new JButton();
    JButton homeButton = new JButton();

    JTextField codenameTextField = new JTextField();
    JPasswordField messagePWTextField = new JPasswordField();
    JTextField usernameTextField = new JTextField();
    JPasswordField userPWTextField = new JPasswordField();

    JCheckBox checkBox;

    AccessFrame() {
        // --------------- panels --------------------
        // input panel

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.setBackground(new Color(0x310000)); // semanın fax hex

        // -----rows
        // text row
        JPanel textPanel = new JPanel();
        textPanel.setBackground(new Color(0x310000)); // semanın fax hex
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel textLabel = new JLabel();
        textLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textLabel.setForeground(Color.LIGHT_GRAY);
        textLabel.setAlignmentX(LEFT_ALIGNMENT);

        textLabel.setText("Message Codename");
        textPanel.add(textLabel);
        textPanel.add(Box.createRigidArea(new Dimension(20, 20))); // buffer

        textLabel = new JLabel();
        textLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textLabel.setForeground(Color.LIGHT_GRAY);
        textLabel.setAlignmentX(LEFT_ALIGNMENT);

        textLabel.setText("Message Password");
        textPanel.add(textLabel);
        textPanel.add(Box.createRigidArea(new Dimension(20, 20))); // buffer

        textLabel = new JLabel();
        textLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textLabel.setForeground(Color.LIGHT_GRAY);
        textLabel.setAlignmentX(LEFT_ALIGNMENT);

        textLabel.setText("Username");
        textPanel.add(textLabel);
        textPanel.add(Box.createRigidArea(new Dimension(20, 20))); // buffer

        textLabel = new JLabel();
        textLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textLabel.setForeground(Color.LIGHT_GRAY);
        textLabel.setAlignmentX(LEFT_ALIGNMENT);

        textLabel.setText("User Password");
        textPanel.add(textLabel);

        // text field row
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.Y_AXIS));
        textFieldPanel.setBackground(new Color(0x310000)); // semanın fax hex
        textFieldPanel.setAlignmentX(LEFT_ALIGNMENT);

        codenameTextField.setAlignmentX(LEFT_ALIGNMENT);
        codenameTextField.setMinimumSize(new Dimension(0, 0));

        messagePWTextField.setAlignmentX(LEFT_ALIGNMENT);
        messagePWTextField.setMinimumSize(new Dimension(0, 0));

        usernameTextField.setAlignmentX(LEFT_ALIGNMENT);
        usernameTextField.setMinimumSize(new Dimension(0, 0));

        userPWTextField.setAlignmentX(LEFT_ALIGNMENT);
        userPWTextField.setMinimumSize(new Dimension(0, 0));

        textFieldPanel.add(codenameTextField);
        textFieldPanel.add(Box.createRigidArea(new Dimension(0, 20))); // buffer
        textFieldPanel.add(messagePWTextField);
        textFieldPanel.add(Box.createRigidArea(new Dimension(0, 20))); // buffer
        textFieldPanel.add(usernameTextField);
        textFieldPanel.add(Box.createRigidArea(new Dimension(0, 20))); // buffer
        textFieldPanel.add(userPWTextField);

        textFieldPanel.setMaximumSize(new Dimension(100, textPanel.getMaximumSize().height));

        inputPanel.add(textPanel);
        inputPanel.add(Box.createHorizontalStrut(20));
        inputPanel.add(textFieldPanel);

        // button panels and buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0x310000)); // semanın fax hex
        buttonPanel.setLayout(new FlowLayout(0, 30, 0));
        buttonPanel.setMaximumSize(new Dimension(inputPanel.getMaximumSize().width, 60));

        viewButton.setText("View");
        viewButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
        viewButton.setFocusable(false);
        viewButton.setAlignmentX(CENTER_ALIGNMENT);
        viewButton.addActionListener(this);

        resetButton.setText("Reset");
        resetButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
        resetButton.setFocusable(false);
        resetButton.setAlignmentX(CENTER_ALIGNMENT);
        resetButton.addActionListener(this);

        homeButton.setText("Home");
        homeButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
        homeButton.setFocusable(false);
        homeButton.setAlignmentX(CENTER_ALIGNMENT);
        homeButton.addActionListener(this);

        buttonPanel.add(viewButton);
        buttonPanel.add(resetButton);
        // password checkbox

        checkBox = new JCheckBox("Show Password");
        checkBox.setForeground(Color.gray);
        checkBox.setBackground(new Color(0x310000)); // semanın fax hexcode
        checkBox.setAlignmentX(CENTER_ALIGNMENT);
        checkBox.setFocusable(false);
        checkBox.addActionListener(this);

        // ------------------------ frame init --------------------
        this.setTitle("Message view");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit when pressed X
        this.setResizable(false);
        this.setSize(300, 400);

        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        this.add(Box.createVerticalStrut(20)); // buffer
        this.add(inputPanel);
        this.add(checkBox);
        this.add(Box.createVerticalStrut(20)); // buffer
        this.add(buttonPanel);
        this.add(Box.createVerticalStrut(20)); // buffer
        this.add(homeButton);
        this.add(Box.createVerticalStrut(20)); // buffer

        this.getContentPane().setBackground(new Color(0x310000)); // semanın fax hexcode
        this.setVisible(true);
        this.setLocationRelativeTo(null); // set frame initialization location to centre of the screen
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black)); // black outline

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewButton) {
            System.out.println("View");
            // check validations
            this.dispose();
            new MessageFrame(
                    "masajaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\naaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n\n\n\n\n\n\n\n\n\n\nasdasdasdasdsad\n\n\n\n\n");

        } else if (e.getSource() == resetButton) {
            System.out.println("Reset");
            codenameTextField.setText("");
            messagePWTextField.setText("");
            usernameTextField.setText("");
            userPWTextField.setText("");

        } else if (e.getSource() == homeButton) {
            System.out.println("Home");
            this.dispose();
            new HomeFrame();
        } else if (e.getSource() == checkBox) {
            if (checkBox.isSelected()) {
                userPWTextField.setEchoChar((char) 0);
                messagePWTextField.setEchoChar((char) 0);
            } else {
                userPWTextField.setEchoChar('*');
                messagePWTextField.setEchoChar('*');
            }
        }
    }

}
