package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.DTO.InstitutionPairDTO;
import pl.coderslab.charity.DTO.InstitutionPairDTOMapper;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstitutionService {
    private final InstitutionRepository institutionRepository;
    private final InstitutionPairDTOMapper institutionPairDTOMapper;

    public InstitutionService(InstitutionRepository institutionRepository, InstitutionPairDTOMapper institutionPairDTOMapper) {
        this.institutionRepository = institutionRepository;

        this.institutionPairDTOMapper = institutionPairDTOMapper;
    }

    public List<InstitutionPairDTO> getInstitutionPairDTOList() {
        List<Institution> institutionList = institutionRepository.findAll();
        List<InstitutionPairDTO> institutionPairDTOList = new ArrayList<>();
        for (int i = 0; i <= institutionList.size() - 1; i = i + 2) {
            if (institutionList.size() % 2 == 0) {
                institutionPairDTOList.add(institutionPairDTOMapper.toDto(institutionList.get(i), institutionList.get(i + 1)));
            } else {
                if (i < institutionList.size() - 2) {
                    institutionPairDTOList.add(institutionPairDTOMapper.toDto(institutionList.get(i), institutionList.get(i + 1)));
                } else {
                    institutionPairDTOList.add(institutionPairDTOMapper.toDto(institutionList.get(i), null));
                }
            }
        }
        return institutionPairDTOList;
    }
}
