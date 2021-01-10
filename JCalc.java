import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JCalc extends JFrame {
	//Furhan Khan fsk2pd
	//Sources:
	//https://docs.oracle.com/javase/7/docs/api/javax/swing/JComboBox.html
	//https://docs.oracle.com/javase/7/docs/api/javax/swing/table/DefaultTableModel.html
	//https://docs.oracle.com/javase/7/docs/api/javax/swing/JFrame.html
	//https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseAdapter.html
	//https://docs.oracle.com/javase/tutorial/uiswing/components/scrollpane.html
	//http://www.java2s.com/Tutorial/Java/0240__Swing/CreatingaJTable.htm
	//Assumptions:
	//All taken courses are assumed to have a grade
	//All courses are inserted with respective credits
	//Assume grades are correctly inputed in as letter grades
	//Assume user puts in double/int value for target value
	//Quick add method adds 5 new 3 credit current course blocks
	JButton addCourse; //fields
	JButton removeCourse;
	JButton quickAdd;
	JButton clearTable;
	JButton getGPA;
	JButton target;
	JLabel currentGPA;
	JLabel nameLabel;
	JLabel hourLabel;
	JLabel gradeLabel;
	JLabel statusLabel;
	JTextField name;
	JTextField hours;
	JTextField grade;
	JTextField targGrade;
	JComboBox<String> status;
	JTable courses;
	JOptionPane panel;
	JFrame frame;
	JScrollPane pane;
	Object[] columns;
	Object[] row;
	DefaultTableModel model;
	int count;
	public static void main(String[] args) {
		new JCalc();
	}
	public JCalc() {
		frame = new JFrame();
		courses = new JTable();
		Object[] columns = {"Course Name","Credit Hours","Grade","Course Status"}; //Column labels  for jtable
		DefaultTableModel model = new DefaultTableModel(); //setting the table to the default model and to later use to refer to.
	    model.setColumnIdentifiers(columns); // setting the labels on the jtable
	    courses.setModel(model); 
		courses.setBackground(Color.orange); //setting background color of rows
	    courses.setForeground(Color.black); //setting text color
	    Font font = new Font("",1,17); //setting font and font size
	    courses.setFont(font);
	    courses.setRowHeight(28); //setting row height of jtable
	    
	    JLabel currentGPA = new JLabel("");
	    JLabel nameLabel = new JLabel("Course Name");
	    JLabel hourLabel = new JLabel("Credit Hours"); //creating new instances of buttons and labels.
	    JLabel gradeLabel = new JLabel("Letter Grade");
	    JLabel statusLabel = new JLabel("Course Status");
	    JButton addCourse = new JButton("Add Course");
        JButton removeCourse = new JButton("Remove Course");
        JButton quickAdd = new JButton("Quick Add");
        JButton clearTable = new JButton("Clear Table");
        JButton getGPA = new JButton("Calculate GPA");
        JButton target = new JButton("Target GPA");
        
	    
	    JTextField name = new JTextField(); //creating new instances of textfields and comboboxes
        JTextField hours = new JTextField();
        JTextField grade = new JTextField();
        JTextField targGrade = new JTextField();
        JComboBox<String> status = new JComboBox<String>();
        status.addItem("Taken");
        status.addItem("Current"); //adding options to combobox
        status.addItem("Anticipated");
        
	    nameLabel.setBounds(130,220,100,25); //setting location for all buttons and labels
	    hourLabel.setBounds(130,250,100,25);
	    gradeLabel.setBounds(130,280,100,25);
	    statusLabel.setBounds(130,310,100,25);
        addCourse.setBounds(240, 220, 100, 25);
        removeCourse.setBounds(240, 310, 125, 25);
        quickAdd.setBounds(240, 265, 100, 25);
        clearTable.setBounds(360,220,100,25);
        getGPA.setBounds(650,220,140,25);
        currentGPA.setBounds(710,250,75,25);
        target.setBounds(650,325,140,25);
	    JScrollPane pane = new JScrollPane(courses); //setting location of scroll bar if used
        pane.setBounds(0, 0, 880, 200);
        
        
        name.setBounds(20, 220, 100, 25);
        hours.setBounds(20, 250, 100, 25); //setting bounds bounds of textfields
        grade.setBounds(20, 280, 100, 25);
        status.setBounds(20, 310, 100, 25);
        targGrade.setBounds(670, 290, 100, 25);
        
        frame.setLayout(null);
        frame.add(pane); //adding scroll bar
        Object[] row = new Object[4]; //creating a row of 4 columns in the jtable
	    
		frame.add(name);
		frame.add(hours);
		frame.add(grade); //adding the text fields to the frame
		frame.add(status);
		frame.add(targGrade);
		
		frame.add(currentGPA); //adding all buttons,labels,table, etc to the frame
		frame.add(addCourse);
		frame.add(removeCourse);
		frame.add(quickAdd);
		frame.add(clearTable);
		frame.add(getGPA);
		frame.add(target);
	    frame.add(pane);
	    frame.add(statusLabel);
	    frame.add(gradeLabel);
	    frame.add(hourLabel);
	    frame.add(nameLabel);
	    
	    frame.setLayout(null); //implementing layout manager
	    frame.setSize(900,400); //setting size of frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close if closed
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); //making all changes visible
	
    addCourse.addActionListener(new ActionListener(){ //adding action listen for add course button

        @Override
        public void actionPerformed(ActionEvent e) {
         
            row[0] = name.getText(); //getting the string text values inserted for each item in the row
            row[1] = hours.getText();
            row[2] = grade.getText();
            row[3] = status.getSelectedItem();
            // add row to the model 
            model.addRow(row); 
        }
    });
    courses.addMouseListener(new MouseAdapter(){ //adding mouse listener for user selecting a row on the table to access it
        
    @Override
    public void mouseClicked(MouseEvent e){
        // i = the index of the selected row
        int item = courses.getSelectedRow(); //getting the row that is selected
        
        name.setText(model.getValueAt(item, 0).toString()); //getting the values for each column in the row
        hours.setText(model.getValueAt(item, 1).toString());
        grade.setText(model.getValueAt(item, 2).toString());
        status.setToolTipText(model.getValueAt(item, 3).toString()); //setting the combo box to whatever was in the column
    }
    }
    );
    removeCourse.addActionListener(new ActionListener(){ //adding action listener for remove course button

        @Override
        public void actionPerformed(ActionEvent e) {
            int item = courses.getSelectedRow(); //getting the items in the row
            if(item >= 0){
                model.removeRow(item); //removing the row if a row is actually selected
            }
            else{
            	   JOptionPane.showMessageDialog(null,"Please Select an item to delete","Notice", JOptionPane.INFORMATION_MESSAGE);;
            } // message dialogue if row is not selected.
        }
    });
    quickAdd.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
        		for(int i = 0; i<5;i++) {
        			row[0] = "";		//setting quick add values
        			row[1] = "3";	// assuming quick add only adds current 
        			row[2] = "";
        			row[3] = "Current";
        			model.addRow(row);
        		}
        }
    });
    clearTable.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
          int x = courses.getRowCount();//getting size of the table
          for (int i = x - 1; i >= 0; i--) { //iterating through the the length of table
        	    model.removeRow(i); //removing the row
          }
        }
    });
    
    getGPA.addActionListener(new ActionListener(){ //action listener for get gpa button

        @Override
        public void actionPerformed(ActionEvent e) {
        		int x = courses.getRowCount();
        		if(x == 0) {
        			
        			currentGPA.setText("N/A"); //if no courses set gpa label as it not available
        		}
        		int creditCount = 0;
            	double y = 0;
            	for (int i = x - 1; i >= 0; i--) { //iterating for each row in the jtable
            		String credits = model.getValueAt(i, 1).toString(); //getting credits assuming user puts in a value for credits no matter what
                	int credits1 = Integer.valueOf(credits); //converting string retrieved into an integer value
           		String classGrade = model.getValueAt(i, 2).toString(); //getting grades assuming user puts in a letter grade
           		double classGrade1 = gradeCalc1(classGrade); //converting them into double value using gpa conversion formula created
            		if(classGrade1<4.5) { //if grade is not added still add credits to the to the counter
            			creditCount+=credits1;
                		y+= classGrade1 * credits1;
            		}
            	}
            	double gpa = y/creditCount; //calculated final gpa
            	String gpa1 = String.format("%.3f", gpa); //formating the double value into a string of 3 decimal places
            currentGPA.setText(gpa1); //setting new label 
            if(gpa1.equals("NaN")) {
            		currentGPA.setText("N/A"); //if no grades are entered/gpa is inapplicable
            }
        }
	});
    target.addActionListener(new ActionListener(){

        @Override
        public  void actionPerformed(ActionEvent e) {
        		int x = courses.getRowCount();
        		int creditCount = 0;
        		double y = 0;
        		count = 0;
        		for (int i = x - 1; i >= 0; i--) {
        			String credits = model.getValueAt(i, 1).toString(); //getting gpa with the same previously used gpa function
            		int credits1 = Integer.valueOf(credits);
            		String classGrade = model.getValueAt(i, 2).toString();
       			double classGrade1 = gradeCalc1(classGrade);
        			if(classGrade1<4.5) {
        				creditCount+=credits1;
            			y+= classGrade1 * credits1;
        			}
        			if(model.getValueAt(i, 3).toString().equals("Current") || model.getValueAt(i, 3).toString().equals("Anticipated")) {
            			String credit = model.getValueAt(i, 1).toString(); //adding empty course block credits even if they have no grade
           			int credit1 = Integer.valueOf(credit);
           			count+= credit1;
            		}
        		}
        		double gpa = y/creditCount;
        		String target = targGrade.getText();
        		if(target.length()>0) { //if target gpa is inputted
        			System.out.print(count);
        			double targetInt = Double.valueOf(target); //assume user can only input int/double value for target gpa
        			double tg = ((targetInt*(count+creditCount))-(gpa*creditCount))/(count);
        			String g = String.format("%.3f", tg);
        			if (tg>4) { // returning message logs for different scenarios
        				JOptionPane.showMessageDialog(null, "Necessary GPA greater than 4.0\nTry adding more credits", "Target Gpa", JOptionPane.INFORMATION_MESSAGE); //if target gpa is greater than 4
        			}
        			else if(tg<2) {
        				JOptionPane.showMessageDialog(null,"Required GPA less than 2.0\nYou can take fewer credits if you wish" , "Target Gpa", JOptionPane.INFORMATION_MESSAGE); //if target gpa is less than 2.0
        			}
        			else if(g.equals("NaN")) {
        				if(count > 0 || creditCount>0) {
        					JOptionPane.showMessageDialog(null,"Required GPA: " + target, "Target Gpa", JOptionPane.INFORMATION_MESSAGE); //if only empty course blocks are inputed
        				}
        				else {
        					JOptionPane.showMessageDialog(null, "Add more courses with grades/credits to calculate\n target GPA", "Error", JOptionPane.ERROR_MESSAGE); // if no course blocks are inputted
        				}
        			}
        			else {
        				JOptionPane.showMessageDialog(null,"Required GPA: " + g, "Target Gpa", JOptionPane.INFORMATION_MESSAGE); //calculated target gpa
        			}
        		}
        		else{
        			JOptionPane.showMessageDialog(null, "Please Enter a Target GPA", "Error", JOptionPane.ERROR_MESSAGE); // if no target gpa is entered
        		}

        }
	});
	}
	// Algorithm for converting letter grades into doubles
	protected double gradeCalc1(String s) {
		if(s.equalsIgnoreCase("A")) {
			return 4.0;
		}
		else if(s.equalsIgnoreCase("A-")) { //ignoring case in the off chance user inputs lowercase letter
			return 3.7;
		}
		else if(s.equalsIgnoreCase("B+")) {
			return 3.3;
		}
		else if(s.equalsIgnoreCase("B")) {
			return 3.0;
		}
		else if(s.equalsIgnoreCase("B-")) {
			return 2.7;
		}
		else if(s.equalsIgnoreCase("C+")) {
			return 2.3;
		}
		else if(s.equalsIgnoreCase("C")) {
			return 2.0;
		}
		else if(s.equalsIgnoreCase("C-")) {
			return 1.7;
		}
		else if(s.equalsIgnoreCase("D+")) {
			return 1.3;
		}
		else if(s.equalsIgnoreCase("D")) {
			return 1.0;
		}
		else if(s.equalsIgnoreCase("D-")) {
			return .7;
		}
		else if(s.equalsIgnoreCase("F")){
			return 0.0;
		}
		else {
			return 5.0;
		}
	}
}
