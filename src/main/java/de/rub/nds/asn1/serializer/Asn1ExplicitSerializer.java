package de.rub.nds.asn1.serializer;

import de.rub.nds.asn1.model.Asn1Explicit;

public class Asn1ExplicitSerializer extends Asn1FieldSerializer {

    private final Asn1Explicit asn1Explicit;

    public Asn1ExplicitSerializer(final Asn1Explicit asn1Explicit) {
        super(asn1Explicit);
        this.asn1Explicit = asn1Explicit;
    }

    @Override
    public void updateLayers() {
        this.encodeExplicit();
        super.updateLayers();
    }

    private void encodeExplicit() {
        int offset = this.asn1Explicit.getOffset();
        this.asn1Explicit.getTagNumber().setOriginalValue(offset);
        this.asn1Explicit.setContent(this.asn1Explicit.getEncodedChildren());
    }
}