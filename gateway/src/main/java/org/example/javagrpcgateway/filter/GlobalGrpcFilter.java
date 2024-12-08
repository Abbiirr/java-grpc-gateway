@Slf4j
@Component
public class GlobalGrpcFilter implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next) {
        log.info("Request to {} with headers {}", call.getMethodDescriptor().getFullMethodName(), headers);
        return next.startCall(call, headers);
    }
}
