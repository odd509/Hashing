package UI;

import java.awt.*;

import javax.annotation.processing.SupportedOptions;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SignupFrame extends JFrame implements ActionListener {

    JButton signupButton = new JButton();
    JButton homeButton = new JButton();

    JTextField usernameTextField = new JTextField();
    JPasswordField userPWTextField = new JPasswordField();
    JPasswordField confirmPWTextField = new JPasswordField();

    JCheckBox checkBox;

    SignupFrame() {
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

        textLabel.setText("Username");
        textPanel.add(textLabel);
        textPanel.add(Box.createRigidArea(new Dimension(20, 20))); // buffer

        textLabel = new JLabel();
        textLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textLabel.setForeground(Color.LIGHT_GRAY);
        textLabel.setAlignmentX(LEFT_ALIGNMENT);

        textLabel.setText("User Password");
        textPanel.add(textLabel);
        textPanel.add(Box.createRigidArea(new Dimension(20, 20))); // buffer

        textLabel = new JLabel();
        textLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textLabel.setForeground(Color.LIGHT_GRAY);
        textLabel.setAlignmentX(LEFT_ALIGNMENT);

        textLabel.setText("Confirm Password");
        textPanel.add(textLabel);

        // text field row
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.Y_AXIS));
        textFieldPanel.setBackground(new Color(0x310000)); // semanın fax hex
        textFieldPanel.setAlignmentX(LEFT_ALIGNMENT);

        usernameTextField.setAlignmentX(LEFT_ALIGNMENT);
        usernameTextField.setMinimumSize(new Dimension(0, 0));

        userPWTextField.setAlignmentX(LEFT_ALIGNMENT);
        userPWTextField.setMinimumSize(new Dimension(0, 0));

        confirmPWTextField.setAlignmentX(LEFT_ALIGNMENT);
        confirmPWTextField.setMinimumSize(new Dimension(0, 0));

        textFieldPanel.add(usernameTextField);
        textFieldPanel.add(Box.createRigidArea(new Dimension(0, 20))); // buffer
        textFieldPanel.add(userPWTextField);
        textFieldPanel.add(Box.createRigidArea(new Dimension(0, 20))); // buffer
        textFieldPanel.add(confirmPWTextField);

        textFieldPanel.setMaximumSize(new Dimension(100, textPanel.getMaximumSize().height));

        inputPanel.add(textPanel);
        inputPanel.add(Box.createHorizontalStrut(20));
        inputPanel.add(textFieldPanel);

        // button panels and buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0x310000)); // semanın fax hex
        buttonPanel.setLayout(new FlowLayout(0, 30, 0));
        buttonPanel.setMaximumSize(new Dimension(inputPanel.getMaximumSize().width, 60));

        signupButton.setText("Sign Up");
        signupButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
        signupButton.setFocusable(false);
        signupButton.setAlignmentX(CENTER_ALIGNMENT);
        signupButton.addActionListener(this);

        homeButton.setText("Home");
        homeButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
        homeButton.setFocusable(false);
        homeButton.setAlignmentX(CENTER_ALIGNMENT);
        homeButton.addActionListener(this);

        buttonPanel.add(signupButton);
        buttonPanel.add(homeButton);
        // password checkbox

        checkBox = new JCheckBox("Show Password");
        checkBox.setForeground(Color.gray);
        checkBox.setBackground(new Color(0x310000)); // semanın fax hexcode
        checkBox.setAlignmentX(CENTER_ALIGNMENT);
        checkBox.setFocusable(false);
        checkBox.addActionListener(this);

        // ------------------------ frame init --------------------
        this.setTitle("Sign Up");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit when pressed X
        this.setResizable(false);
        this.setSize(300, 400);

        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel signupLabel = new JLabel();
        signupLabel.setText("Sign Up");
        signupLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
        signupLabel.setForeground(Color.LIGHT_GRAY);
        signupLabel.setAlignmentX(CENTER_ALIGNMENT);

        this.add(Box.createVerticalStrut(20)); // buffer
        this.add(signupLabel);
        this.add(inputPanel);
        this.add(checkBox);
        this.add(Box.createVerticalStrut(20)); // buffer
        this.add(buttonPanel);
        this.add(Box.createVerticalStrut(20)); // buffer

        this.getContentPane().setBackground(new Color(0x310000)); // semanın fax hexcode
        this.setVisible(true);
        this.setLocationRelativeTo(null); // set frame initialization location to centre of the screen
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black)); // black outline

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            System.out.println("Sign up");
            // check validations
            // if valid, success pop up

            // if username is taken

            // else if passwords dont match

            if (usernameTextField.getText().length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Username can not be empty", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            } else if (userPWTextField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(rootPane, "Password can not be empty", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            } else if (confirmPWTextField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(rootPane, "Confirm password can not be empty", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            } else if (!Arrays.equals(userPWTextField.getPassword(), confirmPWTextField.getPassword())) {
                JOptionPane.showMessageDialog(rootPane, "Passwords do not match", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println("zito");
            }

        } else if (e.getSource() == homeButton) {
            System.out.println("Home");
            this.dispose();
            new HomeFrame();
        } else if (e.getSource() == checkBox) {
            if (checkBox.isSelected()) {
                userPWTextField.setEchoChar((char) 0);
                confirmPWTextField.setEchoChar((char) 0);
            } else {
                userPWTextField.setEchoChar('*');
                confirmPWTextField.setEchoChar('*');
            }
        }

    }

}
