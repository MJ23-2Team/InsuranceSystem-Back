package server.api.insurance.common.util;

import server.api.insurance.common.exception.CTimeOutException;

import java.util.concurrent.*;

public class TimeChecker {
    public static <V> V viewNotResponseCheck(Callable<V> callable) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<V> future = executor.submit(callable);
        try {
            return future.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new CTimeOutException("현재 해당 페이지를 불러올 수 없습니다.");
        }
    }

    public static <V> V actorNotResponseCheck(Callable<V> callable, int day, String errorMessage) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<V> future = executor.submit(callable);
        try {
            return future.get(day, TimeUnit.DAYS);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new CTimeOutException(errorMessage);
        }
    }
}
