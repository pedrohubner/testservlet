package com.user.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private final String id;
    private final String name;
    private final String email;
}
