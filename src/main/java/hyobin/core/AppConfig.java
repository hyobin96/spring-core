package hyobin.core;

import hyobin.core.discount.DiscountPolicy;
import hyobin.core.discount.FixDiscountPolicy;
import hyobin.core.discount.RateDiscountPolicy;
import hyobin.core.member.*;
import hyobin.core.order.OrderService;
import hyobin.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 역할에 따른 구현이 잘 보이게 작성
@Configuration
public class AppConfig {

    // name을 지정하지 않으면 메서드 이름으로 Bean이 등록된다.
    @Bean
    public MemberService memberService() {
        // 생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
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
