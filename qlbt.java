import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.table.TableModel;
import javax.swing.JFormattedTextField;
import javax.swing.JDesktopPane;

public class QLBH extends JFrame implements ActionListener,MouseListener{
	Connection conn;
	Statement stm;
	ResultSet rst;
	
	String country[] = {"Apple", "Samsung", "Sony", "HTC", "HMD","Mi","Google"};
	Vector vData = new Vector();
	Vector vTitle = new Vector();
	DefaultTableModel model;
	JTable tb = new JTable();
	
	int selectedrow=0;
	JButton btnBn;
	private JPanel contentPane;
	private JTextField txtmasp;
	private JTextField txttensp;
	private JTextField txtgianhap;
	private JTextField txtgiaban;
	private JTextField txtkho;
	private JTextField txttimkiem;
	private JTable table;
	JComboBox cbohangsx;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLBH frame = new QLBH();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public QLBH() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlbh","root","");
			stm = conn.createStatement();
			
			reload();
			model = new DefaultTableModel(vData,vTitle);
			model.fireTableDataChanged();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable(model);
		table.setBounds(55, 43, 869, 235);
		contentPane.add(table);
		table.addMouseListener(this);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 s\u1EA3n ph\u1EA9m");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(30, 305, 87, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnSnPhm = new JLabel("T\u00EAn s\u1EA3n ph\u1EA9m");
		lblTnSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnSnPhm.setBounds(30, 345, 87, 27);
		contentPane.add(lblTnSnPhm);
		
		JLabel lblHngSnXut = new JLabel("H\u00E3ng s\u1EA3n xu\u1EA5t");
		lblHngSnXut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHngSnXut.setBounds(30, 388, 103, 27);
		contentPane.add(lblHngSnXut);
		
		JLabel lblGiNhp = new JLabel("Gi\u00E1 nh\u1EADp");
		lblGiNhp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiNhp.setBounds(30, 428, 87, 27);
		contentPane.add(lblGiNhp);
		
		JLabel lblGiBn = new JLabel("Gi\u00E1 b\u00E1n");
		lblGiBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiBn.setBounds(30, 468, 87, 27);
		contentPane.add(lblGiBn);
		
		JLabel txttonkho = new JLabel("T\u1ED3n kho");
		txttonkho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txttonkho.setBounds(30, 508, 87, 27);
		contentPane.add(txttonkho);
		
		txtmasp = new JTextField();
		txtmasp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtmasp.setEditable(false);
		txtmasp.setBounds(156, 308, 160, 27);
		contentPane.add(txtmasp);
		txtmasp.setColumns(10);
		
		txttensp = new JTextField();
		txttensp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txttensp.setBounds(156, 348, 160, 27);
		contentPane.add(txttensp);
		txttensp.setColumns(10);
		
		cbohangsx = new JComboBox(country);
		cbohangsx.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbohangsx.setBounds(156, 391, 160, 27);
		contentPane.add(cbohangsx);
		
		txtgianhap = new JTextField();
		txtgianhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtgianhap.setBounds(156, 431, 160, 27);
		contentPane.add(txtgianhap);
		txtgianhap.setColumns(10);
		
		txtgiaban = new JTextField();
		txtgiaban.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtgiaban.setBounds(156, 473, 160, 27);
		contentPane.add(txtgiaban);
		txtgiaban.setColumns(10);
		
		txtkho = new JTextField();
		txtkho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtkho.setBounds(156, 513, 160, 27);
		contentPane.add(txtkho);
		txtkho.setColumns(10);
		
