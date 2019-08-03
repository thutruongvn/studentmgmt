package edu.mum.cs.cs425.studentmgmt.repository;

import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends CrudRepository<Transcript, Integer> {
}
