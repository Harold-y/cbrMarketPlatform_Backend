package org.chengbing.util;

public class ResultWithStr<T> {
    T t;
    int messageCode;
    String info;

    public ResultWithStr(T t, int messageCode) {
        this.t = t;
        this.messageCode = messageCode;
    }

    public ResultWithStr(T t, int messageCode, String info) {
        this.t = t;
        this.messageCode = messageCode;
        this.info = info;
    }

    @Override
    public String toString() {
        return "ResultWithStr{" +
                "t=" + t +
                ", messageCode=" + messageCode +
                ", info='" + info + '\'' +
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
