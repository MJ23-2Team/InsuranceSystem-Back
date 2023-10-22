package server.api.insurance.contract;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AdviceNoteService {
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
