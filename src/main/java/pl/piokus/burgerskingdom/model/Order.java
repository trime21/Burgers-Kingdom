package pl.piokus.burgerskingdom.model;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Burger_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placed_At;

    @NotBlank(message = "Podanie imienia i nazwiska jest obowiązkowe")
    private String delivery_Name;

    @NotBlank(message = "Podanie ulicy jest obowiązkowe")
    private String delivery_Street;

    @NotBlank(message = "Podanie miejscowości jest obowiązkowe")
    private String delivery_City;

    @NotBlank(message = "Podanie województwa jest obowiązkowe")
    private String delivery_State;

    @NotBlank(message = "Podanie kodu pocztowego jest obowiązkowe")
    private String delivery_Zip;

    @CreditCardNumber(message = "To nie jest prawidłowy numer karty kredytowej.")
    private String cc_Number;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Wartość musi być w formacie MM/RR")
    private String cc_Expiration;

    @Digits(integer = 3, fraction = 0, message = "nieprawidłowy kod CVV.")
    private String cc_CVV;

    @ManyToMany(targetEntity = Burger.class)
    private List<Burger> burger = new ArrayList<>();

    public void addDesign(Burger design) {
        this.burger.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placed_At = new Date();
    }
}
