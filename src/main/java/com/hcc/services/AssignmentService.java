package com.hcc.services;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AssignmentService {
    @Autowired
    AssignmentRepository assignmentRepository;

    public Set<Assignment> getAssignmentsByUser(User user) {
        return assignmentRepository.findByUser(user);
    }

    public Assignment getAssignmentById(Long id) {
        return assignmentRepository.findById(id).orElse(new Assignment());
    }

    public Assignment updateAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Assignment createAssignment(User user) {
        Assignment assignment = new Assignment();
        assignment.setUser(user);
        return assignmentRepository.save(assignment);
    }
}
