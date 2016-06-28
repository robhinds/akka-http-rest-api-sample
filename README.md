# akka-http-rest-api-sample
Trying to learn real world Scala, getting started with an Akka-Http API and adding features.

Trying to code it in a real-world application style using good coding standards and organisation, rather than the usual hello world apps that put all the code in one place.

Have created an API endpoint, now adding in Cassandra data storage to back the API and will try out Macwire for DI


### Running via SBT:
- From the project root run: `sbt run`

### Running via Docker
If you have Docker installed locally, run the following from the root project:
- `sbt docker:publishLocal`
- `docker run -p 8080:8080 sample-rest-api:0.0.1` 



### References
- Docker and Scala apps: http://yeghishe.github.io/2015/06/24/running-akka-applications.html
- Getting started with Phantom example code: https://github.com/thiagoandrade6/cassandra-phantom
- Getting started with Phantom tutorial: http://outworkers.com/blog/post/a-series-on-phantom-part-1-getting-started-with-phantom
