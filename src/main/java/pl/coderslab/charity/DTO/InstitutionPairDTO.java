package pl.coderslab.charity.DTO;

public class InstitutionPairDTO {
    private String nameFirst;
    private String descriptionFirst;

    private String nameSecond;
    private String descriptionSecond;


    public InstitutionPairDTO(String nameFirst, String descriptionFirst, String nameSecond, String descriptionSecond) {
        this.nameFirst = nameFirst;
        this.descriptionSecond = descriptionSecond;
        this.nameSecond = nameSecond;
        this.descriptionFirst = descriptionFirst;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getDescriptionSecond() {
        return descriptionSecond;
    }

    public void setDescriptionSecond(String descriptionSecond) {
        this.descriptionSecond = descriptionSecond;
    }

    public String getNameSecond() {
        return nameSecond;
    }

    public void setNameSecond(String nameSecond) {
        this.nameSecond = nameSecond;
    }

    public String getDescriptionFirst() {
        return descriptionFirst;
    }

    public void setDescriptionFirst(String descriptionFirst) {
        this.descriptionFirst = descriptionFirst;
    }

    @Override
    public String toString() {
        return "InstitutionPairDTO{" +
                "nameFirst='" + nameFirst + '\'' +
                ", descriptionSecond='" + descriptionSecond + '\'' +
                ", nameSecond='" + nameSecond + '\'' +
                ", descriptionFirst='" + descriptionFirst + '\'' +
                '}';
    }
}
