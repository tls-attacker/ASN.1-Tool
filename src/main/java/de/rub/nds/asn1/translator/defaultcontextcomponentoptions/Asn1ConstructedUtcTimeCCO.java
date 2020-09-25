package de.rub.nds.asn1.translator.defaultcontextcomponentoptions;

import de.rub.nds.asn1.TagClass;
import de.rub.nds.asn1.TagConstructed;
import de.rub.nds.asn1.TagNumber;
import de.rub.nds.asn1.model.Asn1ConstructedUtcTime;
import de.rub.nds.asn1.translator.ContextComponentOption;
import de.rub.nds.asn1.translator.fieldtranslators.Asn1ConstructedUtcTimeFT;

public class Asn1ConstructedUtcTimeCCO extends ContextComponentOption<Asn1ConstructedUtcTime> {

    public Asn1ConstructedUtcTimeCCO(final String subContextName) {
        super(
                TagClass.UNIVERSAL.getIntValue(),
                TagConstructed.CONSTRUCTED.getBooleanValue(),
                TagNumber.UTCTIME.getIntValue(),
                true,
                Asn1ConstructedUtcTimeFT.class,
                subContextName
        );
    }
}