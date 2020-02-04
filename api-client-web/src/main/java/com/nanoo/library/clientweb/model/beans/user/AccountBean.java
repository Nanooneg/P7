package com.nanoo.library.clientweb.model.beans.user;

import com.nanoo.library.commonpackage.model.Gender;
import com.nanoo.library.commonpackage.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author nanoo
 * @create 20/01/2020 - 11:34
 */
@Getter @Setter @ToString
@NoArgsConstructor
public class AccountBean {
    
    @Pattern(regexp = "(0|\\\\+33|0033)[1-9][0-9]{8}",
             message = "Le numéro que vous avez renseigné n'est pas valide")
    private String phoneNumber;
    @NotNull(message = "Ce champ est requis")
    @Pattern(regexp = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)",
             message = "L'adresse e-mail que vous avez renseignée n'est pas valide")
    private String email;
    private String password;
    
    private Integer id;
    private String lastName;
    private String firstName;
    private Date birthDate;
    private Gender gender;
    private AddressBean address;
    private Role role;
    private Long clientNumber;
    private Date dateOfCreation;
    private Date dateOfUpdate;
    
    
}
