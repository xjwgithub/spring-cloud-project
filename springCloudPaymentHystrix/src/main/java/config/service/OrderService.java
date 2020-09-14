package config.service;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.Hystrix;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class OrderService {
	
	public void getPaymentInfoOk() {
		System.out.println("SpringCloudPaymentHystrixApp-->port=8010, method=getPaymentInfoOk");
	}
	
	@HystrixCommand(fallbackMethod = "getPaymentInfoTimeOutFallback",commandProperties = {
			@HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
	})
	public void getPaymentInfoTimeOut() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("SpringCloudPaymentHystrixApp-->port=8010, method=getPaymentInfoTimeOut");
	}
	
	public void getPaymentInfoTimeOutFallback() {
		System.out.println("SpringCloudPaymentHystrixApp-->port=8010, TimeOutFallback!");
	}
	
	@HystrixCommand(fallbackMethod = "getPaymentInfoErrorFallback",commandProperties = {
			@HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启熔断机制
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "2"),//滚动窗口时间内发生熔断所需达到的请求数，默认20次
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),//滚动窗口时间内发生熔断所需达到的降级率，默认是百分之50
			//也就是默认是20*0.5=10次降级后开启熔断
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//开启熔断后恢复half-open状态的时间间隔，默认是5秒；
			//恢复half-open状态后，尝试调用主方法，如果再次降级，继续熔断等待恢复；如果调用成功返回，则恢复closed状态，重新计算滚动窗口内降级率。
			@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "2000")//滚动窗口持续时间，默认10秒
	})
	public void getPaymentInfoError(int i) throws Exception {
		System.out.println("SpringCloudPaymentHystrixApp-->port=8010, method=getPaymentInfoError");
		if(i>0) {
			throw new Exception("模拟异常");
		}
	}
	
	public void getPaymentInfoErrorFallback(int i) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("SpringCloudPaymentHystrixApp-->port=8010, ErrorFallback!");
	}
}
