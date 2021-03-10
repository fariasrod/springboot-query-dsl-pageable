package com.dsl.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class ParamUtils {
    public static boolean objectIsNull(final Object field) {
        return field == null;
    }
}
