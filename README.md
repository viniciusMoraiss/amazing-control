# Amazing-control
Projeto feito para atender conclusão de semestre da faculdade.

## Configurando o ambiente

* Faça clone do projeto https://github.com/frenangomes/amazing-control.git em algum diretorio
* Faça download do [eclipse](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars1)

## Importando projeto no Eclipse
* Ao abrir o eclipse sera solicitado o workspace, para facilitar escolha o mesmo diretorio que clonou o projeto;
* Importe o projeto clonado: File > Import > Existing Projects into Workspace > Browse > Pasta_do_projeto;
* Adicione a lib do mysql no buildpath do projeto:  Abra a pasta libs dentro do eclipse e clique com direito no mysql, apos clique em build path > add to Build Path

## Atenção:
Em algumas versões do eclipse o projeto importa de forma errada, uma solução é: 
* localizar a pasta dentro do projeto e renomea-la para qualquer para src2. 
* No eclipse, depois do projeto importado, clicar com o direito do mouse encima do projeto > properties > add folder > create new folder. Ira solicitar o nome da pasta, escreva: src/main/java. Clique Ok e depois em apply para salvar as aterações:
* Volte no diretorio do projeto e copie a pasta amazingcontrol dentro da pasta src2/main/java e cole dentro da pasta src/main/java. Apos delete a pasta src2.


## Configurando MySQL
Para facilitar vamos usar uma senha padrão para todos no grupo, portanto:
 * Crie um novo usuario no mysql: entre normalmente com algum usuario que tenha acesso total ao banco (Geralmente é o usuario root), clique em Server > User and Privileges > Add Account. Em login crie o usuario 'amazing' e a senha deixe em branco. Clique na aba Admininstrative Roles e marque a opcao DBA. Após clique em apply.
 * importe o script.sql dentro da pasta do projeto e execute no mysql
 * Crie um usuario:  
 ``` 
USE amazing_control ;

insert into usuarios(name, senha, confirmacaoSenha, ativo) values ("seu_nome", "sua_senha", "sua_senha", true);
  ```
 * Para rodar o projeto no eclipse, localize a classe App no pacote amazingcontrol.app.view, clique com o direto do mouse na tela do código selecione Run As > 1 Java Application. Para rodar nas proximas vezes apenas clique no play verde na parte superior da IDE.

#### Para ser mais produtivo com o eclipse, recomendo um breve [tutorial](http://www.devmedia.com.br/principais-atalhos-do-eclipse/25614)
  
