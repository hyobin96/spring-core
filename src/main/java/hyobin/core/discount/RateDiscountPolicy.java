package hyobin.core.discount;

import hyobin.core.member.Grade;
import hyobin.core.member.Member;
import org.springframework.stereotype.Component;

// 컴포넌트 스캔 방식의 경우 붙여줘야 함
@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
