package Cliente;
import javax.swing.JOptionPane;
import Cliente.Cliente;
import Cliente.ListaClientes;

/*
 * Versão beta, por enquanto existe apenas o cadastro com o nome do cliente.
 * 
 * 
 * 
 */
public class Main {
	
	
	public static void main(String args[]) {
		int opt = 0;
		boolean run = true;
		try {
			while (run) {
				opt = Integer.parseInt(JOptionPane.showInputDialog(null, 
						"1 - Cadastrar\n"
						+ "2 - Consultar\n"
						+ "3 - Atualizar\n"
						+ "4 - Excluir\n"
						+ "5 - Listar Clientes\n"
						+ "Digite qualquer outra tecla para sair."));
				switch(opt) {
				case 1:
					InsereCadastro();
					break;
				case 2:
					ConsultaCadastro();
					break;
				case 3:
					AtualizaCadastro();
					break;
				case 4:
					ExcluiCadastro();
					break;
				case 5:
					ListaClientes();
					break;
				default:
					run = false;
					break;
				}
			}
			
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO!");
		}
		
	}
	
	// Funçao do case 1:
	public static void InsereCadastro() {
		Cliente novo_cliente = new Cliente(JOptionPane.showInputDialog(null,
				"Digite o nome do cliente"));
		ListaClientes.InserirNovoCliente(novo_cliente);
		JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso");
	}
	
	// Funçao do case 2:
	public static void ConsultaCadastro() {
		Cliente cliente = ListaClientes.ConsultaPorNome(
				JOptionPane.showInputDialog(null,
				"Digite o nome do cliente que você procura"));
		if (cliente != null) {
			JOptionPane.showMessageDialog(null, "O cliente existe");
			ListaClientes.MostraDados(cliente);
		} else {
			JOptionPane.showMessageDialog(null, "O cliente não existe");
		}
	}
	
	// Funcao do case 3:
	public static void AtualizaCadastro() {
		try {
			Cliente cliente = ListaClientes.PegaCliente(
					Integer.parseInt(JOptionPane.showInputDialog(null,
							"Digite o id do cliente")));
			if (cliente != null) {
				boolean run = true;
				while(run) {
					int opt = Integer.parseInt(JOptionPane.showInputDialog(null,
							"Digite o que você quer mudar.\n"
							+ "1 - Cidade e UF\n"
							+ "2 - Email\n"
							+ "Digite qualquer outra tecla para sair."));
					switch(opt) {
					case 1:
						cliente.setCidade(JOptionPane.showInputDialog(null,
								"Digite o nome da nova cidade"));
						cliente.setUF(JOptionPane.showInputDialog(null,
								"Digite o novo UF"));
						break;
					case 2:
						cliente.setEmail(JOptionPane.showInputDialog(null,
								"Digite o novo email"));
						break;
					default:
						run = false;
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
			}
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro!");
		}

	}
	
	// Funçao case 4:
	public static void ExcluiCadastro() {
		Cliente cliente = ListaClientes.PegaCliente(
				Integer.parseInt(JOptionPane.showInputDialog(null,
						"Digite o ID do cliente")));
		if (cliente != null) {
			ListaClientes.RemoverCliente(cliente);
		} else {
			JOptionPane.showMessageDialog(null, "Cliente não encontrado");
		}
	}
	
	// Funçao case 5:
	public static void ListaClientes() {
		ListaClientes.ListaTodosClientes();
	}
	
	
	
}
