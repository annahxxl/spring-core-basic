package spring.corebasic;

import spring.corebasic.discount.FixDiscountPolicy;
import spring.corebasic.member.MemberService;
import spring.corebasic.member.MemberServiceImpl;
import spring.corebasic.member.MemoryMemberRepository;
import spring.corebasic.order.OrderService;
import spring.corebasic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
