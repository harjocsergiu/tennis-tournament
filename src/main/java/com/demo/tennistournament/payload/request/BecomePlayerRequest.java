package com.demo.tennistournament.payload.request;

import com.demo.tennistournament.model.enums.Gender;
import com.demo.tennistournament.model.enums.PrimaryHand;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.time.LocalDate;

import static com.demo.tennistournament.exception.ExceptionMessages.FieldValidation.MIN_2_CHARS;

@Getter
@Setter
@ToString
public class BecomePlayerRequest {

    @NotBlank
    private Long userId;

    private PrimaryHand primaryHand;

    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private Gender gender;

    @NotBlank
    @Size(min = 2, message = MIN_2_CHARS)
    private String nationality;

    public BecomePlayerRequest(Long userId, String primaryHand, String gender, String nationality){
        this.userId = userId;
        this.primaryHand = PrimaryHand.valueOf(primaryHand);
        this.gender = Gender.valueOf(gender);
        this.nationality = nationality;
    }
}
