#book-store


### init middleware start
```
cd docker
docker-compose up -d
```

### db setup
```
docker-compose up flyway_clean
```
```
docker-compose up flyway_migrate
```

### run application

```
./gradew bootRun
```

### api documentation

```
http://localhost:8080/swagger-ui.html
```
