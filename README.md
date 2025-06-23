# **📚 Library Management System**

Um sistema de gerenciamento de biblioteca em Java, com controle de empréstimos, devoluções e datas, seguindo princípios de **Orientação a Objetos** e **Separação de Responsabilidades**.

---

## **⚙️ Funcionalidades**
✅ **Cadastro de Livros**  
✅ **Empréstimo e Devolução**  
✅ **Controle de Datas**  
✅ **Listagem de Livros Emprestados**  
✅ **Interface por Linha de Comando (CLI)**  

---

## **📦 Estrutura do Projeto**
```
src/
├── main/
│   ├── model/          # Classes de domínio
│   │   ├── Livro.java
│   │   ├── Usuario.java
│   ├── repository/     # Armazenamento de dados
│   │   ├── AcervoRepository.java
│   ├── service/        # Lógica de negócio
│   │   ├── EmprestimoService.java
│   ├── ui/            # Interface do usuário
│   │   ├── BibliotecaApp.java
```

---

## **🚀 Como Executar**
1. **Pré-requisitos**:
   - Java JDK 17+
   - Maven (opcional)

2. **Compilar e Executar**:
   ```
   javac -d out $(find src -name "*.java")
   ```

3. **Ou com Maven** (se configurado):
   ```sh
   mvn compile exec:java -Dexec.mainClass="src.main.ui.BibliotecaApp"
   ```

---

## **📝 Menu Principal**
```
=== SISTEMA DE BIBLIOTECA ===
1 - Listar todos os livros
2 - Emprestar livro
3 - Devolver livro
4 - Ver meus livros emprestados
5 - Adicionar livro ao acervo
6 - Remover livro do acervo
0 - Sair
```

---


## **📌 Exemplo de Uso**
```java
// Criar usuário
Usuario usuario = new Usuario("João Silva", 123);

// Emprestar livro
emprestimoService.emprestarLivro(usuario, 1); // ID do livro

// Ver livros emprestados
bibliotecaApp.verLivrosComData(usuario);
```

---

### **🎯 Objetivo do Projeto**
Este projeto foi desenvolvido para praticar:
✔ **Boas práticas de OOP**  
✔ **Separação de responsabilidades**  
✔ **Manipulação de datas com `java.time`**  
✔ **Estruturação de projetos em Java**  

---
