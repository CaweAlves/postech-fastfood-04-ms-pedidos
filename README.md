# FastFood Pedidos - Microserviço de Pedidos

Este projeto é um microserviço responsável pelo gerenciamento de pedidos do sistema FastFood. Ele faz parte de uma arquitetura de microsserviços, sendo responsável por operações como criação de pedidos, atualização de status, integração com pagamentos e consulta de informações relacionadas a pedidos e clientes.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Docker
- PostgreSQL
- SQS (mensageria)
- Maven

## Estrutura do Projeto
- `src/main/java`: Código-fonte principal
- `src/test/java`: Testes automatizados
- `k8s/`: Manifests para Kubernetes
- `run/`: Scripts e arquivos de configuração para execução local (Docker Compose, inicialização de banco e SQS)

## Como Executar Localmente

### Pré-requisitos
- Java 17+
- Docker e Docker Compose
- Maven

### Passos
1. Clone o repositório:
   ```bash
   git clone <url-do-repositorio>
   cd postech-fastfood-04-ms-pedido
   ```
2. Suba os serviços necessários (banco de dados e SQS) com Docker Compose:
   ```bash
   cd run
   docker-compose up -d
   ```
3. Execute as migrações do banco de dados (Flyway é executado automaticamente ao subir a aplicação).
4. Para rodar a aplicação localmente:
   ```bash
   ./mvnw spring-boot:run
   ```
   Ou utilize o Docker:
   ```bash
   ./docker_build_and_run.sh
   ```
   Ou no Windows:
   ```bat
   docker_build_and_run.bat
   ```

## Executando Testes

Para rodar os testes automatizados:
```bash
./mvnw test
```

## Endpoints Principais
- `/api/pedidos` - Gerenciamento de pedidos
- `/api/clientes` - Gerenciamento de clientes
- `/api/produtos` - Consulta de produtos
- `/api/pagamentos` - Integração com pagamentos


## Licença
Este projeto está licenciado sob a licença MIT. Veja o arquivo LICENSE para mais detalhes. 