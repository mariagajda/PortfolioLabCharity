package pl.coderslab.charity.DTO;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Donation;

@Component
public class DonationDTOMapper {
    public Donation dtoToDonation(DonationDTO donationDTO){
        Donation donation = new Donation(
                donationDTO.getQuantity(),
                donationDTO.getStreet(),
                donationDTO.getCity(),
                donationDTO.getZipCode(),
                donationDTO.getPhoneNumber(),
                donationDTO.getPickUpDate(),
                donationDTO.getPickUpTime(),
                donationDTO.getPickUpComment(),
                donationDTO.getCategories(),
                donationDTO.getInstitution()
        );
        return donation;
    }
}
