package compiler;

public class Token {
    String key;
    String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Token(String key, String value) {
        this.key = key;
        this.value = value;

    }
    @Override
    public String toString() {
        return   key + " | " + value + "\n" ;
    }
}
