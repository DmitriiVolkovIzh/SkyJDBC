package sky.project.enums;

public enum Position {
    DIRECTOR("Директор"), ENGINEER("Инженер"),
    CLEANER("Уборщик"), DEVELOPER("Разработчик"),
    WELDER("Сварщик");

    private final String description;

    Position(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

