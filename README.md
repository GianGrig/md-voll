# md-voll

API REST da clínica fictícia **Voll.med**, para cadastro e gerenciamento de médicos e pacientes, com autenticação via JWT.

> Projeto desenvolvido durante a formação **Java e Spring Boot** da [Alura](https://cursos.alura.com.br/app/learning-guide/alura/spring-boot-3). Ainda em desenvolvimento.

## Tecnologias

- Java 17
- Spring Boot 3.5 (Web, Data JPA, Validation, Security)
- MySQL
- Flyway (versionamento do banco)
- JWT ([java-jwt](https://github.com/auth0/java-jwt))
- Lombok
- Maven (com Maven Wrapper)

## Funcionalidades

- Cadastro, listagem, detalhamento, atualização e exclusão de **médicos** e **pacientes**
- Exclusão lógica (o registro é marcado como inativo, não é apagado)
- Listagem paginada e ordenada por nome (10 itens por página)
- Validação dos dados de entrada (e-mail, CRM, CPF, CEP etc.) com respostas de erro padronizadas
- Migrations do banco com Flyway
- Login com geração de token JWT (senhas protegidas com BCrypt)

## Endpoints

| Método | Rota | Descrição |
| --- | --- | --- |
| `POST` | `/login` | Autentica e retorna o token JWT |
| `POST` | `/medicos` | Cadastra um médico |
| `GET` | `/medicos` | Lista médicos ativos (paginado) |
| `GET` | `/medicos/{id}` | Detalha um médico |
| `PUT` | `/medicos` | Atualiza nome, telefone e endereço |
| `DELETE` | `/medicos/{id}` | Inativa um médico |
| `POST` | `/pacientes` | Cadastra um paciente |
| `GET` | `/pacientes` | Lista pacientes ativos (paginado) |
| `GET` | `/pacientes/{id}` | Detalha um paciente |
| `PUT` | `/pacientes` | Atualiza dados do paciente |
| `DELETE` | `/pacientes/{id}` | Inativa um paciente |

### Exemplo: cadastrar médico

```json
POST /medicos
{
  "nome": "Maria Silva",
  "email": "maria.silva@voll.med",
  "telefone": "47999999999",
  "crm": "123456",
  "especialidade": "CARDIOLOGIA",
  "endereco": {
    "logradouro": "Rua das Flores",
    "bairro": "Centro",
    "cep": "89010000",
    "cidade": "Blumenau",
    "uf": "SC",
    "numero": "100",
    "complemento": "Sala 2"
  }
}
```

Especialidades disponíveis: `ORTOPEDIA`, `CARDIOLOGIA`, `GINECOLOGIA`, `DERMATOLOGIA`.

## Como executar

### Pré-requisitos

- JDK 17 ou superior
- MySQL em execução

### Passo a passo

1. Clone o repositório:

   ```bash
   git clone https://github.com/GianGrig/md-voll.git
   cd md-voll
   ```

2. Crie o banco de dados:

   ```sql
   CREATE DATABASE vollmed_api;
   ```

3. Ajuste o usuário e a senha do MySQL em `src/main/resources/application.properties`.

4. Defina o segredo usado para assinar os tokens JWT:

   ```bash
   # Linux / macOS
   export JWT_SECRET="troque-por-um-segredo-longo-e-aleatorio"

   # Windows (PowerShell)
   $env:JWT_SECRET="troque-por-um-segredo-longo-e-aleatorio"
   ```

5. Inicie a aplicação (as tabelas são criadas automaticamente pelo Flyway):

   ```bash
   ./mvnw spring-boot:run
   ```

   A API ficará disponível em `http://localhost:8080`.

### Usuário para login

Ainda não existe endpoint de cadastro de usuários. Para testar o `/login`, insira um usuário direto na tabela `usuarios`, com a senha já criptografada em BCrypt:

```sql
INSERT INTO usuarios (login, senha) VALUES ('admin@voll.med', '<hash BCrypt da senha>');
```

## Estrutura do projeto

```
src/main/java/md/voll/api
├── controller   # endpoints REST
├── domain       # entidades, DTOs e repositórios (medico, paciente, endereco, usuario)
└── infra        # segurança (JWT) e tratamento de erros

src/main/resources/db/migration   # migrations do Flyway
```

## Status

- [x] CRUD de médicos e pacientes
- [x] Validações e tratamento de erros (400 e 404)
- [x] Migrations com Flyway
- [x] Geração do token JWT no login
- [ ] Validação do token e proteção dos endpoints (em andamento)

## Autor

Feito por [GianGrig](https://github.com/GianGrig).