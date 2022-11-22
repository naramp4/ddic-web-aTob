package io.goorm.ddic;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testMember() throws Exception{
        Member member = new Member();
        Member member2 = new Member();
        Member member3 = new Member();
        member.setUsername("memberA");
        member2.setUsername("hi");
        member3.setUsername("hi3");
        memberRepository.save(member);
        memberRepository.save(member2);
        memberRepository.save(member3);

        memberRepository.deleteOne(2);


    }

}