		JButton btthem = new JButton("Th\u00EAm");
		btthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String masp = txtmasp.getText();
				Vector temp= (Vector) vData.lastElement();
				masp= temp.elementAt(0).toString();
				masp= String.valueOf(Integer.parseInt(masp)+1);
				String tensp= txttensp.getText();
				String hangsx = cbohangsx.getSelectedItem().toString();
				String gianhap = txtgianhap.getText();
				String giaban = txtgiaban.getText();
				String tonkho = txtkho.getText();
				try {
					String sql="Insert into qlbh values (\""+ masp +"\",\""+ tensp +"\",\""+hangsx+"\",\""+gianhap+"\",\""+giaban+"\",\""+tonkho+"\")";
					stm.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Đã thêm thành công");
					reload();
					model.fireTableDataChanged();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		});
		btthem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btthem.setBounds(398, 345, 100, 40);
		contentPane.add(btthem);
		
		JButton btsua = new JButton("S\u1EEDa");
		btsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String masp = txtmasp.getText();
				String tensp= txttensp.getText();
				String hangsx = cbohangsx.getSelectedItem().toString();
				String gianhap = txtgianhap.getText();
				String giaban = txtgiaban.getText();
				String tonkho = txtkho.getText();
				try {
					String sql="Update qlbh set MaSP= \""+ masp +"\",TenSP=\""+tensp+"\",HangSX=\""+hangsx+"\",GiaNhap=\""+gianhap+"\",GiaBan=\""+giaban+"\",TonKho=\""+tonkho+"\" where MaSP=\""+masp+"\"";
					stm.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Đã sửa thành công");
					reload();
					model.fireTableDataChanged();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

				
			}
		});
		btsua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btsua.setBounds(398, 404, 100, 40);
		contentPane.add(btsua);
		
		JButton btxoa = new JButton("X\u00F3a");
		btxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String masp = txtmasp.getText();
				try {
					String sql="Delete from qlbh where MaSP=\""+masp+"\"";
					stm.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Đã xóa thành công");
					reload();
					model.fireTableDataChanged();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		btxoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btxoa.setBounds(398, 461, 100, 40);
		contentPane.add(btxoa);
		
		JLabel lblTmKim = new JLabel("T\u00ECm ki\u1EBFm");
		lblTmKim.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTmKim.setBounds(731, 322, 87, 27);
		contentPane.add(lblTmKim);
		
		txttimkiem = new JTextField();
		txttimkiem.setText("Nh\u1EADp m\u00E3 ho\u1EB7c t\u00EAn s\u1EA3n ph\u1EA9m");
		txttimkiem.setBounds(644, 365, 255, 34);
		contentPane.add(txttimkiem);
		txttimkiem.setColumns(10);
		
		JButton bttimkiem = new JButton("T\u00ECm ki\u1EBFm");
		bttimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchReload();
				model.fireTableDataChanged();
			}
		});
		bttimkiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bttimkiem.setBounds(721, 412, 97, 40);
		contentPane.add(bttimkiem);
		
		JButton btnNewButton = new JButton("Thống Kê");
		btnNewButton.setBounds(709, 482, 120, 35);
		contentPane.add(btnNewButton);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(249, 100, 1, 1);
		contentPane.add(desktopPane);
		
		btnBn = new JButton("Bán");
		btnBn.setVisible(false);
		btnBn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				String ten=JOptionPane.showInputDialog("Nhập tên người mua");
				String sdt=JOptionPane.showInputDialog("Nhập số điện thoại");
				String dc=JOptionPane.showInputDialog("Nhập địa chỉ");
				String sql="Insert into thongke values (\""+ ten +"\",\""+sdt+"\",\""+dc+"\",\""+txttensp.getText()+"\",\""+txtgiaban.getText()+"\")";
				String sql1="Update qlbh set TonKho=\""+String.valueOf(Integer.parseInt(txtkho.getText())-1)+"\" where TenSP=\""+txttensp.getText()+"\"";
				//JOptionPane.showMessageDialog(null, txtkho.getText());
				try {
					stm.executeUpdate(sql);
					stm.executeUpdate(sql1);
					reload();
					model.fireTableDataChanged();
					JOptionPane.showMessageDialog(null,"Đã bán");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnBn.setBounds(401, 510, 97, 25);
		contentPane.add(btnBn);
	}
	private void searchReload() {
		try
		{
			vTitle.clear();
			vData.clear();
			ResultSet rst = stm.executeQuery("SELECT * FROM qlbh where TenSP like \'%"+txttimkiem.getText()+"%\'");
			ResultSetMetaData rstmeta = rst.getMetaData();
			int num_column = rstmeta.getColumnCount();
			for(int i=1;i<=num_column;i++)
			{
				vTitle.add(rstmeta.getColumnLabel(i));
			}
			while(rst.next())
			{
				Vector row = new Vector(num_column);
				for(int i=1;i<=num_column;i++)
					row.add(rst.getString(i));
				vData.add(row);
			}
			rst.close();
		}
		
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	private void reload() {
		// TODO Auto-generated method stub
		try
		{
			vTitle.clear();
			vData.clear();
			
			ResultSet rst = stm.executeQuery("Select * from qlbh");
			ResultSetMetaData rstmeta = rst.getMetaData();
			int num_column = rstmeta.getColumnCount();
			vTitle = new Vector(num_column);
			for(int i=1;i<=num_column;i++)
			{
				
				vTitle.add(rstmeta.getColumnLabel(i));
			}
			vData = new Vector(10,10);
			while (rst.next())
			{
				Vector row = new Vector(num_column);
				for (int i=1;i<=num_column;i++)
					row.add(rst.getString(i));
				vData.add(row);
			}
			rst.close();
//			JOptionPane.showMessageDialog(null, vData.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		selectedrow = table.getSelectedRow();
		Vector tam = (Vector) vData.get(selectedrow);
		btnBn.setVisible(true);
		txtmasp.setText(tam.elementAt(0).toString());
		txttensp.setText(tam.elementAt(1).toString());
		int i;
		for(i=0;i<country.length;i++) {
			if(tam.elementAt(2).equals(country[i]))
				break;
		}
		cbohangsx.setSelectedIndex(i);
		txtgianhap.setText(tam.elementAt(3).toString());
		txtgiaban.setText(tam.elementAt(4).toString());
		txtkho.setText(tam.elementAt(5).toString());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
