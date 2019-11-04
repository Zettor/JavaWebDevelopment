package by.ysenko.task4.dao;

public enum  FlowerEnum {
    ID("id"),
    FLOWERS("flowers"),
    BLOSSOM("blossom"),
    CACTUS("cactus"),
    LIANA("liana"),
    NAME("name"),
    SOIL("soil"),
    ORIGIN("origin"),
    GROWING_TIPS("growing_tips"),
    MULTIPLYING("multiplying"),
    VISUAL_PARAMETERS("visual_parameters"),
    TEMPERATURE("temperature"),
    LIGHTING("lighting"),
    WATERING("watering"),
    STEM_COLOR("stem_color"),
    SIZE("size"),
    LEAF_COLOR("leaf_color"),
    LEAF_TYPE("leaf_type"),
    SUBFAMILY("subfamily"),
    FRUITS("fruits"),
    TYPE("type");


    private String value;
    private FlowerEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
