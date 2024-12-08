package org.example.service;

import com.example.grpc.ServicesProto;
import com.example.grpc.ServicesProto.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {

    @Override
    public void getProductById(ServicesProto.ProductRequest request, StreamObserver<ServicesProto.ProductResponse> responseObserver) {
        // Mocking product data
        ServicesProto.ProductResponse response = ServicesProto.ProductResponse.newBuilder()
                .setProductId(request.getProductId())
                .setName("Sample Product")
                .setPrice(19.99)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
