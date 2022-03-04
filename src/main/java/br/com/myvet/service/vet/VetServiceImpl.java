package br.com.myvet.service.vet;

import br.com.myvet.domain.Vet;
import br.com.myvet.dto.vet.VetCreationRequestDto;
import br.com.myvet.mapper.vet.VetMapper;
import br.com.myvet.repository.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VetServiceImpl implements VetService {

    private final VetRepository repository;

    private final VetMapper mapper;

    @Override
    public void registerVet(VetCreationRequestDto requestDto) {
        final var vet = mapper.mapToVet(requestDto);
        repository.save(vet);
    }
}
