import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public class LibraryMain extends JFrame implements ActionListener{
	Container c;
	JButton prof, std,delete, save,book;
	JLabel user, borrow, available;
	JScrollPane s1,s2,s3;
	static JList<Books> l3= new JList<>();
	static JList<User> l1= new JList<>();
	static JList<Borrowed> l2= new JList();	
	static int i=0;
	static ArrayList<Borrowed> borr = new ArrayList<>(100);
	static ArrayList<Borrowed> idbol = new ArrayList<>(100);
	public LibraryMain() {
		super("Library App");
		prof= new JButton("Add prof.");
		prof.addActionListener(this);
		std=new JButton ("Add std.");
		std.addActionListener(this);
		delete=new JButton("Delete user");
		save= new JButton("Save Data to file");
		book= new JButton("Add new Book");
		book.addActionListener(this);
		user= new JLabel("All Users");
		borrow= new JLabel("All borrowed Books");
		available= new JLabel("Available Books");
		delete.addActionListener(this);
		s1= new JScrollPane(l1); 
		s2= new JScrollPane(l2); s3= new JScrollPane(l3);
		c=getContentPane(); c.setLayout(null);
		prof.setBounds(20,10,90,20); std.setBounds(120,10,90,20);
		save.setBounds(230,10,190,20); book.setBounds(440,10,190,20);
		delete.setBounds(20,40,190,20); user.setBounds(20,80,190,20);
		borrow.setBounds(230,80,190,20); available.setBounds(440,80,190,20);
		s1.setBounds(20,110,190,220); s2.setBounds(230,110,190,220); s3.setBounds(440,110,190,220); 
		c.add(prof); c.add(std); c.add(save); c.add(book); c.add(delete); 
		c.add(user); c.add(borrow); c.add(available); c.add(s2); c.add(s1); c.add(s3);
		setResizable(false);
		setBounds(200,300, 680,400);
		setVisible(true);
		
		l1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList l1 = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		            int getIndex = l1.locationToIndex(evt.getPoint());
					 for(Student o : AddStudent.s){
						 int idd= AddProfessor.u.get(getIndex).id;
							if (o.id==idd) {
								UsersInfo.t1.setText(AddProfessor.u.get(getIndex).name);
								UsersInfo.t2.setText("Student");
								UsersInfo.t3.setText(""+AddProfessor.u.get(getIndex).id);
								UsersInfo.t4.setText(o.field);
								UsersInfo.L2.setListData(AddBook.b.toArray(new Books[AddBook.b.size()]));
								new UsersInfo();
								idbol=new ArrayList<>(100);
								int q=0;
								for(Borrowed w : borr){
									if (w.id==idd) {
										idbol.add(q,w);
										q++;
				}
									else
										continue;
							 }
								UsersInfo.L1.setListData(idbol.toArray(new Borrowed[idbol.size()]));
								}
							else {
									continue;}
							
					 }
					 
					for( Proffesor x : AddProfessor.p){
						 int idf= AddProfessor.u.get(getIndex).id;
						if (x.id==idf) {
							UsersInfo.t1.setText(AddProfessor.u.get(getIndex).name);
							UsersInfo.t2.setText("proffesor");
							UsersInfo.t3.setText(""+AddProfessor.u.get(getIndex).id);
							UsersInfo.t4.setText(x.faculty);
							UsersInfo.L2.setListData(AddBook.b.toArray(new Books[AddBook.b.size()]));
							new UsersInfo();
							idbol=new ArrayList<>(100);
							int q=0;
							for(Borrowed w : borr){
								System.out.println(w.id);
								if (w.id==idf) {
									idbol.add(q,w);
									q++;
									}
								else
									continue;
						 }
							UsersInfo.L1.setListData(idbol.toArray(new Borrowed[idbol.size()]));
						}
					else {
							continue;}
					
			 }   
		        } 
		    }
		});
		
		}
	 
	 public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==prof) 
			 new AddProfessor();
		 
		
		 else if(e.getSource()==std)
			 new AddStudent();
		 else if(e.getSource()==book)
			 new AddBook(); 	
			 
	 	else if (e.getSource()==delete) {
		 if (l1.getSelectedIndex()==-1) {
			 JOptionPane.showMessageDialog(this, "you havent choosen a user");
		 }
		 else {
			 int getindex=l1.getSelectedIndex();
			 int idd= AddProfessor.u.get(getindex).id;
			  for (Iterator<Proffesor> iterator = AddProfessor.p.iterator(); iterator.hasNext(); ) {
				    Proffesor value = iterator.next();
				    if (value.id==idd) {
				        iterator.remove();
				        AddProfessor.pi= AddProfessor.pi-1;
				    }
				}
			 for (Iterator<Student> iterator = AddStudent.s.iterator(); iterator.hasNext(); ) {
				    Student value = iterator.next();
				    if (value.id==idd) {
				        iterator.remove();
						AddStudent.si= AddStudent.si-1;
				    }
				}
			 for (Iterator<Borrowed> iterator = borr.iterator(); iterator.hasNext(); ) {
				    Borrowed value = iterator.next();
				    if (value.id==idd) {
				    	 AddBook.b.add(new Books(value.Title ,value.Author,value.year));
				    	 AddBook.i=AddBook.i+1;
				         iterator.remove();
				         LibraryMain.i=LibraryMain.i-1;
				    }
				}
			 for (Iterator<User> iterator = AddProfessor.u.iterator(); iterator.hasNext(); ) {
				    User value = iterator.next();
				    if (value.id==idd) {
				        iterator.remove();
				        AddProfessor.i= AddProfessor.i-1;
				    }
				}
 
			 l2.setListData(borr.toArray(new Borrowed[borr.size()]));
			 l3.setListData(AddBook.b.toArray(new Books[AddBook.b.size()]));
			 l1.setListData(AddProfessor.u.toArray(new User[AddProfessor.u.size()]));
			
			}}}
	public static void main(String [] args) {	
		new LibraryMain();	
	}
		 }	 
//mainly



