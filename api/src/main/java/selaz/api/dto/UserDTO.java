package selaz.api.dto;

import selaz.api.entity.user.UserNivel;

public record UserDTO(String useUsername, String usePassword, UserNivel useNivel) {
}
