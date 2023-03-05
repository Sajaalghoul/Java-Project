import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.text.*;
public class AddBook extends JFrame implements ActionListener{
	Container c;
	JLabel Title, Author, Year;
	JTextField t1,t2,t3;
	JButton save,cancel;
	static int i=0;
	static ArrayList<Books> b = new ArrayList<>(100);	
	public AddBook() {
		super("AddBook");
		c=getContentPane(); c.setLayout(null);	
		Title= new JLabel("Title: "); Title.setBounds(20,20,100,20);
		Author = new JLabel("Author: "); Author.setBounds(20,60,100,20);
		Year= new JLabel("Year: "); Year.setBounds(20,100,100,20);
		t1=new JTextField(); t1.setBounds(140,20,170,20);
		t2= new JTextField();  t2.setBounds(140,60,170,20);
		t3= new JTextField();  t3.setBounds(140,100,170,20);	
		t3.setDocument(new LimitJTextField(4));	
		save= new JButton("save"); save.setBounds(140,140,80,20);
		cancel= new JButton("cancel");cancel.setBounds(230,140,80,20);
		c.add(Title); c.add(Author); c.add(Year); c.add(t1); c.add(t2); 
		c.add(t3); c.add(save); c.add(cancel);
		save.addActionListener(this);
		cancel.addActionListener(this);
		setResizable(false);
		setSize(340,230);
		setVisible(true);
			}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==save) {
			if(t1.getText().isEmpty()||t2.getText().isEmpty()||t3.getText().isEmpty()||  t3.getText().length()!=4) {
				JOptionPane.showMessageDialog(this, "pleas fill all fields rightly (name, year(2019 or 2020) , faculty)");
			}
			else {
				String yearr= t3.getText();
				int[] Year = new int[4];
			for (int i = 0; i < 4; i++)
			{
			    Year[i] = yearr.charAt(i) - '0';
			}
			
			if ((Year[1]==9 && Year[0] ==1) || (Year[1]==0 && Year[0] ==2)){
				int year= Integer.parseInt(t3.getText());
				System.out.println(year);
				b.add(i,new Books(t1.getText(),t2.getText(),year));
				JOptionPane.showMessageDialog(this, "The book has been added successfulty");
				i++;
				(LibraryMain.l3).setListData(b.toArray(new Books[b.size()]));
				(UsersInfo.L2).setListData(b.toArray(new Books[b.size()]));
				t1.setText("");t2.setText(""); t3.setText("");
			}
			
		
			else {
				JOptionPane.showMessageDialog(this, "please enter right year");
				}}}
				
		if (e.getSource()==cancel) {
			 setVisible(false);
			}
		}
	
	public static void main(String[] args) {
		new AddBook();
		
	}

		
	}

