# Conexão do SQL Server a uma Aplicação Java


## :octocat: Integrantes
[Geisianny Bernardo](https://github.com/Geisianny) | [Gison Vilaça](https://github.com/gison-vilaca) | [Luciano Carvalho](https://github.com/jlalvescarvalho) | [Rodrigo Leandro](https://github.com/rudrigozx)


## :page_with_curl: Sobre o Projeto
<p align="justify"> É uma aplicação escrita em Java com conexão ao SQL Server para a disciplina de __Banco de Dados__ ministrada pelo Professor Dimas Cassimiro do Nascimento Filho, da  Universidade Federal do Agreste de Pernambuco(UFAPE), referente ao período de 2022.1 com intuito de avaliação para a 2ª Verificação de Aprendizagem. O projeto foi desenvolvido através de um banco de dados que  deve armazenar informações de produtos, pedidos, clientes, estoques e outras informações relacionadas. Um produto 
deve ser identificado por um identificador (ID), o qual deve ser único e sequencial para cada produto. Todo produto tem um nome, descrição,data de garantia, valor (numérico) de status, preço de custo, preço de venda e preço de venda mínimo. Um produto pode ter diversos nomes e descrições em idiomas diferentes. Os
produtos são classificados em diferentes categorias, sendo que cada categoria possui um ID próprio, um nome e uma descrição. Além disso, deve ser possível identificar o fornecedor de
um produto, tal que cada fornecedor tem um nome, localidade, tipo de fornecedor (pessoa
física ou jurídica) e número do CNPJ ou do CPF. O estoque deve ser identificado unicamente
por um ID (único e sequencial), além de possuir um código. Um estoque sempre está
relacionado a um único produto, identificando a quantidade existente de um determinado
produto. Por sua vez, um armazém é composto por um ou mais estoques. Além disso, cada
armazém possui um ID único e sequencial, além de nome e endereço do armazém. Um pedido
realizado por um cliente pode conter diversos produtos diferentes, sendo que os diferentes
produtos de uma compra podem ser encomendados em quantidades diferentes. Por sua vez, o
preço do produto em um pedido pode ser diferente do preço de venda padrão associado ao
produto, mas não pode ser inferior ao preço mínimo de venda do produto. Um pedido deve
ser identificado unicamente e sequencialmente por um ID, além de constar informações sobre
data do pedido, modo de encomenda (presencial ou online), o cliente que realizou o pedido, o
status do pedido e a data de prazo de entrega do pedido. Finalmente, cada cliente deve ser
identificado unicamente e sequencialmente por um ID, além de constar dados sobre o nome,
os telefone(s), o país, estado, cidade, e-mail(s), limite de crédito ($) e data de cadastro do
cliente.</p>


## :round_pushpin: Objetivos
Aplicar o conhecimento de banco de dados adquirido na disciplina, em um sistema e realizar a conexão de um BD em uma aplicação usual.


## :hammer_and_wrench: Tecnologias Usadas
### [SGBD SQL Server](https://www.microsoft.com/pt-br/sql-server/sql-server-downloads)
*   Versão 19
### [IntelliJ IDEA](https://www.jetbrains.com/idea/)
*   Versão 2022.3.3
### [Java](https://www.java.com/pt-BR/)
*   Versão 19.0.2
### [JavaFX](https://openjfx.io/)
*   Versão 19


## :memo: Tutoriais de referência para conexão com o Banco
### [Autenticação no SQL Server](https://www.youtube.com/watch?v=IbArd7cn2x4&t=153s)
### [Backup do Banco de Dados e Restauração](https://www.youtube.com/watch?v=ndkxT7aEgWM&t=1s)
### [Gerando Instalador - Aplicação Java](https://www.youtube.com/watch?v=uZnseHc2PBA&t=136s)

## :video_camera: Demonstração de funcionamento da aplicação em video 
### [Funcionamento do sistema](https://drive.google.com/drive/folders/1S3Y55c8U0MF2e68fTnloz2iaYNqvY4bb?usp=sharing)


## :keyboard: Acessando o sistema
*   Escolha a opção "Autenticação do SQL Server"
*   E preencha os campos de login e senha
*   Exemplo:
![Exemplo](https://user-images.githubusercontent.com/117764233/227303077-6252ff1e-1c06-4e28-9605-079ed552f174.png)


Após o tutorial de autenticação do SQL Server, mudar o usuário e senha no diretório:
src/main/java/Models/DAO/DAO.java


## :framed_picture: Imagens do Sistema
 * Exemplo de consulta realizada com sucesso:
 
![image](https://user-images.githubusercontent.com/117764233/227409287-86a6cdbb-85cb-4146-b086-4e7cfd9db9c7.png)
![image (1)](https://user-images.githubusercontent.com/117764233/227409312-73e8cb51-6dea-4c78-a195-39c9e1433bc4.png)

* Exemplo de consulta com erro:

![image (2)](https://user-images.githubusercontent.com/117764233/227409334-261265f9-1a13-43fb-8895-a6b6ff9e8fc7.png)

* Menu executavél da aplicação: 

![image (3)](https://user-images.githubusercontent.com/117764233/227409348-4bb5f384-edd2-4224-bf34-2ae497871534.png)

* Telas das classes essenciais do sistema:

![image (4)](https://user-images.githubusercontent.com/117764233/227409385-314913c4-37a4-402b-8c15-288ebafd9384.png)
![image (5)](https://user-images.githubusercontent.com/117764233/227409397-ab9db53e-7765-4129-868d-540b8e1ff5f3.png)


## :construction: Status do Projeto
Concluído.
