package conta;

public class Conta {

    private final int id;

    private final String agencia;

    private String nome_titular;

    private double saldo;

    /**
     * Cria uma conta, com ID (número da conta), nome do titular e
     * (número da) agência.
     * 
     * @param id O número da conta.
     * @param nome_titular O nome do titular da conta.
     * @param agencia O número da agência, no padrão XXX-X.
     * @throws IllegalArgumentException Se o ID for negativo, se o nome
     * ou a agência forem nulos ou vazios, ou se a agência não seguir o
     * padrão XXX-X.
     */
    public Conta(int id, String nome_titular, String agencia) throws IllegalArgumentException {
        //Valida o ID (Número da conta).
        if(id < 0) {
            throw new IllegalArgumentException("Erro na Criação da Conta: Número da Conta (ID) inválido (valor negativo).");
        }
        this.id = id;

        // Valida o número da agência.
        if(agencia == null || agencia.isEmpty()) {
            throw new IllegalArgumentException("Erro na Criação da Conta: Número da agência vazio.");
        }
        if(!agencia.matches("^\\d{3}-\\d$")) {
            throw new IllegalArgumentException("Erro na Criação da Conta: Número da agência não segue o padrão (XXX-X).");
        }
        this.agencia = agencia;

        // Valida o nome do titular.
        setNomeTitular(nome_titular);
    }

    /**
     * Configura o nome do titular da conta.
     * 
     * @param nome_titular Nome do titular da conta.
     * @throws IllegalArgumentException Se o nome for nulo ou vazio.
     */
    public void setNomeTitular(String nome_titular) throws IllegalArgumentException {
        if(nome_titular == null || nome_titular.isEmpty()) {
            throw new IllegalArgumentException("Erro na Criação da Conta: Nome do titular vazio.");
        }
        this.nome_titular = nome_titular;
    }

    /**
     * Define o saldo atual da conta.
     * 
     * @param saldo Saldo da conta.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getId() {
        return this.id;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public String getNomeTitular() {
        return this.nome_titular;
    }

    public double getSaldo() {
        return this.saldo;
    }
    
    public String toString() {
        return String.format("ID: %d\nAgência: %s\nNome do Titular: %s\nSaldo Atual: R$ %.2f", this.id, this.agencia, this.nome_titular, this.saldo);
    }

}
