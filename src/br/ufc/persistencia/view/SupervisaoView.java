package br.ufc.persistencia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import br.ufc.persistencia.Entity.Limpeza;
import br.ufc.persistencia.dao.FuncionarioDao;
import br.ufc.persistencia.view.field.FieldInteger;
import br.ufc.persistencia.view.field.StringField;

public class SupervisaoView {

	private Limpeza supervisor = new Limpeza();
	private Limpeza supervisionado = new Limpeza();
	
	private JFrame frame;
	private JPanel panel;
	private JLabel lbId;
	private JTextField txtCpf;
	private JLabel lbNome;
	private JTextField txtNome;
	private JLabel lblSupervisor;
	private JList<String> list;
	private JTextField txtCpfSurp;
	private JTextField txtNomeSurp;

	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupervisaoView window = new SupervisaoView();
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
	public SupervisaoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		FieldInteger integer = new FieldInteger();
		StringField string = new StringField();
		
		FuncionarioDao funcDAO = new FuncionarioDao();
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 604, 374);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.RED));
		panel.setBounds(36, 33, 517, 62);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lbId = new JLabel("ID");
		lbId.setBounds(12, 12, 70, 15);
		panel.add(lbId);
		
		lbNome = new JLabel("Nome");
		lbNome.setBounds(94, 12, 70, 15);
		panel.add(lbNome);
		
		txtCpf = new JTextField();
		txtCpf.addKeyListener(integer);
		txtCpf.setColumns(10);
		txtCpf.setBounds(13, 29, 70, 19);
		panel.add(txtCpf);
		
		txtNome = new JTextField();
		txtNome.addKeyListener(string);
		txtNome.setColumns(10);
		txtNome.setBounds(94, 30, 365, 19);
		panel.add(txtNome);
		
		list = new JList<String>();
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.RED));
		list.setBounds(36, 125, 444, 99);
		frame.getContentPane().add(list);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				try {
					if (!txtCpf.getText().equals("")) {
						supervisor = funcDAO.buscarLimpeza(txtCpf.getText());
						if (supervisor == null) {
							JOptionPane.showMessageDialog(null, "Supervisor não encontrado");
							txtCpf.setText("");
							list.setListData(new String[0]);
						} else {
							//txtCpf.setText(supervisor.getCpf());
							txtNome.setText(supervisor.getNome());
							list.setListData(funcDAO.superviosionados(supervisor.getNome()));
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Supervisor não encontrado!");
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon("./images/icons/magnifier (1).png"));
		btnBuscar.setBounds(464, 23, 41, 25);
		panel.add(btnBuscar);
		
		lblSupervisor = new JLabel("Supervisor");
		lblSupervisor.setBounds(36, 12, 102, 15);
		frame.getContentPane().add(lblSupervisor);
		
		
		
		JLabel lblSupervisionados = new JLabel("Supervisionados");
		lblSupervisionados.setBounds(36, 107, 137, 15);
		frame.getContentPane().add(lblSupervisionados);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(36, 236, 517, 54);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("ID");
		label.setBounds(12, 12, 70, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Nome");
		label_1.setBounds(94, 12, 70, 15);
		panel_1.add(label_1);
		
		txtCpfSurp = new JTextField();
		txtCpfSurp.setColumns(10);
		txtCpfSurp.setBounds(13, 29, 70, 19);
		panel_1.add(txtCpfSurp);
		
		txtNomeSurp = new JTextField();
		txtNomeSurp.setColumns(10);
		txtNomeSurp.setBounds(94, 30, 365, 19);
		panel_1.add(txtNomeSurp);
		
		JButton btnBuscaSupervionado = new JButton("");
		btnBuscaSupervionado.setIcon(new ImageIcon("./images/icons/magnifier (1).png"));
		btnBuscaSupervionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					if (!txtCpfSurp.getText().equals("")) {
						supervisionado = funcDAO.buscarLimpeza(txtCpfSurp.getText());
						if (supervisionado == null) {
							JOptionPane.showMessageDialog(null, "Supervisionado não encontrado");
							txtCpfSurp.setText("");
						} else {
							//txtCpfSurp.setText(supervisionado.getCpf());
							txtNomeSurp.setText(supervisionado.getNome());
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Supervisionado não encontrado!");
				}
			}
		});
		btnBuscaSupervionado.setBounds(464, 23, 41, 25);
		panel_1.add(btnBuscaSupervionado);
		
		JButton btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (supervisionado != null && supervisor != null
											&& supervisionado != supervisor) {
					funcDAO.supervisao(supervisor.getNome(), supervisionado.getNome());
				}	
			}
		});
		btnNovo.setIcon(new ImageIcon("./images/icons/plus (2).png"));
		btnNovo.setBounds(501, 137, 40, 32);
		frame.getContentPane().add(btnNovo);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon("./images/icons/bin.png"));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = list.getSelectedValue().toString();
				if (supervisor != null && !list.isSelectionEmpty()) {
					funcDAO.removeSupervisao(supervisor.getNome(), nome);
				}
			}
		});
		btnExcluir.setBounds(501, 181, 40, 32);
		frame.getContentPane().add(btnExcluir);
	}
}
