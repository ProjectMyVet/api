package br.com.myvet.service.vet;

import br.com.myvet.domain.Vet;
import br.com.myvet.dto.user.UserCreationResponseDto;
import br.com.myvet.dto.vet.VetCreationRequestDto;
import br.com.myvet.dto.vet.VetSearchingResponseDto;
import br.com.myvet.exception.NotFoundException;
import br.com.myvet.mapper.VetMapper;
import br.com.myvet.repository.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VetServiceImpl implements VetService {

    private final VetRepository repository;

    private final VetMapper mapper;

    @Override
    public UserCreationResponseDto registerVet(VetCreationRequestDto requestDto) {
        final var vet = mapper.mapToVet(requestDto);
        return new UserCreationResponseDto(repository.save(vet).getId());
    }

    @Override
    public VetSearchingResponseDto search(Vet vet) {
        return mapper.mapToVetSearchingResponseDto(vet);
    }

    @Override
    public Vet findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }
}
