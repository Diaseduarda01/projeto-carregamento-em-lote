# Carregamento em Lote com Java (Apache POI + JDBC)

Falaaa devs!

Um belo dia para codar Java, né? 



Este repositório traz um **exemplo prático de carregamento em lote (batch)** — aquele tipo de processamento eficiente que evita ficar dando `INSERT` um por um no banco de dados.

Mas a provocação que deixo para vocês refletirem é:  
**Será que dá pra viver só de CARREGAMENTO em lote?**

Spoiler: nem sempre.

---

## Configurações Importantes

Antes de rodar o projeto, fiquem de olho nas configs 

###  Dependências
- [Apache POI](https://poi.apache.org/) — para ler e manipular planilhas `.xlsx`
- JDBC — para comunicação com o banco
>  **Dica:** Verifiquem no `pom.xml` se as dependências do Apache POI estão completas (`poi-ooxml`, `poi-ooxml-schemas`, etc.)

### Banco de Dados
- Configure o acesso ao banco no arquivo `application.properties` e arquivo `load`
- Verifique:
    - URL correta do banco
    - Usuário e senha válidos
    - Driver JDBC configurado

---

## Artigos para Estudo

Para quem quiser se aprofundar:

-  [Inserções em Lote com JDBC – GeeksforGeeks](https://www.geeksforgeeks.org/batch-insert-in-jdbc/)
-  [Processamento em Lote no JDBC – TutorialsPoint](https://www.tutorialspoint.com/jdbc/jdbc-batch-processing.htm)
-  [Transações em Banco de Dados – Alura (ou docs oficiais do seu SGBD)](https://www.alura.com.br/artigos/como-funcionam-transacoes-banco-de-dados)

---

##  O que praticar depois?

- Tentar implementar um **rollback** em caso de erro no batch
- Comparar tempo de execução entre inserts individuais e batch
- Simular carregamentos com planilhas grandes (1000+ linhas)

---
 *"Código bom é aquele que você entende sem esforço."*

> 💬 Se tiver dúvidas, consulte seu professor...