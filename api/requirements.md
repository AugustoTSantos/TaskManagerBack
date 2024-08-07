# Doc 1
# Teste Prático para Desenvolvedor Pleno Back-End em Java e Spring Boot

Este repositório contém o teste prático para a vaga de Desenvolvedor Pleno Back-End em Java e Spring Boot.

## Descrição do Projeto

Desenvolver uma aplicação de gerenciamento de tarefas (todo list) com as seguintes funcionalidades:

1. **Cadastro de Usuários**:
   - Criar, editar, excluir e listar usuários.
   - Cada usuário deve ter um nome e nível (admin, user).
2. **Gerenciamento de Tarefas**:
   - Criar, editar, excluir e listar tarefas.
   - Cada tarefa deve ter um título, descrição, data de criação, data de vencimento, status (pendente, em andamento, concluída) e um usuário associado.
3. **Filtros e Ordenação**:
   - Permitir que as tarefas sejam filtradas por status.
   - Permitir que as tarefas sejam ordenadas por data de vencimento.
4. **Associação de Tarefas a Usuários**
   - Permitir que tarefas sejam atribuídas a usuários específicos.
   - Permitir que as tarefas de um usuário específico sejam listadas.
   
### Aplicação de Testes unitários
   - O metodos devem ser testados com JUnit

## Requisitos Técnicos

- Java 11 ou superior
- Spring Boot
- Banco de Dados Relacional (H2 para facilitar os teste)
- JPA/Hibernate
- Maven
- Spring Security
- Spring Data JPA
- JUnit e Mockito para testes

## Instruções para Implementação

1. Clone o repositório:
   ```bash
   git clone https://github.com/ManagerThalles/backend-java-spring-test.git
   cd backend-java-spring-boot-test
2. Siga as instruções no arquivo `requirements.md` para detalhes sobre a implementação.

## Configuração Automática

Para facilitar a configuração do ambiente, você pode usar o script `setup.sh` incluído no repositório. 

### Passos para Configuração

1. Clone o repositório:
    ```bash
    git clone https://github.com/ManagerThalles/backend-java-spring-test.git
    cd backend-java-spring-boot-test
    ```

2. Dê permissão de execução ao script:
    ```bash
    chmod +x setup.sh
    ```

3. Execute o script:
    ```bash
    ./setup.sh
    ```

O script irá verificar se você tem Java 11 e Maven instalados, instalar as dependências do Maven e iniciar a aplicação Spring Boot.

## Envio do Projeto
O candidato deve enviar o link do repositório (GitHub) contendo o código-fonte do projeto, junto com um arquivo README.md explicando como configurar e executar a aplicação.

Boa sorte!

# Doc 2
# Requisitos do Projeto

## Funcionalidades

1. **Gerenciamento de Usuário**:
   - `GET /api/users`: Listar todos os usuários.
   - `POST /api/users`: Criar um novo usuário.
   - `PUT /api/users/{id}`: Atualizar um usuário existente.
   - `DELETE /api/users/{id}`: Deletar um usuário.

2. **Gerenciamento de Tarefas**:
   - `GET /api/tasks`: Listar todas as tarefas do usuário autenticado.
   - `POST /api/tasks`: Criar uma nova tarefa.
   - `PUT /api/tasks/{id}`: Atualizar uma tarefa existente.
   - `DELETE /api/tasks/{id}`: Deletar uma tarefa.
   - `GET /api/tasks?status={status}`: Filtrar tarefas por status.
   - `GET /api/tasks?sort=dueDate`: Ordenar tarefas por data de vencimento.
   - `GET /api/users/{userId}/tasks`: Listar todas as tarefas de um usuário específico.

## Modelagem de Dados

- **User**:
  - `id`: Long
  - `username`: String
  - `nivel`: String

- **Task**:
  - `id`: Long
  - `title`: String
  - `description`: String
  - `createdAt`: Date
  - `dueDate`: Date
  - `status`: Status
  - `user`: User
   
- **Status**
   - `PENDENTE`
   - `EM_ANDAMENTO`
   - `CONCLUIDA`

## Critérios de Avaliação

1. **Funcionalidade**:
   - **Requisitos Atendidos**: O sistema implementa todas as funcionalidades especificadas no teste (cadastro de usuários, gerenciamento de tarefas, autenticação e autorização)?
   - **Operacionalidade**: Todas as funcionalidades estão operacionais e livres de bugs críticos?
   - **Conformidade com a Especificação**: As funcionalidades estão implementadas conforme descrito nos requisitos do projeto?

2. **Qualidade do Código**:
   - **Clean Code**: O código está limpo, organizado e de fácil leitura? Segue os princípios do Clean Code?
   - **Princípios SOLID**: O código segue os princípios SOLID (Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion)?
   - **Estrutura e Organização**: O código está bem estruturado, com uma separação clara entre camadas (controladores, serviços, repositórios, etc.)?
   - **Manutenibilidade**: O código é fácil de manter e expandir? Existe modularização adequada?

3. **Testes**:
   - **Cobertura de Testes**: Os testes cobrem uma parte significativa da aplicação (especialmente as funcionalidades principais)?
   - **Qualidade dos Testes**: Os testes são bem escritos, claros e bem organizados? Utilizam boas práticas de testes unitários e de integração?
   - **Automatização**: Existe alguma forma de execução automatizada dos testes, como scripts ou configuração de CI/CD?

4. **Documentação**:
   - **README.md**: O projeto inclui um arquivo README.md com instruções claras sobre como configurar e rodar a aplicação?
   - **Documentação dos Endpoints**: Os endpoints estão documentados (por exemplo, usando Swagger ou outra ferramenta de documentação)?
   - **Comentários no Código**: O código inclui comentários úteis que explicam partes complexas ou importantes da implementação?

5. **FrontEnd**:
   - **Diferencial (Opcional)**: Embora a aplicação frontend não seja obrigatória, será considerada um diferencial. Se desenvolvida, será avaliada pela qualidade e integração com o backend. Isso inclui:
     - **Funcionalidade**: A aplicação frontend implementa as funcionalidades básicas (visualização, criação, edição e exclusão de tarefas)?
     - **UX/UI**: A interface é intuitiva e de fácil uso?
     - **Integração**: A integração com o backend é feita de forma eficiente e segura?

## Recursos Adicionais

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Security Documentation](https://spring.io/projects/spring-security)
- [Spring Data JPA Documentation](https://spring.io/projects/spring-data-jpa)
