package org.chengbing.util;

public class ResultWithInfo<T> {

    T t;
    int messageCode;
    Integer info;

    public ResultWithInfo() {
    }

    public ResultWithInfo(T t, int messageCode) {
        this.t = t;
        this.messageCode = messageCode;
    }

    public ResultWithInfo(T t, int messageCode, Integer info) {
        this.t = t;
        this.messageCode = messageCode;
        this.info = info;
    }

    @Override
    public String toString() {
        return "ResultWithInfo{" +
                "t=" + t +
                ", messageCode=" + messageCode +
                ", info=" + info +
                '}';
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(int messageCode) {
        this.messageCode = messageCode;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }
}
