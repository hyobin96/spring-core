package hyobin.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// bean 이름 지정도 가능
//@Component("memberService2")
@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired  //ac.getBean(MemberRepository.class)해서 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
