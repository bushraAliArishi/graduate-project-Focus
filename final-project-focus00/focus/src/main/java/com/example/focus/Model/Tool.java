package com.example.focus.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, max = 100, message = "Name should be between 3 and 100 characters")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @NotEmpty(message = "Description cannot be empty")
    @Size(max = 500, message = "Description should not exceed 500 characters")
    @Column(columnDefinition = "varchar(60) not null")
    private String description;

    @NotEmpty(message = "Model number is empty")
    @Column(columnDefinition = "varchar(255) not null")
    private String modelNumber;

    @Column(columnDefinition = "int ")
    private Integer numberOfRentals;

    @NotEmpty(message = "Category cannot be empty")
    @Pattern(regexp = "^(Camera|Lens|Tripods|Lighting|Other)$", message = "Category must be one of the following: Camera, Lens, Tripods, Lighting, Photography Equipment")
    @Column(columnDefinition = "varchar(23) not null")
    private String category;

    @NotEmpty(message = "Brand cannot be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String brand;

    @DecimalMin(value = "0.0", inclusive = false, message = "Rental price must be greater than 0")
    @Column(columnDefinition = "decimal not null")
    private Double rentalPrice;

    //@NotEmpty(message = "Image URL cannot be empty")
    //@Pattern(regexp = "^(https?|ftp)://[^\s/$.?#].[^\s]*$", message = "Image URL must be a valid URL")
    @Column(columnDefinition = "varchar(255) not null")
    private String imageURL;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photographer_id")
    private Photographer photographer;
}