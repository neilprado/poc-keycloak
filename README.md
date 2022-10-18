## Exemplo de uso do keycloak

#### Como rodar este projeto?
1. Clone este repositório `git clone https://github.com/neilprado/poc-keycloak.git`
2. Instale o [Docker](https://www.docker.com/products/docker-desktop/), caso não o tenha instalado 
   1. No terminal, execute `docker pull postgres`
      1. Ainda no terminal, execute `docker run -d -p 55000:5432 -e POSTGRES_PASSWORD=postgrespw postgres:latest`
      2. Para acessar o root e poder criar a base de dados `docker exec -it {nome_do_container} psql -U postgres` o nome do container pode ser visto no docker desktop
      3. No root do postgres, execute `create database test;`
      4. Feche o terminal
   2. Abra uma instância do terminal e execute `docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:19.0.3 start-dev`
3. Execute `localhost:8080` e insira as credenciais de acesso **admin**/**admin**
4. Crie uma realm em *create realm* e no campo Realm name.
5. Com a realm criada, crie um client no menu Clients e no botão Create client
   1. No campo Client ID, digite um nome e clique *Next* e *Save*
6. É necessário criar um usuário, para tal, no menu Users e no botão Add User.
   1. Insira um nome de usuário no campo Username e clique em Create.
   2. Com o usuário criado, na aba Credentials, clique em Set password, digite uma senha e sua confirmação e desabilite o campo Temporary.
7. Rode o projeto spring boot
8. No [Postman](https://www.postman.com/downloads/) crie uma requisição POST para o path: `http://localhost:8080/realms/{nome_do_realm}/protocol/openid-connect/token` com os seguintes dados do body:
   1. "client_id": "{nome_do_client}"
   2. "username": "{nome_do_usuario}"
   3. "grant_type": "password"
   4. "password": "{password_criado}"
9. Na response, é trazido informações como access_token e refresh_token
10. Abra uma outra requisição no Postman, insira no campo Authorization um Bearer Token com o token trazido na response da requisição anterior e utilize `http://localhost:8081/api/countries/` para realizar um teste se é trazido um status 200.