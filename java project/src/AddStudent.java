import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class AddStudent extends JFrame implements ActionListener {
	Container c;
	JLabel name, Id, Field;
	JTextField t1,t2,t3;
	JButton save,cancel;
	static ArrayList<Student> s = new ArrayList<>();
	static int si=0;
	public AddStudent() {
		super("AddStudent");
		c=getContentPane(); c.setLayout(null);	
		name= new JLabel("Name: "); name.setBounds(20,20,100,20);
		Id = new JLabel("Id: "); Id.setBounds(20,60,100,20);
		 Field= new JLabel(" Field: ");  Field.setBounds(20,100,100,20);
		t1=new JTextField(); t1.setBounds(140,20,170,20);
		t2= new JTextField();  t2.setBounds(140,60,170,20);
		t2.setDocument(new LimitJTextField(8));
		t3= new JTextField();  t3.setBounds(140,100,170,20);
		save= new JButton("save"); save.setBounds(140,140,80,20);
		cancel= new JButton("cancel");cancel.setBounds(230,140,80,20);
		c.add(name); c.add(Id); c.add( Field); c.add(t1); c.add(t2); 
		c.add(t3); c.add(save); c.add(cancel);
		save.addActionListener(this);
		cancel.addActionListener(this);
		setResizable(false);
		setSize(340,230);
		setVisible(true);
	}
	public static void main(String[] args) {
		new AddStudent();
		

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==save) {
			if(t1.getText().isEmpty()||t2.getText().isEmpty()||t3.getText().isEmpty()||  t2.getText().length()!=8) {
				JOptionPane.showMessageDialog(this, "pleas fill all fields rightly (name, id of 8 number(start with 20), filed)");
			}
			else {
			String ids= t2.getText();
			int[] ID = new int[8];
			for (int i = 0; i < 8; i++)
			{
			    ID[i] = ids.charAt(i) - '0';
			}
			
			if (ID[1]==0 && ID[0] ==2){
				int id= Integer.parseInt(t2.getText());
				System.out.println(id);
				AddProfessor.u.add(AddProfessor.i, new User(t1.getText(),id));
				s.add(si,new  Student(t3.getText(), t1.getText(), id));
				JOptionPane.showMessageDialog(this, "The user has been added successfulty");
				(AddProfessor.i)++;
				si++;
				(LibraryMain.l1).setListData((AddProfessor.u).toArray(new User[(AddProfessor.u).size()]));
				t1.setText("");t2.setText(""); t3.setText("");
		
	}
			else {
				JOptionPane.showMessageDialog(this, "please enter right Id(start with 20)");
			}
			}}
		if (e.getSource()==cancel) {
			 setVisible(false);
			}

}}