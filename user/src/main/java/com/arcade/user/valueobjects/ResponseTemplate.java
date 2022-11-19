package com.arcade.user.valueobjects;

import com.arcade.user.entity.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {
    private UserModel user;
    private Department department;
}
