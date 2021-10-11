package com.klj.konglearn.demo.delayqueue;

import java.util.Comparator;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 消息体，定义延时策略
 */
public class Message implements Delayed {

    private int id;

    private String body;

    private long executeTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(long executeTime) {
        this.executeTime = executeTime;
    }

    public Message(int id, String body, long delayTime) {
        this.id = id;
        this.body = body;
        this.executeTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.executeTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        Message m = (Message) o;
        return Comparator.comparing(Message::getExecuteTime).compare(this, m);
    }
}
