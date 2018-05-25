package com.three.base.userweb.thread;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author:luiz
 * @Date: 2018/4/12 10:20
 * @Descripton:
 * @Modify :
 **/
public class ThreadDemo {
    private static String getFirstResult(String question, List<String> engines) {

        AtomicReference<String> result = new AtomicReference<>();

       /* for(String base: engines) {

            String url = base + question;

            new Thread(() -> {

                result.compareAndSet(url, question);

            }).start();

        }
*/
        String url = "9999" + question;
        result.compareAndSet(url, question);
      //  while(result.get() == null); // wait for some result to appear

        return result.get();

    }

    public static void main(String[] args) {
        List engines= Lists.newArrayList();
        for(int i=1;i<=10;i++){
            engines.add(i+"");
        }
        System.err.println(ThreadDemo.getFirstResult("4444",engines));
    }
}
