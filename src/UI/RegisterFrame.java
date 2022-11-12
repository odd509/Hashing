package UI;

import Backend.DataBase;
import Backend.Message;
import Backend.NotAUniqueFieldException;
import Backend.User;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class RegisterFrame extends JFrame implements ActionListener {

    JButton crateMessageButton = new JButton();
    JButton homeButton = new JButton();

    JComboBox<String> usernameBox;
    JPasswordField passwordTextField = new JPasswordField();
    JTextField messageCodenameTextField = new JTextField();
    JPasswordField confPasswordTextField = new JPasswordField();
    JTextArea messageTextField = new JTextArea();

    JCheckBox checkBox;
    User selectedUser = null;

    RegisterFrame() {
        // --------------- panels --------------------
        // input panel

        // combo box

        String[] list = new String[DataBase.getUserDB().size()];
        int counter = 0;
        for (User user : DataBase.getUserDB()) {
            list[counter] = user.getUsername();
            counter++;
        }

        usernameBox = new JComboBox<String>(list);
        usernameBox.addActionListener(this);
        usernameBox.setEditable(false);
        usernameBox.setSelectedItem(null);
        usernameBox.setMaximumSize(new Dimension(300, 5));

        // --------------- panels --------------------
        // input panel

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
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

        textLabel.setText("Auth. username");
        textPanel.add(textLabel);
        textPanel.add(Box.createRigidArea(new Dimension(20, 20))); // buffer

        textLabel = new JLabel();
        textLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textLabel.setForeground(Color.LIGHT_GRAY);
        textLabel.setAlignmentX(LEFT_ALIGNMENT);

        textLabel.setText("Password");
        textPanel.add(textLabel);
        textPanel.add(Box.createRigidArea(new Dimension(20, 20))); // buffer

        textLabel = new JLabel();
        textLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textLabel.setForeground(Color.LIGHT_GRAY);
        textLabel.setAlignmentX(LEFT_ALIGNMENT);

        textLabel.setText("Message codename");
        textPanel.add(textLabel);
        textPanel.add(Box.createRigidArea(new Dimension(20, 20))); // buffer

        textLabel = new JLabel();
        textLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textLabel.setForeground(Color.LIGHT_GRAY);
        textLabel.setAlignmentX(LEFT_ALIGNMENT);

        textLabel.setText("Confirm Password");

        // text field row
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.Y_AXIS));
        textFieldPanel.setBackground(new Color(0x310000)); // semanın fax hex
        textFieldPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        textFieldPanel.add(usernameBox);
        textFieldPanel.add(Box.createRigidArea(new Dimension(0, 15))); // buffer
        textFieldPanel.add(passwordTextField);
        textFieldPanel.add(Box.createRigidArea(new Dimension(0, 15))); // buffer
        textFieldPanel.add(messageCodenameTextField);
        textFieldPanel.add(Box.createRigidArea(new Dimension(0, 15))); // buffer

        textFieldPanel.setMaximumSize(new Dimension(150, textPanel.getMaximumSize().height));

        inputPanel.add(textPanel);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 15))); // buffer
        inputPanel.add(textFieldPanel);

        // nest one conf pass
        JPanel nest1 = new JPanel();
        nest1.setBackground(new Color(0x310000)); // semanın fax hex
        nest1.setLayout(new BoxLayout(nest1, BoxLayout.X_AXIS));
        nest1.setAlignmentX(CENTER_ALIGNMENT);
        nest1.setAlignmentY(CENTER_ALIGNMENT);
        nest1.setMaximumSize(new Dimension(300, textPanel.getMaximumSize().height / 4));

        nest1.add(textLabel);
        textFieldPanel.add(Box.createRigidArea(new Dimension(0, 15))); // buffer
        nest1.add(confPasswordTextField);

        // nest two auth and confirm pass
        JPanel nest2 = new JPanel();
        nest2.setBackground(new Color(0x310000)); // semanın fax hex
        nest2.setLayout(new BoxLayout(nest2, BoxLayout.X_AXIS));
        nest2.add(inputPanel);
        nest2.add(Box.createRigidArea(new Dimension(15, 0))); // buffer
        nest2.add(nest1);
        // password checkbox

        checkBox = new JCheckBox("Show Password");
        checkBox.setForeground(Color.gray);
        checkBox.setBackground(new Color(0x310000)); // semanın fax hexcode
        checkBox.setAlignmentX(LEFT_ALIGNMENT);
        checkBox.setFocusable(false);
        checkBox.addActionListener(this);

        // message panel
        JPanel messagePanel = new JPanel();
        messagePanel.setBackground(new Color(0x310000)); // semanın fax hex
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.X_AXIS));
        messagePanel.setMaximumSize(new Dimension(600, 300));

        textLabel = new JLabel();
        textLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textLabel.setForeground(Color.LIGHT_GRAY);

        textLabel.setText("ENTER YOUR MESSAGE");

        messagePanel.add(textLabel);
        messagePanel.add(Box.createRigidArea(new Dimension(30, 0))); // buffer

        messageTextField.setPreferredSize(new Dimension(430, 200));
        messageTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        messageTextField.setMaximumSize(messageTextField.getPreferredSize());

        messagePanel.add(messageTextField);

        // button panels and buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0x310000)); // semanın fax hex
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 0));

        crateMessageButton.setText("Create Message");
        crateMessageButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
        crateMessageButton.setFocusable(false);
        crateMessageButton.addActionListener(this);

        homeButton.setText("HOME");
        homeButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
        homeButton.setFocusable(false);
        homeButton.addActionListener(this);

        buttonPanel.add(crateMessageButton);
        buttonPanel.add(homeButton);
        // password checkbox

        // ------------------------ frame init --------------------
        this.setTitle("Register Form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit when pressed X
        this.setResizable(true);
        this.setSize(700, 700);

        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        this.add(Box.createVerticalStrut(20)); // buffer
        this.add(nest2);
        this.add(checkBox);
        this.add(Box.createVerticalStrut(20)); // buffer
        this.add(messagePanel);
        this.add(Box.createVerticalStrut(20)); // buffer
        this.add(buttonPanel);

        this.getContentPane().setBackground(new Color(0x310000)); // semanın fax hexcode
        this.setVisible(true);
        this.setLocationRelativeTo(null); // set frame initialization location to centre of the screen
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black)); // black outline

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == usernameBox) {
            String name = String.valueOf(usernameBox.getSelectedItem());
            selectedUser = DataBase.findUser(name);

        } else if (e.getSource() == crateMessageButton) {

            if (passwordTextField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(rootPane, "Password can not be empty", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            } else if (confPasswordTextField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(rootPane, "Confirm password can not be empty", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            } else if (new String(passwordTextField.getPassword()).contains("-")
                    || new String(passwordTextField.getPassword()).contains("_")) {
                JOptionPane.showMessageDialog(rootPane, "Passwords can not contain \"-\"or \"_\"", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            } else if (!Arrays.equals(passwordTextField.getPassword(), confPasswordTextField.getPassword())) {
                JOptionPane.showMessageDialog(rootPane, "Passwords do not match", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (messageCodenameTextField.getText().length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Message codename can not be empty", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            } else if (messageCodenameTextField.getText().contains("-")
                    || messageCodenameTextField.getText().contains("_")) {
                JOptionPane.showMessageDialog(rootPane, "Message can not contain \"-\" or \"_\"", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            } else if (messageTextField.getText().contains("-") || messageTextField.getText().contains("_")) {
                JOptionPane.showMessageDialog(rootPane, "Message can not contain \"-\"or \"_\"", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            } else if (selectedUser == null) {
                JOptionPane.showMessageDialog(rootPane, "Please select a valid user", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    new Message(messageCodenameTextField.getText(), messageTextField.getText(), selectedUser,
                            new String(passwordTextField.getPassword()), false);
                    JOptionPane.showMessageDialog(rootPane, "Message sent successfully", "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (NotAUniqueFieldException exception) {
                    JOptionPane.showMessageDialog(rootPane, exception, "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        } else if (e.getSource() == homeButton) {
            System.out.println("Home");
            this.dispose();
            new HomeFrame();

        } else if (e.getSource() == checkBox) {
            if (checkBox.isSelected()) {
                passwordTextField.setEchoChar((char) 0);
                confPasswordTextField.setEchoChar((char) 0);
            } else {
                passwordTextField.setEchoChar('*');
                confPasswordTextField.setEchoChar('*');
            }
        }

    }

}
