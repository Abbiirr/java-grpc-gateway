import com.example.grpc.ServicesProto;
import com.example.grpc.ServicesProto.UserServiceGrpc;
import com.example.grpc.ServicesProto.ProductServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcClient {

    @GrpcClient("user-service")
    private UserServiceGrpc.UserServiceBlockingStub userStub;

    @GrpcClient("product-service")
    private ProductServiceGrpc.ProductServiceBlockingStub productStub;

    public void callServices() {
        // Call UserService
        ServicesProto.UserRequest userRequest = ServicesProto.UserRequest.newBuilder()
                .setUserId("123")
                .build();
        ServicesProto.UserResponse userResponse = userStub.getUserById(userRequest);
        System.out.println("UserService Response: " + userResponse);

        // Call ProductService
        ServicesProto.ProductRequest productRequest = ServicesProto.ProductRequest.newBuilder()
                .setProductId("456")
                .build();
        ServicesProto.ProductResponse productResponse = productStub.getProductById(productRequest);
        System.out.println("ProductService Response: " + productResponse);
    }
}
