package com.baeldung.openltablets.rules;

public interface IRule {
    //void helloUser(final Case aCase, final Response response);
    Boolean validateCatchement(String state, String county);

}