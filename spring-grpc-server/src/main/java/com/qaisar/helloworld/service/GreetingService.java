package com.qaisar.helloworld.service;

import com.qaisar.grpc.GreetingServiceGrpc;
import com.qaisar.grpc.GreetingServiceOuterClass.HelloRequest;
import com.qaisar.grpc.GreetingServiceOuterClass.HelloResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingService extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println(request);
        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting("Hello, " + request.getName() + "!")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
