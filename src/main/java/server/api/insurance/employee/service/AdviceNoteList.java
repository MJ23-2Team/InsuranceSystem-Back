package server.api.insurance.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.api.insurance.employee.entity.AdviceNote;
import server.api.insurance.employee.dto.AdviceNoteDto;
import server.api.insurance.employee.repository.AdviceNoteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AdviceNoteList {
    private final AdviceNoteRepository adviceNoteRepository;

    public void add( AdviceNoteDto request ){
        adviceNoteRepository.save( AdviceNote.of( request ) );
    }

    public AdviceNoteDto retrieve( int id ){
        return AdviceNoteDto.of( adviceNoteRepository.findById( id ).get() );
    }

    public List<AdviceNoteDto> retrieveAll(){
        return adviceNoteRepository.findAll().stream().map( AdviceNoteDto::of ).collect(Collectors.toList());
    }

    public void update( AdviceNoteDto request ){
        adviceNoteRepository.save( AdviceNote.of( request ) );
    }

    public void delete( int id ){
        adviceNoteRepository.deleteById( id );
    }
}
