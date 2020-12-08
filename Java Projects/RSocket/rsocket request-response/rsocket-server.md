# RSocket Server

This simple project is from a spring.io tutorial written by Ben Wilcock on March 20, 2020. This project aims to introduce users to the request-response, fire-and-forget feature's of RSocket

One way of communicating with the RSocket Serveris using the RSocket CLI (RSC); A tool developed by Toshaki Maki. Alternatively we should & typically would write our own Shell Program to communicate with the server.



## Issues with the RSC

Some issues working with the RSC were that the stringified JSON Objects that we were sending, were being received on the server-side as invalid (missing quotations). In my limited testing it seems to be an issue with RSC directly. The workaround I found was adding three \\" in order for a single double quote to be received by the server

### According to the tutorial we should be using this command to send data
```
java -jar rsc.jar --debug --request --data "{\"origin\":\"Client\",\"interaction\":\"Request\"}" --route request-response tcp://localhost:7000

```

### What we actually need to send
```
java -jar rsc-0.7.0.jar tcp://localhost:7000 --request --route request-response --debug -d "{\"\"\"origin\"\"\":\"\"\"Client\"\"\",\"\"\"interaction\"\"\":\"\"\"Request\"\"\"}"
```
notice the additional \". This has to be done because i believe RSC is parsing the JSON we send even though it should be sent as a string... Regardless the workaround is adding ```\"\"\"``` for every double quote we need.



## References

https://spring.io/blog/2020/03/02/getting-started-with-rsocket-spring-boot-server

https://github.com/making/rsc

https://benwilcock.wordpress.com/2020/06/25/getting-started-with-rsocket-on-spring-boot

https://spring.io/blog/2020/03/23/getting-started-with-rsocket-spring-boot-request-stream