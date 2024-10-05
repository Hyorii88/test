package project;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Quanlysinhvien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Namefield;
	private JTextField IDField;
	private JTextField Addfield;
	private JTable table;
	private JTextField GPAField;
	private JTextField MJField;
	private JTextField timkiem;
	
	public Quanlysinhvien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Student hocsinh=new Student();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Name = new JLabel("Name:");
		Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Name.setBounds(32, 11, 46, 14);
		contentPane.add(Name);
		
		Namefield = new JTextField();
		Namefield.setBounds(76, 10, 86, 20);
		contentPane.add(Namefield);
		Namefield.setColumns(10);
		
		JLabel IDsearch = new JLabel("ID:");
		IDsearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IDsearch.setBounds(216, 13, 19, 14);
		contentPane.add(IDsearch);
		
		IDField = new JTextField();
		IDField.setBounds(239, 10, 86, 20);
		contentPane.add(IDField);
		IDField.setColumns(10);
		
		JLabel Address = new JLabel("Address:");
		Address.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Address.setBounds(355, 13, 58, 14);
		contentPane.add(Address);
		
		Addfield = new JTextField();
		Addfield.setBounds(409, 10, 86, 20);
		contentPane.add(Addfield);
		Addfield.setColumns(10);
		
		
		JButton AddButton = new JButton("Add");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Namefield.getText().equals("") || IDField.getText().equals("")||Addfield.getText().equals("")||GPAField.getText().equals("")||MJField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(AddButton, "Xin hay nhap du thong tin");
				}
				else
				{
					hocsinh.setName(Namefield.getText());
					hocsinh.setId(Integer.parseInt(IDField.getText()));
					hocsinh.setGpa(Integer.parseInt(GPAField.getText()));
					hocsinh.setAddress(Addfield.getText());
					
					String StudentName=hocsinh.getName();
					String StudentID=Integer.toString(hocsinh.getId());
					String StudentAddress =hocsinh.getAddress();
					String StudentGPA = Float.toString(hocsinh.getGpa());
					
					String[] data = {"Bang","DEp","trai"};
					DefaultTableModel sample = (DefaultTableModel)table.getModel();
					sample.addRow(data);
					sample.addRow(data);
					JOptionPane.showMessageDialog(AddButton, "Da them thong tin");
					
				}
			}
			
			
			
			
			
			
		});
		AddButton.setBounds(545, 46, 89, 23);
		contentPane.add(AddButton);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{DefaultTableModel s =(DefaultTableModel)table.getModel();
				String updateName =s.getValueAt(table.getSelectedRow(), 0).toString();
				String updateID =s.getValueAt(table.getSelectedRow(), 1).toString();
				String updateAddress =s.getValueAt(table.getSelectedRow(), 2).toString();
				String updateGPA =s.getValueAt(table.getSelectedRow(), 3).toString();
				String updateMajor =s.getValueAt(table.getSelectedRow(), 4).toString();
				
				Namefield.setText(updateName);
				IDField.setText(updateID);
				Addfield.setText(updateAddress);
				GPAField.setText(updateGPA);
				MJField.setText(updateMajor);
				}
				catch(Exception ex)
				{
					
				};
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setBounds(57, 175, 592, 117);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("GPA:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(32, 64, 46, 14);
		contentPane.add(lblNewLabel);
		
		GPAField = new JTextField();
		GPAField.setBounds(76, 61, 86, 20);
		contentPane.add(GPAField);
		GPAField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Major:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(196, 64, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		MJField = new JTextField();
		MJField.setBounds(239, 61, 86, 20);
		contentPane.add(MJField);
		MJField.setColumns(10);
		
		JButton DeleteButton = new JButton("Delete");
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel s = (DefaultTableModel)table.getModel();
				if (table.getSelectedRowCount()==1)
				{
					s.removeRow(table.getSelectedRow());
				}
				else
				{
					if (table.getSelectedRowCount()==0)
					{
						JOptionPane.showMessageDialog(DeleteButton, "Xin hay chon dong de xoa");
					}
					else
					{
						JOptionPane.showMessageDialog(DeleteButton, "Xin chi chon mot dong");
					}
				}
				
				}
		});
		DeleteButton.setBounds(545, 80, 89, 20);
		contentPane.add(DeleteButton);
		
		JButton UpdateButton = new JButton("Update");
		UpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel s = (DefaultTableModel)table.getModel();
				if (table.getSelectedRowCount()==1)
				{
					String name = Namefield.getText();
					String ID 	= IDField.getText();
					String Address = Addfield.getText();
					String GPA = GPAField.getText();
					String Major = MJField.getText();
					
					s.setValueAt(name, table.getSelectedRow(), 0);
					s.setValueAt(ID, table.getSelectedRow(), 1);
					s.setValueAt(Address, table.getSelectedRow(), 2);
					s.setValueAt(GPA, table.getSelectedRow(), 3);
					s.setValueAt(Major, table.getSelectedRow(), 4);
					
					JOptionPane.showMessageDialog(UpdateButton,"Da cap nhat thanh cong");
				}
				else
				{
					if (table.getSelectedRowCount()==0)
					{
						JOptionPane.showMessageDialog(DeleteButton, "Xin chon mot dong de cap nhat");
					}
					else
					{
						JOptionPane.showMessageDialog(DeleteButton, "Xin chi chon mot dong de cap nhat");
					}
				}
				
				}
			
		});
		UpdateButton.setBounds(545, 111, 89, 23);
		contentPane.add(UpdateButton);
		
		JButton SearchButton = new JButton("Search");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel se =(DefaultTableModel)table.getModel();
				TableRowSorter<DefaultTableModel> obj =new TableRowSorter<>(se);
				table.setRowSorter(obj);
				obj.setRowFilter(RowFilter.regexFilter(timkiem.getText()));
			}
		});
		SearchButton.setBounds(545, 9, 89, 23);
		contentPane.add(SearchButton);
		
		timkiem = new JTextField();
		timkiem.setBounds(657, 10, 104, 20);
		contentPane.add(timkiem);
		timkiem.setColumns(10);
		
		JButton ImportButton = new JButton("Import File");
		ImportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filepath = "C:\\Users\\bangd\\Desktop\\data.txt";
				File file = new File(filepath);
				
				 try {
			            BufferedReader br = new BufferedReader(new FileReader(file));
			            String firstLine = br.readLine().trim();
			            String[] columnsName = firstLine.split(",");
			            DefaultTableModel model = (DefaultTableModel)table.getModel();
			            model.setColumnIdentifiers(columnsName);
			            
			            Object[] tableLines = br.lines().toArray();
			            
			        
			            for(int i = 0; i < tableLines.length; i++)
			            {
			                String line = tableLines[i].toString().trim();
			                String[] dataRow = line.split("/");
			                model.addRow(dataRow);
			            }
			            
			            
			        } catch (Exception ex) {
			 
			        }
			    } 
				
			
				
		
			
		});
		ImportButton.setBounds(144, 122, 181, 23);
		contentPane.add(ImportButton);
		
		JButton btnNewButton = new JButton("Export");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("C:\\Users\\bangd\\Desktop\\data.txt");
					FileWriter fw =new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					for (int i=0; i<table.getRowCount();i++)
					{
						for (int j=0; j<table.getColumnCount();j++)
						{
							bw.write((String)table.getModel().getValueAt(i, j)+" ");
							if (j==table.getColumnCount()-1)
							{
								bw.write("\n");
								continue;
							}
							bw.write("/");
						}
					}
					bw.close();
					fw.close();
					
				}catch(Exception ex)
				{}
				
			}
		});
		btnNewButton.setBounds(246, 333, 144, 23);
		contentPane.add(btnNewButton);
	}
}