package org.adrianl.genericosYcolecciones;

import java.util.Comparator;

public class PaisesComparator implements Comparator<PaisesComparable> {
    @Override
    public int compare(PaisesComparable p1, PaisesComparable p2) {
        return p1.getNombre().compareToIgnoreCase(p2.getNombre());
    }
}
