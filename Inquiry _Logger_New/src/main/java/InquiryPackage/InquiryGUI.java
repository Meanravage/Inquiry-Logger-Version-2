package InquiryPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InquiryGUI extends JFrame implements ActionListener {
    public void run() {

        int textX = 320;
        int labelX = 12;
        int labelWidth = 250;
        int textWidth = 150;
        int rowY = 50;

        //inquiry submission window setup
        JFrame frame=new JFrame("InquiryGUI");
        frame.setSize(500, 600);

        //Time Stamp
        JLabel labelTimeStamp = new JLabel("Time Stamp: ");
        labelTimeStamp.setBounds(labelX,rowY, labelWidth,20);
        frame.add(labelTimeStamp);

        //First Name
        JLabel labelFirstName = new JLabel("First Name: ");
        labelFirstName.setBounds(labelX,rowY += 25, labelWidth,20);
        frame.add(labelFirstName);

        final JTextField FirstName = new JTextField();
        FirstName.setBounds(textX,rowY, textWidth,20);
        frame.add(FirstName);

        //Last Name
        JLabel labelLastName = new JLabel("Last Name: ");
        labelLastName.setBounds(labelX,rowY += 25, labelWidth,20);
        frame.add(labelLastName);

        final JTextField LastName = new JTextField();
        LastName.setBounds(textX,rowY, textWidth,20);
        frame.add(LastName);

        // Email
        JLabel labelEmail = new JLabel("Email: ");
        labelEmail.setBounds(labelX,rowY += 25, labelWidth,20);
        frame.add(labelEmail);

        final JTextField Email = new JTextField();
        Email.setBounds(textX,rowY, textWidth,20);
        frame.add(Email);

        // Phone
        JLabel labelPhone = new JLabel("Phone: ");
        labelPhone.setBounds(labelX,rowY += 25, labelWidth,20);
        frame.add(labelPhone);

        final JTextField Phone = new JTextField();
        Phone.setBounds(textX,rowY, textWidth,20);
        frame.add(Phone);

        // Instrument interest
        JLabel labelInstrument = new JLabel("Instrument Interest: ");
        labelInstrument.setBounds(labelX, rowY += 25, labelWidth,20);
        frame.add(labelInstrument);

        final JCheckBox PianoCheck = new JCheckBox("Piano");
        PianoCheck.setBounds(textX, rowY, 75,20);
        frame.add(PianoCheck);

        final JCheckBox GuitarCheck = new JCheckBox("Guitar");
        GuitarCheck.setBounds(textX + 75, rowY, 75,20);
        frame.add(GuitarCheck);

        final JCheckBox VoiceCheck = new JCheckBox("Voice");
        VoiceCheck.setBounds(textX, rowY += 25, 75,20);
        frame.add(VoiceCheck);

        final JCheckBox ViolinCheck = new JCheckBox("Violin");
        ViolinCheck.setBounds(textX + 75, rowY, 75,20);
        frame.add(ViolinCheck);




        // Contacted Method
        JLabel labelContactMethod = new JLabel("Contacted Method: ");
        labelContactMethod.setBounds(labelX,rowY += 35, labelWidth,20);
        frame.add(labelContactMethod);

        String[] contactMethodList = {"Other", "Email", "Social Media", "Text", "Phone"}; //all the contact methods

        JComboBox ContactMethods = new JComboBox(contactMethodList);
        ContactMethods.setSelectedIndex(4);
        ContactMethods.addActionListener(this);
        ContactMethods.setBounds(textX,rowY, textWidth,20);
        frame.add(ContactMethods);
        //JComboBox cb = (JComboBox)e.getSource();
        //String petName = (String)cb.getSelectedItem();
        //updateLabel(petName);

        // Invited to Preview Lesson
        JLabel labelPreviewInvite = new JLabel("Invited to Preview Lesson? ");
        labelPreviewInvite.setBounds(labelX,rowY += 25, labelWidth,20);
        frame.add(labelPreviewInvite);

        final JCheckBox PreviewInvite = new JCheckBox();
        PreviewInvite.setBounds(textX,rowY, 150,20);
        frame.add(PreviewInvite);

        // Preview Lesson Date
        JLabel labelPreviewLesson = new JLabel("Preview Lesson Date: ");
        labelPreviewLesson.setBounds(labelX,rowY += 25, labelWidth,20);
        frame.add(labelPreviewLesson);

        final JTextField PreviewLesson = new JTextField();
        PreviewLesson.setBounds(textX,rowY, textWidth,20);
        frame.add(PreviewLesson);

        // Showed up for preview lesson?
        JLabel labelPreviewAttended = new JLabel("Showed up for preview lesson? ");
        labelPreviewAttended.setBounds(labelX,rowY += 25, labelWidth,20);
        frame.add(labelPreviewAttended);

        final JCheckBox PreviewAttended = new JCheckBox();
        PreviewAttended.setBounds(textX,rowY, 150,20);
        frame.add(PreviewAttended);

        //Invited to enroll
        JLabel labelEnrollInvite = new JLabel("Invited to enroll ");
        labelEnrollInvite.setBounds(labelX,rowY += 25, labelWidth,20);
        frame.add(labelEnrollInvite);

        final JCheckBox EnrollInvite = new JCheckBox();
        EnrollInvite.setBounds(textX,rowY, 150,20);
        frame.add(EnrollInvite);

        // Enrolled
        JLabel labelEnrolled = new JLabel("Enrolled ");
        labelEnrolled.setBounds(labelX,rowY += 25, labelWidth,20);
        frame.add(labelEnrolled);

        final JCheckBox Enrolled = new JCheckBox();
        Enrolled.setBounds(textX,rowY, 150,20);
        frame.add(Enrolled);

        // Preferred Contact
        JLabel labelPreferredContact = new JLabel("Preferred Contact Method: ");
        labelPreferredContact.setBounds(labelX,rowY += 25, labelWidth,20);
        frame.add(labelPreferredContact);

        final JTextField PreferredContact = new JTextField();
        PreferredContact.setBounds(textX,rowY, textWidth,20);
        frame.add(PreferredContact);

        // Notes
        JLabel labelNotes = new JLabel("Notes: ");
        labelNotes.setBounds(labelX,rowY += 25, labelWidth,20);
        frame.add(labelNotes);

        final JTextArea Notes = new JTextArea(textWidth,100);
        JScrollPane scrollPane = new JScrollPane(Notes);
        Notes.setEditable(true);
        Notes.setBounds(textX,rowY, textWidth,100);
        frame.add(Notes);

        // Submit
        JButton button1 =new JButton("Submit");
        button1.setBounds(338,525,130,30);
        frame.add(button1);
        button1.addActionListener(this);

        /*
        //drop-down
        String[] Instruments = { "Piano",  }; //all the instruments
        int num = 5 //number of instruments
        JComboBox inList = new JComboBox(Instruments);
        inList.setSelectedIndex(4);
        inList.addActionListener(this);
        JComboBox cb = (JComboBox)e.getSource();
        String petName = (String)cb.getSelectedItem();
        updateLabel(petName);

        JFrame f;
    ComboBoxExample(){
    f=new JFrame("ComboBox Example");
    String country[]={"India","Aus","U.S.A","England","New Zealand"};
    JComboBox cb=new JComboBox(country);
    cb.setBounds(50, 50,90,20);
    f.add(cb);
    f.setLayout(null);
    f.setSize(400,500);
    f.setVisible(true);

  }
         */

        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Submit")) {
            //call data manager to send input from window to google spreadsheet
        }
    }
}
