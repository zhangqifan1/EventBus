package com.example.anadministrator.eventbus2;

import java.util.List;

/**
 * Created by 张祺钒
 * on2017/9/5.
 */
//EventBus消息类,一个容器,负责存放一些数据,方便另一个订阅者(接受者),获取消息
public class EventMessage {
    //定义发送的数据类型
    public  String  message;

    //有参构造
    public EventMessage(String message) {
        this.message = message;
    }

    //get方法
    public String getMessage() {
        return message;
    }
    List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
