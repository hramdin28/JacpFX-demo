package com.elca.fx.backend.server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 *
 * @author bhr
 */
public class GrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new HelloServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}
