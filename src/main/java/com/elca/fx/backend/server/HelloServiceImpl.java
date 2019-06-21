package com.elca.fx.backend.server;

import com.elca.fx.grpc.HelloRequest;
import com.elca.fx.grpc.HelloResponse;
import com.elca.fx.grpc.HelloServiceGrpc;

import io.grpc.stub.StreamObserver;

/**
 *
 * @author bhr
 */
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(
            HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .append(" living at ")
                .append(request.getAddress())
                .append(" is local worker: ")
                .append(request.getLocal())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}