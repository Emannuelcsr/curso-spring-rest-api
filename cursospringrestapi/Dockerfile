# Etapa 1 - Usar imagem base do Java 17
FROM eclipse-temurin:17-jdk

# Etapa 2 - Criar diretório da aplicação
WORKDIR /app

# Etapa 3 - Copiar o WAR gerado pelo Maven
COPY target/cursospringrestapi.war app.war

# Etapa 4 - Expõe a porta (Render define dinamicamente via variável PORT)
EXPOSE 8080

# Etapa 5 - Comando para iniciar o app
CMD ["java", "-jar", "app.war"]