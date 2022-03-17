package br.com.myvet.controller;

import br.com.myvet.dto.pet.PetCreationRequestDto;
import br.com.myvet.dto.pet.PetSearchingResponseDto;
import br.com.myvet.service.pet.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    @PostMapping
    public void registerPet(@RequestBody PetCreationRequestDto requestDto) {
        petService.registerPet(requestDto);
    }

    @GetMapping
    public List<PetSearchingResponseDto> search(@RequestParam(name = "userId") Long userId) {
        return petService.search(userId);
    }

    //TODO edição de pets
}
