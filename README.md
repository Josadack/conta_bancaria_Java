# 💰 Projeto: Gerenciamento de Contas Bancárias

Este é um projeto desenvolvido em **Java** utilizando o **Spring Boot**, que oferece uma API para gerenciar contas bancárias. Com ele, é possível criar, listar, atualizar e excluir contas dos tipos **Corrente** e **Poupança**.

---

## 📂 Estrutura do Projeto

### **Pacotes Principais**
- **`com.conta_bancaria.controller`**: Controladores REST que expõem os endpoints da API.
- **`com.conta_bancaria.dto`**: Objetos de Transferência de Dados (DTO) usados na comunicação entre camadas.
- **`com.conta_bancaria.model`**: Modelos que representam os tipos de conta e suas propriedades.
- **`com.conta_bancaria.repository`**: Interface que gerencia a persistência dos dados com o **Spring Data JPA**.
- **`com.conta_bancaria.service`**: Contém as regras de negócio e lógica do sistema.

---

## 🌟 Funcionalidades

### 1️⃣ Criar Conta Corrente
Cria uma conta corrente, incluindo a definição de limite de crédito.

**📍 Endpoint:**  
`POST /contas/corrente`

**Exemplo de Requisição JSON:**
```json
{
  "agencia": 1234,
  "numero": 5678,
  "titular": "João Silva",
  "saldo": 1000,
  "limite": 500.0,
  "aniversario": 0
}
2️⃣ Criar Conta Poupança
Cria uma conta poupança, com a configuração da data de aniversário.

📍 Endpoint:
POST /contas/poupanca

Exemplo de Requisição JSON:

json
Copiar código
{
  "agencia": 1234,
  "numero": 9876,
  "titular": "Maria Souza",
  "saldo": 2000,
  "limite": 0.0,
  "aniversario": 15
}
3️⃣ Listar Todas as Contas
Retorna todas as contas registradas no sistema.

📍 Endpoint:
GET /contas

4️⃣ Buscar Conta Específica
Busca os detalhes de uma conta utilizando seu id.

📍 Endpoint:
GET /contas/{id}

5️⃣ Atualizar Conta
Atualiza as informações de uma conta existente, com exceção do id.

📍 Endpoint:
PUT /contas/{id}

6️⃣ Deletar Conta
Remove uma conta específica com base no id.

📍 Endpoint:
DELETE /contas/{id}

🛠️ Tecnologias Utilizadas
Java 17 ☕
Spring Boot 3.0 🚀
Spring Data JPA 🗃️
Hibernate 🌐
Jakarta Validation ✅
PostgreSQL 🐘
Postman (para testes de API) 🛠️
⚙️ Configuração do Ambiente
Configuração do Banco de Dados
No arquivo application.properties, configure o acesso ao banco de dados PostgreSQL:

properties
Copiar código
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=adminroot
spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true  
Certifique-se de que:

O PostgreSQL esteja em execução.
O banco de dados e as credenciais estejam configurados corretamente.
🏃 Como Executar o Projeto
Clone este repositório:

bash
Copiar código
git clone https://github.com/seu-usuario/projeto-conta-bancaria.git
Configure o banco de dados no arquivo application.properties.

Compile e execute o projeto com sua IDE favorita ou via terminal:

bash
Copiar código
./mvnw spring-boot:run
Acesse a API no endereço:
http://localhost:8080/contas

🧪 Testes de API
Os endpoints foram testados utilizando o Postman. Replique as requisições com os exemplos de JSON fornecidos na seção de funcionalidades para validar as operações.

Coleção do Postman
Importe a coleção no Postman para facilitar os testes. Caso precise de ajuda para configurar, consulte a documentação oficial.