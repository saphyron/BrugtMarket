package dk.BrugtMarket.domain;

import java.util.Objects;
import java.util.UUID;

public class Id {

    private final UUID id;

    public Id(UUID id) {
        this.id = id;
    }

    public Id(String id) {
        this.id = UUID.fromString(id);
    }

    public UUID getId() {
        return id;
    }

    public String toString() {
        return id.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id id1 = (Id) o;
        return Objects.equals(id, id1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
