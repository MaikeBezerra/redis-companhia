package br.ufc.persistencia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.ufc.persistencia.Entity.Departamento;
import br.ufc.persistencia.dao.DepartamentoDao;
import br.ufc.persistencia.view.field.StringField;

public class DepartamentoView {
	
	private DepartamentoDao depDAO = new DepartamentoDao();
	private JFrame frmDepartamento;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartamentoView window = new DepartamentoView();
					window.frmDepartamento.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DepartamentoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		StringField stringField = new StringField();
		
		//Frame
		frmDepartamento = new JFrame();
		frmDepartamento.setTitle("Departamento");
		frmDepartamento.setBounds(100, 100, 382, 179);
		frmDepartamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDepartamento.getContentPane().setLayout(null);
		
		//Labels
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(35, 26, 70, 15);
		frmDepartamento.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.addKeyListener(stringField);
		txtNome.setBounds(35, 49, 278, 19);
		frmDepartamento.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		//Buttons
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!txtNome.getText().equals("")){
					String nome = txtNome.getText();
					if (depDAO.busca(nome)) {
						JOptionPane.showMessageDialog(null, "Departamento encontrado");
					} else {
						JOptionPane.showMessageDialog(null, "Departamento não encontrado");
					}
					
				} else 
					JOptionPane.showMessageDialog(null, "Preencha o campo Nome");
			}
		});
		btnBuscar.setIcon(new ImageIcon("./images/icons/magnifier (1).png"));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(325, 43, 25, 25);
		frmDepartamento.getContentPane().add(btnBuscar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Departamento departamento;
				if (!txtNome.getText().equals("")) {
					departamento = new Departamento(txtNome.getText());
					depDAO.salva(departamento);
				} else {
					JOptionPane.showMessageDialog(null, "Preencha o campo Nome");
				}
			}
		});
		btnSalvar.setBounds(80, 80, 102, 25);
		frmDepartamento.getContentPane().add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!txtNome.getText().equals("")){
					depDAO.delete(txtNome.getText());
					JOptionPane.showMessageDialog(null, "Departamento excluido");
				} else 
					JOptionPane.showMessageDialog(null, "Preencha o campo Nome");
			}
		});
		btnExcluir.setBounds(197, 80, 102, 25);
		frmDepartamento.getContentPane().add(btnExcluir);
	}
}
