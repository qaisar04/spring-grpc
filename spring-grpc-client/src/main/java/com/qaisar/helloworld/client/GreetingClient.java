package com.qaisar.helloworld.client;

import com.qaisar.grpc.GreetingServiceGrpc.GreetingServiceBlockingStub;
import com.qaisar.grpc.GreetingServiceOuterClass.HelloRequest;
import com.qaisar.grpc.GreetingServiceOuterClass.HelloResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingClient {

    @GrpcClient("greetingService")
    private GreetingServiceBlockingStub blockingStub;

    public String greet(String name, List<String> hobbies) {
        HelloRequest.Builder request = HelloRequest.newBuilder()
                .setName(name);

        for (String hobby : hobbies) {
            request.addHobbies(hobby);
        }

        HelloResponse response = blockingStub.greeting(request.build());
        return response.getGreeting();
    }
}
