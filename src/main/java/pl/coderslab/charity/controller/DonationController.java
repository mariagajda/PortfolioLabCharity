package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.charity.DTO.DonationDTO;
import pl.coderslab.charity.DTO.DonationDTOMapper;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;

@Controller
//@RequestMapping("/form")
public class DonationController {
    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationDTOMapper donationDTOMapper;
    private final DonationRepository donationRepository;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationDTOMapper donationDTOMapper, DonationRepository donationRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationDTOMapper = donationDTOMapper;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("institutions", institutionRepository.findAll());
        model.addAttribute("donationDTO", new DonationDTO());
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String saveDonation(Model model, @Valid DonationDTO donationDTO, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryRepository.findAll());
            model.addAttribute("institutions", institutionRepository.findAll());
            return "form";
        }
        donationRepository.save(donationDTOMapper.dtoToDonation(donationDTO));
        return "form-confirmation";
    }

}
