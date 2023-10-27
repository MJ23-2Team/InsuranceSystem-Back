package server.api.insurance.businessEducation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EducationStudentService {
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
