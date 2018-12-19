package com.designpattern.observer;

public class Program {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

       /* ConcreteObserver A = new ConcreteObserver(subject, "观察者A");
        ConcreteObserver B = new ConcreteObserver(subject, "观察者B");
        ConcreteObserver C = new ConcreteObserver(subject, "观察者C");

        subject.setSubjectState("111");*/

        subject.attach(new ConcreteObserver("D"){
            @Override
            public void update() {
                System.out.println(this.name + "------xxxxx");
                super.update();
            }
        });



        subject.attach(new ConcreteObserver("E"));
        subject.attach(new ConcreteObserver("F"));
        subject.setSubjectState("222");
    }

    static class ConcreteObserver implements Observer{


        public ConcreteObserver(String name) {
            this.name = name;
        }

        @Override
        public void update() {

        }

        Subject subject;
        String name;
        String observerState;

        @Override
        public void setSubject(Subject concreteSubject) {
            this.subject = concreteSubject;
        }

        @Override
        public void setObserverState(String observerState) {
            this.observerState = observerState;
        }
    }
}
