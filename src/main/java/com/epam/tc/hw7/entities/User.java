package com.epam.tc.hw7.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class User {
    public String name = "Roman";
    public String password = "Jdi1234";
    @Getter
    public String fullName = "ROMAN IOVLEV";
}
