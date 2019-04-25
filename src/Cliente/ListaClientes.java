package Cliente;

import javax.swing.JOptionPane;
import Cliente.Cliente;
import java.util.ArrayList;
import java.util.List;


// Organização interna dos clientes.
public class ListaClientes {
	private static int id_counter = 0;
	private static List<Cliente> clientes = new ArrayList<>();
	
	public static int PegaCodigo() {
		id_counter += 1;
		
		return id_counter;
	}
	
	public static void ListaTodosClientes() {
		JOptionPane.showMessageDialog(null, "Existem " + clientes.size() + " clientes cadastrados.");
		for(Cliente cliente : clientes) {
			MostraDados(cliente);
		}
	}
	
	public static void MostraDados(Cliente cliente) {
		JOptionPane.showMessageDialog(null, "Codigo : " + cliente.getCodigo() + "\n"
				+ "Nome : " + cliente.getNome());
		if (cliente.getEmail() != null) {
			JOptionPane.showMessageDialog(null, "Email : " + cliente.getNome());
		}
		if (cliente.getCidade() != null) {
			JOptionPane.showMessageDialog(null, "Cidade : " + cliente.getCidade());
		}
		if (cliente.getUf() != null) {
			JOptionPane.showMessageDialog(null, "UF : " + cliente.getUf());
		}
	}
	
	public static void InserirNovoCliente(Cliente novo_cliente) {
		clientes.add(novo_cliente);
	}
	
	public static Cliente ConsultaPorNome(String nome_cliente) {
		if (clientes.isEmpty()) {
			return null;
		}
		for(Cliente cliente : clientes) {
			if (cliente.getNome().equals(nome_cliente) ) {
				return cliente;
			}
		}
		
		return null;
	}		
	
	public static void RemoverCliente(Cliente cliente) {
		clientes.remove(cliente);
	}

	
	public static Cliente PegaCliente(int id) {
		if (clientes.isEmpty()) {
			return null;
		}
		for (Cliente cliente : clientes) {
			if(cliente.getCodigo() == id) {
				return cliente;
			}
		}
		return null;
	}
	
	
	
	
}
