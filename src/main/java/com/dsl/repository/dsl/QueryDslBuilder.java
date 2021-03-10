package com.dsl.repository.dsl;

import com.dsl.util.ParamUtils;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class QueryDslBuilder {

    public static BooleanExpression addAndContains(final BooleanExpression expression, final StringPath path,
                                                   final String stringValue) {
        BooleanExpression stringContains = null;
        if (!ParamUtils.objectIsNull(stringValue)) {
            stringContains = path.contains(stringValue);
        }

        return addAndCriteria(expression, stringContains);
    }

    public static BooleanExpression addAndEquals(final BooleanExpression expression, final NumberPath<Long> path,
                                                 final Long value) {

        BooleanExpression longEquals = null;
        if (!ParamUtils.objectIsNull(value)) {
            longEquals = path.eq(value);
        }

        return addAndCriteria(expression, longEquals);
    }

    public static BooleanExpression addAndEqualsInt(final BooleanExpression expression, final NumberPath<Integer> path,
                                                    final Integer value) {

        BooleanExpression intEquals = null;
        if (!ParamUtils.objectIsNull(value)) {
            intEquals = path.eq(value);
        }

        return addAndCriteria(expression, intEquals);
    }

    public static BooleanExpression addAndBoolean(final BooleanExpression expression, final BooleanPath path,
                                                  final Boolean value) {

        BooleanExpression booleanEquals = null;
        if (!ParamUtils.objectIsNull(value)) {
            booleanEquals = path.eq(value);
        }

        return addAndCriteria(expression, booleanEquals);
    }

    public static BooleanExpression addAndCriteria(final BooleanExpression expression, final BooleanExpression added) {
        BooleanExpression expressionAux = expression;
        if (!ParamUtils.objectIsNull(added)) {
            if (ParamUtils.objectIsNull(expressionAux)) {
                expressionAux = added;
            } else {
                expressionAux = expressionAux.and(added);
            }
        }

        return expressionAux;
    }
}
