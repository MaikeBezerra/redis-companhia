package br.ufc.persistencia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ufc.persistencia.Entity.Departamento;
import br.ufc.persistencia.Entity.Funcionario;
import br.ufc.persistencia.Entity.Limpeza;
import br.ufc.persistencia.Entity.Pesquisador;
import br.ufc.persistencia.Entity.Secretario;
import br.ufc.persistencia.dao.DepartamentoDao;
import br.ufc.persistencia.dao.FuncionarioDao;
import br.ufc.persistencia.view.field.FieldDouble;
import br.ufc.persistencia.view.field.FieldInteger;
import br.ufc.persistencia.view.field.StringField;

public class FuncionarioView {
	
	private Funcionario funcionario;
	private JFrame frmFuncionario;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtDataNascimento;
	private JTextField txtSalario;
	private JTextField txtArea;
	private JTextField txtGrau;
	private JTextField txtCargo;
	private JTextField txtJornada;
	private JTextField txtCpf;

	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioView window = new FuncionarioView();
					window.frmFuncionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FuncionarioView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		FuncionarioDao funcDAO = new FuncionarioDao();
		DepartamentoDao depDAO = new DepartamentoDao();
		//EnderecoJPADAO endDAO = new EnderecoJPADAO();
		
		
		FieldDouble fieldDouble = new FieldDouble();
		FieldInteger fieldInteger = new FieldInteger();
		StringField stringField = new StringField();		
		
		//Frame
		frmFuncionario = new JFrame();
		frmFuncionario.setTitle("Funcionario");
		frmFuncionario.setBounds(100, 100, 600, 461);
		frmFuncionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFuncionario.getContentPane().setLayout(null);
		
		//Panels
		JPanel pnlFuncionario = new JPanel();
		pnlFuncionario.setBounds(33, 28, 512, 162);
		frmFuncionario.getContentPane().add(pnlFuncionario);
		pnlFuncionario.setLayout(null);
		
		JPanel pnlDepartamento = new JPanel();
		pnlDepartamento.setBounds(250, 314, 293, 64);
		frmFuncionario.getContentPane().add(pnlDepartamento);
		pnlDepartamento.setLayout(null);
		
		JPanel pnlSecretario = new JPanel();
		pnlSecretario.setLayout(null);
		pnlSecretario.setBounds(33, 314, 189, 64);
		frmFuncionario.getContentPane().add(pnlSecretario);
		
		JPanel pnlLimpeza = new JPanel();
		pnlLimpeza.setLayout(null);
		pnlLimpeza.setBounds(252, 219, 293, 64);
		frmFuncionario.getContentPane().add(pnlLimpeza);
		
		JPanel pnlPesquisador = new JPanel();
		pnlPesquisador.setBounds(33, 219, 189, 64);
		frmFuncionario.getContentPane().add(pnlPesquisador);
		pnlPesquisador.setLayout(null);
		
		//Labels
		JLabel lblDadosPessoais = new JLabel("Dados Pessoais");
		lblDadosPessoais.setBounds(33, 12, 114, 15);
		frmFuncionario.getContentPane().add(lblDadosPessoais);
		
		JLabel lblId = new JLabel("CPF");
		lblId.setBounds(12, 12, 70, 15);
		pnlFuncionario.add(lblId);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(178, 12, 70, 15);
		pnlFuncionario.add(lblNome);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setBounds(12, 60, 70, 15);
		pnlFuncionario.add(lblEndereco);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(266, 104, 40, 15);
		pnlFuncionario.add(lblSexo);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(326, 104, 40, 15);
		pnlFuncionario.add(lblTipo);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setBounds(155, 109, 70, 15);
		pnlFuncionario.add(lblSalario);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setBounds(12, 109, 147, 15);
		pnlFuncionario.add(lblDataNascimento);
		
		JLabel lblPesquisador = new JLabel("Pesquisador");
		lblPesquisador.setBounds(33, 202, 104, 15);
		frmFuncionario.getContentPane().add(lblPesquisador);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setBounds(12, 12, 70, 15);
		pnlPesquisador.add(lblArea);
		
		JLabel lblSecretario = new JLabel("Secretario");
		lblSecretario.setBounds(33, 295, 104, 15);
		frmFuncionario.getContentPane().add(lblSecretario);		
		
