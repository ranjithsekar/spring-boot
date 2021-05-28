### TOOLS & TECHNOLOGIES
  1. Eclipse/STS
  2. SpringBoot
  3. MongoDB
  4. GraphQL
  5. GraphiQL Tool
  6. PostMan Tool

### CONCEPTS/TOPICS COVERED
  1. MongoDB CRUD Operations using GraphQL

### HOW TO RUN?
http://localhost:6060/greeting

### Add a Product (use Postman Tool)
http://localhost:6060/addProduct

```json
{
    "id": "100",
    "name": "Samsung Galaxy S10",
    "type": "Mobile",
    "price": "55000"
}
```

### Get All products (use Postman Tool)
http://localhost:6060/graphql

``` json
{
  getAllProducts{
    id
    name
    price
  }
}
```

### Check your Schema
http://localhost:6060/graphql/schema.json

### GraphiQL Console
http://localhost:6060/graphiql

``` json
{
  getAllProducts{
    id
    name
    price
  }
}

------------
{
  getProductById(id: "100") {
    id
    name
    price
  }
}
```

### References
