package com.pet.home.test;

import com.pet.common.entity.PetReply;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<PetReply> list = new ArrayList<>();
        PetReply petReply = new PetReply();
        test(petReply);
        list.add(petReply);
        System.out.println(petReply.getRpId());
        test1(petReply);
        System.out.println(petReply.getRpId());
    }

    public static PetReply test(PetReply petReply){
        petReply.setRpId("123");
        return petReply;
    }
    public static PetReply test1(PetReply petReply){
        petReply.setRpId("555");
        return petReply;
    }
}
