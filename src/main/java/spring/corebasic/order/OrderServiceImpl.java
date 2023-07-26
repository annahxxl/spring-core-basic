package spring.corebasic.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.corebasic.discount.DiscountPolicy;
import spring.corebasic.discount.FixDiscountPolicy;
import spring.corebasic.discount.RateDiscountPolicy;
import spring.corebasic.member.Member;
import spring.corebasic.member.MemberRepository;
import spring.corebasic.member.MemoryMemberRepository;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
