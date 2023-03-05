import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class AddProfessor extends JFrame implements ActionListener {
	Container c;
	JLabel name, Id, Faculty;
	JTextField t1,t2,t3;
	JButton save,cancel;
	static int i=0;
	static int pi=0;
	static ArrayList<User> u = new ArrayList<>(100);
	static ArrayList<Proffesor> p = new ArrayList<>();
	public AddProfessor() {
		super("Add Professor");
		c=getContentPane(); c.setLayout(null);	
		name= new JLabel("Name: "); name.setBounds(20,20,100,20);
		Id = new JLabel("Id: "); Id.setBounds(20,60,100,20);
		Faculty= new JLabel("Faculty: "); Faculty.setBounds(20,100,100,20);
		t1=new JTextField(); t1.setBounds(140,20,170,20);
		t2= new JTextField();  t2.setBounds(140,60,170,20);
		t2.setDocument(new LimitJTextField(9));
		t3= new JTextField();  t3.setBounds(140,100,170,20);
		save= new JButton("save"); save.setBounds(140,140,80,20);
		cancel= new JButton("cancel");cancel.setBounds(230,140,80,20);
		c.add(name); c.add(Id); c.add(Faculty); c.add(t1); c.add(t2); 
		c.add(t3); c.add(save); c.add(cancel);
		save.addActionListener(this);
		cancel.addActionListener(this);
		setResizable(false);
		setSize(340,230);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		
		new AddProfessor();
		

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==save) {
			if(t1.getText().isEmpty()||t2.getText().isEmpty()||t3.getText().isEmpty()||  t2.getText().length()!=9) {
				JOptionPane.showMessageDialog(this, "pleas fill all fields rightly (name, id of 9 number (start with 00), faculty)");
			}
			else {
			String ids= t2.getText();
			int[] ID = new int[9];
			for (int i = 0; i < 9; i++)
			{
			    ID[i] = ids.charAt(i) - '0';
				
			}
			
			if (ID[1]==0 && ID[0] ==0) {
			int id= Integer.parseInt(t2.getText());
			System.out.println(id);
			u.add(i,new User(t1.getText(),id));
			p.add(pi,new  Proffesor(t3.getText(), t1.getText(), id));
			JOptionPane.showMessageDialog(this, "The user has been added successfulty");
			pi++;
			i++;
		   (LibraryMain.l1).setListData(u.toArray(new User[u.size()]));
			t1.setText("");t2.setText(""); t3.setText("");
		
	}
			else {
				JOptionPane.showMessageDialog(this, "please enter right ID(start with 00)");
			}
			}}
		if (e.getSource()==cancel) {
		 setVisible(false);
		}
	}}
