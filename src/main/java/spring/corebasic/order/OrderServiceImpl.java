package spring.corebasic.order;

import spring.corebasic.discount.DiscountPolicy;
import spring.corebasic.discount.FixDiscountPolicy;
import spring.corebasic.member.Member;
import spring.corebasic.member.MemberRepository;
import spring.corebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
