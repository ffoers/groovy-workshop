package exercises.one
/**
 * Your task is simple:
 * Use whatever Groovy knowledge you have acquired and simplify this to a concise Groovy class.
 * Use the Spec JavaLikeSpec to control your work.
 */
public class JavaLike {
    String identifier = null;
    BigInteger identifierLength = null;

    String getIdentifier() {
        return identifier;
    }

    void setIdentifier(String identifier) {
        if (identifier != null) {
            this.identifier = identifier;
            this.identifierLength = identifier.length();
        } else {
            this.identifier = identifier;
            this.identifierLength = null;
        }
    }

    BigInteger getIdentifierLength() {
        return identifierLength
    }

    public JavaLike(String identifier) {
        this.identifier = identifier
    }

    public String analyze(String input) {
        int length;
        int hash;
        if (input == null) {
            length = 0;
            hash = 0;
        } else {
            length = input.length();
            hash = input.hashCode();
        }
        return "identifier: " + identifier + " \nlength: " + length + " hash: " + hash;
    }

    public boolean equals(o) {
        if (this.is(o)) return true;
        if (getClass() != o.class) return false;

        JavaLike javaLike = (JavaLike) o;

        if (identifier != javaLike.identifier) return false
        if (identifierLength != javaLike.identifierLength) return false

        return true
    }

    public int hashCode() {
        int result
        result = (identifier != null ? identifier.hashCode() : 0)
        result = 31 * result + (identifierLength != null ? identifierLength.hashCode() : 0)
        return result
    }
}
