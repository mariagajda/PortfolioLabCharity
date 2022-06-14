package pl.coderslab.charity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.DTO.InstitutionPairDTO;
import pl.coderslab.charity.DTO.InstitutionPairDTOMapper;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {
    private final InstitutionRepository institutionRepository;
    private final InstitutionPairDTOMapper institutionPairDTOMapper;


    public HomeController(InstitutionRepository institutionRepository, InstitutionPairDTOMapper institutionPairDTOMapper) {
        this.institutionRepository = institutionRepository;
        this.institutionPairDTOMapper = institutionPairDTOMapper;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        return "index";
    }

    @ModelAttribute("institutionsPairs")
    public List<InstitutionPairDTO> getInstitutionPairs() {
        List<Institution> institutionList = institutionRepository.findAll();
        List<InstitutionPairDTO> institutionPairDTOList = new ArrayList<>();
        for (int i = 0; i <= institutionList.size()-1; i = i + 2) {
            if (institutionList.size() % 2 == 0) {
                institutionPairDTOList.add(institutionPairDTOMapper.toDto(institutionList.get(i), institutionList.get(i + 1)));
            } else {
                if(i < institutionList.size() - 2){
                    institutionPairDTOList.add(institutionPairDTOMapper.toDto(institutionList.get(i), institutionList.get(i + 1)));
                } else {
                    institutionPairDTOList.add(institutionPairDTOMapper.toDto(institutionList.get(i), new Institution()));

                }
            }
        }
        return institutionPairDTOList;
    }
}
