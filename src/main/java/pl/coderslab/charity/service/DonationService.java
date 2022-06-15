package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

@Service
public class DonationService {
    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Long getBagsQuantity(){
        Long bagsQuantity = 0L;
        //stream - map na quantity -> long -> sum
        for(Donation donation : donationRepository.findAll()){
            bagsQuantity += donation.getQuantity();
        }
        return bagsQuantity;
    }
}
