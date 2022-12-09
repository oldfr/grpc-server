package com.example.grpcserver.service;


import com.example.grpcserver.HelloRequest;
import com.example.grpcserver.HelloResponse;
import com.example.grpcserver.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println("inside overriden method hello()");
        HelloResponse response = HelloResponse.newBuilder().setGreeting("Hello "+ request.getFirstName()+" "+request.getLastName()+". Welcome").build();
        System.out.println("returning :"+response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
