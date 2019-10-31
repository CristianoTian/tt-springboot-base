package com.hy.tt;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * @auther thy
 * @date 2019/10/31
 */
@Component
public class Mylifecycle implements SmartLifecycle {

	private volatile boolean running = false;

	public Mylifecycle() {
		System.out.println("构造方法!!!");
	}


	public void start() {
		System.out.println("lifycycle start");
		running = true;

	}
	public void stop() {
		System.out.println("lifycycle stop");
		running = false;
	}

	public boolean isRunning() {
		return running;
	}

	public int getPhase() {
		return DEFAULT_PHASE;
	}
}
