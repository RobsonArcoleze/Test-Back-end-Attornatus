# Test Back-end Attornatus 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/devsuperior/sds1-wmazoni/blob/master/LICENSE) 

# Sobre o projeto

Este teste foi criado para o processo seletivo de desenvolvedor back-end junior da empresa Attornatus.

Esta aplicação consiste em desenvolver uma API Rest em java com Spring. Esta aplicação contém o relacionamento entre Pessoa e endereço.


## Funcionalidades aplicadas

- Criar uma pessoa
- Editar uma pessoa
- Consultar uma pessoa
- Listar Pessoas
- Criar endereço para a pessoa
- Listar endereços da pessoa
- Poder informar qual o endereço principal da pessoa     **''obs: esta funcionalidade não foi aplicada!''**

## Arquitetura de camadas

Esta aplicação foi desenvolvida de acordo com a arquitetura de camadas.

![Arquitetura](https://github.com/RobsonArcoleze/Test-Back-end-Attornatus/blob/main/img/ArquiteturaCamadas.png)

## Modelo Conceitual

![Modelo conceitual](https://github.com/RobsonArcoleze/Test-Back-end-Attornatus/blob/main/img/modeloConceitualjpeg)

## Tests com Junit e Mockito

Esta aplicação contem testes Unitários realizados com junit e Mockito.

## Testando a API

Para testar os endpoints desta aplicação, foi utilizado o Postman, a collection utilizada está disponivel neste repositorio!

![Postman](https://github.com/RobsonArcoleze/Test-Back-end-Attornatus/blob/main/img/CollectionPostman.png)

Todas as requisições devem ser feitas através de ```/pessoas```, ou seja, Para se criar uma pessoa deve-se utilizar um json com nome e data de aniversário, ou pode passar a pessoa 
com o endereço também! Esta requisição dever ser **POST**

Exemplo 1:

```
 {
    "nome": "Antonio José",
    "dataDeNascimento": "2001-07-25"
 }
 ```
 
 Exemplo 2:
 
 ```
  {
    "nome": "Antonio José",
    "dataDeNascimento": "2001-07-25",
    "enderecos": [
        {
            "logradouro": "Rua Canário",
            "cep": 1234567,
            "numero": 25,
            "cidade": "SP"
        }
    ]
 }
 ```
 
 Para listar os endereços de uma pessoa basta que a rota seja ```/pessoas/id```,esta requisição deve ser **GET** esse é o resultado:
 
 ```
 {
    "id": 2,
    "nome": "Paulo Aurélio",
    "dataDeNascimento": "2001-07-25",
    "enderecos": [
        {
            "id": 3,
            "logradouro": "Rua dos Passaros",
            "cep": 1234567,
            "numero": 25,
            "cidade": "SP"
        },
        {
            "id": 4,
            "logradouro": "Rua dos Jatobas",
            "cep": 1234567,
            "numero": 25,
            "cidade": "SP"
        }
    ]
}
```

Para iserir um endereço há uma pessoa, deve-se chamar ```/pessoas/id```, esta requisição deve ser **POST** nela deve conter um Json:

```
{
    
    "enderecos": [
        {
            "logradouro": "Rua Canário",
            "cep": 1234567,
            "numero": 25,
            "cidade": "SP"
        }
    ]
}
```

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- Spring Data
- Spring Web
- JPA / Hibernate
- Maven
- Banco h2
- Junit
- Mockito


# Como executar o projeto

## Back end
Pré-requisitos: Java 11+

```bash
# clonar repositório
git@github.com:RobsonArcoleze/Test-Back-end-Attornatus.git

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw spring-boot:run
```
# Autor

Robson de Oliveira Arcoleze

https://www.linkedin.com/in/robsonarcoleze/

