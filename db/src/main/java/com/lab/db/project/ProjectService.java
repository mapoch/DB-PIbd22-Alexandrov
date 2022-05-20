package com.lab.db.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service("projectService")
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Transactional
    public Project findById(int id) {
        return projectRepository.findById(id).get();
    }

    @Transactional
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    @Transactional
    public Integer create(Project project) {
        return projectRepository.save(project).getId();
    }

    @Transactional
    public void update(int id, Project project) {
        Project proj = projectRepository.findById(id).get();
        proj.setRooms(project.getRooms());
        projectRepository.save(proj);
    }

    @Transactional
    public void delete(int id) {
        projectRepository.delete(projectRepository.findById(id).get());
    }
}
