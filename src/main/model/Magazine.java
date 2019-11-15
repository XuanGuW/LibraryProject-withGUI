package model;

public class Magazine extends AbstractBook {

    private String publicationYear;

    public Magazine(String name, String publicationYear) {
        this.name = name;
        this.publicationYear = publicationYear;
    }

    public String getPublicationYear() {
        return publicationYear;
    }


    @Override
    public String toString() {
        return  name + " " + publicationYear;
    }


}
