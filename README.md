### Introduction
Backend for todo app

### Resources
- [MongoDB entity relation modeling](https://spring.io/blog/2021/11/29/spring-data-mongodb-relation-modelling)
- [Enabling @Created and @LastModifiedDate](https://bootify.io/mongodb/created-and-last-modified-date-in-spring-data-mongodb.html)

### Keycloak

Start keycloak server
```shell
./kc.sh start-dev --http-port 8180
```

All Config url
http://localhost:8180/realms/todoapp/.well-known/openid-configuration

[Add custom attributes to keycloak access token](https://medium.com/@lakshminp/adding-user-attributes-to-jwt-token-in-keycloak-f3981b7df310)