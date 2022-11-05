import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MyFrame extends JFrame {

    MyFrame() {
        ImageIcon semaImage = new ImageIcon("assets/sema.jpeg");
        Image image = semaImage.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        semaImage = new ImageIcon(image);

        ImageIcon ouzImage = new ImageIcon("assets/ouz.png");
        image = ouzImage.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        ouzImage = new ImageIcon(image);

        // panels
        // welcome panel
        JPanel welcomePanel = new JPanel();
        welcomePanel.setBackground(new Color(0x310000)); // semanın fax hex

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome to MessageBox");
        welcomeLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.LIGHT_GRAY);

        welcomePanel.add(welcomeLabel);

        // welcomeLabel.setVerticalAlignment(JLabel.TOP);
        // welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        // welcomeLabel.setHorizontalTextPosition(JLabel.CENTER); // centers the text of

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
        buttonsPanel.setBackground(new Color(0x310000)); // semanın fax hex

        JButton button = new JButton();
        button.addActionListener(e -> System.out.println("Access"));
        button.setText("Access");
        // button.setBorder(BorderFactory.createLineBorder(Color.black));
        button.setBounds(100, 100, 100, 100);
        button.setFocusable(false);

        buttonsPanel.add(button);

        // credit panel
        JPanel creditsPanel = new JPanel();
        creditsPanel.setBackground(new Color(0x310000)); // semanın fax hex

        JLabel creditsLabel = new JLabel();

        creditsLabel.setText("by Sema and Oğuz");
        creditsLabel.setFont(new Font("Arial Black", Font.ITALIC, 10));
        creditsLabel.setForeground(Color.LIGHT_GRAY);
        creditsLabel.setHorizontalAlignment(JLabel.CENTER);

        creditsPanel.add(creditsLabel);

        // frame init
        this.setTitle("Message Box");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit when pressed X
        // this.setResizable(false);
        this.setSize(600, 500);
        this.setVisible(true);

        this.setLayout(new BorderLayout());

        this.add(welcomePanel, BorderLayout.NORTH);
        // this.add(semaLabel, BorderLayout.WEST);
        // this.add(ouzLabel, BorderLayout.EAST);
        this.add(buttonsPanel, BorderLayout.CENTER);
        this.add(creditsLabel, BorderLayout.SOUTH);
        this.pack();
        // frame icon

        // this.setIconImage(semaImage.getImage());

        // frame graphics
        this.getContentPane().setBackground(new Color(0x310000)); // semanın fax hexcode

    }

}
