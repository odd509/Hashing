import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame extends JFrame implements ActionListener {

    JButton accessButton = new JButton();
    JButton messageButton = new JButton();

    HomeFrame() {

        /*
         * ImageIcon semaImage = new ImageIcon("assets/sema.jpeg");
         * Image image = semaImage.getImage().getScaledInstance(200, 200,
         * java.awt.Image.SCALE_SMOOTH);
         * semaImage = new ImageIcon(image);
         * 
         * ImageIcon ouzImage = new ImageIcon("assets/ouz.png");
         * image = ouzImage.getImage().getScaledInstance(200, 200,
         * java.awt.Image.SCALE_SMOOTH);
         * ouzImage = new ImageIcon(image);
         */

        // --------------- panels --------------------
        // welcome panel

        JPanel welcomePanel = new JPanel();
        welcomePanel.setBackground(new Color(0x310000)); // semanın fax hex

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome to MessageBox");
        welcomeLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.LIGHT_GRAY);

        welcomePanel.add(welcomeLabel);

        // image panels
        /*
         * JPanel imagePanel = new JPanel();
         * imagePanel.setBackground(Color.red);
         * imagePanel.setBounds(50, 50, 400, 200);
         * 
         * JLabel semaLabel = new JLabel();
         * JLabel ouzLabel = new JLabel();
         * 
         * semaLabel.setText("Sema");
         * semaLabel.setForeground(Color.lightGray);
         * ouzLabel.setText("Oğuz");
         * ouzLabel.setForeground(Color.lightGray);
         * 
         * semaLabel.setIcon(semaImage);
         * ouzLabel.setIcon(ouzImage);
         * 
         * semaLabel.setVerticalTextPosition(JLabel.BOTTOM);
         * semaLabel.setHorizontalTextPosition(JLabel.CENTER);
         * ouzLabel.setVerticalTextPosition(JLabel.BOTTOM);
         * ouzLabel.setHorizontalTextPosition(JLabel.CENTER);
         * 
         * imagePanel.add(semaLabel);
         * imagePanel.add(ouzLabel);
         */

        // button panel and buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));
        buttonsPanel.setBackground(new Color(0x310000)); // semanın fax hex

        accessButton.setText("Access");
        accessButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
        accessButton.setFocusable(false);
        accessButton.setAlignmentX(CENTER_ALIGNMENT);
        accessButton.addActionListener(this);

        messageButton.setText("Leave Message");
        messageButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
        messageButton.setFocusable(false);
        messageButton.setAlignmentX(CENTER_ALIGNMENT);
        messageButton.addActionListener(this);

        buttonsPanel.add(Box.createVerticalStrut(20)); // buffer space
        buttonsPanel.add(accessButton);
        buttonsPanel.add(Box.createVerticalStrut(20));
        buttonsPanel.add(messageButton);

        // credit panel
        JPanel creditsPanel = new JPanel();
        creditsPanel.setBackground(new Color(0x310000)); // semanın fax hex

        JLabel creditsLabel = new JLabel();

        creditsLabel.setText("by Sema and Oğuz");
        creditsLabel.setFont(new Font("Arial Black", Font.ITALIC, 10));
        creditsLabel.setForeground(Color.LIGHT_GRAY);
        creditsLabel.setHorizontalAlignment(JLabel.CENTER);

        creditsPanel.add(creditsLabel);

        // ------------------------ frame init --------------------
        this.setTitle("Main Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit when pressed X
        this.setResizable(true);
        this.setSize(350, 250);

        this.setLayout(new BorderLayout());

        this.add(welcomePanel, BorderLayout.NORTH);
        this.add(buttonsPanel, BorderLayout.CENTER);
        this.add(creditsLabel, BorderLayout.SOUTH);
        // this.add(semaLabel, BorderLayout.WEST);
        // this.add(ouzLabel, BorderLayout.EAST);

        // this.pack();
        // ----------frame icon
        // this.setIconImage(semaImage.getImage());

        // -------------------------frame graphics
        this.getContentPane().setBackground(new Color(0x310000)); // semanın fax hexcode
        this.setVisible(true);
        this.setLocationRelativeTo(null); // set frame initialization location to centre of the screen

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == accessButton) {
            System.out.println("Access");
            this.dispose();
            new AccessFrame();
        } else if (e.getSource() == messageButton) {
            System.out.println("Register Message");
            this.dispose();
            new RegisterFrame();

        }

    }
}
