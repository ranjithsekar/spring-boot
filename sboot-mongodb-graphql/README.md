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
GET: http://localhost:6060/sboot-mongodb-graphql/product/greeting

### Add a Product (use Postman Tool)
POST: http://localhost:6060/sboot-mongodb-graphql/product/add

```json
{
    "id": 100,
    "name": "Samsung Galaxy S10",
    "category": "Mobile",
    "price": 55000
}
```

### Get All products (use Postman Tool)
GET: http://localhost:6060/sboot-mongodb-graphql/product/getall

``` json
{
  getAllProducts{
    id
    name
    price
  }
}
```

### Check your Schema (use Browser)
http://localhost:6060/sboot-mongodb-graphql/graphql/schema.json

### GraphiQL Console (use Browser)
http://localhost:6060/sboot-mongodb-graphql/graphiql

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
