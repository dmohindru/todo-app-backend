package dev.dmohindru.todoappbackend.constants;

public enum RequestHeaderKey {

    USER_NAME("username"),
    NAME("name");
    private final String keyName;

    RequestHeaderKey(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyName() {
        return this.keyName;
    }
}
