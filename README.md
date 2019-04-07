# API do Sistema de Controle de Despesa

O SCD é um sistema de gerenciamento de despesas, que permite a inclusão, alteração, edição e exclusão de despesas cadastradas. O sistema disponibiliza gráficos para auxiliar o usuário a identificar seus maiores gastos por categoria. 

## Tecnologias utilizadas

* [Java](https://www.java.com/pt_BR/) - Linguagem
* [Spring](https://spring.io/projects/spring-boot/) - Framework
* [Maven](https://rometools.github.io/rome/) - Gerenciador de dependência
* [Flyway](https://flywaydb.org/) - Controlador de versão de banco de dados
* [MySQL](https://rometools.github.io/rome/) - Sistema de Gerenciamento de Banco de Dados

## Pré-requisitos
 
* [Java](https://www.java.com/pt_BR/)
* [Maven](https://rometools.github.io/rome/) 
* [MySQL](https://rometools.github.io/rome/)

## Tutoriais de instalação

* Java
  - [Linux](https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-linux-platforms.htm#JSJIG-GUID-737A84E4-2EFF-4D38-8E60-3E29D1B884B8)
  - [Windows ](https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-microsoft-windows-platforms.htm)
  - [MacOSX](https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-macos.htm#JSJIG-GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE)
  
* Instalação do Maven
  - [Linux](https://www.javahelps.com/2017/10/install-apache-maven-on-linux.html)
  - [Windows](https://docs.wso2.com/display/IS323/Installing+Apache+Maven+on+Windows)
  - [MacOSX](https://loiane.com/2015/05/instalando-maven-no-mac-os-yosemite/)
  
* MySQL
  - [Linux](https://support.rackspace.com/how-to/installing-mysql-server-on-ubuntu/)
  - [Windows](https://dev.mysql.com/downloads/installer/)
  - [MacOSX](https://dev.mysql.com/doc/refman/5.7/en/osx-installation-pkg.html)
  
## Executando o projeto
Navegue pelo terminal até a raiz do projeto, até chegar na pasta fpf. Em seguida, execute: 
```
mvn spring-boot:run 
```

## Utilização
Para utilizar os recursos dessa API, configure o [front-end](https://github.com/dev-alves/fpf-front-despesa) da aplicação.
