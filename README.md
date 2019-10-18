# hexagonal-architecture
The hexagonal architecture is one more approach to create maintainable software solutions (and it can be one more way to shoot yourself in the foot).
The main idea is to separate core logic (business logic and domain) from frameworks.
Usually, the first part is called inside and the last one is called outside. 
Inside provides a port to communicate with it, and at the same time, outside provides the implementation of this port called the adapter.
This is why this particular development style has another name — the ports and adapters architecture.

## Advantages 
- Ability to support multiple channels
- Flexibility in choice of channels
- Easy testing of core logic by the mock outside part

## Implementation
Speaking of this implementation style in Java, it is easy to imagine that the classic interface plays a role in the port. 
Therefore, the adapter (the outside part) is the implementation of the current interface. 
This concept will be shown in the following simple Spring Boot application that will simulate the work of some stock (add/get some orders). 
The core of our app consists of business logic [OrderService](https://github.com/alexkirnsu/hexagonal-architecture/blob/master/src/main/java/com/alexkirnsu/hexarch/inside/core/OrderService.java) 
and the domain part [Order](https://github.com/alexkirnsu/hexagonal-architecture/blob/master/src/main/java/com/alexkirnsu/hexarch/inside/domain/Order.java).

Of course, it is a far-fetched example, but I suppose it helps to understand the concept in a simple way. As I previously said, our inside part should offer a port to integrate with it. 
In this specific case, our port is  [OrderDao](https://github.com/alexkirnsu/hexagonal-architecture/blob/master/src/main/java/com/alexkirnsu/hexarch/inside/port/OrderDao.java).

In this way, all repositories (the outside part) implement this interface and can be integrated with our inside part. [OrderDaoImpl](https://github.com/alexkirnsu/hexagonal-architecture/blob/master/src/main/java/com/alexkirnsu/hexarch/outside/adapter/OrderDaoImpl.java) is a simple implementation of the following interface.

Thus, we have a typical example of a pair `(port, adapter) = (OrderDao , OrderDaoImpl)`, which is a major concept of the hexagonal architecture.

## Test
As was mentioned previously, a pleasing benefit of considering this architecture style is that it is easy to test the business logic of our software with mock integration points. You can see that "complex" business logic lays in the `isMajor(int id)` method of our `OrderService`. 
Let us mock `OrderDao` and test this logic. You could find simple unit test in [OrderServiceTest](https://github.com/alexkirnsu/hexagonal-architecture/blob/master/src/test/java/com/alexkirnsu/hexarch/OrderServiceTest.java).

## Conclusion
The hexagonal architecture offers efficient tools (ports/adapters) to isolate the business logic of our application from outside elements. Additionally, it leads to flexibility in the testing of our app and enhances the number of possible integration points.

Mirror of the note in [DZone](https://dzone.com/articles/simple-example-of-hexagonal-architecture-in-java)
