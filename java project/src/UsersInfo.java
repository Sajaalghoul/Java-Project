import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class UsersInfo extends JFrame implements ActionListener  {
		Container c;
		JLabel l1,l2,l3, l4,l5,l6,l7;
		JScrollPane s1,s2;
		static JList<Borrowed> L1=new JList<>();
		static JList<Books> L2=new JList<>();
		JButton B1,B2;
		static JTextField t1=new JTextField();
		static JTextField t2=new JTextField();
		static JTextField t3=new JTextField();
		static JTextField t4=new JTextField();
		JPanel p1;
		public UsersInfo() {
			super("Users Information");
			t1.setEditable(false);t2.setEditable(false);t3.setEditable(false);t4.setEditable(false);
			c=getContentPane(); c.setLayout(null);
			p1=new JPanel(); p1.setLayout(null);  p1.setBackground(Color.gray);
			l1= new JLabel("Name: "); l1.setBounds(20,20,100,20);
			l2 = new JLabel("Jop: "); l2.setBounds(20,60,100,20);
			l3= new JLabel(" ID: "); l3.setBounds(20,100,100,20);
			l4= new JLabel(" Field: "); l4.setBounds(20,140,100,20);
			t1.setBounds(140,20,170,20); t2.setBounds(140,60,170,20); t3.setBounds(140,100,170,20); t4.setBounds(140,140,170,20);
			p1.add(l1); p1.add(l2); p1.add(l3); p1.add(l4);
			p1.add(t1); p1.add(t2); p1.add(t3);p1.add(t4);
			l5=new JLabel(" Selected Users Info"); l6=new JLabel("Users book");
			l7= new JLabel("Available Books");
			l5.setBounds(20,20,310,20); p1.setBounds(20,45,350,170);
			l6.setBounds(390,20,170,20); l7.setBounds(580,20,170,20);
			s1= new JScrollPane(L1); s2=new JScrollPane(L2);
			B1=new JButton("Return Book");  B2=new JButton("Borrow Book");
			B1.addActionListener(this);
			B2.addActionListener(this);
			s1.setBounds(390,45,170,145); s2.setBounds(580,45,170,145); 
			B1.setBounds(390,190,170,25); B2.setBounds(580,190,170,25);
			c.add(p1); c.add(l5); c.add(l6); c.add(l7); c.add(s1);
			c.add(s2); c.add(B1); c.add(B2);
			setResizable(false);
			setSize(800,300);
			setVisible(true);
		}
		public static void main(String[] args) {
		 new UsersInfo();

	}
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==B2) {
				int idd= Integer.parseInt(t3.getText());
				if (L2.getSelectedIndex()==-1) {
					JOptionPane.showMessageDialog(this, "you havent choosen a book");			}
				else {
				int getindex=L2.getSelectedIndex();
				LibraryMain.borr.add(LibraryMain.i,new Borrowed(idd,AddBook.b.get(getindex).Title,AddBook.b.get(getindex).Author,AddBook.b.get(getindex).year));
				(LibraryMain.i)++;
				AddBook.b.remove(getindex);
				if (AddBook.i!=0)
					AddBook.i=AddBook.i-1;
				(LibraryMain.l3).setListData(AddBook.b.toArray(new Books[AddBook.b.size()]));
				L2.setListData(AddBook.b.toArray(new Books[AddBook.b.size()]));
				(LibraryMain.l2).setListData(LibraryMain.borr.toArray(new Borrowed[LibraryMain.borr.size()]));
				Borrowed[] idbo = new Borrowed[100]; int y=0;
				LibraryMain.idbol = new ArrayList<>(100);
				for(Borrowed w : LibraryMain.borr){
					if (w.id==idd) {
						idbo[y]=w;
						LibraryMain.idbol.add(y,w);
						y++;
						L1.setListData(idbo);
						}
					else
						continue;
			 }
				
			}}
			if(e.getSource()==B1) {
				if (L1.getSelectedIndex()==-1) {
					JOptionPane.showMessageDialog(this, "you havent choosen a book");
					}
				else {
				int getindex=L1.getSelectedIndex();
				int idd= Integer.parseInt(t3.getText());
				AddBook.b.add(new Books(LibraryMain.idbol.get(getindex).Title ,LibraryMain.idbol.get(getindex).Author,LibraryMain.idbol.get(getindex).year));
				for(Borrowed s : (LibraryMain.borr)){
					if (s.year==LibraryMain.idbol.get(getindex).year) {
						LibraryMain.borr.remove(s);
						LibraryMain.i=LibraryMain.i-1;
						break;
					}
					else
						continue;
			 }	
				LibraryMain.idbol.remove(getindex);
				L2.setListData(AddBook.b.toArray(new Books[AddBook.b.size()]));
				(LibraryMain.l2).setListData(LibraryMain.borr.toArray(new Borrowed[LibraryMain.borr.size()]));
				(LibraryMain.l3).setListData(AddBook.b.toArray(new Books[AddBook.b.size()]));
				Borrowed[] idboo = new Borrowed[100]; int y=0;
				for(Borrowed g : LibraryMain.borr){
					if (g.id==idd) {
						idboo[y]=g;
						y++;
						
						}
					
					else
						continue;
			 }
				L1.setListData(idboo);
		}	}
		
				
			
		}

}
//mainly
