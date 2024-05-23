package junhyeok.springcoreadvanced.trace.logtrace;

import junhyeok.springcoreadvanced.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);

    void end(TraceStatus traceStatus);

    void exception(TraceStatus traceStatus, Exception e);
}
