package hyobin.core;

import hyobin.core.member.Grade;
import hyobin.core.member.Member;
import hyobin.core.member.MemberService;
import hyobin.core.member.MemberServiceImpl;
import hyobin.core.order.Order;
import hyobin.core.order.OrderService;
import hyobin.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
