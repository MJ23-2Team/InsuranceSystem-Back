package server.app.insurance.user.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.app.insurance.user.employee.entity.AdviceNote;
import server.app.insurance.user.employee.dto.AdviceNoteDto;
import server.app.insurance.user.employee.repository.AdviceNoteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AdviceNoteList {
    private final AdviceNoteRepository adviceNoteRepository;

    public void createAdviceNote( AdviceNoteDto request ){
        adviceNoteRepository.save( AdviceNote.of( request ) );
    }

    public AdviceNoteDto retrieveAdviceNote( int id ){
        return AdviceNoteDto.of( adviceNoteRepository.findById( id ).get() );
    }

    public List<AdviceNoteDto> retrieveAllAdviceNote(){
        return adviceNoteRepository.findAll().stream().map( AdviceNoteDto::of ).collect(Collectors.toList());
    }
    public List<AdviceNoteDto> retrieveAdviceNoteByCustomerId( int customerId ){
        return adviceNoteRepository.findByCustomerId( customerId ).stream().map( AdviceNoteDto::of ).collect( Collectors.toList() );
    }

    public void updateAdviceNote( AdviceNoteDto request ){
        adviceNoteRepository.save( AdviceNote.of( request ) );
    }

    public void deleteAdviceNote( int id ){
        adviceNoteRepository.deleteById( id );
    }
}
