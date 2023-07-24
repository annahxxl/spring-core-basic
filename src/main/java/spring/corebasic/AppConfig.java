package spring.corebasic;

import spring.corebasic.discount.DiscountPolicy;
import spring.corebasic.discount.FixDiscountPolicy;
import spring.corebasic.member.MemberRepository;
import spring.corebasic.member.MemberService;
import spring.corebasic.member.MemberServiceImpl;
import spring.corebasic.member.MemoryMemberRepository;
import spring.corebasic.order.OrderService;
import spring.corebasic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
