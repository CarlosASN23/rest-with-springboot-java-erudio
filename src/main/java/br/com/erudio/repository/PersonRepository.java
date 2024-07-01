package br.com.erudio.repository;

import br.com.erudio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person> findAll();
    @Override
    Optional<Person> findById(Long id);

    Person update(Person person);
    Person create(Person person);
    void delete(Long id);
}
