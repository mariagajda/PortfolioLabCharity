package pl.coderslab.charity.DTO;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Institution;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DonationDTO {
    @Min(1)
    @Max(10)
    @NotNull
    private Integer quantity;

    @Size(min=2, message = "{pattern.street}")
    @NotNull
    @NotBlank
    private String street;

    @Size(min=2, message = "{pattern.city}")
    @NotNull
    @NotBlank
    private String city;

    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$", message = "{pattern.zipCode}")
    @NotNull
    @NotBlank
    private String zipCode;

    @NotNull
    @NotBlank
    @Pattern(regexp = "(?<!\\w)(\\(?(\\+|00)?48\\)?)?[ -]?\\d{3}[ -]?\\d{3}[ -]?\\d{3}(?!\\w)", message = "{pattern.phonenumber}")
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Future
    private LocalDate pickUpDate;

    @NotNull
    private LocalTime pickUpTime;

    private String pickUpComment;

    @NotNull
    private List<Category> categories;

    @NotNull
    private Institution institution;


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}

