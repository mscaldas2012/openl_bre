package com.baeldung.openltablets.rules;

public interface IRule {
    Boolean validateCatchment(String state, String county, Integer age);


}