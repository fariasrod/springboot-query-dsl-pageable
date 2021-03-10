package com.dsl.repository.dsl;

import com.dsl.filter.BookFilter;
import com.dsl.model.QBook;
import com.dsl.util.ParamUtils;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BookFilterDsl {

    private static final QBook BOOK = QBook.book;

    public static BooleanExpression filter(final BookFilter filter) {
        BooleanExpression expression = null;

        if (!ParamUtils.objectIsNull(filter)) {
            expression = QueryDslBuilder.addAndEquals(expression, BOOK.id, filter.getId());
            expression = QueryDslBuilder.addAndContains(expression, BOOK.name, filter.getName());
            expression = QueryDslBuilder.addAndContains(expression, BOOK.author, filter.getAuthor());
            expression = QueryDslBuilder.addAndBoolean(expression, BOOK.free, filter.getFree());
            expression = QueryDslBuilder.addAndEqualsInt(expression, BOOK.year, filter.getYear());
        }
        return expression;
    }
}
