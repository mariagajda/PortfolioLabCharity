package pl.coderslab.charity.DTO;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Institution;

@Component
public class InstitutionPairDTOMapper {
    public InstitutionPairDTO toDto(Institution institution1, Institution institution2) {
        String nameFirst = institution1.getName();
        String descriptionFirst = institution1.getDescription();
        if (institution2 != null) {
            String nameSecond = institution2.getName();
            String descriptionSecond = institution2.getDescription();
            return new InstitutionPairDTO(nameFirst, descriptionFirst, nameSecond, descriptionSecond);
        }
        return new InstitutionPairDTO(nameFirst, descriptionFirst, null, null);
    }
}
