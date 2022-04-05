package br.com.myvet.service.pet;

import br.com.myvet.domain.Pet;
import br.com.myvet.dto.pet.PetCreationRequestDto;
import br.com.myvet.dto.pet.PetEditionRequestDto;
import br.com.myvet.dto.pet.PetSearchingResponseDto;
import br.com.myvet.exception.NotFoundException;
import br.com.myvet.mapper.PetMapper;
import br.com.myvet.repository.PetRepository;
import br.com.myvet.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final UserService userService;

    private final PetRepository repository;

    private final PetMapper mapper;

    @Override
    public void register(PetCreationRequestDto requestDto) {
        final var user = userService.findByIdOrElseThrow(requestDto.getUserId());
        final var pet = mapper.mapFromPetCreationRequestDto(user, requestDto);
        repository.save(pet);
    }

    @Override
    public List<PetSearchingResponseDto> search(Long userId) {
        final var user = userService.findByIdOrElseThrow(userId);
        return repository.findAllByUser(user).stream()
                .map(mapper::mapToPetSearchingResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void edit(Long userId, PetEditionRequestDto requestDto) {
        final var user = userService.findByIdOrElseThrow(userId);
        final Pet pet = repository.findAllByIdAndUser(requestDto.getId(), user)
                .orElseThrow(() -> new NotFoundException("Pet não encontrado"));
        mapper.mapFromPetEditionRequestDto(pet, requestDto);
        repository.save(pet);
    }

    @Override
    public Pet findById(Long petId) {
        return repository.findById(petId)
                .orElseThrow(() -> new NotFoundException("Pet não encontrado"));
    }
}
