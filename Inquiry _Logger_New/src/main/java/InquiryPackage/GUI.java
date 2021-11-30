package InquiryPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame implements ActionListener {
        private JPanel mainPanel;

        public void run() {
            JFrame frame = new JFrame("Inquiry Logger"); //Name of program
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);


            //buttons
            JButton button1 = new JButton("New Inquiry");
            JButton button2 = new JButton("Search");
            JButton button3 = new JButton("Analytics");
            //JButton button4 = new JButton("Exit");


            //button placement
            button1.setBounds(10,10,130,30);
            button2.setBounds(10,45,130,30);
            button3.setBounds(10,80,130,30);
            //button4.setBounds(320,400,130,30);
            //frame.getContentPane().add(BorderLayout.SOUTH, button4);

            //in case we want exit to move dynamically as window expands
            int exitButtonX = 0;
            int exitButtonY = 0;

            //add to GUI
            frame.add(button1);
            frame.add(button2);
            frame.add(button3);
            //frame.add(button4);

            //basically makes the buttons on-click
            button1.addActionListener(this);
            button2.addActionListener(this);
            button3.addActionListener(this);
            //button4.addActionListener(this);

            frame.setLayout(null);
            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("New Inquiry")) {
                InquiryPackage.InquiryGUI Steve = new InquiryPackage.InquiryGUI();
                Steve.run();//call other GUI??? or next window
            }
            else if (command.equals("Search")) {
                System.out.println("Search button has been pressed");
                //InquiryGUI Steve = new InquiryGUI();
                //Steve.run();//call other GUI??? or next window
                //myMethod();//other method
            }
            else if (command.equals("Analytics")){
                InquiryPackage.Analytics.display();
            }
            else if (command.equals("Exit")){
               dispose();
            }
        }

        public void myMethod() {
            System.out.println("rered");
            JOptionPane.showMessageDialog(this, "Hello, World!!!!!");
        }


}
