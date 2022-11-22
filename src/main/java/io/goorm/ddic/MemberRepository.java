package io.goorm.ddic;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

    public int save(Member member){
        em.persist(member);
        return member.getId();
    }

    public Member find(int id){
        return em.find(Member.class, id);
    }

    public void deleteAll(){
        em.createQuery("delete from Member m").executeUpdate();
    }

    public void deleteOne(int id){
        em.createQuery("delete from Member m where m.id = :id").setParameter("id", id).executeUpdate();
    }
}
