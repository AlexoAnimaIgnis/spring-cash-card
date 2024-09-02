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