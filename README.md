# spring-cash-card
Demo Application from Spring Academy

### Implementing GET

#### REST , CRUD and HTTP

REST - Representational State Transfer. In a RESTful system,
data objects are called Resource Representations, purpose of
the RESTFUL API is to manage these so called resources.

REST is a way to manage the values of things which can be
accessed via an API.

##### CRUD
CRUD stands for Create, Read, Update, Delete which refers to the
basic operations that can be done with the resources.
##### HTTP (Hyper-text Transfer Protocol)
Protocol associated with REST. In HTTP, client sends a request
to a URI. Web Server receives teh request and routes it to a request handler.
Handler creates a response and sends it back to the caller.

- for CREATE : use HTTP POST method
- for READ: use HTTP GET method
- for UPDATE: use HTTP PUT method
- for DELETE: use HTTP DELETE method

##### Request Body
Following REST conventions, when creating or updating a resource
we need to submit data to the API. This data is referred to as
REQUEST BODY which is a requirement for HTTP POST and HTTP PUT method.

#### REST in Spring Boot

Spring Annotations and Component Scan: You can direct Spring to
manage, configure and instantiate objects which we often refer to as
Spring Beans. With Spring Annotation, spring can create an instance
of the class during the Spring Component Scan phase upon application startup.
The beans that were created are stored in Spring's IOC Container which
can be injected to any part of the code that requires it.


#### Spring Web Controllers
Requests are handled by Controllers (@RestControllers). A controller method can be
designated a handler method to be called when a request that the method knows how
to handle is received
@GetMapping for example, tells the Spring that GET requests/read requests should be handled
by method annotated with @GetMapping.
```java
@GetMapping("/cashcards/{requestedId}")
private CashCard findById(Long requestedId) {
}

```
To get the value of the requestId parameter, we can use @PathVariable annotation to allow
Spring to inject the correct value to the requestedId variable.
```java
@GetMapping("/cashcards/{requestedId}")
private CashCard findById(@PathVariable Long requestedId) {
}

```

Rest convention states that response needs to contain in a body and a response code of 200 (if successful).
ResponseEntity is provided by Spring Web to help us create response entities.
```java
@RestController
class CashCardController {
  @GetMapping("/cashcards/{requestedId}")
  private ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
     CashCard cashCard = /* Here would be the code to retrieve the CashCard */;
     return ResponseEntity.ok(cashCard);
  }
}

```

### Repositories and Spring Data

#### Controller Repository Architecture

Separation of Concerns principle state that well-designed software should be MODULAR. Common architectural
patterns that separates the functions is called Layered Architecture.

#### Spring Data's CRUD Repository
Spring Data is responsible for the implementation of the CRUD operations during the IOC container
startup time. This repository, upon runtime, will be exposed as another bean that we can reference whenever
needed in the application. Here's complete implementation of CRUD operations. CrudRepository generates SQL stements
to read and write your data.
```java
interface CashCardRepository extends CrudRepository<CashCard, Long> {
}

```

Spring Data has many implementations for a variety of relational and non-relational database technologies, and 
has various abstraction on top of those technologies which are commonly known as ORM (Object Relational Mapping)

### Implementing POST

#### Idempotence and HTTP

idempotent requests are requests that can be performed multiple times but still yields the same results and
doesn't change the internal state of the server.

Idempotent methods:
1. GET
2. PUT
3. DELETE

Note: POST and PATCH are not idempotent.

#### POST Request and Response

Request
- method: POST
- URI
- POST method allows body (usually JSON representation of an object)
Response
- HTTP 201 status code means CREATED
- header: location of the newly created resource
- 
### Returning List of Objects
- crud repository has findAll method to fetch all the objects in the database
- 
```java
@GetMapping()
private ResponseEntity<Iterable<CashCard>> findAll() {
return ResponseEntity.ok(cashCardRepository.findAll());
}

```

#### Pagination and Sorting
utilize PagingAndSortingRepository, which is a specialized version of the CrudRepository, that provides
Paging and Sorting functionality. Pagination is used by specifying the page length and page index. Spring Data provides
PageRequest and Sort for these functionality.
Example:
```java
Page<CashCard> page2 = cashCardRepository.findAll(
    PageRequest.of(
        1,  // page index for the second page - indexing starts at 0
        10, // page size (the last page might have fewer items)
        Sort.by(new Sort.Order(Sort.Direction.DESC, "amount"))));
```