		JLabel lblGrau = new JLabel("Grau");
		lblGrau.setBounds(12, 6, 70, 15);
		pnlSecretario.add(lblGrau);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(250, 295, 104, 15);
		frmFuncionario.getContentPane().add(lblDepartamento);
		
		JLabel lblNomeDep = new JLabel("Nome");
		lblNomeDep.setBounds(12, 12, 70, 15);
		pnlDepartamento.add(lblNomeDep);
		
		JLabel lblLimpeza = new JLabel("Limpeza");
		lblLimpeza.setBounds(252, 202, 163, 15);
		frmFuncionario.getContentPane().add(lblLimpeza);		
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(12, 12, 70, 15);
		pnlLimpeza.add(lblCargo);
		
		JLabel lblJornada = new JLabel("Jornada");
		lblJornada.setBounds(211, 12, 70, 15);
		pnlLimpeza.add(lblJornada);
		
		txtCpf = new JTextField();
		txtCpf.addKeyListener(fieldInteger);
		txtCpf.setBounds(13, 29, 151, 19);
		pnlFuncionario.add(txtCpf);
		txtCpf.setColumns(10);		
		
		//FieldTexts
		txtNome = new JTextField();
		txtNome.addKeyListener(stringField);
		txtNome.setBounds(176, 30, 321, 19);
		pnlFuncionario.add(txtNome);
		txtNome.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.addKeyListener(stringField);
		txtEndereco.setBounds(12, 77, 485, 19);
		pnlFuncionario.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(12, 126, 129, 19);
		pnlFuncionario.add(txtDataNascimento);
		txtDataNascimento.setColumns(10);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(153, 126, 95, 19);
		pnlFuncionario.add(txtSalario);
		txtSalario.addKeyListener(fieldDouble);
		txtSalario.setColumns(10);
		
		//Boxes
		JComboBox<String> boxSexo = new JComboBox<String>();
		boxSexo.setBounds(266, 123, 51, 24);
		pnlFuncionario.add(boxSexo);
		boxSexo.setModel(new DefaultComboBoxModel<String>(new String[] {"M", "F"}));
		
		JComboBox<String> cmbBxDepartamento = new JComboBox<String>();
		cmbBxDepartamento.setBounds(12, 28, 254, 24);
		pnlDepartamento.add(cmbBxDepartamento);
		cmbBxDepartamento.setModel(new DefaultComboBoxModel<>(depDAO.departamentos()));
		
