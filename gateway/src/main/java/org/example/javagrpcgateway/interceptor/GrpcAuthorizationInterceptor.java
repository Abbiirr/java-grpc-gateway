@Component
public class GrpcAuthorizationInterceptor implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next) {
        // Perform authorization checks
        String token = headers.get(Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER));
        if (token == null || !isValidToken(token)) {
            call.close(Status.UNAUTHENTICATED.withDescription("Invalid token"), headers);
            return new ServerCall.Listener<>() {};
        }
        return next.startCall(call, headers);
    }

    private boolean isValidToken(String token) {
        // Validate token logic here
        return true;
    }
}
