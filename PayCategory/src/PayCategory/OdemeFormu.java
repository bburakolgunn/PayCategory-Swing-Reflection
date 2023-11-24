package PayCategory;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class OdemeFormu {

	private JFrame frame;
	private JTextField txtTutar;
	private String secilenOdemeTipi;
	private JLabel lblSonuc;
	private IOdemeTipi iOdemeTipi;
	private OdemeIslemiFactory factory;
	private int id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OdemeFormu window = new OdemeFormu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OdemeFormu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOdemeTipi = new JLabel("Ödeme Tipi : ");
		lblOdemeTipi.setBounds(70, 89, 146, 14);
		frame.getContentPane().add(lblOdemeTipi);
		
		JComboBox cmbOdemeTipleri = new JComboBox();
		cmbOdemeTipleri.setModel(new DefaultComboBoxModel(new String[] {"Seçiniz", "KrediKarti", "MailOrder", "SMSOdeme", "ApplePay"}));
		cmbOdemeTipleri.setBounds(289, 85, 130, 22);
		frame.getContentPane().add(cmbOdemeTipleri);
		
		JLabel lblTutar = new JLabel("Tutar : ");
		lblTutar.setBounds(70, 160, 46, 14);
		frame.getContentPane().add(lblTutar);
		
		txtTutar = new JTextField();
		txtTutar.setBounds(289, 155, 130, 20);
		frame.getContentPane().add(txtTutar);
		txtTutar.setColumns(10);
		
		JButton btnOdemeYap = new JButton("Ödeme Yap");
		btnOdemeYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
					String db = "jdbc:postgresql://localhost:5432/Payment";
				
					Connection conn = DriverManager.getConnection(db, "postgres", "654123");
					PreparedStatement prStmt = conn.
					prepareStatement("insert into paymentsystem(id,payments,price) values(?,?,?)");
					prStmt.setInt(1,id);
					prStmt.setString(2, toString().valueOf(cmbOdemeTipleri.getSelectedItem().toString()));
					prStmt.setString(3,txtTutar.getText());
					
					int OdemeSayisi = prStmt.executeUpdate();
					if(OdemeSayisi>0)
					{
						JOptionPane.showMessageDialog(null, "Ödeme alınmıştır.", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				}
				catch(Exception ex)
				{
				
					JOptionPane.showMessageDialog(null, "Ödeme alınamamıştır"+ex.getMessage().toString(), 
							"Dikkat", JOptionPane.ERROR_MESSAGE);
				}
				
		
				
				
				
				/*secilenOdemeTipi = cmbOdemeTipleri.getSelectedItem().toString();
				double tutar = Integer.valueOf(txtTutar.getText());
				factory = new OdemeIslemiFactory();
				iOdemeTipi = factory.createInstance(secilenOdemeTipi);
				OdemeIslemi odemeIslemi = new OdemeIslemi(iOdemeTipi);
				lblSonuc.setText(odemeIslemi.OdemeYap(tutar));*/
					
				
			}
		});
		btnOdemeYap.setBounds(300, 230, 129, 43);
		frame.getContentPane().add(btnOdemeYap);
		
		lblSonuc = new JLabel("Sonuç : ");
		lblSonuc.setBounds(70, 486, 446, 14);
		frame.getContentPane().add(lblSonuc);
	}
}
