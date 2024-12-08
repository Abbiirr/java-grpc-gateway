import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import com.brainstation.grpc.ApiRouteServiceGrpc;
import com.brainstation.grpc.ApiRouteRequest;
import com.brainstation.grpc.ApiRouteResponse;

@GrpcService
public class ApiRouteGrpcService extends ApiRouteServiceGrpc.ApiRouteServiceImplBase {

    @Override
    public void getApiRoute(ApiRouteRequest request, StreamObserver<ApiRouteResponse> responseObserver) {
        // Example response
        ApiRouteResponse response = ApiRouteResponse.newBuilder()
                .setUri("http://example.com")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}