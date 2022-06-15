package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.DTO.InstitutionPairDTO;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
public class HomeController {
    private final DonationRepository donationRepository;
    private final InstitutionService institutionService;
    private final DonationService donationService;


    public HomeController(DonationRepository donationRepository, InstitutionService institutionService, DonationService donationService) {
        this.donationRepository = donationRepository;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("institutionsPairs", institutionService.getInstitutionPairDTOList());
        model.addAttribute("bagsQuantity", donationService.getBagsQuantity());
        model.addAttribute("donationsQuantity", donationRepository.findAll().size());
        return "index";
    }

}
