### TOOLS & TECHNOLOGIES
  1. Eclipse/STS
  2. SpringBoot
  3. H2DB
  4. REST API
  5. Swagger

### CONCEPTS/TOPICS COVERED
  1. CRUD Operations using JPA
  2. Swagger Implementation for RESTful API

### HOW TO RUN?
http://localhost:6060/restapi-swagger/hello

### H2 DB Console
http://localhost:6060/restapi-swagger/h2-console

### **Get response as json**
* http://localhost:6060/restapi-swagger/v2/api-docs 

copy the response and paste @ https://editor.swagger.io/

### **View Swagger UI**
* http://localhost:6060/restapi-swagger/swagger-ui.html

### **RESTApi Response**
* http://localhost:6060/restapi-swagger/products
* http://localhost:6060/restapi-swagger/products/100

### TEST CUSTOM EXCEPTIONS
#### CustomExceptionGlobalHandler.handleMethodArgumentNotValid(); - Choose POST method in POSTMAN
``` json
{
  "id": "",
  "name": "dddd S8",
  "category": "Mobile",
  "price": "7777"
}
```
#### CustomExceptionGlobalHandler.handleHttpRequestMethodNotSupported(): - Choose PATCH method
``` json
{
  "id": "222",
  "name": "dddd S8",
  "category": "Mobile",
  "price": "7777"
}
```

#### CustomExceptionGlobalHandler.handleProductNameNotFoundException(): - Choose GET
http://localhost:6060/restapi-swagger/getProductByName/Usha


### CLASSES/INTERFACES/ANNOTATIONS USED
#### CLASSES
1. ResponseEntityExceptionHandler
 
#### INTERFACES
1.

#### ANNOTATIONS
1. ControllerAdvice
2. ExceptionHandler
3. RestControllerAdvice