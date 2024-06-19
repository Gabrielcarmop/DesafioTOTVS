# Projeto Desafio

Este projeto é uma aplicação Java Spring Boot com frontend em React para gerenciamento de clientes e seus telefones.

## Funcionalidades

- Cadastro de clientes com nome, endereço e telefones associados.
- Validações de nome único e formato e duplicidade de telefone.
- Persistência de dados utilizando banco de dados.
- Interface frontend para interação com os usuários.

## Tecnologias Utilizadas

### Backend

- Java 17
- Spring Boot
- Maven
- H2 Database 
- RESTful API

### Frontend

- React
- Semantic UI React (para componentes visuais)
- Formik e Yup (para formulários e validações)

## Estrutura do Projeto

|-- backend
|   |-- src
|   |   |-- main
|   |   |   |-- java
|   |   |   |   |-- configuration   # Arquivos de cofiguração
|   |   |   |   |-- controller      # Controller
|   |   |   |   |-- exception       # Exceptions 
|   |   |   |   |-- mapper          # Mapeamnento de entidades e DTOs
|   |   |   |   |-- model           # Entidades
|   |   |   |   |-- repository      # Repository
|   |   |   |   |-- service         # Service
|   |   |-- ...
|   `-- pom.xml
|
|-- frontend
|   |-- public
|   |-- src
|   |   |-- components    # Componentes React
|   |   |-- services      # Serviços para comunicação com backend
|   |   |-- App.js        # Componente principal do React
|   |   |-- index.js      # Ponto de entrada do React
|   |   |-- ...
|   |-- package.json      # Configurações e dependências do npm

|
|-- README.md             # README principal do projeto

## Pré-requisitos

### Backend

- Java 17 ou superior instalado
- Maven 3.9.7
- IDE de desenvolvimento (Eclipse, IntelliJ IDEA, etc.)

### Frontend

- Node.js (com npm) instalado
- IDE de desenvolvimento (Visual Studio Code, WebStorm, etc.)

## Instalação e Execução

### Backend

1. Importe o projeto na sua IDE.

2. Execute a aplicação a partir da classe DesafioApplication.java ou utilizando Maven:
   
    mvn spring-boot:run

3. http://localhost:8080/api/clientes

### Frontend

1. Instale as dependências do projeto:

    cd frontend
    npm install

2. Inicie o servidor de desenvolvimento:

    npm start

3. Acesse o frontend através do navegador:
    
    http://localhost:3000
    
