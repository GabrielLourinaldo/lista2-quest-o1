import java.util.Map;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;

public class Configuracao {
    private static Configuracao instance;
    
    private Properties properties;

    private Configuracao() {
        properties = new Properties();
        
        try (FileReader reader = new FileReader("config.properties")) {
            properties.load(reader);
            System.out.println("Configuração lida e carregada na memória.");
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo de configuração: " + e.getMessage());
        }
    }

    public static Configuracao getInstance() {
        if (instance == null) {
            instance = new Configuracao();
        }
        return instance;
    }
    
    public String getPropriedade(String chave) {
        return properties.getProperty(chave);
    }
    
    public void imprimirTodosOsDados() {
        System.out.println("\n--- Dados de Configuração ---");
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println("-----------------------------\n");
    }
}