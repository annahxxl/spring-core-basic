package spring.corebasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.corebasic.discount.DiscountPolicy;
import spring.corebasic.discount.FixDiscountPolicy;
import spring.corebasic.discount.RateDiscountPolicy;
import spring.corebasic.member.MemberRepository;
import spring.corebasic.member.MemberService;
import spring.corebasic.member.MemberServiceImpl;
import spring.corebasic.member.MemoryMemberRepository;
import spring.corebasic.order.OrderService;
import spring.corebasic.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();

    }

}
