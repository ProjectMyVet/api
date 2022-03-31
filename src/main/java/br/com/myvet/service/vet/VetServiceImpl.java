package br.com.myvet.service.vet;

import br.com.myvet.domain.Vet;
import br.com.myvet.dto.user.UserCreationResponseDto;
import br.com.myvet.dto.vet.VetCreationRequestDto;
import br.com.myvet.dto.vet.VetSearchResponseDto;
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
    public VetSearchResponseDto search(Vet vet) {
        return mapper.mapToVetSearchResponseDto(vet);
    }
}
