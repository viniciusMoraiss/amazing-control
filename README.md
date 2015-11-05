# Amazing-control

## Configurando o ambiente

* Faça clone do projeto https://github.com/frenangomes/amazing-control.git em algum diretorio
* Faça download do [eclipse](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars1)

## Importando projeto no Eclipse
* Ao abrir o eclipse sera solicitado o workspace, para facilitar escolha o mesmo diretorio que clonou o projeto;
* Importe o projeto clonado: File > Import > Existing Projects into Workspace > Browse > Pasta_do_projeto;
* Adicione a lib do mysql no buildpath do projeto:  Abra a pasta libs dentro do eclipse e clique com direito no mysql, apos clique em build path > add to Build Path

## Configurando MySQL
Para facilitar vamos usar uma senha padrão para todos no grupo, portanto:
 * Crie um novo usuario no mysql: entre normalmente com algum usuario que tenha acesso total ao banco (Geralmente é o usuario root), clique em Server > User and Privileges > Add Account. Em login crie o usuario 'amazing' e a senha deixe em branco. Clique na aba Admininstrative Roles e marque a opcao DBA. Após clique em apply
 * Crie a data base e a tabela usuarios conforme script abaixo:
 ``` 
 CREATE DATABASE IF NOT EXISTS amazing_control;

USE amazing_control ;

CREATE TABLE IF NOT EXISTS usuarios (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  senha VARCHAR(16) NOT NULL,
  confirmacaoSenha VARCHAR(16) NOT NULL,
  ativo BOOLEAN NOT NULL DEFAULT FALSE,
  PRIMARY KEY (id));
  ```
 * Para rodar o projeto no eclipse, localize a classe App no pacote amazingcontrol.app.view, clique com o direto do mouse na tela do código selecione Run As > 1 Java Application. Para rodar nas proximas vezes apenas clique no play verde na parte superior da IDE.

#### Para ser mais produtivo com o eclipse, recomendo um breve [tutorial](http://www.devmedia.com.br/principais-atalhos-do-eclipse/25614)
  
