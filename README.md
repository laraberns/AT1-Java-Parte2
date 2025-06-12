# 📌 Ponto de Partida - Parte 2

Este projeto corresponde à implementação da **Rubrica 3** do AT proposto, referente aos clientes HTTP que consomem a API REST desenvolvida na Parte 1.

---

# 📊 Rubrica 3 - Consumir serviços web (RESTful APIs) com Java

Neste projeto foram implementados os clientes Java utilizando `HttpURLConnection` para consumir os serviços da API REST desenvolvida na primeira parte do trabalho.

## ✅ Funcionalidades implementadas

- **Cliente de criação de Mensalista (POST /mensalistas):**
  - Envia uma requisição POST para criar um novo Mensalista.
  - O JSON de entrada é montado e enviado pelo cliente.

- **Cliente de listagem de Mensalistas (GET /mensalistas):**
  - Realiza uma requisição GET para listar todos os Mensalistas.
  - Os dados retornados são impressos no console.

- **Cliente de busca por matrícula (GET /mensalistas/{matricula}):**
  - Envia uma requisição GET com path param para buscar um Mensalista pela matrícula.
  - O retorno é impresso no console.

- **Cliente de status da API (GET /status):**
  - Envia uma requisição GET para o endpoint `/status` e imprime o JSON de resposta, contendo o status da API e o timestamp.

---

# 🚀 Tecnologias utilizadas

- Java
- Maven
- HttpURLConnection (pacote nativo do Java para chamadas HTTP)
- JSON (org.json para manipulação)

---

# 📦 Entregáveis

- Código-fonte em projeto Maven contendo:
  - Todas as classes clientes.
  - Configurações básicas de execução.

---

# 🔒 Observações de segurança

- **As credenciais de conexão com o Firebase, utilizadas no projeto da Parte 1, não são utilizadas aqui e não estão presentes neste repositório.**
---

# 📌 Observação importante

> Este projeto depende da execução prévia do serviço da Parte 1 (API REST Javalin) para funcionamento completo, pois os clientes enviam e recebem dados desta API.

