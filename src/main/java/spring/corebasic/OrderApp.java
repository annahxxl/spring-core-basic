package spring.corebasic;

import spring.corebasic.member.Grade;
import spring.corebasic.member.Member;
import spring.corebasic.member.MemberService;
import spring.corebasic.member.MemberServiceImpl;
import spring.corebasic.order.Order;
import spring.corebasic.order.OrderService;
import spring.corebasic.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