		JComboBox<String> boxFuncionario = new JComboBox<String>();
		boxFuncionario.setBounds(329, 123, 168, 24);
		pnlFuncionario.add(boxFuncionario);
		boxFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (boxFuncionario.getSelectedItem().toString()) {
				case "Pesquisador":
					enablePesquisador();
					disableSecretario();
					disableLimpeza();
					break;
				case "Secretario":
					enableSecretario();
					disablePesquisador();
					disableLimpeza();
					break;
				case "Limpeza":
					enableLimpeza();
					disablePesquisador();
					disableSecretario();
					break;
				default:
					break;
				}
			}
		});
		boxFuncionario.setModel(new DefaultComboBoxModel<String>(new String[] {"Pesquisador", "Secretario", "Limpeza"}));
		
		txtArea = new JTextField();
		txtArea.addKeyListener(stringField);
		txtArea.setBounds(12, 33, 138, 19);
		txtArea.setEnabled(false);
		pnlPesquisador.add(txtArea);
		txtArea.setColumns(10);		
		
		txtGrau = new JTextField();
		txtGrau.addKeyListener(stringField);
		txtGrau.setColumns(10);
		txtGrau.setBounds(12, 33, 138, 19);
		txtGrau.setEnabled(false);
		pnlSecretario.add(txtGrau);		
		
		txtCargo = new JTextField();
		txtCargo.addKeyListener(stringField);
		txtCargo.setColumns(10);
		txtCargo.setBounds(12, 33, 188, 19);
		txtCargo.setEnabled(false);
		pnlLimpeza.add(txtCargo);		
		
		txtJornada = new JTextField();
		txtJornada.addKeyListener(fieldInteger);
		txtJornada.setText("0");
		txtJornada.setBounds(212, 33, 56, 19);
		txtJornada.setEnabled(false);
		pnlLimpeza.add(txtJornada);
		txtJornada.setColumns(10);
		
		//Buttons 
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String tipo = boxFuncionario.getSelectedItem().toString();
					String cargo = txtCargo.getText();
					String grau = txtGrau.getText();
					String area = txtArea.getText();
					String dataNasc = txtDataNascimento.getText();
					String endereco = txtEndereco.getText();
					String cpf = txtCpf.getText();
					String nome = txtNome.getText();
					String sexo = boxSexo.getSelectedItem().toString();
					
					int jornada = Integer.parseInt(txtJornada.getText());
					double salario = Double.parseDouble(txtSalario.getText());
					
					String nomeDepartamento = cmbBxDepartamento.getSelectedItem().toString();
					Departamento departamento = depDAO.buscar(nomeDepartamento);
										
					if (tipo.equals("Pesquisador")) {
						Pesquisador pesquisador = new Pesquisador(cpf, nome, endereco, sexo, 
								dataNasc, salario, departamento, area);
						funcDAO.salva(pesquisador);
					} else if (tipo.equals("Secretario")) {
						Secretario secretario = new Secretario(cpf, nome, endereco, sexo, 
										dataNasc, salario, departamento, grau);
						funcDAO.salva(secretario);
					} else if (tipo.equals("Limpeza")) {
						Limpeza limpeza = new Limpeza(cpf, nome, endereco, sexo, dataNasc, 
											salario, departamento, cargo, jornada, null);
						funcDAO.salva(limpeza);
					}
					
					JOptionPane.showMessageDialog(null, "Funcionario salvo com sucesso");
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Erros possiveis no campo salario");
					
				}
				
			}
		});
		btnSalvar.setBounds(61, 390, 117, 25);
		frmFuncionario.getContentPane().add(btnSalvar);		
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtCpf.getText().equals("")){
					funcDAO.delete(txtCpf.getText());
					JOptionPane.showMessageDialog(null, "Funcionario excluido");
				} else 
					JOptionPane.showMessageDialog(null, "Preencha o campo CPF");
			}
		});
		btnExcluir.setBounds(348, 390, 117, 25);
		frmFuncionario.getContentPane().add(btnExcluir);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!txtCpf.getText().equals("")) {
					String cpf = txtCpf.getText();
					funcionario = funcDAO.buscar(cpf);
					
					if (funcionario == null) {
						JOptionPane.showMessageDialog(null, "Funcionario não encontrado");
						txtCpf.setText("");
					} else {
						txtCpf.setText(funcionario.getCpf());
						txtNome.setText(funcionario.getNome());						
						txtEndereco.setText(funcionario.getEndereco());					
						txtDataNascimento.setText(funcionario.getDataNascimento());							
						txtSalario.setText(String.valueOf(funcionario.getSalario()));
						boxSexo.setSelectedItem(funcionario.getSexo());
						boxFuncionario.setSelectedItem(funcionario.getTipo());
						
						Departamento dep = funcionario.getDepartamento();
						if (dep != null) {
							cmbBxDepartamento.setSelectedItem(dep.getNome());
						}
						
					}
				
				}
			
			}
		});
		btnBuscar.setBounds(207, 390, 117, 25);
		frmFuncionario.getContentPane().add(btnBuscar);
	}
	
	public void disableCampos(){
		txtArea.setEnabled(false);
		txtCargo.setEnabled(false);
		txtJornada.setEnabled(false);
		txtGrau.setEnabled(false);
	}
	
	public void enableLimpeza(){
		txtCargo.setEnabled(true);
		txtJornada.setEnabled(true);
	}
	
	public void enableSecretario(){
		txtGrau.setEnabled(true);
	}
	
	public void enablePesquisador(){
		txtArea.setEnabled(true);
	}
	
	public void disableLimpeza(){
		txtCargo.setEnabled(false);
		txtJornada.setEnabled(false);
	}
	
	public void disableSecretario(){
		txtGrau.setEnabled(false);
	}
	
	public void disablePesquisador(){
		txtArea.setEnabled(false);
	}
}
