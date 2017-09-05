package com.example.anadministrator.eventbus;

/**
 * Created by 张祺钒
 * on2017/9/5.
 */

//EventBus消息类,一个容器,负责存放一些数据,方便另一个订阅者(接受者),获取消息
public class EventBusMessage {
    //定义了发送类型
    public String Message;

    //有参构造
    public EventBusMessage(String message) {
        Message = message;
    }

    //写一个GET方法
    public String getMessage() {
        return Message;
    }
}
