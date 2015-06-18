package concurrent;

import java.util.*;
import java.util.concurrent.*;
import static java.util.Arrays.asList;

/*
 * 这份是从网上拿来的测试代码
 * 用到了 executor   来实现多线程调度，这个要优于 Runnable接口的Thread 
 * 
 * 内部使用了一些JAVA SE7的新特性
 * 
 */
public class Sums {

	static class Sum implements Callable<Long> {
		private final long from;
		private final long to;

		Sum(long from, long to) {
			this.from = from;
			this.to = to;
		}

		@Override
		public Long call() {
			long acc = 0;
			for (long i = from; i <= to; i++) {
				acc = acc + i;
			}
			return acc;
		}
	}

	//JAVA SE 7  新特性  整数中能在任意位置插入_以提高可读性
	public static void main(String[] args) throws Exception {
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List <Future<Long>> results = executor.invokeAll(asList(
            new Sum(0, 10), new Sum(100, 1_000), new Sum(10_000, 1_000_000)
        ));
        executor.shutdown();
        
        for (Future<Long> result : results) {
            System.out.println(result.get());
        }      
    }}