package io.stivaplina.pptool.services;

import io.stivaplina.pptool.domain.Project;
import io.stivaplina.pptool.exception.ProjectIdException;
import io.stivaplina.pptool.exception.ProjectIdExceptionResponse;
import io.stivaplina.pptool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public Project saveOrUpdateProject(Project project){
        String projectIdentifierToUpperCase = project.getProjectIdentifier().toUpperCase();
        try{
            project.setProjectIdentifier(projectIdentifierToUpperCase);
            return projectRepository.save(project);
        }
        catch (Exception e){
            String message = "Project '" + projectIdentifierToUpperCase + "' already exits";
            throw  new ProjectIdException(message);
        }

    }

    public Project findProjectByIdentifier(String projectId){
        String projectIdentifierToUpperCase = projectId.toUpperCase();
        Project project = projectRepository.findByProjectIdentifier(projectIdentifierToUpperCase).orElse(null);
        if(project==null){
            throw new ProjectIdException("Project '" + projectIdentifierToUpperCase + "' does not exits");
        }

        return project;
    }

}
