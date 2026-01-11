package hyobin.core;

import hyobin.core.member.MemberRepository;
import hyobin.core.member.MemoryMemberRepository;
import hyobin.core.order.OrderService;
import hyobin.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hyobin.core.member", 컴포넌트 스캔을 시작할 패키지를 지정할 수 있다. 이 패키지를 포함해서 하위 패키지를 모두 탐색한다.
//        basePackageClasses = AutoAppConfig.class, 지정한 클래스의 패키지를 탐색 시작 패키지로 지정한다.
        // 만약 지정하지 않으면 @ComponentScan이 붙은 클래스의 패키지를 시작 패키지로 지정한다.
        // 기존에 만든 AppConfig도 등록되어버리기 때문에 올바른 실습을 위해 일단 제외
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // Bean 이름이 중복되지만 수동 빈이 자동 빈을 오버라이딩한다.
//    @Bean(name = "memoryMemberRepository")
//    public MemberRepository memoryMemberRepository() {
//        return new MemoryMemberRepository();
//    }
}
