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
import br.ufc.persistencia.Entity.Endereco;
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
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;

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
		frmFuncionario.setBounds(100, 100, 600, 530);
		frmFuncionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFuncionario.getContentPane().setLayout(null);
		
		//Panels
		JPanel pnlFuncionario = new JPanel();
		pnlFuncionario.setBounds(33, 28, 512, 216);
		frmFuncionario.getContentPane().add(pnlFuncionario);
		pnlFuncionario.setLayout(null);
		
		JPanel pnlDepartamento = new JPanel();
		pnlDepartamento.setBounds(211, 382, 293, 64);
		frmFuncionario.getContentPane().add(pnlDepartamento);
		pnlDepartamento.setLayout(null);
		
		JPanel pnlSecretario = new JPanel();
		pnlSecretario.setLayout(null);
		pnlSecretario.setBounds(33, 382, 162, 64);
		frmFuncionario.getContentPane().add(pnlSecretario);
		
		JPanel pnlLimpeza = new JPanel();
		pnlLimpeza.setLayout(null);
		pnlLimpeza.setBounds(211, 289, 293, 64);
		frmFuncionario.getContentPane().add(pnlLimpeza);
		
		JPanel pnlPesquisador = new JPanel();
		pnlPesquisador.setBounds(33, 289, 162, 64);
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
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(439, 60, 58, 15);
		pnlFuncionario.add(lblNumero);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(12, 104, 70, 15);
		pnlFuncionario.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(319, 104, 70, 15);
		pnlFuncionario.add(lblCidade);
		
		JLabel lblUF = new JLabel("UF");
		lblUF.setBounds(442, 104, 32, 15);
		pnlFuncionario.add(lblUF);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(266, 150, 40, 15);
		pnlFuncionario.add(lblSexo);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(326, 150, 40, 15);
		pnlFuncionario.add(lblTipo);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setBounds(155, 155, 70, 15);
		pnlFuncionario.add(lblSalario);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setBounds(12, 155, 147, 15);
		pnlFuncionario.add(lblDataNascimento);
		
		JLabel lblPesquisador = new JLabel("Pesquisador");
		lblPesquisador.setBounds(33, 272, 104, 15);
		frmFuncionario.getContentPane().add(lblPesquisador);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setBounds(12, 12, 70, 15);
		pnlPesquisador.add(lblArea);
		
		JLabel lblSecretario = new JLabel("Secretario");
		lblSecretario.setBounds(33, 365, 104, 15);
		frmFuncionario.getContentPane().add(lblSecretario);		
		
		JLabel lblGrau = new JLabel("Grau");
		lblGrau.setBounds(12, 12, 70, 15);
		pnlSecretario.add(lblGrau);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(211, 365, 104, 15);
		frmFuncionario.getContentPane().add(lblDepartamento);
		
		JLabel lblNomeDep = new JLabel("Nome");
		lblNomeDep.setBounds(12, 12, 70, 15);
		pnlDepartamento.add(lblNomeDep);
		
		JLabel lblLimpeza = new JLabel("Limpeza");
		lblLimpeza.setBounds(211, 272, 163, 15);
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
		txtEndereco.setBounds(12, 77, 415, 19);
		pnlFuncionario.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.addKeyListener(fieldInteger);
		txtNumero.setBounds(439, 77, 61, 19);
		pnlFuncionario.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.addKeyListener(stringField);
		txtBairro.setBounds(12, 119, 292, 19);
		pnlFuncionario.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.addKeyListener(stringField);
		txtCidade.setBounds(316, 119, 114, 19);
		pnlFuncionario.add(txtCidade);
		txtCidade.setColumns(10);
		
		JComboBox<String> boxEstado = new JComboBox<String>();
		boxEstado.setBounds(442, 119, 55, 24);
		boxEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", 
																		"ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", 
																		"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", 
																		"SC", "SP", "SE", "TO"}));
		pnlFuncionario.add(boxEstado);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(12, 172, 129, 19);
		pnlFuncionario.add(txtDataNascimento);
		txtDataNascimento.setColumns(10);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(153, 172, 95, 19);
		pnlFuncionario.add(txtSalario);
		txtSalario.addKeyListener(fieldDouble);
		txtSalario.setColumns(10);
		
		//Boxes
		JComboBox<String> boxSexo = new JComboBox<String>();
		boxSexo.setBounds(266, 169, 51, 24);
		pnlFuncionario.add(boxSexo);
		boxSexo.setModel(new DefaultComboBoxModel<String>(new String[] {"M", "F"}));
		
		JComboBox<String> cmbBxDepartamento = new JComboBox<String>();
		cmbBxDepartamento.setBounds(12, 28, 254, 24);
		pnlDepartamento.add(cmbBxDepartamento);
		cmbBxDepartamento.setModel(new DefaultComboBoxModel<>(depDAO.departamentos()));
		
		JComboBox<String> boxFuncionario = new JComboBox<String>();
		boxFuncionario.setBounds(329, 169, 168, 24);
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
					
					//Campos do Endereco 
					String rua = txtEndereco.getText();
					int numero = Integer.parseInt(txtNumero.getText());
					String bairro = txtBairro.getText();
					String cidade = txtCidade.getText();
					String estado = boxEstado.getSelectedItem().toString();
					
					String cpf = txtCpf.getText();
					String nome = txtNome.getText();
					String sexo = boxSexo.getSelectedItem().toString();
					
					//Criando o objeto Endereco
					Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, null);
					
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
		btnSalvar.setBounds(65, 458, 117, 25);
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
		btnExcluir.setBounds(352, 458, 117, 25);
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
						
//						Endereco end = funcionario.getEndereco();
//						txtEndereco.setText(end.getRua());
//						txtNumero.setText(String.valueOf(end.getNumero()));
//						txtBairro.setText(end.getBairro());
//						txtCidade.setText(end.getCidade());
//						boxEstado.setSelectedItem(end.getCidade());
					
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
		btnBuscar.setBounds(211, 458, 117, 25);
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
