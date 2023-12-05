package server.app.insurance.intra.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.intra.dto.EducationStudentDto;
import server.app.insurance.intra.entity.EducationStudent;
import server.app.insurance.intra.repository.EducationStudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EducationStudentList {
    private final EducationStudentRepository educationStudentRepository;

    public void createEducationStudent( EducationStudentDto request ){
        educationStudentRepository.save( EducationStudent.of( request ) );
    }

    public EducationStudentDto retrieveEducationStudent( int id ){
        return EducationStudentDto.of( educationStudentRepository.findById( id ).get() );
    }

    public List<EducationStudentDto> retrieveAllEducationStudent(){
        return educationStudentRepository.findAll().stream().map( EducationStudentDto::of).collect( Collectors.toList() );
    }

    public void updateEducationStudent( EducationStudentDto request ){
        educationStudentRepository.save( educationStudentRepository.save( EducationStudent.of( request ) ) );
    }

    public void deleteEducationStudent( int id ){
        educationStudentRepository.deleteById( id );
    }
}
