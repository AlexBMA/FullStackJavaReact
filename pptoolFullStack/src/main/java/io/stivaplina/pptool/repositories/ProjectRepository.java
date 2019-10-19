package io.stivaplina.pptool.repositories;

import io.stivaplina.pptool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {

    List<Project> findAllByIdIn(List<Long> id);
}
