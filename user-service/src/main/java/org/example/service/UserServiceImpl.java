import com.example.grpc.ServicesProto;
import com.example.grpc.ServicesProto.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void getUserById(ServicesProto.UserRequest request, StreamObserver<ServicesProto.UserResponse> responseObserver) {
        // Mocking user data
        ServicesProto.UserResponse response = ServicesProto.UserResponse.newBuilder()
                .setUserId(request.getUserId())
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
