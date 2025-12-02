public class App {
    public static void main(String[] args) {
        System.out.println("--- Testando Padrão Singleton: Leitura da Configuração ---");
        
        // 1. Primeira chamada: A instância é criada e o arquivo é lido (carregamento lento/Lazy loading)
        System.out.println("\nSolicitação do Cliente A (Configuracao.getInstance())...");
        Configuracao configA = Configuracao.getInstance();
        
        // 2. Segunda chamada: A mesma instância é retornada, o arquivo NÃO é lido novamente.
        System.out.println("\nSolicitação do Cliente B (Configuracao.getInstance())...");
        Configuracao configB = Configuracao.getInstance();
        
        // 3. Verifica se as referências são as mesmas
        System.out.println("\nVerificando se configA é a mesma instância que configB: " + (configA == configB));
        
        // 4. Acessa dados individuais (requisito do problema)
        System.out.println("\nAcesso a dados individuais:");
        System.out.println("AppId (Cliente A): " + configA.getPropriedade("AppId"));
        System.out.println("Signature (Cliente B): " + configB.getPropriedade("Signature"));
        
        // 5. Imprime todos os dados (requisito do problema)
        configA.imprimirTodosOsDados();
    }
}s