package com.designpattern.observer;

public class Program {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver A = new ConcreteObserver(subject, "观察者A");
        ConcreteObserver B = new ConcreteObserver(subject, "观察者B");
        ConcreteObserver C = new ConcreteObserver(subject, "观察者C");

        subject.setSubjectState("111");

        subject.attach(new ConcreteObserver("D"));
        subject.attach(new ConcreteObserver("E"));
        subject.attach(new ConcreteObserver("F"));
        subject.setSubjectState("222");
    }
}
