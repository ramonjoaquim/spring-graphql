# Spring-boot + GraphQL
## Study by graphQL with Spring boot

### Setup project

run project normally 
```bash
mvn spring-boot:run
```

the project has a dependency called *graphiql-spring-boot-starter* with serve a gui client for run querys graphQL
on the port 
```bash
http://localhost:8080/graphiql
```

for h2 console
```bash
http://localhost:8080/h2-console
```

Example for get all trainers 
```graphql
query {
    getAllTrainers {
        id
        name
        age
        gym {
            id
            name
        },
        pokemons {
            id
            name
            category
        },
        insignias {
            id
            name
        }

    }
}
```

Example of Mutation that create a new Trainer
this create a new trainer and return ID created
```graphql
mutation {
    createTrainer(trainer: {name: "Gary", age: 15}) {
        id
    }
}
```
