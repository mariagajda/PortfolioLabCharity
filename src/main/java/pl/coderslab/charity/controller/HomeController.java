package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.DTO.InstitutionPairDTO;
import pl.coderslab.charity.DTO.InstitutionPairDTOMapper;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {
    private final InstitutionRepository institutionRepository;
    private final InstitutionPairDTOMapper institutionPairDTOMapper;
    private final DonationRepository donationRepository;


    public HomeController(InstitutionRepository institutionRepository, InstitutionPairDTOMapper institutionPairDTOMapper, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.institutionPairDTOMapper = institutionPairDTOMapper;
        this.donationRepository = donationRepository;
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

    @ModelAttribute("bagsQuantity")
    public Long getBagsQuantity(){
        Long bagsQuantity = 0L;

//      donationRepository.findAll().stream()
//              .forEach(donation -> bagsQuantity += donation.getQuantity())

        for(Donation donation : donationRepository.findAll()){
            bagsQuantity += donation.getQuantity();
        }
        return bagsQuantity;
    }

    @ModelAttribute("donationsQuantity")
    public Integer getDonationsQuantity(){
        return donationRepository.findAll().size();
    }
}
