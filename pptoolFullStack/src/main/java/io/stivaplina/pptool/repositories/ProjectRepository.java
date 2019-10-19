package io.stivaplina.pptool.repositories;

import io.stivaplina.pptool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {

    List<Project> findAllByIdIn(List<Long> id);
    Optional<Project> findByProjectIdentifier(String id);
    List<Project> findAll();
}
