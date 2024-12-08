package org.example.service;

import com.example.productservice.ProductServiceProto;
import com.example.productservice.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {

    @Override
    public void getProductById(ProductServiceProto.ProductRequest request, StreamObserver<ProductServiceProto.ProductResponse> responseObserver) {
        ProductServiceProto.ProductResponse response = ProductServiceProto.ProductResponse.newBuilder()
                .setProductId(request.getProductId())
                .setName("Sample Product")
                .setPrice(19.99)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
