# 🛒 Sistema de Gestão de Pedidos com Catálogo de Produtos

Este projeto consiste no desenvolvimento de um sistema de microserviços utilizando Spring Boot, Spring Cloud, Eureka Server e Spring Cloud Gateway.
O objetivo é demonstrar a construção de uma arquitetura distribuída simples, com dois serviços independentes que se comunicam entre si  via **Spring Cloud OpenFeign**.

---

## 🏛️ Arquitetura
- Eureka Server -> Service Discovery
- produto-api ->  Responsável por gerenciar o catálogo de produtos (cadastrar, listar e consultar) com persistência em banco de dados em memória (H2 Databse)
- pedidos-api ->  Responsável por criar pedidos. Utiliza o **FeignClient** para consultar os produtos disponíveis no `produto-api`. Não possui persistência.
- API Gateway ->  Faz o roteamento das requisições para cada microserviço.

## 🚀 Tecnologias Utilizadas
- **Java 21**
- **Spring Boot**
- **Spring Cloud Netflix Eureka (Service Discovery)**
- **Spring Cloud Gateway**
- **Spring Cloud OpenFeign (para comunicação entre serviços)**
- **Spring Data JPA**
- **H2 Database (persistência em memória para testes)**
- **Lombok**
- **Maven**

---

## 🔄 Fluxo de Comunicação
1. O cliente envia requisições para o **API Gateway**.  
2. O **Gateway** encaminha para o microserviço adequado (`produto-api` ou `pedidos-api`).  
3. O `pedidos-api` utiliza **FeignClient** para buscar os produtos disponíveis no `produto-api`.  
4. O `eureka-server` garante que todos os serviços possam se descobrir dinamicamente.

---

## ⚙️ Endpoints Principais

### Produto API
*Base URL:* http://localhost:8700/produto-api/produtos
- `POST /produtos` → Cadastra um produto
  ```
  Body:
  json
  {
    "nome": "Notebook",
    "descricao": "Dell Inspiron 15",
    "preco": 3500.00
  }
  ```  
- `GET /produtos` → Lista todos os produtos
- `GET /produtos/id` → Busca produto por ID

### Pedido API
*Base URL:* http://localhost:8700/pedidos-api/pedidos
- `GET /pedidos` → Lista todos os produtos disponíveis  
- `POST /pedidos` → Cria um pedido informando os IDs dos produtos
```
  Body:
  json
  [1, 2, 3]
  ```  

---

## ▶️ Como Executar

1. **Clonar o repositório**

   ```
   git clone https://github.com/gabievb/sistemas-pedidos-microservicos.git
   cd sistemas-pedidos-microservicos
   ```
3. **Subir o Eureka Server (porta 8761)**

   ```
   cd eureka-server
   mvn spring-boot:run
   ```
4. **Subir produto-api (porta 8100)**

   ```
   cd produto-api
   mvn spring-boot:run
   ```
5. **Subir pedidos-api (porta 8200)**

   ```
   cd pedidos-api
   mvn spring-boot:run
   ```
6. **Subir API Gateway (porta 8700)**

   ```
   cd api-gateway
   mvn spring-boot:run
   ```

--- 

🔗 Autor: Gabriely Venturoso
📌 Projeto desenvolvido como desafio de arquitetura de microserviços com Spring Boot da DIO. 

---
