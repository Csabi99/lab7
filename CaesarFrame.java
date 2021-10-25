import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaesarFrame extends JFrame {
    private JPanel p1, p2;
    private JTextField f1, f2;
    private  JButton button;
    private JComboBox combobox;
    public CaesarFrame(){
        super("CaesarCoding");
        this.setTitle("SwingLab");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400,110);
        GridLayout lm=new GridLayout();
        lm.setRows(2);
        lm.setColumns(1);
        this.setLayout(lm);


        p1=new JPanel(new FlowLayout());
        add(p1);
        Object chars[]=new Object[26];
        for(int i=(int)'A';i<=(int)'Z';i++) {
            chars[i - (int) 'A'] = (char) i;
        }
        combobox = new JComboBox(chars);
        p1.add(combobox);
        f1 = new JTextField(20);
        f1.setEnabled(true);
        p1.add(f1);
        button=new JButton();
        button.setText("Code!");
        button.addActionListener(new OkButtonActionListener());
        p1.add(button);

        p2=new JPanel(new BorderLayout());
        add(p2);
        p2.add(new JLabel("Output:"),BorderLayout.WEST);
        f2=new JTextField(20);
        f2.setEditable(false);
        p2.add(f2);

        setResizable(true);
    }
    private String caesarCode(String input, char offset){
        input=input.toUpperCase();
        String s="";
        offset=Character.toUpperCase(offset);
        int numericOffset=(int)offset - (int)'A';
        for(int x=0; x<input.length(); x++){
            char c=(char)(input.charAt(x) + numericOffset);
            if (c > 'Z')
                s+=(char)(input.charAt(x) - (26-numericOffset));
            else
                s+=(char)(input.charAt(x) + numericOffset);
        }
        return s;

    }
    private class OkButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            f2.setText(caesarCode(f1.getText(), (char)combobox.getSelectedItem()));
        }

    }
}
