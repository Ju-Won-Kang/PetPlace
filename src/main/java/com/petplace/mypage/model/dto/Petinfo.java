package com.petplace.mypage.model.dto;

public class Petinfo {
    private String petName;
    private String petType;
    private String petBirth; // petBirth 필드를 String으로 설정
    private String petGender;

    // 기본 생성자
    public Petinfo() {}

    // 모든 필드를 포함한 생성자
    public Petinfo(String petName, String petType, String petBirth, String petGender) {
        this.petName = petName;
        this.petType = petType;
        this.petBirth = petBirth;
        this.petGender = petGender;
    }

    // Getter와 Setter 메서드
    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetBirth() {
        return petBirth;
    }

    public void setPetBirth(String petBirth) {
        this.petBirth = petBirth;
    }

    public String getPetGender() {
        return petGender;
    }

    public void setPetGender(String petGender) {
        this.petGender = petGender;
    }

    // toString 메서드 (디버깅을 위한 문자열 표현)
    @Override
    public String toString() {
        return "Petinfo{" +
                "petName='" + petName + '\'' +
                ", petType='" + petType + '\'' +
                ", petBirth='" + petBirth + '\'' +
                ", petGender='" + petGender + '\'' +
                '}';
    }
}
