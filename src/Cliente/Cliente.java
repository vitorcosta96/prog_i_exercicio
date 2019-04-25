package Cliente;
import Cliente.ListaClientes;


public class Cliente {
	private String nome, email, cidade, uf;
	private int codigo;
	
	public Cliente(String nome) {
		this.nome = nome;
		this.codigo = ListaClientes.PegaCodigo();
		this.email = null;
		this.cidade = null;
		this.uf = null;
	};
	
// Getters
	public String getNome() {
		return this.nome;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getCidade() {
		return this.cidade;
	}
	
	public String getUf() {
		return this.uf;
	}
	
// Fim Getters
	
// Setters	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void setUF(String uf) {
		if(checks_UF(uf)) {
			this.uf = uf;
		}
	}
// Fim Setters
	
	
	// Funçao para consultar se o UF é real;
	public boolean checks_UF(String uf) {
		String[] ufs = {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE",
		                "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"};
		for (int i = 0; i<ufs.length; i++) {
			if (uf == ufs[i]) {
				return true;
			}
		}
		return false;
	};
}
