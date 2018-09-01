package lb.zad18_1;

public enum Category {
    ART_SPOZYWCZE("art. spożywcze"),
    ART_GOSP_DOMOWEGO("art. gosp. domowego"),
    INNE("inne");

    public final String name;

    Category(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }


    public static Category getByName(String name) {
        for (Category category : Category.values()) {
            if (category.getName().equalsIgnoreCase(name)) {
                return category;
            }

        }
        return null;
    }
}
