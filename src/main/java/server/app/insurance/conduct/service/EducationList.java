package server.app.insurance.conduct.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.conduct.dto.EducationDto;
import server.app.insurance.conduct.entity.Education;
import server.app.insurance.conduct.repository.EducationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EducationList {
    private final EducationRepository educationRepository;

    public void add( EducationDto request ){
        educationRepository.save( Education.of( request ) );
    }

    public EducationDto retrieve( int id ){
        return EducationDto.of( educationRepository.findById( id ).get() );
    }

    public List<EducationDto> retrieveAll(){
        return educationRepository.findAll().stream().map( EducationDto::of ).collect( Collectors.toList() );
    }

    public void update( EducationDto request ){
        educationRepository.save( Education.of( request ) );
    }

    public void delete( int id ){
        educationRepository.deleteById( id );
    }

}
