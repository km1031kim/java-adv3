package parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class ParallelMain5 {
    public static void main(String[] args) throws InterruptedException {
        // 병렬 수준 3으로 제한
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");
        System.out.println("ForkJoinPool.commonPool() = " + ForkJoinPool.commonPool());

        // 요청 풀 추가
        ExecutorService requestPool = Executors.newFixedThreadPool(100);
        int nThreads = 3;
        for (int i = 0; i < nThreads; i++) {
            String requestName = "request" + i;
            requestPool.submit(() -> logic(requestName));
            Thread.sleep(100); // 스레드 순서를 확인하기 위해 약간 대기
        }
        requestPool.close();

    }

    private static Object logic(String requestName) {
            return null;
    }
}
