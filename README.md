#book-store


### init middleware start
```
cd docker
docker-compose up -d
```

### db setup
```
cd docker
docker-compose up flywayClean
```
```
cd docker
docker-compose up flywayMigrate
```

### run application

```
./gradew bootRun
```

### api documentation

```
http://localhost:8080/swagger-ui.html
```
