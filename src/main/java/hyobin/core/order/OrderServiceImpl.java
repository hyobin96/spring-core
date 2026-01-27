package hyobin.core.order;

import hyobin.core.annotation.MainDiscountPolicy;
import hyobin.core.discount.DiscountPolicy;
import hyobin.core.discount.FixDiscountPolicy;
import hyobin.core.member.Member;
import hyobin.core.member.MemberRepository;
import hyobin.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

//    이 방식도 가능하지만 권장하지는 않는다. 테스트 코드에서 스프링 컨테이너 없이 테스트를 할 수 없다.
//    @Autowired
//  final을 넣으면 의존관계 주입 누락의 경우 컴파일 오류가 난다.
    private final MemberRepository memberRepository;
//    @Autowired
    private final DiscountPolicy discountPolicy;

//    생성자가 하나라면 @Autowired가 없어도 주입이 된다.
//    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
//        this.discountPolicy = rateDiscountPolicy;
    }

//    일반 메서드 주입, 잘 사용하지 않음
//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    // setter 방식 의존관계 주입
//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy;

//    @Autowired(required = false)
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
