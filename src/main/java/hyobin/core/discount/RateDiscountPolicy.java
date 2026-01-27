package hyobin.core.discount;

import hyobin.core.annotation.MainDiscountPolicy;
import hyobin.core.member.Grade;
import hyobin.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// 컴포넌트 스캔 방식의 경우 붙여줘야 함
@Component
// Qualifier로 매칭할 수 있는 이름 지정, Primary보다 Qualifer가 우선권이 높다.
//@Qualifier("mainDiscountPolicy")
// 우선순위 ex) 메인 DB는 Primary, 보조 DB는 Qualifer
//@Primary
@MainDiscountPolicy
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
