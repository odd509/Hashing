import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccessFrame extends JFrame implements ActionListener {

    JButton viewButton = new JButton();
    JButton resetButton = new JButton();
    JButton homeButton = new JButton();

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

        textLabel = new JLabel();
        textLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textLabel.setForeground(Color.LIGHT_GRAY);
        textLabel.setAlignmentX(LEFT_ALIGNMENT);

        textLabel.setText("Message Password");
        textPanel.add(textLabel);

        textLabel = new JLabel();
        textLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textLabel.setForeground(Color.LIGHT_GRAY);
        textLabel.setAlignmentX(LEFT_ALIGNMENT);

        textLabel.setText("Username");
        textPanel.add(textLabel);

        textLabel = new JLabel();
        textLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        textLabel.setForeground(Color.LIGHT_GRAY);
        textLabel.setAlignmentX(LEFT_ALIGNMENT);

        textLabel.setText("User Password");
        textPanel.add(textLabel);

        // text field row
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.Y_AXIS));
        textFieldPanel.setAlignmentX(LEFT_ALIGNMENT);

        JTextField codenameTextField = new JTextField();
        codenameTextField.setAlignmentX(LEFT_ALIGNMENT);
        codenameTextField.setMinimumSize(new Dimension(0, 0));

        JTextField messagePWTextField = new JTextField();
        messagePWTextField.setAlignmentX(LEFT_ALIGNMENT);
        messagePWTextField.setMinimumSize(new Dimension(0, 0));

        JTextField usernameTextField = new JTextField();
        usernameTextField.setAlignmentX(LEFT_ALIGNMENT);
        usernameTextField.setMinimumSize(new Dimension(0, 0));

        JTextField userPWTextField = new JTextField();
        userPWTextField.setAlignmentX(LEFT_ALIGNMENT);
        userPWTextField.setMinimumSize(new Dimension(0, 0));

        textFieldPanel.add(codenameTextField);
        textFieldPanel.add(messagePWTextField);
        textFieldPanel.add(usernameTextField);
        textFieldPanel.add(userPWTextField);

        textFieldPanel.setMaximumSize(new Dimension(100, textPanel.getMaximumSize().height));

        inputPanel.add(textPanel);
        inputPanel.add(Box.createHorizontalStrut(20));
        inputPanel.add(textFieldPanel);

        // button pannel and buttons

        homeButton.setText("Home");
        homeButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
        homeButton.setFocusable(false);
        homeButton.setAlignmentX(CENTER_ALIGNMENT);
        homeButton.addActionListener(this);

        // ------------------------ frame init --------------------
        this.setTitle("Message view");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit when pressed X
        // this.setResizable(false);
        this.setSize(450, 250);

        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        this.add(Box.createVerticalStrut(20)); // buffer
        this.add(inputPanel);
        this.add(Box.createVerticalStrut(20)); // buffer
        this.add(homeButton);

        this.getContentPane().setBackground(new Color(0x310000)); // semanın fax hexcode
        this.setVisible(true);
        this.setLocationRelativeTo(null); // set frame initialization location to centre of the screen
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("as");
        if (e.getSource() == homeButton) {
            System.out.println("Home");
            this.dispose();
            new HomeFrame();
        }
    }

}
