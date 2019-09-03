package com.asciibooks

import java.text.NumberFormat

// tag::BookDomainClass[]
class Book {
    String title
    String description
    String content
    String isbn
    Boolean published = false
    Integer price
    Date datePublished

    Date lastUpdated
    Date dateCreated

    static belongsTo = [author: Author]

    static constraints = {
        price min: 0, max: 1000_00
        isbn nullable: true
        description nullable: true
        content nullable: true
        datePublished nullable: true
    }

    static mapping = {
        content type: 'text'
    }

    String getFormattedPrice() {
        if (price) {
            return NumberFormat.getCurrencyInstance(Locale.US).format(price / 100)
        } else {
            return ""
        }
    }
}
