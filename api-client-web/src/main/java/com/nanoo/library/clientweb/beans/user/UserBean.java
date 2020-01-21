package com.nanoo.library.clientweb.beans.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author nanoo
 * @create 06/12/2019 - 21:12
 */
@Getter @Setter
@NoArgsConstructor
public class UserBean {
    
    @NotNull(message = "Ce champ est requis")
    @Pattern(regexp = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)",
            message = "doit être une adresse mail valide")
    private String username;
    
    @NotNull
    @Size(min = 5, max = 20, message = "doit contenir entre 5 et 20 caractères")
    private String password;
    
}
