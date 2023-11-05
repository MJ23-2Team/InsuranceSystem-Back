package server.app.insurance.conduct.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.conduct.dto.EducationStudentDto;
import server.app.insurance.conduct.entity.EducationStudent;
import server.app.insurance.conduct.repository.EducationStudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EducationStudentList {
    private final EducationStudentRepository educationStudentRepository;

    public void add( EducationStudentDto request ){
        educationStudentRepository.save( EducationStudent.of( request ) );
    }

    public EducationStudentDto retrieve( int id ){
        return EducationStudentDto.of( educationStudentRepository.findById( id ).get() );
    }

    public List<EducationStudentDto> retrieveAll(){
        return educationStudentRepository.findAll().stream().map( EducationStudentDto::of).collect( Collectors.toList() );
    }

    public void update( EducationStudentDto request ){
        educationStudentRepository.save( educationStudentRepository.save( EducationStudent.of( request ) ) );
    }

    public void delete( int id ){
        educationStudentRepository.deleteById( id );
    }
}
