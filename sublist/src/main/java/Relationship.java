import java.util.List;
import java.util.stream.IntStream;

enum Relationship { EQUAL, SUBLIST, SUPERLIST, UNEQUAL }

class RelationshipComputer<T> {

    Relationship computeRelationship(List a, List b) {

        Relationship relationship;

        if (a.equals(b))
            relationship = Relationship.EQUAL;
        else if (a.isEmpty() || isContained(a, b))
            relationship = Relationship.SUBLIST;
        else if (b.isEmpty() || isContained(b, a))
            relationship = Relationship.SUPERLIST;
        else
            relationship = Relationship.UNEQUAL;

        return relationship;

    }

    private static boolean isContained(List a, List b) {
        return IntStream.range(0, b.size() - a.size() + 1)
                .mapToObj(value -> b.subList(value, a.size() + value))
                .anyMatch(a::equals);
    }

}
