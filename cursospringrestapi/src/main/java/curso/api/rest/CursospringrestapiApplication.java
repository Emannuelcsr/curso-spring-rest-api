package curso.api.rest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Classe principal da aplicação Spring Boot.
 *
 * <p>Essa classe é o ponto de entrada do projeto — é a partir dela que o Spring Boot
 * inicia toda a aplicação, configura automaticamente os componentes e sobe o servidor embutido (Tomcat).
 * Quando o método `main` é executado, o Spring inicializa todas as configurações necessárias
 * para que os controladores, serviços, repositórios e entidades funcionem corretamente.</p>
 *
 * <p>Em outras palavras: essa classe é o “motor de partida” do sistema.</p>
 *
 * <h3>Anotações explicadas</h3>
 * <ul>
 *   <li><b>{@link SpringBootApplication}</b> – indica que essa é a classe principal do Spring Boot e
 *   ativa a configuração automática, varredura de componentes e o suporte ao Spring Boot.</li>
 *
 *   <li><b>{@link EntityScan}</b> – define onde estão as classes de modelo (entidades JPA) que representam
 *   as tabelas do banco de dados.</li>
 *
 *   <li><b>{@link ComponentScan}</b> – indica ao Spring onde procurar os componentes da aplicação
 *   (controladores, serviços, etc.). Aqui, ele procura em todo o pacote `curso.*`.</li>
 *
 *   <li><b>{@link EnableJpaRepositories}</b> – informa onde estão os repositórios JPA
 *   (interfaces que fazem a comunicação com o banco de dados).</li>
 *
 *   <li><b>{@link EnableTransactionManagement}</b> – habilita o controle de transações no JPA,
 *   garantindo que operações no banco (salvar, atualizar, excluir) sejam seguras e consistentes.</li>
 *
 *   <li><b>{@link EnableWebMvc}</b> – ativa o suporte ao padrão MVC (Model-View-Controller),
 *   permitindo criar controladores que respondem a requisições HTTP.</li>
 *
 *   <li><b>{@link RestController}</b> – indica que essa classe (ou o projeto) expõe endpoints REST,
 *   ou seja, respostas em formato JSON ou XML via HTTP.</li>
 *
 *   <li><b>{@link EnableAutoConfiguration}</b> – faz o Spring configurar automaticamente os recursos
 *   da aplicação com base nas dependências do projeto (banco, servidor, segurança, etc.).</li>
 * </ul>
 */
@SpringBootApplication
@EntityScan(basePackages = {"curso.api.rest.model"})
@ComponentScan(basePackages = {"curso.*"})
@EnableJpaRepositories(basePackages = {"curso.api.rest.repository"})
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration
public class CursospringrestapiApplication {

    /**
     * Método principal da aplicação.
     *
     * <p>O método `main` é o ponto de partida do Java. Aqui ele chama
     * {@link SpringApplication#run(Class, String...)} que inicializa todo o contexto do Spring,
     * carrega as configurações, conecta ao banco de dados, e deixa o servidor pronto para
     * receber requisições HTTP.</p>
     *
     * @param args argumentos de linha de comando (geralmente não utilizados em aplicações web).
     */
    public static void main(String[] args) {
        // Inicia a aplicação Spring Boot, configurando automaticamente o contexto e os componentes.
        SpringApplication.run(CursospringrestapiApplication.class, args);
    }
}

/**
 * Explicação didática:
 *
 * Essa classe é como o “botão de ligar” do sistema. Quando você executa a aplicação,
 * o Spring Boot começa a trabalhar por aqui — ele escaneia pacotes, configura o banco,
 * prepara as rotas REST e deixa o servidor embutido pronto para receber requisições HTTP.
 *
 * É aqui que tudo começa: o contexto do Spring é criado, as entidades são mapeadas,
 * os repositórios são registrados e os controladores ficam disponíveis para responder
 * às chamadas da API. Sem essa classe, o sistema simplesmente não inicializa.
 */
