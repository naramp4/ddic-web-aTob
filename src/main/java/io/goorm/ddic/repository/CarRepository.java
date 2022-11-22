package io.goorm.ddic.repository;

import io.goorm.ddic.domain.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CarRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Car car){
        em.persist(car);
    }

    public Car findOne(int id){
        return em.find(Car.class, id);
    }

    public List<Car> findAll(){
        return em.createQuery("select c from Car c", Car.class).getResultList();
    }

    public void deleteAll(){
        em.createQuery("delete from Car c").executeUpdate();
    }

    public void deleteOne(int id){
        em.createQuery("delete from Car c where c.id = :id").setParameter("id", id).executeUpdate();
    }


}
