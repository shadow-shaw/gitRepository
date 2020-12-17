package axysis.entity;


import axysis.interfaces.Waiter;

/**
 * @program: spring
 * @description:
 * @author: shaw
 * @create: 2020-07-14 16:07
 **/
public class ManWaiter implements Waiter {

    public void doService() {
        System.out.println("--------------男服务员正在服务---------------");
    }

    public void waiterSex() {
        System.out.println("--------------男性服务员---------------");
    }
}

