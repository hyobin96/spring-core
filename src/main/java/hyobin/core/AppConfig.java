package hyobin.core;

import hyobin.core.discount.DiscountPolicy;
import hyobin.core.discount.FixDiscountPolicy;
import hyobin.core.discount.RateDiscountPolicy;
import hyobin.core.member.*;
import hyobin.core.order.OrderService;
import hyobin.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration을 붙이면 AppConfig@CGLIB를 만들어서 Bean으로 등록된 객체 호출을 가로채 싱글톤을 보장한다.
// 역할에 따른 구현이 잘 보이게 작성
@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()

    // name을 지정하지 않으면 메서드 이름으로 Bean이 등록된다.
    // factory method 방법
    @Bean
    public MemberService memberService() {
        // 생성자 주입
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return new OrderServiceImpl();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
