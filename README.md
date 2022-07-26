# aws-tools-camel Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/aws-tools-camel-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Camel AWS 2 Lambda ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/aws2-lambda.html)): Manage and invoke AWS Lambda functions using AWS SDK version 2.x
- RESTEasy Classic JSON-B ([guide](https://quarkus.io/guides/rest-json)): JSON-B serialization support for RESTEasy Classic
- Camel AWS 2 Elastic Container Service (ECS) ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/aws2-ecs.html)): Manage AWS ECS cluster instances using AWS SDK version 2.x
- Camel AWS 2 Key Management Service (KMS) ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/aws2-kms.html)): Manage keys stored in AWS KMS instances using AWS SDK version 2.x
- Camel AWS 2 S3 Storage Service ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/aws2-s3.html)): Store and retrieve objects from AWS S3 Storage Service using AWS SDK version 2.x

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
