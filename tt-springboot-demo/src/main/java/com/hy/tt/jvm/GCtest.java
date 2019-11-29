package com.hy.tt.jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther thy
 * @date 2019/11/28
 */
/**
 * 需求：写一段程序，让其运行时的表现为触发5次ygc，然后3次fgc，然后3次ygc，然后1次fgc，请给出代码以及启动参数。
 * VM设置：-Xms41m -Xmx41m -Xmn10m -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
 * -Xms41m 				堆最小值
 * -Xmx41m 				堆最大值
 * -Xmn10m 				新生代大小大小(推荐 3/8)
 * -XX:+UseParallelGC   使用并行收集器
 * @author chenhailong
 *
 *  初始化时：835k(堆内存)
 * 第一次add：3907k
 * 第二次add：6979k
 * 第三次add: eden + survivor1 = 9216k < 6979k + 3072k,区空间不够，开始 YGC
 * YGC  6979k -> 416k(9216k) 表示年轻代 GC前为6979，GC后426k.年轻代总大小9216k
 */
public class GCtest {
    /**
     * 最小的单位
     */
    private static final int UNIT_MB = 1024 * 1024;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        getJvmInfo();
        int count = 1;
        List caches = new ArrayList();
        System.out.println("--初始化时已用堆值:" +  ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed()/1024+"k");
        for (int i = 1; i <= 12; i++){
            if(i==11) {
                System.out.println("--caches准备添加第11次,old区内存不够，开始full GC 前先执行minor GC 第"+5+"次,FGC 第1次(触发条件：【MinorGC后存活的对象超过了老年代剩余空间】)");
            }
              System.out.println("before");
            caches.add(new byte[3 * UNIT_MB]);
             System.out.println("end"); 
            if(i%2==0 && i!=10) {
                System.out.println("--caches添加第"+i+"次后，eden + survivor 的内存不够，开始minor GC 第"+count+"次");
                count++;
            }else {
                System.out.println("--caches添加第"+i+"次结束");
            }
        }
        System.out.println("目前整个堆内存已经36m多，Young区6M多，Old区最大值为32M");
        caches.remove(0);//释放空间，重新添加 ,如果不释放空间，会报错：java.lang.OutOfMemoryError: Java heap space 【这里这样做，主要为了防止数组对象实际大小超过堆大小】
        System.out.println("--FGC开始 第2次（触发条件：晋升到老年代的大小超过了老年代剩余大小）");
        caches.add(new byte[3 * UNIT_MB]);
        System.out.println("本次FGC，移植了Young区的一部分到Old区，导致Young区还有3M左右");
        for (int i = 0; i < 8; i++){//这里是为了下次FGC后，直接减少老年代的内存大小，从而正常YGC
            caches.remove(0);
        }
        System.out.println("--FGC开始 第3次(触发条件:同上)");
        caches.add(new byte[3 * UNIT_MB]);

        for (int i = 0; i < 6; i++){
            caches.add(new byte[3 * UNIT_MB]);
        }
    }

    /**
     * 通过代码打印程序的堆、内存信息
     */
    public static void getJvmInfo() {
        System.out.println("-----------------------JVM-Info-start----------------");

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage mu = memoryMXBean.getHeapMemoryUsage();

        System.out.println("heapInfo:" +  mu);
        System.out.println("初始化堆:" +  mu.getInit()/1024/1024 + "Mb");
        System.out.println("最大堆值:"  +  mu.getMax()/1024/1024 + "Mb");
        System.out.println("已用堆值:" +  mu.getUsed()/1024/1024 + "Mb");

        MemoryUsage none = memoryMXBean.getNonHeapMemoryUsage();
        System.out.println("non-heap Info(非堆内存):" +  none);


        List<String> args = ManagementFactory.getRuntimeMXBean().getInputArguments();
        System.out.println("运行时VM参数:"+args);

        System.out.println("运行时总内存"+Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println("运行时空闲内存"+Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("运行时最大内存"+Runtime.getRuntime().maxMemory()/1024/1024);

        System.out.println("-----------------------JVM-Info-end----------------");
        System.out.println("--");
        System.out.println("--");
        System.out.println("--");
    }

}
