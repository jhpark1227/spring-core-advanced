package junhyeok.springcoreadvanced.trace.logtrace;

import junhyeok.springcoreadvanced.trace.TraceId;
import junhyeok.springcoreadvanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalLogTrace implements LogTrace {
    private final static String START_PREFIX = "-->";
    private final static String COMPLETE_PREFIX = "<--";
    private final static String EX_PREFIX = "<X-";

    private ThreadLocal<TraceId> traceIdHolder = new ThreadLocal<>();
    @Override
    public TraceStatus begin(String message) {
        syncTraceId();
        TraceId traceId = traceIdHolder.get();
        Long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMs, message);
    }

    @Override
    public void end(TraceStatus traceStatus) {
        complete(traceStatus, null);
    }

    @Override
    public void exception(TraceStatus traceStatus, Exception e) {
        complete(traceStatus, e);
    }

    private void complete(TraceStatus status, Exception e){
        Long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();
        if(e == null){
            log.info("[{}] {}{} time={}ms", traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()),status.getMessage(), resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(), addSpace(EX_PREFIX, traceId.getLevel()),status.getMessage(), resultTimeMs, e.toString());
        }

        releaseTraceId();
    }

    public void releaseTraceId(){
        TraceId traceId = traceIdHolder.get();
        if (traceId.isFirstLevel()){
            traceIdHolder.remove();
        } else {
            traceIdHolder.set(traceId.createPreviousId());
        }
    }

    private String addSpace(String prefix, int level){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<level;i++){
            sb.append((i==level-1)? "|"+prefix : "|    ");
        }
        return sb.toString();
    }

    private void syncTraceId(){
        TraceId traceId = traceIdHolder.get();
        if (traceIdHolder.get() == null){
            traceIdHolder.set(new TraceId());
        } else {
            traceIdHolder.set(traceId.createNextId());
        }
    }
}
